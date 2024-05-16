package org.example.authentiation.exception;

public class FactureNotFoundException extends RuntimeException {
    public FactureNotFoundException(String message) {
        super(message);
    }
}