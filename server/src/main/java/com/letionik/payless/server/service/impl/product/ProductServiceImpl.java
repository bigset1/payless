package com.letionik.payless.server.service.impl.product;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;
import com.letionik.payless.server.persistance.PriceItemRepository;
import com.letionik.payless.server.persistance.ProductRepository;
import com.letionik.payless.server.persistance.StoreRepository;
import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.ProductBO;
import com.letionik.payless.server.persistance.model.StoreBO;
import com.letionik.payless.server.service.ProductService;
import com.letionik.payless.server.service.ServiceException;
import com.letionik.payless.server.service.impl.ConversionUtils;
import com.letionik.payless.server.util.product.details.ProductDetailsProvider;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private List<ProductDetailsProvider> productDetailsProviders;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceItemRepository priceItemRepository;

    @Autowired
    private StoreRepository storeRepository;

	@Override
    public Response addPriceItem(PriceItemDTO priceItemDto) throws ServiceException {
        StoreBO store = storeRepository.findOne(priceItemDto.getStoreId());
        if (store == null) {
            throw new ServiceException("Store with id '" + priceItemDto.getStoreId() + "' doesn't exist");
        }
        ProductBO product = getProduct(priceItemDto.getBarcode());

        PriceItemBO priceItem = new PriceItemBO();
        priceItem.setProduct(product);
        priceItem.setDate(new Date());
        priceItem.setPrice(priceItemDto.getPrice());
        priceItem.setStore(store);

        priceItemRepository.insert(priceItem);
        return Response.ok().build();
    }

	@Override
    public Product parseProduct(String barcode) throws ServiceException {
        return ConversionUtils.convertProduct(getProduct(barcode));
	}

    private ProductBO getProduct(String barcode) throws ServiceException {
        ProductBO product = null;
        try {
            product = productRepository.findOne(barcode);
        } catch (DataAccessException e) {/*NOP*/}

        if (product == null) {
            product = parseAndInsertProduct(barcode);
        }
        return product;
    }

    private ProductBO parseAndInsertProduct(final String barcode) throws ServiceException {
        ProductBO product;

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<ProductBO>> productDetails = new ArrayList<>();
        for (final ProductDetailsProvider productDetailsProvider : productDetailsProviders) {
            Future<ProductBO> productFuture = executorService.submit(new Callable<ProductBO>() {
                @Override
                public ProductBO call() throws Exception {
                    return productDetailsProvider.provide(barcode);
                }
            });
            productDetails.add(productFuture);
        }

        product = getMostDetailed(extractList(productDetails));

        productRepository.insert(product);

        return product;
    }

    private List<ProductBO> extractList(List<Future<ProductBO>> productDetails) {
        List<ProductBO> result = new ArrayList<>();
        for (Future<ProductBO> productDetail : productDetails) {
            try {
                result.add(productDetail.get(5, TimeUnit.SECONDS));
            } catch (Exception e) {
                // just ignore
            }
        }
        return result;
    }

    private ProductBO getMostDetailed(List<ProductBO> products) {
        int maxPoint = 0;
        ProductBO bestProduct = null;
        for (ProductBO product : products) {
            int currentPoint = 0;
            if (!StringUtils.isBlank(product.getName())) {
                currentPoint += 3;
            }
            if (!StringUtils.isBlank(product.getDescription())) {
                currentPoint += 2;
            }
            if (!StringUtils.isBlank(product.getImageUrl())) {
                currentPoint += 2;
            }
            if (!StringUtils.isBlank(product.getCountry())) {
                currentPoint += 1;
            }
            if (!StringUtils.isBlank(product.getProducer())) {
                currentPoint += 1;
            }
            if (currentPoint >= maxPoint) {
                bestProduct = product;
                maxPoint = currentPoint;
            }
        }

        return bestProduct;
    }

	@Override
    public Collection<ProductSearchResult> searchProductByLocation(String barcode,
                                                             double latitude,
                                                             double longitude,
                                                             Double maxDistance) {
        GeoResults<StoreBO> nearestStores = storeRepository.searchStoresByLocation(new Point(longitude, latitude), maxDistance);

        Map<PriceItemKey, ProductSearchResult> searchResults = new HashMap<>();
        for (GeoResult<StoreBO> store : nearestStores) {
            List<PriceItemBO> priceItems = priceItemRepository.findByStoreAndProductBarcode(store.getContent(), barcode);
            if (priceItems != null && !priceItems.isEmpty()) {
                for (PriceItemBO priceItem : priceItems) {
                    PriceItemKey key = new PriceItemKey(barcode, store.getContent().getId());
                    ProductSearchResult searchResult = searchResults.get(key);
                    if (searchResult == null) {
                        searchResult = new ProductSearchResult();
                        searchResult.setStore(ConversionUtils.convertStore(store.getContent()));
                        searchResult.setDistance(store.getDistance().getValue());
                        searchResult.setPrice(priceItem.getPrice());
                    } else {
                        Double averagePrice = (searchResult.getPrice() + priceItem.getPrice()) / 2;
                        searchResult.setPrice(averagePrice);
                    }
                    searchResults.put(key, searchResult);
                }

            }
        }
		return searchResults.values();
	}

    @Override
    public List<Product> searchProductsByName(String name, int number) throws ServiceException{
        if (name == null || StringUtils.isBlank(name)) {
            throw new ServiceException("Query parameter name '" + name + "' cannot be null");
        }

        Collection<ProductBO> foundProducts = productRepository.searchByName(name.trim());

		List<Product> results = new ArrayList<Product>(foundProducts.size());
		for (ProductBO product : foundProducts) {
			Product convertedProduct = ConversionUtils.convertProduct(product);
			convertedProduct.setMaxPrice(priceItemRepository.getMaxPriceByProduct(product));
			convertedProduct.setMinPrice(priceItemRepository.getMinPriceByProduct(product));
			results.add(convertedProduct);
		}

        return results;
	}

	@Override
    public Product searchProductByBarcode(String barcode) {
        return ConversionUtils.convertProduct(productRepository.findOne(barcode));
	}
}
