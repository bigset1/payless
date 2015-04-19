package com.letionik.payless.server.util.product.details;

import com.letionik.payless.server.persistance.model.ProductBO;
import com.letionik.payless.server.util.BarcodeInfoParser;
import org.springframework.stereotype.Component;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
@Component
public class Ean13InfoProductDetailsProvider implements ProductDetailsProvider {

    @Override
    public ProductBO provide(String barcode) throws Exception {
        return BarcodeInfoParser.getProduct(barcode);
    }

}
