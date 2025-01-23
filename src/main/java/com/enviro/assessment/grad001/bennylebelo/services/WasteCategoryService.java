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
        return repository.findById(id);
    }

    public void createCategory(WasteCategory category) {
        WasteCategory newCategory = new WasteCategory(category.getName(), category.isRecyclable());
        repository.save(newCategory);
    }

    public boolean updateCategory(Integer id, WasteCategory category) {
        Optional<WasteCategory> cat = repository.findById(id);

        if (cat.isPresent()) {
            WasteCategory existingCategory = cat.get();
            existingCategory.setName(category.getName());
            existingCategory.setRecyclable(category.isRecyclable());
            repository.save(existingCategory);
            return true;
        }
        return false;
    }

    public void deleteCategory(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);

    }
}