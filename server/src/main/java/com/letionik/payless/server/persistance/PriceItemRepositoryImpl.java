package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.ProductBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class PriceItemRepositoryImpl implements CustomPriceItemRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override public double getMinPriceByProduct(ProductBO productBO) {

		Query priceItemQuery = new Query(Criteria.where("product.barcode").is(productBO.getBarcode()));
		priceItemQuery.limit(1);
		priceItemQuery.with(new Sort(Sort.Direction.ASC, "price"));

		PriceItemBO priceItemBO = mongoTemplate.findOne(priceItemQuery, PriceItemBO.class);
		if (priceItemBO != null) {
			return priceItemBO.getPrice();
		} else {
			return 0.0;
		}
	}

	@Override public double getMaxPriceByProduct(ProductBO productBO) {
		Query priceItemQuery = new Query(Criteria.where("product.barcode").is(productBO.getBarcode()));
		priceItemQuery.limit(1);
		priceItemQuery.with(new Sort(Sort.Direction.DESC, "price"));

		PriceItemBO priceItemBO = mongoTemplate.findOne(priceItemQuery, PriceItemBO.class);
		if (priceItemBO != null) {
			return priceItemBO.getPrice();
		} else {
			return 0.0;
		}
	}
}
