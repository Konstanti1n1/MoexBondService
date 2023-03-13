package com.example.moexbondservice.exception;

public class BondParsingException extends RuntimeException {
    public BondParsingException(Exception exception) {
        super(exception);
    }
}
