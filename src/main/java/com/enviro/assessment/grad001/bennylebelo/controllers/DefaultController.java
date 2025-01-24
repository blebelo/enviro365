package com.enviro.assessment.grad001.bennylebelo.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DefaultController is a REST controller that handles HTTP requests to the root endpoint.
 * It provides a default response for the API.
 * 
 * This controller serves as a placeholder or default endpoint, ensuring the API
 * has a base response for users accessing it without specifying a path.
 * 
 */
@RestController
public class DefaultController {
    /**
     * Handles GET requests to the root URL ("/").
     *
     * @return A String message "Enviro 365 - API" to indicate the API is accessible.
     */
    @GetMapping()
    public ResponseEntity<Object> defaultController() {
        Map <String, String> body = Map.of("Enviro 365", "API");
        return ResponseEntity.ok(body);
    }
}
