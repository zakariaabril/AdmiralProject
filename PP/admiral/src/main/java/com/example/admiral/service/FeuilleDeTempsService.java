package com.example.admiral.service;

import com.example.admiral.model.FeuilleDeTemps;
import com.example.admiral.repository.FeuilleDeTempsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeuilleDeTempsService {

    @Autowired
    private FeuilleDeTempsRepository feuilleDeTempsRepository;

    public List<FeuilleDeTemps> getAllFeuillesDeTemps() {
        return feuilleDeTempsRepository.findAll();
    }

    public FeuilleDeTemps getFeuilleDeTempsById(Long id) {
        return feuilleDeTempsRepository.findById(id).orElse(null);
    }

    public FeuilleDeTemps saveFeuilleDeTemps(FeuilleDeTemps feuilleDeTemps) {
        return feuilleDeTempsRepository.save(feuilleDeTemps);
    }

    public void deleteFeuilleDeTemps(Long id) {
        feuilleDeTempsRepository.deleteById(id);
    }
}