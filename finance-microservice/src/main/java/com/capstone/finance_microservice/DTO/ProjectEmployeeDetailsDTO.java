package com.capstone.finance_microservice.DTO;

import java.util.List;

public class ProjectEmployeeDetailsDTO {
    private ProjectDetailsDTO projectDetails;
    private List<EmployeeDTO> employees;
    public ProjectEmployeeDetailsDTO() {
    }
    public ProjectEmployeeDetailsDTO(ProjectDetailsDTO projectDetails, List<EmployeeDTO> employees) {
        this.projectDetails = projectDetails;
        this.employees = employees;
    }
    public ProjectDetailsDTO getProjectDetails() {
        return projectDetails;
    }
    public void setProjectDetails(ProjectDetailsDTO projectDetails) {
        this.projectDetails = projectDetails;
    }
    public List<EmployeeDTO> getEmployees() {
        return employees;
    }
    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    // Getters and Setters
}
