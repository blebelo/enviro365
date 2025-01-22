package com.enviro.assessment.grad001.bennylebelo.services;


import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    public Iterable<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public Optional<WasteCategory> getCategoryById(Integer id) {
        return repository.findById(id);
    }

    public WasteCategory createCategory(WasteCategory category) {
        return repository.save(category);
    }

    public WasteCategory updateCategory(Integer id, WasteCategory category) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        return repository.save(category);
    }

    public void deleteCategory(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Field not found.");
        }
        repository.deleteById(id);

    }
}