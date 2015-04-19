package com.letionik.payless.model.transport;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class PriceItemDTO {

    private String barcode;

    private String storeId;

    private Double price;

    public PriceItemDTO() {
    }

    public PriceItemDTO(String barcode, String storeId, Double price) {
        this.barcode = barcode;
        this.storeId = storeId;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

