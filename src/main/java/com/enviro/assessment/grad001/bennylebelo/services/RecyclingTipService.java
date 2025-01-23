package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.models.RecyclingTip;
import com.enviro.assessment.grad001.bennylebelo.repositories.RecyclingTipRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecyclingTipService {

    @Autowired
    private RecyclingTipRepository repository;

    public Iterable<RecyclingTip> getAllTips() {
        return repository.findAll();
    }

    public Optional<RecyclingTip> getTipById(Integer id) {
        return repository.findById(id);
    }

    public void createTip(RecyclingTip tip) {
        RecyclingTip newTip = new RecyclingTip(tip.getCategory(), tip.getDescription());
        repository.save(newTip);
    }

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

    public void deleteTip(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);
    }
}
