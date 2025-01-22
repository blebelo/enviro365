package com.enviro.assessment.grad001.bennylebelo.controllers;

import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/waste-categories")
public class WasteCategoryController {
    @Autowired
    private WasteCategoryService service;

    private final Map<String, String> success =  Map.of("Status", "Success");

    @GetMapping
    public Map<String, Iterable<WasteCategory>> getAllCategories() {
        return Map.of("Waste Categories", service.getAllCategories());
    }

    @GetMapping("/{id}")
    public Map<String, Optional<WasteCategory>> getCategoryById(@PathVariable Integer id){
        return Map.of("ID" + id, service.getCategoryById(id));
    }

    @PostMapping
    public Map<String, String> createCategory(@Valid @RequestBody WasteCategory category) {
        service.createCategory(category);
        return success;
    }

    @PutMapping("/{id}")
    public Map<String, String> updateCategory(
            @PathVariable Integer id, @Valid @RequestBody WasteCategory category) {
        service.updateCategory(id, category);
        return success;

    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return success;

    }
}
