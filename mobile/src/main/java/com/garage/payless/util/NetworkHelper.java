package com.garage.payless.util;

import com.garage.payless.api.PayLessApi;

import retrofit.ErrorHandler;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class NetworkHelper {

    public static final PayLessApi payLessApi = getRestAdapter().create(PayLessApi.class);

    private static final String SITE_URL = "http://payless.cloudapp.net/server";
    private static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint(SITE_URL)
            .setErrorHandler(new ErrorHandler() {
                @Override
                public Throwable handleError(RetrofitError cause) {
                    cause.printStackTrace();
                    return cause;
                }
            })
            .build();

    public static RestAdapter getRestAdapter() {
        return restAdapter;
    }
}
