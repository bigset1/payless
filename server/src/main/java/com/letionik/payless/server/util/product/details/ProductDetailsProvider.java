package com.letionik.payless.server.util.product.details;

import com.letionik.payless.server.persistance.model.ProductBO;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
public interface ProductDetailsProvider {

    ProductBO provide(String barcode) throws Exception;

}
