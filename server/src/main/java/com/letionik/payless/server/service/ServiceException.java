package com.letionik.payless.server.service;

/**
 * @author Roman Kishchenko
 * @since 4/18/15
 */
public class ServiceException extends Exception {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
