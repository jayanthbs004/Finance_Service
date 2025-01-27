package com.capstone.finance_microservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.finance_microservice.Model.FinanceDetails;

@Repository
public interface FinanceRepository extends JpaRepository<FinanceDetails, Long> {
    List<FinanceDetails> findByProjectId(Long projectId);
    List<FinanceDetails> findByPoId(String poId);
}
