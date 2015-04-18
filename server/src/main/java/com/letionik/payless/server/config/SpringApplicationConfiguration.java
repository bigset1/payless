package com.letionik.payless.server.config;

import com.letionik.payless.server.ApplicationInitializer;
import com.letionik.payless.server.config.mongo.MongoClientEnvConfiguration;
import com.letionik.payless.server.config.mongo.MongoClientLocalConfiguration;
import com.letionik.payless.server.persistance.CustomProductRepository;
import com.letionik.payless.server.persistance.CustomStoreRepository;
import com.letionik.payless.server.persistance.PriceItemRepository;
import com.letionik.payless.server.persistance.ProductRepository;
import com.letionik.payless.server.persistance.StoreRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = {ProductRepository.class,
        StoreRepository.class,
        PriceItemRepository.class,
        CustomProductRepository.class,
        CustomStoreRepository.class})
@ComponentScan(basePackageClasses = ApplicationInitializer.class)
@Import(value = {MongoClientLocalConfiguration.class, MongoClientEnvConfiguration.class})
public class SpringApplicationConfiguration {

}
