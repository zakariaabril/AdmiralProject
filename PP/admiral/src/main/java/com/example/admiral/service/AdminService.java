package com.example.admiral.service;

import com.example.admiral.DTO.LoginDTO;
import com.example.admiral.model.Admin;
import com.example.admiral.model.Employer;
import com.example.admiral.repository.AdminRepo;
import com.example.admiral.repository.EmployerRepo;
import com.example.admiral.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String addAdmin(Admin admin) {
        Admin newadmin = new Admin(
                admin.getId(),
                admin.getUsername(),
                this.passwordEncoder.encode(admin.getPassword())
        );
        adminRepo.save(newadmin);
        return admin.getUsername();
    }

    public LoginResponse loginAdmin(LoginDTO loginDTO) {
        String msg = "";
        Admin admin1 = adminRepo.findByUsername(loginDTO.getUsername());
        if (admin1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = admin1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<Admin> admin = adminRepo.findOneByUsernameAndPassword(loginDTO.getUsername(), encodedPassword);
                if (admin.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("username not exits", false);
        }
    }



}
