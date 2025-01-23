package com.enviro.assessment.grad001.bennylebelo.controllers;


import com.enviro.assessment.grad001.bennylebelo.models.RecyclingTip;
import com.enviro.assessment.grad001.bennylebelo.services.RecyclingTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recycling-tips")
public class RecyclingTipController {
    @Autowired
    private RecyclingTipService service;

    private final Map<String, String> success =  Map.of("Status", "Success");

    @GetMapping
    public Map<String, Iterable<RecyclingTip>> getAllTips() {
        return Map.of("Recycling Tips", service.getAllTips());
    }

    @GetMapping("/{id}")
    public Map<String, Optional<RecyclingTip>> getTipById(@PathVariable Integer id){
        return Map.of("ID" + id, service.getTipById(id));
    }

    @PostMapping
    public ResponseEntity<RecyclingTip> createTip(@Valid @RequestBody RecyclingTip tip) {
        return new ResponseEntity<>(service.createTip(tip), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Map<String, String> updateTip(
            @PathVariable Integer id, @Valid @RequestBody RecyclingTip tip) {
            service.updateTip(id, tip);
            return success;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteTip(@PathVariable Integer id) {
        service.deleteTip(id);
        return success;
    }
}
