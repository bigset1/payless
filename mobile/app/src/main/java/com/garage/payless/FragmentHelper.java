package com.garage.payless;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Paryshkura Roman on 17.04.2015.
 */
public class FragmentHelper {

    public static void add(FragmentManager fragmentManager, Fragment fragment, int container) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null).replace(container,
                fragment).commit();
    }

}
