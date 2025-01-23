package com.enviro.assessment.grad001.bennylebelo.exceptions;

public class CustomSystemException extends RuntimeException {
    public CustomSystemException(String message) {
        super(message);
    }

    public CustomSystemException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
