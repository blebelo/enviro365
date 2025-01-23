package com.enviro.assessment.grad001.bennylebelo.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(value = {CustomSystemException.class})
    public ResponseEntity<Object> handleCustomSystemException(CustomSystemException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        SystemException error = new SystemException(
                e.getMessage(),
                e,
                status,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(error, status);


    }
}