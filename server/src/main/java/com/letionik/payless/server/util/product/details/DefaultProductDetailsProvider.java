package com.letionik.payless.server.util.product.details;

import com.letionik.payless.server.persistance.model.ProductBO;
import org.springframework.stereotype.Component;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
@Component
public class DefaultProductDetailsProvider implements ProductDetailsProvider
{
    @Override
    public ProductBO provide(String barcode) throws Exception {
        ProductBO product = new ProductBO();
        product.setBarcode(barcode);
        return product;
    }

}
