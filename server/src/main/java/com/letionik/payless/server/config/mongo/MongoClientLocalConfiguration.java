package com.letionik.payless.server.config.mongo;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Configuration
@Profile("local")
public class MongoClientLocalConfiguration {

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(mongoClient(), mongoDatabaseName());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean
    public String mongoDatabaseName() {
        return "payless";
    }

}
