package com.guidejourney.exceptions;

public class InvalidProfileException extends RuntimeException {
    public InvalidProfileException(String message) {
        super(message);
    }
}

