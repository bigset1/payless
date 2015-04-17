package com.letionik.payless.model.transport;

import com.letionik.payless.model.Store;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class ProductSearchResult {

	private Store store;
	private double distance;
	private double price;

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override public String toString() {
		return "ProductSearchResult{" +
				"store=" + store +
				", distance=" + distance +
				", price=" + price +
				'}';
	}
}
