package com.example.admiral.repository;

import com.example.admiral.model.Admin;
import com.example.admiral.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface AdminRepo extends JpaRepository<Admin, Long> {
    Optional<Admin> findOneByUsernameAndPassword(String username, String password);
    Admin findByUsername(String username);
}
