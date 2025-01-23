package com.enviro.assessment.grad001.bennylebelo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class DefaultController {
    @GetMapping()
    public String defaultController(){
        return "Enviro 365 - API";
    }
}
