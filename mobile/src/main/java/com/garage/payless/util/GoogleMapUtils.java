package com.garage.payless.util;

import android.content.Context;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.letionik.payless.model.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.garage.payless.R;

/**
* Created by Paryshkura Roman on 19.04.2015.
*/
public class GoogleMapUtils {

    private final GoogleMap googleMap;
    private final Context context;

    private final Map<Marker, Store> stores;

    public GoogleMapUtils(Context context, GoogleMap googleMap) {
        if (googleMap == null) {
            throw new RuntimeException("GoogleMapUtils googleMap is NuLL");
        }
        this.googleMap = googleMap;
        this.context = context;
        this.stores = new HashMap<Marker, Store>();

//        this.googleMap.setInfoWindowAdapter(adapterInfoWindow);
//        this.googleMap.setOnInfoWindowClickListener(this);

        this.googleMap.getUiSettings().setZoomControlsEnabled(false);
        this.googleMap.getUiSettings().setMyLocationButtonEnabled(false);
    }

    public void moveCamera(LatLng latLng) {
        int duration = 3000;
        moveCamera(latLng, duration);
    }

    public void moveCamera(LatLng latLng, int duration) {
        float zoom = 15;
        if (latLng != null)
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoom), duration, null);
    }

//    public void addOriginMarker(LatLng latLng) {
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_route_origin));
//        markerOptions.position(latLng);
//
//        addMarker(markerOptions);
//    }
//
//    public void addDestinationMarker(LatLng latLng) {
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_route_destination));
//        markerOptions.position(latLng);
//
//        addMarker(markerOptions);
//    }

    public void addMarker(MarkerOptions markerOptions) {
        Marker marker = googleMap.addMarker(markerOptions);
    }

    public Marker addMarker(LatLng latLng) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);

        Marker marker = googleMap.addMarker(markerOptions);

        return marker;
    }

    public void me(LatLng myLocation) {
        addMarker(myLocation);
    }

    public GoogleMap getMap() {
        return googleMap;
    }

    public void me(double latitude, double longitude) {
        me(new LatLng(latitude, longitude));
    }

    public void moveCamera(double latitude, double longitude) {
        moveCamera(new LatLng(latitude, longitude));
    }

    public void addStore(List<Store> listStore) {
        if (listStore != null) {

            for (Store store : listStore) {
                addStore(store);
            }
        }
    }

    public void addStore(Store store) {
        if (store != null) {
            MarkerOptions markerOptions = new MarkerOptions();

            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.marker_icon));
            markerOptions.position(new LatLng(store.getLatitude(), store.getLongitude()));

            Marker driverMarker = googleMap.addMarker(markerOptions);

            stores.put(driverMarker, store);
        }
    }
}

