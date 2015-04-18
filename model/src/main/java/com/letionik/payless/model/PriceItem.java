package com.letionik.payless.model;

import java.util.Date;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class PriceItem {

	private String id;
	private double price;
	private Date date;
	private Store store;
	private Product product;

	public PriceItem() {
	}

	public PriceItem(double price, Date date, Store store, Product product) {
		this.price = price;
		this.date = date;
		this.store = store;
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override public String toString() {
		return "PriceItem{" +
				"id='" + id + '\'' +
				", price=" + price +
				", date=" + date +
				", store=" + store +
				", product=" + product +
				'}';
	}
}
