package com.geektrust.example.geektrust.exceptions;

public class JourneyEndedException extends RuntimeException {
    public JourneyEndedException() {
        super();
    }

    public JourneyEndedException(String msg) {
        super(msg);
    }    
}
