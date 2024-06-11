package com.example.carrosCaribenios.exception;

public class RentedCarsClientNotFoundException extends RuntimeException{
    public RentedCarsClientNotFoundException() {
    }

    public RentedCarsClientNotFoundException(String message) {
        super(message);
    }

    public RentedCarsClientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentedCarsClientNotFoundException(Throwable cause) {
        super(cause);
    }

    public RentedCarsClientNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
