package org.example.exception;

public class ActivityFullException extends RuntimeException {
    public ActivityFullException(String message) {
        super(message);
    }
}
