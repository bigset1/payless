package com.garage.payless.util;

import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;
import com.letionik.payless.model.Store;
import com.letionik.payless.model.transport.PriceItemDTO;
import com.letionik.payless.model.transport.ProductSearchResult;

import java.util.List;

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
                Product product = payLessApi.getProduct(barcode);
                responseCallback.complete(product);
            }
        }).start();
    }

    public static void getStores(final PayLessApi payLessApi,
                                 final ResponseCallback responseCallback,
                                 final double latitude, final double longitude, final double distance) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Store> stores = payLessApi.getStores(latitude, longitude, distance);
                responseCallback.complete(stores);
            }
        }).start();
    }

    public static void getShopsProduct(final PayLessApi payLessApi,
                                       final ResponseCallback responseCallback,
                                       final String barcode, final double latitude, final double longitude) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<ProductSearchResult> productSearchResults = payLessApi.getShopsProduct(barcode, latitude, longitude);
                responseCallback.complete(productSearchResults);
            }
        }).start();

    }
}
