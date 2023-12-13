package com.example.admiral.repository;

import com.example.admiral.model.EmployeeSheetTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EmployeeSheetTimeRepository extends JpaRepository<EmployeeSheetTime, Long> {
    List<EmployeeSheetTime> findByEmployeeId(Long employeeId);
}
