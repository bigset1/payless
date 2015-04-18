package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.BasketSearchResult;
import com.letionik.payless.server.service.BasketService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

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
		BasketSearchResult basketSearchResult = new BasketSearchResult(testStore, 34.5, null);
		return Arrays.asList(basketSearchResult);
	}
}
