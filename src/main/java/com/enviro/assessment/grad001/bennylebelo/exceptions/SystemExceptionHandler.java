package com.enviro.assessment.grad001.bennylebelo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

/**
 * Global exception handler for handling CustomSystemException.
 * This class uses @RestControllerAdvice to handle exceptions and return
 * appropriate error details in the response.
 */
@RestControllerAdvice
public class SystemExceptionHandler {

    /**
     * Handles CustomSystemException by building SystemException object
     * and returns a detailed error response.
     * 
     * @param e The exception to handle.
     * @return A ResponseEntity containing the error details and HTTP status.
     */
//    @ExceptionHandler(value = {CustomSystemException.class})
//    public ResponseEntity<Object> handleCustomSystemException(CustomSystemException e) {
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//
//        SystemException error = new SystemException(
//                e.getMessage(),
//                e,
//                status,
//                ZonedDateTime.now()
//        );
//        return new ResponseEntity<>(error, status);
//    }
}
