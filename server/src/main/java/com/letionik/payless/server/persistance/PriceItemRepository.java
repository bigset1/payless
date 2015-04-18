package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.ProductBO;
import com.letionik.payless.server.persistance.model.StoreBO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface PriceItemRepository extends MongoRepository<PriceItemBO, String>, CustomPriceItemRepository {

    List<PriceItemBO> findByStore(StoreBO store);

}
