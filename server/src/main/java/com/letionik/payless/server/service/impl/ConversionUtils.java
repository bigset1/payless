package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Product;
import com.letionik.payless.server.persistance.model.ProductBO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ConversionUtils {

    public static Product convertProduct(ProductBO productBO) {
        Product result = new Product();
        result.setName(productBO.getName());
        result.setBarcode(productBO.getBarcode());
        result.setCountry(productBO.getCountry());
        result.setDescription(productBO.getDescription());
        result.setImageUrl(productBO.getImageUrl());
        result.setProducer(productBO.getProducer());
        return result;
    }

    public static List<Product> convertProducts(List<ProductBO> productsBo) {
		List<Product> products = new ArrayList<Product>();
		for(ProductBO productBO : productsBo) {
			products.add(convertProduct(productBO));
		}
        return products;
    }
}
