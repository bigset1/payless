package com.letionik.payless.model.transport;

import com.letionik.payless.model.Store;

/**
 * @author Roman Kishchenko
 * @since 4/19/15
 */
public class StoreSearchResult {

    private Store store;

    private Double distance;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }
}
