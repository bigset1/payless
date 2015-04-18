package com.garage.payless;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.garage.payless.entity.LocationEvent;
import com.garage.payless.fragment.FragmentMain;
import com.garage.payless.util.ReactiveLocationHelper;

import de.greenrobot.event.EventBus;

public class MainActivity extends FragmentActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentMain fragmentMain;
    public static final int FRAME_CONTAINER = R.id.activityMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentMain = FragmentMain.newInstance();
        FragmentHelper.add(fragmentManager, fragmentMain, FRAME_CONTAINER);

        new ReactiveLocationHelper().requestUpdateLocation(this, 2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().registerSticky(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(LocationEvent event) {
//        Toast.makeText(this, event.getLatLng().toString(), Toast.LENGTH_SHORT).show();
    }
}
