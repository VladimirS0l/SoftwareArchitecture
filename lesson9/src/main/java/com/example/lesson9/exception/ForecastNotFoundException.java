package com.example.lesson9.exception;

public class ForecastNotFoundException extends RuntimeException{
    public ForecastNotFoundException(String message) {
        super(message);
    }
}
