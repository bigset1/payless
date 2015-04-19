package com.letionik.payless.server.service.impl;

import com.letionik.payless.model.transport.BasketQueryDTO;
import com.letionik.payless.model.transport.BasketSearchResult;
import com.letionik.payless.server.persistance.PriceItemRepository;
import com.letionik.payless.server.persistance.ProductRepository;
import com.letionik.payless.server.persistance.StoreRepository;
import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.StoreBO;
import com.letionik.payless.server.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
@Component
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PriceItemRepository priceItemRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public List<BasketSearchResult> searchBasket(BasketQueryDTO query) {
        Double maxDistance = query.getMaxDistance();
        if (maxDistance == null) {
            maxDistance = 1d;
        }

        GeoResults<StoreBO> geoResults = storeRepository.searchStoresByLocation(new Point(query.getLongitude(), query.getLatitude()), maxDistance);
        Map<String, Basket> baskets = new HashMap<>();
        for (GeoResult<StoreBO> geoResult : geoResults) {
            Basket basket = baskets.get(geoResult.getContent().getId());
            if (basket == null) {
                basket = new Basket(query.getBarcodeList(), geoResult.getContent(), geoResult.getDistance().getValue());
                baskets.put(geoResult.getContent().getId(), basket);
            }
            List<PriceItemBO> priceItems = priceItemRepository.findByStore(geoResult.getContent());
            for (PriceItemBO priceItem : priceItems) {
                basket.put(priceItem);
            }
        }

        List<BasketSearchResult> results = new ArrayList<>();
        for (Basket basket : baskets.values()) {
            if (basket.areAllProductsBought()) {
                BasketSearchResult result = new BasketSearchResult();
                result.setProductPrices(basket.getPrices());
                result.setDistance(basket.getDistance());
                result.setStore(ConversionUtils.convertStore(basket.getStore()));
                result.setTotalPrice(basket.getTotalPrice());
                results.add(result);
            }
        }

        return results;
    }
}
