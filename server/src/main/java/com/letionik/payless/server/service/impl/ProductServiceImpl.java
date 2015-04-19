package com.letionik.payless.server.service.impl;

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
import com.letionik.payless.server.util.BarcodeInfoParser;
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
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class ProductServiceImpl implements ProductService {

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

    private ProductBO parseAndInsertProduct(String barcode) throws ServiceException {
        ProductBO product;
        try {
            product = BarcodeInfoParser.getProduct(barcode);
        } catch (Exception e) {
            throw new ServiceException("An unexpected error occurred during parsing barcode '" + barcode + '\'', e);
        }
        if (product == null) {
            product = new ProductBO();
            product.setBarcode(barcode);
        }

        productRepository.insert(product);

        return product;
    }

	@Override
    public List<ProductSearchResult> searchProductByLocation(String barcode,
                                                             double latitude,
                                                             double longitude,
                                                             Double maxDistance) {
        GeoResults<StoreBO> nearestStores = storeRepository.searchStoresByLocation(new Point(longitude, latitude), maxDistance);
        List<ProductSearchResult> searchResults = new ArrayList<ProductSearchResult>();
        for (GeoResult<StoreBO> store : nearestStores) {
            List<PriceItemBO> priceItems = priceItemRepository.findByStore(store.getContent());
            if (priceItems != null && !priceItems.isEmpty()) {
                for (PriceItemBO priceItem : priceItems) {
                    ProductBO product = priceItem.getProduct();
                    if (product != null && product.getBarcode().equals(barcode)) {
                        ProductSearchResult searchResult = new ProductSearchResult();
                        searchResult.setStore(ConversionUtils.convertStore(store.getContent()));
                        searchResult.setDistance(store.getDistance().getValue());
                        searchResult.setPrice(priceItem.getPrice());
                        searchResults.add(searchResult);
                    }
                }

            }
        }
		return searchResults;
	}

	@Override
    public List<Product> searchProductsByName(String name, int number) throws ServiceException{
        if (name == null || StringUtils.isBlank(name)) {
            throw new ServiceException("Query parameter name '" + name + "' cannot be null");
        }

        Collection<ProductBO> foundProducts = productRepository.searchByName(name);

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
