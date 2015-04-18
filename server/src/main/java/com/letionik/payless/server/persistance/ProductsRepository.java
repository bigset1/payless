package com.letionik.payless.server.persistance;

import com.letionik.payless.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface ProductsRepository extends MongoRepository<Product, Long> {
}
