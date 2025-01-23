package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.exceptions.CustomSystemException;
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

    public RecyclingTip createTip(@NotNull RecyclingTip tip) {
        if (repository.existsById(tip.getId())) {throw new CustomSystemException("Field already exists.");}
        return repository.save(tip);
    }

    public void updateTip(Integer id, RecyclingTip tip) {
        if (!repository.existsById(id)) {throw new CustomSystemException("Field not found.");}
        repository.save(tip);
    }

    public void deleteTip(Integer id) {
        if (!repository.existsById(id)) {throw new CustomSystemException("Field not found.");}
        repository.deleteById(id);
    }
}
