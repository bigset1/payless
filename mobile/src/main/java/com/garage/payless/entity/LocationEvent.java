package com.garage.payless.entity;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class LocationEvent {
    private LatLng latLng;

    public LocationEvent(LatLng latLng) {
        this.latLng = latLng;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
