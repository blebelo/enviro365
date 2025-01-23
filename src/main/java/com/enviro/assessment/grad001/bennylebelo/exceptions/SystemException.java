package com.enviro.assessment.grad001.bennylebelo.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class SystemException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;
    private final ZonedDateTime timestamp;

    public SystemException(String message, Throwable throwable, HttpStatus status, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
