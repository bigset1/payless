package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.ProductBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<ProductBO> searchByName(String name, int page, int perPage) {
        Query query = TextQuery.queryText(TextCriteria.forDefaultLanguage().matching(name))
                .sortByScore()
                .with(new PageRequest(page, perPage));
        return mongoTemplate.find(query, ProductBO.class);
    }

}
