package com.example.carrosCaribenios.exception;

public class RentNotFoundException extends RuntimeException{
    public RentNotFoundException() {
    }

    public RentNotFoundException(String message) {
        super(message);
    }

    public RentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentNotFoundException(Throwable cause) {
        super(cause);
    }

    public RentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
