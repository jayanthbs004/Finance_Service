package com.ust.finance_analysis.DTO;

public class Employee {
    private String employeeid;
    private String name;
    private String designation;
    private String projectId;
    private String status; // 'idle' or 'assigned'
    public Employee() {
    }
    public Employee(String employeeid, String name, String designation, String projectId, String status) {
        this.employeeid = employeeid;
        this.name = name;
        this.designation = designation;
        this.projectId = projectId;
        this.status = status;
    }
    public String getEmployeeid() {
        return employeeid;
    }
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
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
    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    

    // Getters and Setters
}
