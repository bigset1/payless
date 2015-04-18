package com.letionik.payless.server.service.impl;

import com.letionik.payless.server.persistance.model.PriceItemBO;
import com.letionik.payless.server.persistance.model.StoreBO;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
public class Basket {

    private Set<String> requiredBarCodes;

    private double totalPrice;

    private StoreBO store;

    private double distance;

    private Map<String, Double> prices;

    public Basket(Collection<String> requiredBarCodes, StoreBO store, double distance) {
        this.requiredBarCodes = new HashSet<>(requiredBarCodes);
        this.store = store;
        this.distance = distance;
        prices = new HashMap<>();
    }

    public void put(PriceItemBO priceItemBO) {
        String barcode = priceItemBO.getProduct().getBarcode();
        if (requiredBarCodes.contains(barcode)) {
            requiredBarCodes.remove(barcode);
            prices.put(barcode, priceItemBO.getPrice());
            totalPrice += priceItemBO.getPrice();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public boolean areAllProductsBought() {
        return requiredBarCodes.isEmpty();
    }

    public StoreBO getStore() {
        return store;
    }

    public double getDistance() {
        return distance;
    }
}
