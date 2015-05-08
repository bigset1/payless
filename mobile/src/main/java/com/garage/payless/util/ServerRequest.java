package com.garage.payless.util;

import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

import retrofit.RetrofitError;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class ServerRequest {
    public static void getProduct(final PayLessApi payLessApi,
                                  final ResponseCallback responseCallback,
                                  final String barcode) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Product product = payLessApi.getProduct(barcode);
                    responseCallback.complete(product);
                } catch (RetrofitError e) {
                    responseCallback.failed();
                } catch (Exception e) {
                    responseCallback.failed();
                }
            }
        }).start();
    }

    public static void getStores(final PayLessApi payLessApi,
                                 final ResponseCallback responseCallback,
                                 final double latitude, final double longitude, final double distance) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    List<Store> stores = payLessApi.getStores(latitude, longitude, distance);
                    responseCallback.complete(stores);
                } catch (RetrofitError e) {
                    responseCallback.failed();
                } catch (Exception e) {
                    responseCallback.failed();
                }
            }
        }).start();
    }

    public static void getShopsProduct(final PayLessApi payLessApi,
                                       final ResponseCallback responseCallback,
                                       final String barcode, final double latitude, final double longitude) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<ProductSearchResult> productSearchResults = payLessApi.getShopsProduct(barcode, latitude, longitude);
                    responseCallback.complete(productSearchResults);
                } catch (RetrofitError e) {
                    responseCallback.failed();
                } catch (Exception e) {
                    responseCallback.failed();
                }
            }
        }).start();

    }

    public static void getProductsByName(final PayLessApi payLessApi,
                                         final ResponseCallback responseCallback,
                                         final String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Product> products = payLessApi.getProductsByName(name);
                    responseCallback.complete(products);
                } catch (RetrofitError e) {
                    responseCallback.failed();
                } catch (Exception e) {
                    responseCallback.failed();
                }
            }
        }).start();
    }
}
