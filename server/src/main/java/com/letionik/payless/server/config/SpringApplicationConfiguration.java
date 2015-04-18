package com.letionik.payless.server.config;

import com.letionik.payless.server.ApplicationInitializer;
import com.letionik.payless.server.config.mongo.MongoClientEnvConfiguration;
import com.letionik.payless.server.config.mongo.MongoClientLocalConfiguration;
import com.letionik.payless.server.persistance.ProductsRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = ProductsRepository.class)
@ComponentScan(basePackageClasses = ApplicationInitializer.class)
@Import(value = {MongoClientLocalConfiguration.class, MongoClientEnvConfiguration.class})
public class SpringApplicationConfiguration {

//    @Bean
//    public MongoClient mongoClient() throws UnknownHostException {
//        return new MongoClient(mongoConfiguration.mongoServerAddress(), Arrays.asList(mongoConfiguration.mongoCredential()));
//    }
//
//    @Bean
//    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
//        return new SimpleMongoDbFactory(mongoClient(), mongoConfiguration.mongoDatabaseName());
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() throws UnknownHostException {
//        return new MongoTemplate(mongoDbFactory());
//    }

}
