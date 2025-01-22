package com.enviro.assessment.grad001.bennylebelo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DefaultController {
    @GetMapping()
    public String defaultController(){
        return "All API Endpoints";
    }
}
