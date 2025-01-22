package com.enviro.assessment.grad001.bennylebelo.services;

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

    public DisposalTip createTip(DisposalTip tip) {
        return repository.save(tip);
    }

    public DisposalTip updateTip(Integer id, DisposalTip tip) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Field not found");
        }
        return repository.save(tip);
    }

    public void deleteTip(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Field not found.");
        }
        repository.deleteById(id);

    }
}