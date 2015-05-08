package com.letionik.payless.server.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Document(collection = "product")
public class ProductBO {

    @Id
    private String barcode;

    @TextIndexed
    private String name;

    private String producer;

    private String country;

    private String imageUrl;

    private String description;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductBO productBO = (ProductBO) o;

        if (barcode != null ? !barcode.equals(productBO.barcode) : productBO.barcode != null) return false;
        if (name != null ? !name.equals(productBO.name) : productBO.name != null) return false;
        if (producer != null ? !producer.equals(productBO.producer) : productBO.producer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = barcode != null ? barcode.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (producer != null ? producer.hashCode() : 0);
        return result;
    }
}
