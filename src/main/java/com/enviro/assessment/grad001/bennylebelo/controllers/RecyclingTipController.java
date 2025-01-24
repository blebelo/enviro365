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

    private final Map<String, String> success = Map.of("Status", "Success");//Constant success message for Non-GET endpoints

    /**
     * Retrieves all recycling tips available in the system.
     * 
     * This method handles GET requests to the root endpoint ("/") and returns a list
     * of all recycling tips. It can be used to fetch all categories and descriptions
     * of recycling tips for reference or display.
     * 
     * @return A ResponseEntity containing an iterable of all recycling tips and an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<Iterable<RecyclingTip>> getAllTips() {
        return ResponseEntity.ok(service.getAllTips());
    }

    /**
     * Retrieves a specific recycling tip based on its ID.
     * 
     * This method handles GET requests to the URL "/{id}", where `{id}` is the ID
     * of the recycling tip to be retrieved. If the tip is found, it will be returned
     * in the response. If the tip does not exist, a 404 error with a detailed message will be returned.
     * 
     * @param id The ID of the recycling tip to be retrieved.
     * @return A ResponseEntity containing the requested recycling tip or a 404 error message if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipById(@PathVariable Integer id) {
        Optional<RecyclingTip> tip = service.getTipById(id);
        if (tip.isPresent()) {
            return ResponseEntity.ok(tip);
        } else {
            Map<String, String> response = Map.of(
                    "status", "Error",
                    "details", "ID@" + id + ": Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    /**
     * Creates a new recycling tip.
     * 
     * This method handles POST requests to the root endpoint ("/") and allows users
     * to create a new recycling tip by providing a valid RecyclingTip object in the request body.
     * If successful, it will return a success message indicating that the tip has been created.
     * 
     * @param tip A valid RecyclingTip object containing the category and description for the new tip.
     * @return A ResponseEntity with a success message indicating the tip was created.
     */
    @PostMapping
    public ResponseEntity<Object> createTip(@Valid @RequestBody RecyclingTip tip) {
        service.createTip(tip);
        return ResponseEntity.ok(success);
    }

    /**
     * Updates an existing recycling tip by its ID.
     * 
     * This method handles PUT requests to the URL "/update/{id}", where `{id}` is the ID
     * of the recycling tip to be updated. The request body must contain a valid RecyclingTip
     * object with updated category and description values. If the update is successful,
     * a success message is returned; otherwise, a 404 error message is returned.
     * 
     * @param id The ID of the recycling tip to be updated.
     * @param tip A valid RecyclingTip object containing the updated category and description.
     * @return A ResponseEntity with a success message if the update is successful or an error response if the tip is not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTip(@PathVariable Integer id, @Valid @RequestBody RecyclingTip tip) {
        RecyclingTip newTip = new RecyclingTip(tip.getCategory(), tip.getDescription());

        boolean code = service.updateTip(id, newTip);
        if (!code) {
            Map<String, String> response = Map.of("ID@ " + id, "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(success);
    }

    /**
     * Deletes a specific recycling tip by its ID.
     * 
     * This method handles DELETE requests to the URL "/delete/{id}", where `{id}` is the ID
     * of the recycling tip to be deleted. Upon successful deletion, a success message is returned.
     * If the tip with the specified ID does not exist, the service will handle the deletion process silently.
     * 
     * @param id The ID of the recycling tip to be deleted.
     * @return A ResponseEntity with a success message indicating the tip was deleted.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTip(@PathVariable Integer id) {
        service.deleteTip(id);
        return ResponseEntity.ok(success);
    }
}
