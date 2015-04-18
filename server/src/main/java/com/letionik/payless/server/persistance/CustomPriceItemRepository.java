package com.letionik.payless.server.persistance;

import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.ProductBO;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public interface CustomPriceItemRepository {

	double getMinPriceByProduct(ProductBO productBO);

	double getMaxPriceByProduct(ProductBO productBO);
}
