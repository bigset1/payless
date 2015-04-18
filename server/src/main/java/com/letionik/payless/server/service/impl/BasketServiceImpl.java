package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.BasketSearchResult;
import com.letionik.payless.server.error.DataAccessExceptionMapper;
import com.letionik.payless.server.service.BasketService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class BasketServiceImpl implements BasketService {
	@Override
	public List<BasketSearchResult> searchBasket(List<String> barcodeList, double latitude,
			double longitude) {
		//TODO: replace stub with real implementation
		Store testStore = new Store("test_brand", 55.66, 44.55, "10:00 - 23:00");
		Map<String, Double> productPrices = new HashMap<String, Double>();
		productPrices.put("123123", 3.45);
		productPrices.put("234234", 7.34);
		BasketSearchResult basketSearchResult = new BasketSearchResult(testStore, 34.5, productPrices);
		return Arrays.asList(basketSearchResult);
	}
}
