package com.javastart.bank.exception;

public class AdjustmentNotFoundException extends RuntimeException {

    public AdjustmentNotFoundException(String message) {
        super(message);
    }
}