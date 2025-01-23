package com.enviro.assessment.grad001.bennylebelo.controllers;

import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;

    private final Map<String, String> success = Map.of("Status", "Success");

    @GetMapping
    public ResponseEntity<Iterable<WasteCategory>> getAllCategories(){
        return ResponseEntity.ok(service.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
        Optional<WasteCategory> category = service.getCategoryById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(category);
        } else {
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details",  "ID@"+ id + ":" + "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@Valid @RequestBody WasteCategory category) {
        service.createCategory(category);
        return ResponseEntity.ok(success);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer id, @Valid @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = new WasteCategory(category.getName(), category.isRecyclable());

        boolean code = service.updateCategory(id, updatedCategory);
        if (!code){
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details",  "ID@"+ id + ":" + "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(success);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return ResponseEntity.ok(success);
    }
}