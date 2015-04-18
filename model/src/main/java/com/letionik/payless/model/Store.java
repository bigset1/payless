package com.letionik.payless.model;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
public class Store {

	private String id;
	private String brand;
	private double latitude;
	private double longitude;
	private String workingHours;

	public Store() {
	}

	public Store(String brand, double latitude, double longitude, String workingHours) {
		this.brand = brand;
		this.latitude = latitude;
		this.longitude = longitude;
		this.workingHours = workingHours;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}

	@Override public String toString() {
		return "Store{" +
				"id='" + id + '\'' +
				", brand='" + brand + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", workingHours='" + workingHours + '\'' +
				'}';
	}
}
