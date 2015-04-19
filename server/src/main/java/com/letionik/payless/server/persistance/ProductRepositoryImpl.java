package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.ProductBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ProductRepositoryImpl implements CustomProductRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Collection<ProductBO> searchByName(String name) {
        Set<ProductBO> uniqueProducts = new HashSet<ProductBO>();
        uniqueProducts.addAll(makeRegexpQuery(name));
        uniqueProducts.addAll(makeFullTextSearchQuery(name));
        return uniqueProducts;
    }

    private List<ProductBO> makeFullTextSearchQuery(String name) {
        Query fullTextSearchQuery = TextQuery.queryText(TextCriteria.forDefaultLanguage().matching(name))
                .sortByScore();
        return mongoTemplate.find(fullTextSearchQuery, ProductBO.class);
    }

    private List<ProductBO> makeRegexpQuery(String name) {
        String regExp = (name.length() > 4) ? name : "^" + name;
        Query regexQuery = Query.query(Criteria.where("name").regex(regExp, "i"));
        return mongoTemplate.find(regexQuery, ProductBO.class);
    }


}
