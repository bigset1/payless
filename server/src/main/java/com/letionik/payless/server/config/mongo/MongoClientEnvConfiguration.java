package com.letionik.payless.server.config.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Configuration
@Profile("prod")
public class MongoClientEnvConfiguration {

    public static final String MONGO_HOST_PROPERTY = "OPENSHIFT_MONGODB_DB_HOST";

    public static final String MONGO_PORT_PROPERTY = "OPENSHIFT_MONGODB_DB_PORT";

    public static final String MONGO_DB_NAME_PROPERTY = "OPENSHIFT_APP_NAME";

    public static final String MONGO_USER_PROPERTY = "OPENSHIFT_MONGODB_DB_USERNAME";

    public static final String MONGO_PASSWORD_PROPERTY = "OPENSHIFT_MONGODB_DB_PASSWORD";

    @Autowired
    private Environment environment;

    @Bean
    public String mongoHost() {
        return environment.getProperty(MONGO_HOST_PROPERTY);
    }

    @Bean
    public Integer mongoPort() {
        return environment.getProperty(MONGO_PORT_PROPERTY, Integer.class);
    }

    @Bean
    public String mongoDatabaseName() {
        return environment.getProperty(MONGO_DB_NAME_PROPERTY);
    }

    @Bean
    public ServerAddress mongoServerAddress() throws UnknownHostException {
        return new ServerAddress(mongoHost(), mongoPort());
    }

    @Bean
    public MongoCredential mongoCredential() {
        return MongoCredential.createCredential(environment.getProperty(MONGO_USER_PROPERTY),
                mongoDatabaseName(),
                environment.getProperty(MONGO_PASSWORD_PROPERTY).toCharArray());
    }

    @Bean
    public MongoClient mongoClient() throws UnknownHostException {
        return new MongoClient(mongoServerAddress(), Arrays.asList(mongoCredential()));
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(mongoClient(), mongoDatabaseName());
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }


}
