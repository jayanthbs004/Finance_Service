package com.capstone.finance_microservice.FeignClients;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "purchase-order-service", url = "http://localhost:3032/api/po")
public interface PurchaseOrderClient {

    @GetMapping("/details/{projectId}")
    ResponseEntity<Map<String, Object>> getProjectAndEmployeeDetailsByPoId(@PathVariable("projectId") Long projectId);
}
