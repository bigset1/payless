package com.letionik.payless.model.transport;

import java.util.List;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class BasketQueryDTO {

    private List<String> barcodeList;

    private double latitude;

    private double longitude;

    public List<String> getBarcodeList() {
        return barcodeList;
    }

    public void setBarcodeList(List<String> barcodeList) {
        this.barcodeList = barcodeList;
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
}
