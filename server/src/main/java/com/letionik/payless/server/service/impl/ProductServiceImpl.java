package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.ProductSearchResult;
import com.letionik.payless.server.service.ProductService;
import com.letionik.payless.server.util.BarcodeInfoParser;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

	@Override public Product parseProduct(String barcode) throws IOException {

		//TODO: check if this product is already in db
		Product product = BarcodeInfoParser.getProduct(barcode);
		return product;
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
		Product testProduct =  new Product("123123123", "test_name", "test_producer", "test_country", "http://placekitten.com/g/200/300", "test_description");
		Product testProduct2 =  new Product("234234234", "test_name2", "test_producer2", "test_country2", "http://placekitten.com/g/200/300", "test_description2");
		return Arrays.asList(testProduct, testProduct2);
	}

	@Override public Product searchProductByBarcode(String barcode) {
		//TODO: replace stub with real implementation
		return new Product("123123123", "test_name", "test_producer", "test_country", "test_imageUrl", "test_description");
	}
}
