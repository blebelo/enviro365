package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
import com.enviro.assessment.grad001.bennylebelo.models.DisposalTip;
import com.enviro.assessment.grad001.bennylebelo.repositories.DisposalTipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisposalTipService {
    @Autowired
    private DisposalTipRepository repository;

    public Iterable<DisposalTip> getAllTips(){
        return repository.findAll();
    }

    public Optional<DisposalTip> getTipById(Integer id) {
        return repository.findById(id);
    }

    public void createTip(DisposalTip tip) {
        DisposalTip newTip = new DisposalTip(tip.getCategory(), tip.getDescription());
        repository.save(newTip);
    }

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

    public void deleteTip(Integer id) {
        if (repository.findById(id).isEmpty()) {
            throw new CustomSystemException("Field not found.");
        }
        repository.deleteById(id);
    }
}