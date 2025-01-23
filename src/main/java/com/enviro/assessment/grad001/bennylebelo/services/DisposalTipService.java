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
        if (repository.existsById(tip.getId())) {throw new CustomSystemException("Field already exists.");}
        repository.save(tip);
    }

    public void updateTip(Integer id, DisposalTip tip) {
        if (!repository.existsById(id)) {throw new CustomSystemException("Field not found.");}
        repository.save(tip);
    }

    public void deleteTip(Integer id) {
        if (!repository.existsById(id)) {throw new CustomSystemException("Field not found.");}
        repository.deleteById(id);

    }
}