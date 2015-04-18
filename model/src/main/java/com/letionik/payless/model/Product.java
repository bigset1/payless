package com.letionik.payless.model;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class Product {

	private String barcode;
	private String name;
	private String producer;
	private String country;
	private String imageUrl;
	private String description;

	public Product() {
	}

	public Product(String barcode, String name, String producer, String country, String imageUrl,
			String description) {
		this.barcode = barcode;
		this.name = name;
		this.producer = producer;
		this.country = country;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override public String toString() {
		return "Product{" +
				"barcode='" + barcode + '\'' +
				", name='" + name + '\'' +
				", producer='" + producer + '\'' +
				", country='" + country + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
