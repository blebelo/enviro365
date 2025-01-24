package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.repositories.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing waste categories.
 * Provides methods for CRUD operations related to WasteCategory entities.
 */
@Service
public class WasteCategoryService {

    @Autowired
    private WasteCategoryRepository repository;

    /**
     * Retrieves all waste categories.
     * 
     * @return An iterable collection of all waste categories.
     */
    public Iterable<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    /**
     * Retrieves a waste category by its ID.
     * 
     * @param id The ID of the waste category.
     * @return An Optional containing the waste category if found, otherwise empty.
     */
    public Optional<WasteCategory> getCategoryById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Creates a new waste category and saves it to the repository.
     * 
     * @param category The waste category to be created.
     */
    public void createCategory(WasteCategory category) {
        WasteCategory newCategory = new WasteCategory(category.getName(), category.isRecyclable());
        repository.save(newCategory);
    }

    /**
     * Updates an existing waste category.
     * 
     * @param id The ID of the waste category to update.
     * @param category The new waste category data.
     * @return true if the update was successful, false if the category with the given ID was not found.
     */
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

    /**
     * Deletes a waste category by its ID.
     * 
     * @param id The ID of the waste category to delete.
     * @throws CustomSystemException if the waste category with the given ID is not found.
     */
    public void deleteCategory(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);
    }
}
