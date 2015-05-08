package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.ProductBO;

import java.util.Collection;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface CustomProductRepository {

    Collection<ProductBO> searchByName(String name);

}
