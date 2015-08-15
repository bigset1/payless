package com.garage.payless.api;

import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public interface PayLessApi {

    @POST("/product/priceItem")
    void addPriceItem(@Body PriceItemDTO priceItemDTO, RetrofitCallback<Object> retrofitCallback);

    @GET("/product/parse")
    void getProduct(@Query("barcode") String barcode, RetrofitCallback<Product> retrofitCallback);

    @GET("/store/search")
    void getStores(@Query("latitude") double latitude, @Query("longitude") double longitude,
                                 @Query("distance") double distance, RetrofitCallback<List<Store>> retrofitCallback);

    @GET("/product/search/location")
    void getShopsProduct(@Query("barcode") String barcode, @Query("latitude") double latitude,
                         @Query("longitude") double longitude,
                         RetrofitCallback<List<ProductSearchResult>> retrofitCallback);

    @GET("/product/search/name")
    void getProductsByName(@Query("name") String name, RetrofitCallback<List<Product>> retrofitCallback);
}
