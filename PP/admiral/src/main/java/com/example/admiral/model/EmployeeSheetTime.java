package com.example.admiral.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class EmployeeSheetTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employer employee;

    private Date selectedStartDate;
    private Date selectedEndDate;

    private String projet;
    private String activity;
    private double monday;
    private double tuesday;
    private double wednesday;
    private double thursday;
    private double friday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employer getEmployee() {
        return employee;
    }

    public void setEmployee(Employer employee) {
        this.employee = employee;
    }

    public Date getSelectedStartDate() {
        return selectedStartDate;
    }

    public void setSelectedStartDate(Date selectedStartDate) {
        this.selectedStartDate = selectedStartDate;
    }

    public Date getSelectedEndDate() {
        return selectedEndDate;
    }

    public void setSelectedEndDate(Date selectedEndDate) {
        this.selectedEndDate = selectedEndDate;
    }

    public double getMonday() {
        return monday;
    }

    public void setMonday(double monday) {
        this.monday = monday;
    }

    public double getTuesday() {
        return tuesday;
    }

    public void setTuesday(double tuesday) {
        this.tuesday = tuesday;
    }

    public double getWednesday() {
        return wednesday;
    }

    public void setWednesday(double wednesday) {
        this.wednesday = wednesday;
    }

    public double getThursday() {
        return thursday;
    }

    public void setThursday(double thursday) {
        this.thursday = thursday;
    }

    public double getFriday() {
        return friday;
    }

    public void setFriday(double friday) {
        this.friday = friday;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}

