package com.garage.payless.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

/**
 * Created by Paryshkura Roman on 19.04.2015.
 */
public class SharedPreferencesHelper {
    public static final String STORE_NAME = "PAYLESS_SHARED_PREF";
    public static final String LATLNG = "latlng";

    public static void save(Context context, String objectName, Object object) {
        SharedPreferences  mPrefs = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString(objectName, json);
        prefsEditor.commit();
    }

    public static LatLng retreiveLatLng(Context context) {
        SharedPreferences mPrefs = context.getSharedPreferences(STORE_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString(LATLNG, "");
        LatLng latLng = gson.fromJson(json, LatLng.class);

        return latLng;
    }
}
