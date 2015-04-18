package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.server.persistance.StoreRepository;
import com.letionik.payless.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

	@Override public List<Store> searchStores(double latitude, double longitude) {
		//TODO: replace stub with real implementation
		Store testStore = new Store("test_brand", 55.66, 44.55, "10:00 - 23:00");
		return Arrays.asList(testStore);
	}
}
