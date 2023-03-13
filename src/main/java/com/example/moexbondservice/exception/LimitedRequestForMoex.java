package com.example.moexbondservice.exception;

public class LimitedRequestForMoex extends RuntimeException{
    public LimitedRequestForMoex(String message) {
        super(message);
    }
}
