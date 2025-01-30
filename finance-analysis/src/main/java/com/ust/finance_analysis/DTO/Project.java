package com.ust.finance_analysis.DTO;

import java.util.List;

public class Project {
    private String projectId;
    private String title;
    private String projectDescription;
    private List<String> techStack;
    private String projectLocation;
    private String plannedStartDate;
    private String plannedEndDate;
    private String status; // 'Active', 'Completed', 'Pending'
    private Double budget;
    public Project() {
    }
    public Project(String projectId, String title, String projectDescription, List<String> techStack,
            String projectLocation, String plannedStartDate, String plannedEndDate, String status, Double budget) {
        this.projectId = projectId;
        this.title = title;
        this.projectDescription = projectDescription;
        this.techStack = techStack;
        this.projectLocation = projectLocation;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.status = status;
        this.budget = budget;
    }
    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getProjectDescription() {
        return projectDescription;
    }
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    public List<String> getTechStack() {
        return techStack;
    }
    public void setTechStack(List<String> techStack) {
        this.techStack = techStack;
    }
    public String getProjectLocation() {
        return projectLocation;
    }
    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }
    public String getPlannedStartDate() {
        return plannedStartDate;
    }
    public void setPlannedStartDate(String plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }
    public String getPlannedEndDate() {
        return plannedEndDate;
    }
    public void setPlannedEndDate(String plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Double getBudget() {
        return budget;
    }
    public void setBudget(Double budget) {
        this.budget = budget;
    }
        
}

