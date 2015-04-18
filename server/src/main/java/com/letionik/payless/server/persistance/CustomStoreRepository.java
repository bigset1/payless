package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.StoreBO;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface CustomStoreRepository {

    GeoResults<StoreBO> searchStoresByLocation(Point location, Double maxDistance);

}
