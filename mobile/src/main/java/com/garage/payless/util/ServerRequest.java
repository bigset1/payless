package com.garage.payless.util;

import com.garage.payless.api.PayLessApi;
import com.garage.payless.api.ResponseCallback;
import com.letionik.payless.model.PriceItem;
import com.letionik.payless.model.Product;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class ServerRequest {
    public static void addPriceItem(final PayLessApi payLessApi,
                                    final ResponseCallback responseCallback,
                                    final String barcode, final String storeId, final double price) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PriceItem priceItem = payLessApi.addPriceItem(barcode, storeId, price);
                responseCallback.complete(priceItem);
            }
        }).start();
    }

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
}
