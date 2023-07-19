package com.example.geektrust.exceptions;

public class JourneyEndedException extends RuntimeException{
    public JourneyEndedException(){
        super();
    }
    public JourneyEndedException(String message){
        super(message);
    }
}
