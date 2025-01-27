package com.capstone.finance_microservice.DTO;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String designation;
    private String skills;
    private LocalDate joiningDate;
    private double salary;
    public EmployeeDTO() {
    }
    public EmployeeDTO(Long id, String name, String designation, String skills, LocalDate joiningDate, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.skills = skills;
        this.joiningDate = joiningDate;
        this.salary = salary;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getSkills() {
        return skills;
    }
    public void setSkills(String skills) {
        this.skills = skills;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    // Getters and Setters
    
}
