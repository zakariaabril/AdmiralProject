package com.example.admiral.service;

import com.example.admiral.DTO.LoginDTO;
import com.example.admiral.model.Employer;
import com.example.admiral.repository.EmployerRepo;
import com.example.admiral.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerService {
    @Autowired
    private EmployerRepo employerRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Employer> getAllEmployers() {
        return employerRepo.findAll();
    }

    public Employer getEmployerById(Long id) {
        return employerRepo.findById(id).orElse(null);
    }

    public String addEmployer(Employer employer) {
        Employer newemployer = new Employer(
                employer.getId(),
                employer.getNom(),
                employer.getPrenom(),
                employer.getProfession(),
                employer.getDate_emb(),
                employer.getStatus(),
                employer.getUsername(),

                this.passwordEncoder.encode(employer.getPassword())
        );
        employerRepo.save(newemployer);
        return employer.getUsername();
    }

    public void deleteEmployer(Long id) {
        employerRepo.deleteById(id);
    }


    public LoginResponse loginEmployer(LoginDTO loginDTO) {
        String msg = "";
        Employer employer1 = employerRepo.findByUsername(loginDTO.getUsername());
        if (employer1 != null) {
            if (employer1.getStatus().equals("Activer")) { // Remplacez "getStatus()" par la méthode réelle pour obtenir le statut
                String password = loginDTO.getPassword();
                String encodedPassword = employer1.getPassword();
                Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
                if (isPwdRight) {
                    Optional<Employer> employer = employerRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                    if (employer.isPresent()) {
                        return new LoginResponse("Login Success", true, employer.get());
                    } else {
                        return new LoginResponse("Login Failed", false);
                    }
                } else {
                    return new LoginResponse("Password Not Match", false);
                }
            } else {
                return new LoginResponse("Account Disabled", false);
            }
        } else {
            return new LoginResponse("Username not exists", false);
        }
    }



}
