package com.capstone.finance_microservice.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.finance_microservice.DTO.EmployeeDTO;
import com.capstone.finance_microservice.DTO.ProjectDetailsDTO;
import com.capstone.finance_microservice.DTO.ProjectEmployeeDetailsDTO;
import com.capstone.finance_microservice.FeignClients.EmployeeServiceClient;
import com.capstone.finance_microservice.FeignClients.ProjectServiceClient;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final ProjectServiceClient projectServiceClient;
    private final EmployeeServiceClient employeeServiceClient;

    public FinanceController(ProjectServiceClient projectServiceClient, EmployeeServiceClient employeeServiceClient) {
        this.projectServiceClient = projectServiceClient;
        this.employeeServiceClient = employeeServiceClient;
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<ProjectEmployeeDetailsDTO> getProjectAndEmployeeDetails(
            @PathVariable String projectId) {

        // Fetch project details using Feign client
        ProjectDetailsDTO projectDetails = projectServiceClient.getProjectById(projectId);

        // Fetch employees for the project using Feign client
        List<EmployeeDTO> employees = employeeServiceClient.getEmployeesByProjectId(projectId);

        // Combine the project and employee data into a single response
        ProjectEmployeeDetailsDTO response = new ProjectEmployeeDetailsDTO();
        response.setProjectDetails(projectDetails);
        response.setEmployees(employees);

        // Return the response
        return ResponseEntity.ok(response);
    }
}