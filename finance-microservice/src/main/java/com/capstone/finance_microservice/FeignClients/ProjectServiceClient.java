package com.capstone.finance_microservice.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capstone.finance_microservice.DTO.ProjectDetailsDTO;

@FeignClient(name = "project-service", url = "http://PROJECT-SERVICE")
public interface ProjectServiceClient {

    @GetMapping("/api/project/{projectId}")
    ProjectDetailsDTO getProjectById(@PathVariable("projectId") String projectId);
}

