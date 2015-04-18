package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.BasketQueryDTO;
import com.letionik.payless.model.transport.BasketSearchResult;
import com.letionik.payless.server.service.BasketService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Component
public class BasketServiceImpl implements BasketService {

    @Override
    public List<BasketSearchResult> searchBasket(BasketQueryDTO query) {
        BasketSearchResult one = new BasketSearchResult();
        one.setStore(new Store("brand1", 10, 10, "10-16"));
        Map<String, Double> productPrices = new HashMap<String, Double>();
        productPrices.put("123123", 3.45);
        productPrices.put("234234", 7.34);
        one.setProductPrices(productPrices);
        return Arrays.asList(one);
    }
}
