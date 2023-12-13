package com.example.admiral.controller;

import com.example.admiral.DTO.LoginDTO;
import com.example.admiral.model.Admin;
import com.example.admiral.response.LoginResponse;
import com.example.admiral.service.AdminService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping(path = "/save")
    public String saveAdmin(@RequestBody Admin admin)
    {
        String id = adminService.addAdmin(admin);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = adminService.loginAdmin(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }

}
