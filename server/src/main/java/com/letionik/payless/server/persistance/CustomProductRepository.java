package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.ProductBO;

import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public interface CustomProductRepository {

    List<ProductBO> searchByName(String name);
}
