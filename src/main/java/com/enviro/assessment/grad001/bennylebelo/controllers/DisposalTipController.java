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

    private final Map<String, String> success = Map.of("Status", "Success"); //Constant success message for Non-GET endpoints

    /**
     * Retrieves all disposal tips from the system.
     * 
     * This method handles GET requests to the root endpoint ("/") and returns a list
     * of all available disposal tips. It can be used to display or fetch all tips for disposal.
     * 
     * @return A ResponseEntity containing an iterable of all disposal tips and an HTTP status of OK.
     */
    @GetMapping
    public ResponseEntity<Iterable<DisposalTip>> getAllCategories() {
        return ResponseEntity.ok(service.getAllTips());
    }


    /**
     * Retrieves a specific disposal tip based on its ID.
     * 
     * This method handles GET requests to the URL "/{id}", where `{id}` is the ID
     * of the disposal tip to be retrieved. If the tip exists, it will be returned in the response.
     * If the tip does not exist, a 404 error will be returned with an error message.
     * 
     * @param id The ID of the disposal tip to be retrieved.
     * @return A ResponseEntity containing the requested disposal tip if found, or a not found error response if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTipById(@PathVariable Integer id) {
        Optional<DisposalTip> tip = service.getTipById(id);
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
     * Creates a new disposal tip in the system.
     * 
     * This method handles POST requests to the root endpoint ("/"). It requires a valid
     * DisposalTip object in the request body, which contains the category and description
     * for the new disposal tip. If successful, it returns a success message indicating that
     * the tip was created.
     * 
     * @param tip A valid DisposalTip object containing the category and description for the new tip.
     * @return A ResponseEntity with a success message indicating the tip was created successfully.
     */
    @PostMapping
    public ResponseEntity<Object> createTip(@Valid @RequestBody DisposalTip tip) {
        service.createTip(tip);
        return ResponseEntity.ok(success);
    }


    /**
     * Updates an existing disposal tip in the system by its ID.
     * 
     * This method handles PUT requests to the URL "/update/{id}", where `{id}` is the ID
     * of the disposal tip to be updated. The request body must contain a valid DisposalTip
     * object with updated category and description values. If the update is successful, it
     * returns a success message; otherwise, a 404 error will be returned.
     * 
     * @param id The ID of the disposal tip to be updated.
     * @param tip A valid DisposalTip object containing the updated category and description.
     * @return A ResponseEntity with a success message if the update is successful, or an error response if not found.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateTip(@PathVariable Integer id, @Valid @RequestBody DisposalTip tip) {
        DisposalTip newTip = new DisposalTip(tip.getCategory(), tip.getDescription());

        boolean code = service.updateTip(id, newTip);
        if (!code) {
            Map<String, String> response = Map.of("ID@" + id, "Field is empty");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        return ResponseEntity.ok(success);
    }


    /**
     * Deletes a specific disposal tip from the system by its ID.
     * 
     * This method handles DELETE requests to the URL "/delete/{id}", where `{id}` is the ID
     * of the disposal tip to be deleted. Upon successful deletion, it returns a success message.
     * 
     * @param id The ID of the disposal tip to be deleted.
     * @return A ResponseEntity with a success message indicating the tip was deleted.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTip(@PathVariable Integer id) {
        service.deleteTip(id);
        return ResponseEntity.ok(success);
    }
}
