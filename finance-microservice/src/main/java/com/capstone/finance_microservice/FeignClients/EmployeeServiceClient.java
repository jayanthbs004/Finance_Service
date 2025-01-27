package com.capstone.finance_microservice.FeignClients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.finance_microservice.DTO.EmployeeDTO;

import java.util.List;


@FeignClient(name = "employee-service", url = "http://localhost:3030/api/employees")
public interface EmployeeServiceClient {

    @GetMapping("/project/{projectId}")
    List<EmployeeDTO> getEmployeesByProjectId(@PathVariable("projectId") Long projectId);
}
