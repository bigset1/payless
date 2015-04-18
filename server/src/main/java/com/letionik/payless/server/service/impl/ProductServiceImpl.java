package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.ProductSearchResult;
import com.letionik.payless.server.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class ProductServiceImpl implements ProductService {

	@Override public void addPriceItem(String barcode, String storeId, double price) {
		//TODO: replace stub with real implementation
	}

	@Override public Product parseProduct(String barcode) {
		//TODO: replace stub with real implementation
		return new Product("123123123", "test_name", "test_producer", "test_country", "test_imageUrl", "test_description");
	}

	@Override public List<ProductSearchResult> searchProductByLocation(String barcode, double latitude,
			double longitude) {
		//TODO: replace stub with real implementation
		Store testStore = new Store("test_brand", 55.66, 44.55, "10:00 - 23:00");
		ProductSearchResult productSearchResult = new ProductSearchResult(testStore, 34.5, 123.4);
		return Arrays.asList(productSearchResult);
	}

	@Override public List<Product> searchProductsByName(String name) {
		//TODO: replace stub with real implementation
		Product testProduct =  new Product("123123123", "test_name", "test_producer", "test_country", "test_imageUrl", "test_description");
		return Arrays.asList(testProduct);
	}

	@Override public Product searchProductByBarcode(String barcode) {
		//TODO: replace stub with real implementation
		return new Product("123123123", "test_name", "test_producer", "test_country", "test_imageUrl", "test_description");
	}
}
