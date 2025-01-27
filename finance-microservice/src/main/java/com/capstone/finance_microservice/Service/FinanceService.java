package com.capstone.finance_microservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.finance_microservice.Model.FinanceDetails;
import com.capstone.finance_microservice.Repository.FinanceRepository;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    public FinanceDetails saveFinanceDetails(FinanceDetails financeDetails) {
        return financeRepository.save(financeDetails);
    }

    public List<FinanceDetails> getFinanceDetailsByProjectId(String projectId) {
        return financeRepository.findByProjectId(projectId);
    }

    public List<FinanceDetails> getFinanceDetailsByPoId(String poId) {
        return financeRepository.findByPoId(poId);
    }

    public FinanceDetails updateFinanceDetails(Long id, FinanceDetails updatedDetails) {
        return financeRepository.findById(id)
                .map(finance -> {
                    finance.setBudget(updatedDetails.getBudget());
                    finance.setAllocatedSalary(updatedDetails.getAllocatedSalary());
                    finance.setRemainingBudget(updatedDetails.getRemainingBudget());
                    return financeRepository.save(finance);
                })
                .orElseThrow(() -> new RuntimeException("Finance record not found"));
    }

    public void deleteFinanceDetails(Long id) {
        financeRepository.deleteById(id);
    }
}

