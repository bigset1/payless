package com.letionik.payless.server.persistance;


import com.letionik.payless.server.persistance.model.ProductBO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface ProductRepository extends MongoRepository<ProductBO, String> {
}
