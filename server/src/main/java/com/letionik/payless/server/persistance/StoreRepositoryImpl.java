package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.StoreBO;
import com.letionik.payless.server.util.StoreParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class StoreRepositoryImpl implements CustomStoreRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@PostConstruct
	public void init() throws IOException {
		List<StoreBO> storeBOList = StoreParser.parseStores();
		for (StoreBO storeBO : storeBOList) {
			Query storeBOQuery = new Query();
			storeBOQuery.addCriteria(
					Criteria.where("name").is(storeBO.getName()).and("location").is(storeBO.getLocation()));

			StoreBO storedStoreBO = mongoTemplate.findOne(storeBOQuery, StoreBO.class);
			if (storedStoreBO == null) {
				mongoTemplate.insert(storeBO);
			} else if (storedStoreBO.getAddress() == null) {
                storedStoreBO.setAddress(storeBO.getAddress());
                mongoTemplate.save(storedStoreBO);
            }
		}
	}

	@Override
	public GeoResults<StoreBO> searchStoresByLocation(Point location, Double maxDistance) {
		NearQuery nearQuery = NearQuery.near(location);
		if (maxDistance != null) {
			nearQuery.maxDistance(maxDistance, Metrics.KILOMETERS);
		}
		return mongoTemplate.geoNear(nearQuery.inKilometers(), StoreBO.class);
	}

}
