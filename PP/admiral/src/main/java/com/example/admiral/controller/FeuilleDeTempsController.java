package com.example.admiral.controller;

import com.example.admiral.model.FeuilleDeTemps;
import com.example.admiral.service.FeuilleDeTempsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feuilles-de-temps")
@CrossOrigin("http://localhost:3000")

public class FeuilleDeTempsController {

    @Autowired
    private FeuilleDeTempsService feuilleDeTempsService;

    @GetMapping
    public List<FeuilleDeTemps> getAllFeuillesDeTemps() {
        return feuilleDeTempsService.getAllFeuillesDeTemps();
    }

    @GetMapping("/{id}")
    public FeuilleDeTemps getFeuilleDeTempsById(@PathVariable Long id) {
        return feuilleDeTempsService.getFeuilleDeTempsById(id);
    }

    @PostMapping
    public FeuilleDeTemps createFeuilleDeTemps(@RequestBody FeuilleDeTemps feuilleDeTemps) {
        return feuilleDeTempsService.saveFeuilleDeTemps(feuilleDeTemps);
    }

    @PutMapping("/{id}")
    public FeuilleDeTemps updateFeuilleDeTemps(@PathVariable Long id, @RequestBody FeuilleDeTemps updatedFeuilleDeTemps) {
        FeuilleDeTemps feuilleDeTemps = feuilleDeTempsService.getFeuilleDeTempsById(id);
        if (feuilleDeTemps != null) {
            feuilleDeTemps.setEmployer(updatedFeuilleDeTemps.getEmployer());
            feuilleDeTemps.setActivite(updatedFeuilleDeTemps.getActivite());
            feuilleDeTemps.setProjet(updatedFeuilleDeTemps.getProjet());
            feuilleDeTemps.setJour(updatedFeuilleDeTemps.getJour());
            feuilleDeTemps.setPartie(updatedFeuilleDeTemps.getPartie());
            return feuilleDeTempsService.saveFeuilleDeTemps(feuilleDeTemps);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteFeuilleDeTemps(@PathVariable Long id) {
        feuilleDeTempsService.deleteFeuilleDeTemps(id);
    }


}
