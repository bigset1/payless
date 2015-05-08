package com.garage.payless.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.garage.payless.FragmentHelper;
import com.garage.payless.R;
import com.garage.payless.util.GoogleMapUtils;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.letionik.payless.model.Store;

public class FragmentShopInMap extends Fragment implements FragmentGoogleMap.OnMapInitialized{
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private static final String TITLE = "title";
    private static final int CONTAINER = R.id.fragmentShopInMapFrameLayout;
    private GoogleMapUtils mapUtils;

    private double latitude;
    private double longitude;
    private String title;
    public static FragmentShopInMap newInstance(double latitude, double longitude, String title) {
        FragmentShopInMap fragment = new FragmentShopInMap();
        Bundle args = new Bundle();
        args.putDouble(LATITUDE, latitude);
        args.putDouble(LONGITUDE, longitude);
        args.putString(TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentShopInMap() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            latitude = getArguments().getDouble(LATITUDE);
            longitude = getArguments().getDouble(LONGITUDE);
            title = getArguments().getString(TITLE);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        final FragmentGoogleMap mapFragment = FragmentGoogleMap.newInstance();
        mapFragment.setOnMapInitialized(this);
        FragmentHelper.add(getChildFragmentManager(), mapFragment, CONTAINER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop_in_map, container, false);
    }

    @Override
    public void mapWasInitialized(GoogleMap googleMap) {
        mapUtils = new GoogleMapUtils(getActivity(), googleMap);
        Store store = new Store();
        store.setLatitude(latitude);
        store.setLongitude(longitude);
        mapUtils.addStore(store);
        mapUtils.moveCamera(new LatLng(latitude, longitude));
    }
}
