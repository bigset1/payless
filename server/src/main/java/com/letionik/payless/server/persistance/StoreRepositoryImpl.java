package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.StoreBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.NearQuery;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class StoreRepositoryImpl implements CustomStoreRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public GeoResults<StoreBO> searchStoresByLocation(Point location, Double maxDistance) {
        NearQuery nearQuery = NearQuery.near(location);
        if (maxDistance != null) {
            nearQuery.maxDistance(maxDistance, Metrics.KILOMETERS);
        }
        return mongoTemplate.geoNear(nearQuery.inKilometers(), StoreBO.class);
    }

}
