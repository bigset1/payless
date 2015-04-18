package com.garage.payless.api;

import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public interface PayLessApi {

    @POST("/product/priceItem")
    public void addPriceItem(@Body PriceItemDTO priceItemDTO, Callback<Object> objectCallback);

    @GET("/product/parse")
    public Product getProduct(@Query("barcode") String barcode);

    @GET("/store/search")
    public List<Store> getStores(@Query("latitude") double latitude, @Query("longitude") double longitude,
                                 @Query("distance") double distance);

    @GET("/product/search/location")
    public List<ProductSearchResult> getShopsProduct(@Query("barcode") String barcode, @Query("latitude") double latitude,
                                                     @Query("longitude") double longitude);
}
