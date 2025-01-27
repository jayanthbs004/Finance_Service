package com.capstone.finance_microservice.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.finance_microservice.DTO.ProjectDetailsDTO;

@FeignClient(name = "project-service", url = "http://localhost:3031/api/projects")
public interface ProjectServiceClient {

    @GetMapping("/{Id}")
    ProjectDetailsDTO getProjectById(@PathVariable("projectId") Long projectId);
}

