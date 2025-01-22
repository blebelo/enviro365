package com.enviro.assessment.grad001.bennylebelo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleAllExceptions(Exception exception, WebRequest request) {
        return Map.of("Status", "Error",
        "Message", exception.getMessage(),
        "ExceptionType", exception.getClass().getName());

    }
}
