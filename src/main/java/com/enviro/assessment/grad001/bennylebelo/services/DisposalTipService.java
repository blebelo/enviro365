package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.repositories.DisposalTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class for managing disposal tips.
 * Provides methods for CRUD operations related to DisposalTip entities.
 */
@Service
public class DisposalTipService {
    
    @Autowired
    private DisposalTipRepository repository;

    /**
     * Retrieves all disposal tips.
     * 
     * @return An iterable collection of all disposal tips.
     */
    public Iterable<DisposalTip> getAllTips() {
        return repository.findAll();
    }

    /**
     * Retrieves a disposal tip by its ID.
     * 
     * @param id The ID of the disposal tip.
     * @return An Optional containing the disposal tip if found, otherwise empty.
     */
    public Optional<DisposalTip> getTipById(Integer id) {
        return repository.findById(id);
    }

    /**
     * Creates a new disposal tip and saves it to the repository.
     * 
     * @param tip The disposal tip to be created.
     */
    public void createTip(DisposalTip tip) {
        DisposalTip newTip = new DisposalTip(tip.getCategory(), tip.getDescription());
        repository.save(newTip);
    }

    /**
     * Updates an existing disposal tip.
     * 
     * @param id The ID of the disposal tip to update.
     * @param tip The new disposal tip data.
     * @return true if the update was successful, false if the tip with the given ID was not found.
     */
    public boolean updateTip(Integer id, DisposalTip tip) {
        Optional<DisposalTip> tipOptional = repository.findById(id);

        if (tipOptional.isPresent()) {
            DisposalTip newTip = tipOptional.get();
            newTip.setDescription(tip.getDescription());
            newTip.setCategory(tip.getCategory());
            repository.save(newTip);
            return true;
        }
        return false;
    }

    /**
     * Deletes a disposal tip by its ID.
     * 
     * @param id The ID of the disposal tip to delete.
     * @throws CustomSystemException if the disposal tip with the given ID is not found.
     */
    public void deleteTip(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);
    }
}
