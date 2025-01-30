package com.ust.finance_analysis.Clinets;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ust.finance_analysis.DTO.Employee;

@FeignClient(name = "employee-service", url = "http://localhost:3030/api/employees")
public interface EmployeeClient {
    @GetMapping("/projects/{projectId}")
    List<Employee> getEmployeesByProjectId(@PathVariable String projectId);
}

