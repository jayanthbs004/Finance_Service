package com.ust.finance_analysis.DTO;

import java.util.List;

public class FinanceReport {
    private String projectId;
    private double totalBudget;
    private double salaryPerEmployee;
    private List<Employee> employees;

    public FinanceReport() {
    }

    public FinanceReport(String projectId, double totalBudget, double salaryPerEmployee, List<Employee> employees) {
        this.projectId = projectId;
        this.totalBudget = totalBudget;
        this.salaryPerEmployee = salaryPerEmployee;
        this.employees = employees;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getSalaryPerEmployee() {
        return salaryPerEmployee;
    }

    public void setSalaryPerEmployee(double salaryPerEmployee) {
        this.salaryPerEmployee = salaryPerEmployee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    // Getters & Setters
}



