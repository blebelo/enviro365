package com.enviro.assessment.grad001.bennylebelo.exceptions;

/**
 * Custom exception class for handling system-related errors.
 * This class extends RuntimeException and provides constructors to
 * pass error messages and throwable causes.
 */
public class CustomSystemException extends RuntimeException {

    /**
     * Constructs a new CustomSystemException with the specified detail message.
     * 
     * @param message The detail message.
     */
    public CustomSystemException(String message) {
        super(message);
    }

    /**
     * Constructs a new CustomSystemException with the specified detail message and cause.
     * 
     * @param message The detail message.
     * @param throwable The cause of the exception (can be retrieved later with getCause()).
     */
    public CustomSystemException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
