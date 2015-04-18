package com.garage.payless.util;

import android.content.Context;
import android.location.Location;

import com.garage.payless.entity.LocationEvent;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.LatLng;

import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import pl.charmas.android.reactivelocation.ReactiveLocationProvider;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public class ReactiveLocationHelper {
    private Subscription locationSubscription;
    private static final int UPDATE_TIME = 20000;
    private static final int LOCATION_OBTAIN_TIMEOUT = 5000;

    public void requestUpdateLocation(Context context, int numUpdates) {
        if (locationSubscription != null && !locationSubscription.isUnsubscribed()) {
            locationSubscription.unsubscribe();
        }

//        final long UPDATE_TIME = PayLess.getUserPrefs().updateFrequency().get();

        locationSubscription = new ReactiveLocationProvider(context)
                .getUpdatedLocation(LocationRequest.create()
                        .setNumUpdates(numUpdates)
                        .setInterval(UPDATE_TIME))
                .observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .timeout(LOCATION_OBTAIN_TIMEOUT, TimeUnit.MILLISECONDS, Observable.just((Location) null), AndroidSchedulers.mainThread())
                .subscribe(new Action1<Location>() {
                    @Override
                    public void call(Location location) {
                        if (location == null) {
                            return;
                        }

//                        PayLess.getUserPrefs().edit()
//                                .latitude().put((float) location.getLatitude())
//                                .longitude().put(((float) location.getLongitude()))
//                                .apply();

                        EventBus.getDefault().post(new LocationEvent(new LatLng(location.getLatitude(),
                                location.getLongitude())));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }
}

