package com.example.admiral.controller;
import com.example.admiral.model.EmployeeSheetTime;
import com.example.admiral.service.EmployeeSheetTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-sheet-time")
@CrossOrigin("http://localhost:3000")
public class EmployeeSheetTimeController {

    @Autowired
    private EmployeeSheetTimeService employeeSheetTimeService;

    @PostMapping
    public ResponseEntity<List<EmployeeSheetTime>> createEmployeeSheetTimes(@RequestBody List<EmployeeSheetTime> employeeSheetTimes) {
        List<EmployeeSheetTime> createdSheetTimes = employeeSheetTimeService.createEmployeeSheetTimes(employeeSheetTimes);
        return new ResponseEntity<>(createdSheetTimes, HttpStatus.CREATED);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeSheetTime>> getEmployeeSheetTimesByEmployeeId(@PathVariable Long employeeId) {
        List<EmployeeSheetTime> employeeSheetTimes = employeeSheetTimeService.getEmployeeSheetTimesByEmployeeId(employeeId);
        if (employeeSheetTimes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeSheetTimes, HttpStatus.OK);
    }

}
