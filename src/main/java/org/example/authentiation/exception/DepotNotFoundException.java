package org.example.authentiation.exception;

public class DepotNotFoundException extends RuntimeException {
    public DepotNotFoundException(String message) {
        super(message);
    }
}