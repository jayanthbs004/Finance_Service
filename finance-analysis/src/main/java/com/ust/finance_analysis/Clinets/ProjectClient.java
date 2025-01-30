package com.ust.finance_analysis.Clinets;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ust.finance_analysis.DTO.Project;

@FeignClient(name = "project-service", url = "http://localhost:3031/api/projects")
public interface ProjectClient {
    @GetMapping("/{id}")
    Project getProjectById(@PathVariable("id") String id);
}
