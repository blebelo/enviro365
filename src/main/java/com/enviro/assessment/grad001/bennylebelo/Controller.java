package com.enviro.assessment.grad001.bennylebelo;

import jakarta.servlet.ServletException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("")
    public String error() {
        return "ENVIRO365";
    }

    @GetMapping("/api/tips")
    public Map<String, Object> recyclingTips() {
        Map<String, Object> response = new HashMap<>();
        response.put("tips", List.of("""
                Recycling Tips:
                Check Local Rules: Recycle only accepted items.
                Rinse Items: Remove food and liquids.
                Reuse First: Repurpose before recycling.
                Recycle Electronics: Use e-waste facilities."""));
        return response;
    }



}
