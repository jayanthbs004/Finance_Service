package com.ust.finance_analysis.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.finance_analysis.Model.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByFinanceRecord_FinanceId(Long financeId);
}
