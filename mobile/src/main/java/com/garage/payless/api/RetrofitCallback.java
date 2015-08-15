package com.garage.payless.api;

import android.content.Context;
import android.widget.Toast;

import com.garage.payless.R;

import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by Paryshkura Roman on 09.05.2015.
 */
public abstract class RetrofitCallback<T> implements Callback<T> {

    public static final int INTERNAL_SERVER_ERROR = 500;
    private Context context;

    public RetrofitCallback(Context context) {
        this.context = context;
    }

    @Override
    public void failure(RetrofitError error) {
        switch (error.getResponse().getStatus()) {
            case INTERNAL_SERVER_ERROR:
                Toast.makeText(context, context.getString(R.string.internal_server_error), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(context, error.getResponse().getStatus() + ": " +
                        error.getResponse().getReason(), Toast.LENGTH_SHORT).show();
        }
    }
}
