package com.ust.finance_analysis.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    
    @ManyToOne
    @JoinColumn(name = "finance_id")
    private FinanceRecord financeRecord;
    
    private String employeeId; // Nullable for non-salary transactions
    private double amount;
    private String transactionType; // SALARY, PURCHASE, MISC
    private LocalDateTime timestamp = LocalDateTime.now();
    public Transaction() {
    }
    public Transaction(Long transactionId, FinanceRecord financeRecord, String employeeId, double amount,
            String transactionType, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.financeRecord = financeRecord;
        this.employeeId = employeeId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
    }
    public Long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
    public FinanceRecord getFinanceRecord() {
        return financeRecord;
    }
    public void setFinanceRecord(FinanceRecord financeRecord) {
        this.financeRecord = financeRecord;
    }
    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    
    // Getters and Setters
}
