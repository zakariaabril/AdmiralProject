package com.example.admiral.repository;


import com.example.admiral.model.FeuilleDeTemps;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FeuilleDeTempsRepository extends JpaRepository<FeuilleDeTemps, Long> {

}