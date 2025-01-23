package com.enviro.assessment.grad001.bennylebelo.services;


import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
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
        if (!repository.existsById(id)) {
            throw new CustomSystemException("Field not found.");
        }
        return repository.findById(id);
    }

    public void createCategory(WasteCategory category) {
        if (repository.existsById(category.getId())) {throw new CustomSystemException("Field already exists.");}
        repository.save(category);
    }

    public void updateCategory(Integer id, WasteCategory category) {
        if (!repository.existsById(id)) {
            throw new CustomSystemException("Field not found.");
        }
        repository.save(category);
    }

    public void deleteCategory(Integer id) {
        if (!repository.existsById(id)) {throw new CustomSystemException("Field not found.");}
        repository.deleteById(id);

    }
}