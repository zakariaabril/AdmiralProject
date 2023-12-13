package com.example.admiral.controller;
import com.example.admiral.model.Projet;
import com.example.admiral.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projets")
@CrossOrigin("http://localhost:3000")
public class ProjetController {
    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetController(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @GetMapping()
    public List<Projet> listerProjets() {
        return projetRepository.findAll();
    }

    @PostMapping()
    public Projet creerProjet(@RequestBody Projet projet) {
        return projetRepository.save(projet);
    }

    @GetMapping("/{id}")
    public Projet obtenirProjetParId(@PathVariable Long id) {
        return projetRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Projet mettreAJourProjet(@PathVariable Long id, @RequestBody Projet nouveauProjet) {
        return projetRepository.findById(id)
                .map(projet -> {
                    projet.setNom(nouveauProjet.getNom());
                    return projetRepository.save(projet);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void supprimerProjet(@PathVariable Long id) {
        projetRepository.deleteById(id);
    }
}