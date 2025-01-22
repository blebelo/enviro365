package com.enviro.assessment.grad001.bennylebelo.services;

import com.enviro.assessment.grad001.bennylebelo.models.RecyclingTip;
import com.enviro.assessment.grad001.bennylebelo.repositories.RecyclingTipRepository;
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

    public RecyclingTip createTip(RecyclingTip tip) {
        return repository.save(tip);
    }

    public RecyclingTip updateTip(Integer id, RecyclingTip tip) {
        if (!repository.existsById(id)) {throw new RuntimeException("Field not found.");}
        return repository.save(tip);
    }

    public void deleteTip(Integer id) {
        if (!repository.existsById(id)) {throw new RuntimeException("Field not found.");}
        repository.deleteById(id);
    }
}
