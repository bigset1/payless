package com.garage.payless.api;

import com.garage.payless.entity.Response;

/**
 * Created by Paryshkura Roman on 18.04.2015.
 */
public interface ResponseCallback {
    public void complete(Object response);
}
