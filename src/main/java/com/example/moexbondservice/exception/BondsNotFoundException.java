package com.example.moexbondservice.exception;

public class BondsNotFoundException extends RuntimeException{
    public BondsNotFoundException(String message) {
        super(message);
    }
}
