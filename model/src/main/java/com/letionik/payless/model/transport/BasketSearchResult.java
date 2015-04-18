package com.letionik.payless.model.transport;

import com.letionik.payless.model.Store;

import java.util.Map;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class BasketSearchResult {

	private Store store;
	private double distance;
	private Map<String, Double> productPrices;

	public BasketSearchResult() {
	}

	public BasketSearchResult(Store store, double distance, Map<String, Double> productPrices) {
		this.store = store;
		this.distance = distance;
		this.productPrices = productPrices;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Map<String, Double> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(Map<String, Double> productPrices) {
		this.productPrices = productPrices;
	}

	@Override public String toString() {
		return "BasketSearchResult{" +
				"store=" + store +
				", distance=" + distance +
				", productPrices=" + productPrices +
				'}';
	}
}
