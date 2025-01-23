package com.enviro.assessment.grad001.bennylebelo.controllers;

import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.services.DisposalTipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Iterable<DisposalTip>> getAllCategories(){
        return ResponseEntity.ok(service.getAllTips());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipById(@PathVariable Integer id) {
        Optional<DisposalTip> tip = service.getTipById(id);
        if (tip.isPresent()) {
            return ResponseEntity.ok(tip);
        } else {
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details",  "ID@"+ id + ":" + "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    @PostMapping
    public ResponseEntity<Object> createTip(@Valid @RequestBody DisposalTip tip) {
        service.createTip(tip);
        return ResponseEntity.ok(success);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTip(@PathVariable Integer id, @Valid @RequestBody DisposalTip tip) {
        DisposalTip newTip = new DisposalTip(tip.getCategory(), tip.getDescription());

        boolean code = service.updateTip(id, newTip);
        if (!code){
            Map<String, String> response = Map.of("ID@ "+ id, "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(success);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTip(@PathVariable Integer id) {
        service.deleteTip(id);
        return ResponseEntity.ok(success);
    }
}