package com.capstone.finance_microservice.DTO;

import java.time.LocalDate;

public class ProjectDetailsDTO {
    private Long projectId;
    private String name;

    private String clientName;
    private Double budget;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    public ProjectDetailsDTO() {
    }
    public ProjectDetailsDTO(Long id, String name, String clientName, Double budget, LocalDate startDate,
            LocalDate endDate, String status) {
        this.projectId = id;
        this.name = name;
        this.clientName = clientName;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
    public Long getId() {
        return projectId;
    }
    public void setId(Long id) {
        this.projectId = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double budget) {
        this.budget = budget;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // Getters and Setters

}
