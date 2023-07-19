package com.geektrust.example.geektrust.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super();
    }

    public NotFoundException(String msg) {
        super(msg);
    }
    
}
