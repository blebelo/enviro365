package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
import com.enviro.assessment.grad001.bennylebelo.models.RecyclingTip;
import com.enviro.assessment.grad001.bennylebelo.repositories.RecyclingTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing recycling tips.
 * Provides methods for CRUD operations related to RecyclingTip entities.
 */
@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    /**
     * Retrieves all recycling tips.
     * 
     * @return An iterable collection of all recycling tips.
     */
    public Iterable<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    /**
     * Retrieves a recycling tip by its ID.
     * 
     * @param id The ID of the recycling tip.
     * @return An Optional containing the recycling tip if found, otherwise empty.
     */
    public Optional<RecyclingTip> getTipById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Creates a new recycling tip and saves it to the repository.
     * 
     * @param tip The recycling tip to be created.
     */
    public void createTip(RecyclingTip tip) {
        RecyclingTip newTip = new RecyclingTip(tip.getCategory(), tip.getDescription());
        repository.save(newTip);
    }

    /**
     * Updates an existing recycling tip.
     * 
     * @param id The ID of the recycling tip to update.
     * @param tip The new recycling tip data.
     * @return true if the update was successful, false if the tip with the given ID was not found.
     */
    public boolean updateTip(Integer id, RecyclingTip tip) {
        Optional<RecyclingTip> tipOptional = repository.findById(id);

        if (tipOptional.isPresent()) {
            RecyclingTip newTip = tipOptional.get();
            newTip.setDescription(tip.getDescription());
            newTip.setCategory(tip.getCategory());
            repository.save(newTip);
            return true;
        }
        return false;
    }

    /**
     * Deletes a recycling tip by its ID.
     * 
     * @param id The ID of the recycling tip to delete.
     * @throws CustomSystemException if the recycling tip with the given ID is not found.
     */
    public void deleteTip(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);
    }
}
