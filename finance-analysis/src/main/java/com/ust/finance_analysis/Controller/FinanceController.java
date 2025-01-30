package com.ust.finance_analysis.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ust.finance_analysis.DTO.FinanceReport;
import com.ust.finance_analysis.Service.FinanceService;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceService financeService;

    public FinanceController(FinanceService financeService) {
        this.financeService = financeService;
    }

    @GetMapping("/report/{projectId}")
    public ResponseEntity<FinanceReport> getFinanceReport(@PathVariable String projectId) {
        FinanceReport report = financeService.generateFinanceReport(projectId);
        return ResponseEntity.ok(report);
    }

    @PostMapping("/process-salaries/{projectId}")
    public ResponseEntity<String> processSalaries(@PathVariable String projectId) {
        String response = financeService.processSalaries(projectId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/record-expense/{projectId}")
    public ResponseEntity<String> recordExpense(@PathVariable String projectId, @RequestParam double amount, @RequestParam String description) {
        String response = financeService.recordExpense(projectId, amount, description);
        return ResponseEntity.ok(response);
    }
}
