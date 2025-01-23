package com.enviro.assessment.grad001.bennylebelo.controllers;

import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.services.DisposalTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/disposal-tip")
public class DisposalTipController {
    @Autowired
    private DisposalTipService service;

    private final Map<String, String> success =  Map.of("Status", "Success");

    @GetMapping
    public Map<String, Iterable<DisposalTip>> getAllTips() {
        return Map.of("Disposal Tips", service.getAllTips());
    }

    @GetMapping("/{id}")
    public Map<String, Optional<DisposalTip>> getTipById(@PathVariable Integer id){
        return Map.of("ID" + id, service.getTipById(id));
    }

    @PostMapping
    public Map<String, String> createTip(@Valid @RequestBody DisposalTip tip) {
        service.createTip(tip);
        return success;
    }

    @PutMapping("/update/{id}")
    public Map<String, String> updateTip(
            @PathVariable Integer id, @Valid @RequestBody DisposalTip tip) {
            service.updateTip(id, tip);
            return success;

    }

    @DeleteMapping("/delete/{id}")
    public Map<String, String> deleteTip(@PathVariable Integer id) {
        service.deleteTip(id);
        return success;
    }
}