package com.ust.finance_analysis.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.finance_analysis.Model.FinanceRecord;

@Repository
public interface FinanceRecordRepository extends JpaRepository<FinanceRecord, Long> {
    Optional<FinanceRecord> findByProjectIdOrPoId(String projectId, String poId);
}

