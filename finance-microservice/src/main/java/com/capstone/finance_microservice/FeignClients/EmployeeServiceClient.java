package com.capstone.finance_microservice.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.finance_microservice.DTO.EmployeeDTO;

@FeignClient(name = "employee-service", url = "http://EMPLOYEE-SERVICE")
public interface EmployeeServiceClient {

    @GetMapping("/api/employee/project/{projectId}")
    List<EmployeeDTO> getEmployeesByProjectId(@PathVariable("projectId") String projectId);
}

