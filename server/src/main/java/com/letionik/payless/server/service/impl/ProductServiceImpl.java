package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
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
    public void addPriceItem(PriceItemDTO priceItemDto) throws ServiceException {
        StoreBO store = storeRepository.findOne(priceItemDto.getStoreId());
        if (store == null) {
            throw new ServiceException("Store " + priceItemDto.getStoreId() + " doesn't exist");
        }
        ProductBO product = getProduct(priceItemDto.getBarcode());

        PriceItemBO priceItem = new PriceItemBO();
        priceItem.setProduct(product);
        priceItem.setDate(new Date());
        priceItem.setPrice(priceItemDto.getPrice());
        priceItem.setStore(store);

        priceItemRepository.insert(priceItem);
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
        } catch (IOException e) {
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
    public List<ProductSearchResult> searchProductByLocation(String barcode, double latitude, double longitude) {
		//TODO: replace stub with real implementation
		Store testStore = new Store("test_brand", 55.66, 44.55, "10:00 - 23:00");
		ProductSearchResult productSearchResult = new ProductSearchResult(testStore, 34.5, 123.4);
		return Arrays.asList(productSearchResult);
	}

	@Override
    public List<Product> searchProductsByName(String name, Integer page, Integer perPage) {
        List<ProductBO> products = productRepository.searchByName(name, page, perPage);
        return ConversionUtils.convertProducts(products);
	}

	@Override
    public Product searchProductByBarcode(String barcode) {
		//TODO: replace stub with real implementation
		return new Product("123123123", "test_name", "test_producer", "test_country", "test_imageUrl", "test_description");
	}
}
