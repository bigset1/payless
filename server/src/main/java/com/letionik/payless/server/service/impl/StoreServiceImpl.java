package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.StoreSearchResult;
import com.letionik.payless.server.persistance.StoreRepository;
import com.letionik.payless.server.persistance.model.StoreBO;
import com.letionik.payless.server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Component
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
    public List<Store> searchStores(double latitude, double longitude, double distance) {
		List<Store> storeList = new ArrayList<Store>();
		GeoResults<StoreBO>
				nearestStores = storeRepository.searchStoresByLocation(new Point(longitude, latitude), distance);

		for (GeoResult<StoreBO> nearestStore : nearestStores) {
			storeList.add(ConversionUtils.convertStore(nearestStore.getContent()));
		}
		return storeList;
	}

	@Override
    public Store getStoreById(String id) {
		StoreBO storeBO = storeRepository.findOne(id);
		if (storeBO != null) {
			return ConversionUtils.convertStore(storeBO);
		} else {
			return null;
		}
	}

    @Override
    public List<StoreSearchResult> findStoresByLocation(double latitude, double longitude, double distance) {
        List<StoreSearchResult> results = new ArrayList<>();
        GeoResults<StoreBO> nearestStores = storeRepository.searchStoresByLocation(new Point(longitude, latitude), distance);

        for (GeoResult<StoreBO> nearestStore : nearestStores) {
            StoreSearchResult result = new StoreSearchResult();
            result.setDistance(nearestStore.getDistance().getValue());
            result.setStore(ConversionUtils.convertStore(nearestStore.getContent()));
            results.add(result);
        }

        return results;
    }
}
