package com.enviro.assessment.grad001.bennylebelo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping("/")
    public String defaultResponse() {
        return "ENVIRO365";
    }

    @GetMapping("/table")
    public Map<String, Object> recyclingTips() {
        Map<String, Object> response = new HashMap<>();
        response.put("table", table);//Update Object
        return response;
    }

    @GetMapping("/{resource}")
    public Map<String, Object> recordId(@PathVariable String resource) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", id);//Update Object
        return response;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getRecord(@PathVariable String id) {
        Map<String, Object> response = new HashMap<>();
        response.put("id", record);//Update Object
        return response;
    }

    @GetMapping("/{field}")
    public Map<String, Object> getField(@PathVariable String field) {
        Map<String, Object> response = new HashMap<>();
        response.put("field", data);//Update Object
        return response;
    }

}
