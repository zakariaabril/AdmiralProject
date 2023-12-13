package com.example.admiral.service;

import com.example.admiral.model.EmployeeSheetTime;
import com.example.admiral.repository.EmployeeSheetTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSheetTimeService {

    @Autowired
    private EmployeeSheetTimeRepository employeeSheetTimeRepository;


    public List<EmployeeSheetTime> createEmployeeSheetTimes(List<EmployeeSheetTime> employeeSheetTimes) {
        List<EmployeeSheetTime> createdSheetTimes = new ArrayList<>();
        for (EmployeeSheetTime employeeSheetTime : employeeSheetTimes) {
            createdSheetTimes.add(employeeSheetTimeRepository.save(employeeSheetTime));
        }
        return createdSheetTimes;
    }

    public List<EmployeeSheetTime> getEmployeeSheetTimesByEmployeeId(Long employeeId) {
        return employeeSheetTimeRepository.findByEmployeeId(employeeId);
    }
}
