package com.letionik.payless.server.persistance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author Anton Nikulin
 * @since 4/18/15.
 */
@Document(collection = "priceItem")
public class PriceItemBO {

    @Id
    private String id;

    private double price;

    private Date date;

    @DBRef
    private StoreBO store;

    @DBRef
    private ProductBO product;

    public PriceItemBO() {
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

    public StoreBO getStore() {
        return store;
    }

    public void setStore(StoreBO store) {
        this.store = store;
    }

    public ProductBO getProduct() {
        return product;
    }

    public void setProduct(ProductBO product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "PriceItem{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", store=" + store +
                ", product=" + product +
                '}';
    }
}
