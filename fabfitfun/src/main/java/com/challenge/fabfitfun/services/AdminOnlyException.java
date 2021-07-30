package com.challenge.fabfitfun.services;

public class AdminOnlyException extends RuntimeException 
{

    public AdminOnlyException() {
    }

    public AdminOnlyException(String message) {
        super(message);
    }

    public AdminOnlyException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdminOnlyException(Throwable cause) {
        super(cause);
    }

    public AdminOnlyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
