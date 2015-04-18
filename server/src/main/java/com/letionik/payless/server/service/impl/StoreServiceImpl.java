package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.server.persistance.StoreRepository;
import com.letionik.payless.server.persistance.model.StoreBO;
import com.letionik.payless.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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

	@Override public List<Store> searchStores(double latitude, double longitude, double distance) {
		List<Store> storeList = new ArrayList<Store>();
		GeoResults<StoreBO>
				nearestStores = storeRepository.searchStoresByLocation(new Point(longitude, latitude), distance);

		for (GeoResult<StoreBO> nearestStore : nearestStores) {
			storeList.add(ConversionUtils.convertStore(nearestStore.getContent()));
		}
		return storeList;
	}
}
