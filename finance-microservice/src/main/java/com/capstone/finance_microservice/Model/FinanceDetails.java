package com.capstone.finance_microservice.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "finance_details")
public class FinanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable = false)
    private String poId;

    @Column(nullable = false)
    private Double budget;

    @Column(nullable = false)
    private Double allocatedSalary;

    @Column(nullable = false)
    private Double remainingBudget;

    @Column(nullable = false)
    private LocalDate createdDate;

    public FinanceDetails() {
    }

    public FinanceDetails(Long id, String projectId, String poId, Double budget, Double allocatedSalary,
            Double remainingBudget, LocalDate createdDate) {
        this.id = id;
        this.projectId = projectId;
        this.poId = poId;
        this.budget = budget;
        this.allocatedSalary = allocatedSalary;
        this.remainingBudget = remainingBudget;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Double getAllocatedSalary() {
        return allocatedSalary;
    }

    public void setAllocatedSalary(Double allocatedSalary) {
        this.allocatedSalary = allocatedSalary;
    }

    public Double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(Double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    
    // Getters and Setters
    
}

