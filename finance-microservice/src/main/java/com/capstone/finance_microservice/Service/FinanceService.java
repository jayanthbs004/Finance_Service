package com.capstone.finance_microservice.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capstone.finance_microservice.DTO.EmployeeDTO;
import com.capstone.finance_microservice.DTO.ProjectDetailsDTO;
import com.capstone.finance_microservice.FeignClients.EmployeeServiceClient;
import com.capstone.finance_microservice.FeignClients.ProjectServiceClient;
import com.capstone.finance_microservice.FeignClients.PurchaseOrderClient;
import com.capstone.finance_microservice.Model.FinanceDetails;
import com.capstone.finance_microservice.Repository.FinanceRepository;

@Service
public class FinanceService {


    private final FinanceRepository financeRepository;
    private final PurchaseOrderClient purchaseOrderClient;
    public FinanceService(FinanceRepository financeRepository, PurchaseOrderClient purchaseOrderClient, ProjectServiceClient projectServiceClient, EmployeeServiceClient employeeServiceClient) {
        this.financeRepository = financeRepository;
        this.purchaseOrderClient = purchaseOrderClient;
    }

    public FinanceDetails saveFinanceDetails(FinanceDetails financeDetails) {
        return financeRepository.save(financeDetails);
    }

    public List<FinanceDetails> getFinanceDetailsByProjectId(Long projectId) {
        return financeRepository.findByProjectId(projectId);
    }

    // public List<FinanceDetails> getFinanceDetailsByPoId(String poId) {
    //     return financeRepository.findByPoId(poId);
    // }
    public FinanceDetails getFinanceDetails(Long poId) {
        // Fetch project and employee details using the PO ID
        ResponseEntity<Map<String, Object>> response = purchaseOrderClient.getProjectAndEmployeeDetailsByPoId(poId);
        
        if (response.getStatusCode() == HttpStatus.OK) {
            Map<String, Object> details = response.getBody();

            // Extract the project and employee details from the response
            ProjectDetailsDTO projectDetails = (ProjectDetailsDTO) details.get("projectDetails");
            List<EmployeeDTO> employeeDetails = (List<EmployeeDTO>) details.get("employeeDetails");

            // Process these details to create finance details
            FinanceDetails financeDetails = new FinanceDetails();
            financeDetails.setProjectId(projectDetails.getId());
            financeDetails.setPoId(poId.toString()); // Assuming poId is a String in FinanceDetails
            financeDetails.setBudget(projectDetails.getBudget());
            financeDetails.setAllocatedSalary(calculateAllocatedSalary(employeeDetails));
            financeDetails.setRemainingBudget(calculateRemainingBudget(projectDetails.getBudget(), financeDetails.getAllocatedSalary()));
            financeDetails.setCreatedDate(LocalDate.now());

            return financeDetails;
        } else {
            // Handle error if project/employee details are not found
            return null;
        }
    }

    private Double calculateAllocatedSalary(List<EmployeeDTO> employeeDetails) {
        // Your logic to calculate the total allocated salary
        return employeeDetails.stream()
                .mapToDouble(EmployeeDTO::getSalary)
                .sum();
    }

    private Double calculateRemainingBudget(Double budget, Double allocatedSalary) {
        // Your logic to calculate the remaining budget
        return budget - allocatedSalary;
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

