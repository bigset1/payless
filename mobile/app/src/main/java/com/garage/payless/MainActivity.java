package com.garage.payless;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import com.garage.payless.fragment.FragmentMain;


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
    }
}
