package com.garage.payless.api;

import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;

import java.util.List;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public interface PayLessApi {

    @FormUrlEncoded
    @POST("/product/priceItem")
    public PriceItem addPriceItem(@Field("barcode") String barcode, @Field("storeId") String storeId, @Field("price") double price);

    @GET("/product/parse")
    public Product getProduct(@Query("barcode") String barcode);

    @GET("/store/search")
    public List<Store> getStores(@Query("latitude") double latitude, @Query("longitude") double longitude);
}
