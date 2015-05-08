package com.garage.payless.util;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class RestProvider {
    private static String SITE_URL = "http://payless.cloudapp.net/server";
    private static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(SITE_URL)
            .setErrorHandler(new ErrorHandler() {
                @Override
                public Throwable handleError(RetrofitError cause) {
                    cause.printStackTrace();
//                    String message = cause.getMessage();
                    return null;
                }
            })
            .build();

    public static RestAdapter getInstanse() {
        return restAdapter;
    }
}
