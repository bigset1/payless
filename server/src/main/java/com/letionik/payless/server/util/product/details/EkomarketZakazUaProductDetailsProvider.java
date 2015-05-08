package com.letionik.payless.server.util.product.details;

import org.springframework.stereotype.Component;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
@Component
public class EkomarketZakazUaProductDetailsProvider extends AbstractZakazUaProductDetailsProvider{

    @Override
    protected String getUrl() {
        return "https://ekomarket.zakaz.ua/ru/";
    }

    @Override
    protected String getBarcodePrefix() {
        return "ekomarket";
    }
}
