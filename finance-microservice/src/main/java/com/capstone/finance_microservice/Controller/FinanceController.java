package com.capstone.finance_microservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.finance_microservice.Model.FinanceDetails;
import com.capstone.finance_microservice.Service.FinanceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @PostMapping
    public ResponseEntity<FinanceDetails> createFinanceDetails(@RequestBody @Valid FinanceDetails financeDetails) {
        return new ResponseEntity<>(financeService.saveFinanceDetails(financeDetails), HttpStatus.CREATED);
    }

    @GetMapping("/project/{projectId}")
    public ResponseEntity<List<FinanceDetails>> getByProjectId(@PathVariable String projectId) {
        return ResponseEntity.ok(financeService.getFinanceDetailsByProjectId(projectId));
    }

    @GetMapping("/po/{poId}")
    public ResponseEntity<List<FinanceDetails>> getByPoId(@PathVariable String poId) {
        return ResponseEntity.ok(financeService.getFinanceDetailsByPoId(poId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FinanceDetails> updateFinanceDetails(@PathVariable Long id, @RequestBody @Valid FinanceDetails financeDetails) {
        return ResponseEntity.ok(financeService.updateFinanceDetails(id, financeDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinanceDetails(@PathVariable Long id) {
        financeService.deleteFinanceDetails(id);
        return ResponseEntity.noContent().build();
    }
}

