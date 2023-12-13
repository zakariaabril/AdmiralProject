package com.example.admiral.repository;

import com.example.admiral.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface EmployerRepo extends JpaRepository<Employer, Long> {
    Optional<Employer> findOneByUsernameAndPassword(String username, String password);
    Employer findByUsername(String username);
}
