package com.capstone.finance_microservice.Controller;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.finance_microservice.FeignClients.PurchaseOrderClient;



@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final PurchaseOrderClient purchaseOrderServiceClient;

    public FinanceController(PurchaseOrderClient purchaseOrderServiceClient) {
        this.purchaseOrderServiceClient = purchaseOrderServiceClient;
    }

    @GetMapping("/project-employee-details/{poId}")
    public ResponseEntity<Map<String, Object>> getProjectAndEmployeeDetailsByPoId(@PathVariable Long poId) {
        return purchaseOrderServiceClient.getProjectAndEmployeeDetailsByPoId(poId);
    }
}
