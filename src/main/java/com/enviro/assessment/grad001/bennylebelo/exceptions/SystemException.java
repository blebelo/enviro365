package com.enviro.assessment.grad001.bennylebelo.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

/**
 * Represents a system exception with detailed information such as the message,
 * throwable cause, HTTP status, and timestamp.
 */
public class SystemException {

    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;
    private final ZonedDateTime timestamp;

    /**
     * Constructs a new SystemException with the specified details.
     * 
     * @param message The error message.
     * @param throwable The cause of the exception (can be retrieved later with getThrowable()).
     * @param status The HTTP status associated with this exception.
     * @param timestamp The timestamp when the exception occurred.
     */
    public SystemException(String message, Throwable throwable, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.status = status;
        this.timestamp = timestamp;
    }

    /**
     * Returns the error message associated with this exception.
     * 
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the throwable cause of the exception.
     * 
     * @return The throwable cause.
     */
    public Throwable getThrowable() {
        return throwable;
    }

    /**
     * Returns the HTTP status associated with this exception.
     * 
     * @return The HTTP status.
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Returns the timestamp when this exception occurred.
     * 
     * @return The timestamp.
     */
    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
