package com.enviro.assessment.grad001.bennylebelo.controllers;

import com.enviro.assessment.grad001.bennylebelo.models.WasteCategory;
import com.enviro.assessment.grad001.bennylebelo.services.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/waste-categories")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService service;

    private final Map<String, String> success = Map.of("Status", "Success");//Constant success message for Non-GET endpoints

    /**
     * Retrieves all waste categories from the system.
     * 
     * This method handles GET requests to the root endpoint ("/") and returns a list
     * of all available waste categories. It is typically used to display or fetch all
     * categories for waste classification.
     * 
     * @return A ResponseEntity containing an iterable of all waste categories and an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<Iterable<WasteCategory>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }


    /**
     * Retrieves a specific waste category based on its ID.
     * 
     * This method handles GET requests to the URL "/{id}", where `{id}` is the ID
     * of the waste category to be retrieved. If the category exists, it will be returned in the response.
     * If the category does not exist, a 404 error will be returned with an error message.
     * 
     * @param id The ID of the waste category to be retrieved.
     * @return A ResponseEntity containing the requested waste category if found, or a not found error response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCategoryById(@PathVariable Integer id) {
        Optional<WasteCategory> category = service.getCategoryById(id);

        if (category.isPresent()) {
            return ResponseEntity.ok(category);
        } else {
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details", "ID@" + id + ": Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    /**
     * Creates a new waste category in the system.
     * 
     * This method handles POST requests to the root endpoint ("/"). It requires a valid
     * WasteCategory object in the request body, which contains the name of the category and
     * a boolean indicating if it is recyclable. Upon successful creation, it returns a success message.
     * 
     * @param category A valid WasteCategory object containing the name and recyclable status for the new category.
     * @return A ResponseEntity with a success message indicating the category was created successfully.
     */
    @PostMapping
    public ResponseEntity<Object> createCategory(@Valid @RequestBody WasteCategory category) {
        service.createCategory(category);
        return ResponseEntity.ok(success);
    }


    /**
     * Updates an existing waste category in the system by its ID.
     * 
     * This method handles PUT requests to the URL "/update/{id}", where `{id}` is the ID
     * of the waste category to be updated. The request body must contain a valid WasteCategory
     * object with updated name and recyclable status values. If the update is successful, it
     * returns a success message; otherwise, a 404 error will be returned.
     * 
     * @param id The ID of the waste category to be updated.
     * @param category A valid WasteCategory object containing the updated name and recyclable status.
     * @return A ResponseEntity with a success message if the update is successful, or an error response if not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable Integer id, @Valid @RequestBody WasteCategory category) {
        WasteCategory updatedCategory = new WasteCategory(category.getName(), category.isRecyclable());

        boolean code = service.updateCategory(id, updatedCategory);
        if (!code) {
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details", "ID@" + id + ": Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(success);
    }


    /**
     * Deletes a specific waste category from the system by its ID.
     * 
     * This method handles DELETE requests to the URL "/delete/{id}", where `{id}` is the ID
     * of the waste category to be deleted. Upon successful deletion, it returns a success message.
     * 
     * @param id The ID of the waste category to be deleted.
     * @return A ResponseEntity with a success message indicating the category was deleted successfully.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return ResponseEntity.ok(success);
    }
}
