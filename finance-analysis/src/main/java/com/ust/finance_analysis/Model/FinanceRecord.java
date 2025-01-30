package com.ust.finance_analysis.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "finance_records")
public class FinanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long financeId;
    
    private String projectId;
    private String poId;
    private double totalBudget;
    private double remainingBudget;
    private double totalSalariesPaid;
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToMany(mappedBy = "financeRecord", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public FinanceRecord() {
    }

    public FinanceRecord(Long financeId, String projectId, String poId, double totalBudget, double remainingBudget,
            double totalSalariesPaid, LocalDateTime createdAt, List<Transaction> transactions) {
        this.financeId = financeId;
        this.projectId = projectId;
        this.poId = poId;
        this.totalBudget = totalBudget;
        this.remainingBudget = remainingBudget;
        this.totalSalariesPaid = totalSalariesPaid;
        this.createdAt = createdAt;
        this.transactions = transactions;
    }

    public Long getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Long financeId) {
        this.financeId = financeId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public double getTotalSalariesPaid() {
        return totalSalariesPaid;
    }

    public void setTotalSalariesPaid(double totalSalariesPaid) {
        this.totalSalariesPaid = totalSalariesPaid;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    
    // Getters and Setters
}
