package com.example.admiral.controller;

import com.example.admiral.DTO.LoginDTO;
import com.example.admiral.model.Employer;

import com.example.admiral.response.LoginResponse;
import com.example.admiral.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @GetMapping
    public List<Employer> getAllEmployers() {
        return employerService.getAllEmployers();
    }

    @GetMapping("/{id}")
    public Employer getEmployerById(@PathVariable Long id) {
        return employerService.getEmployerById(id);
    }


    @PostMapping
    public String saveEmployer(@RequestBody Employer employer)
    {
        String id = employerService.addEmployer(employer);
        return id;
    }

    @PutMapping("/{id}")
    public String updateEmployer(@PathVariable Long id, @RequestBody Employer updatedEmployer) {
        Employer employer = employerService.getEmployerById(id);
        if (employer != null) {
            employer.setNom(updatedEmployer.getNom());
            employer.setPrenom(updatedEmployer.getPrenom());
            employer.setProfession(updatedEmployer.getProfession());
            employer.setDate_emb(updatedEmployer.getDate_emb());
            employer.setStatus(updatedEmployer.getStatus());
            employer.setUsername(updatedEmployer.getUsername());
            employer.setPassword(updatedEmployer.getPassword());
            return employerService.addEmployer(employer);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployer(@PathVariable Long id) {
        employerService.deleteEmployer(id);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployer(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = employerService.loginEmployer(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }


}
