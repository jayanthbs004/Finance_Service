package com.ust.finance_analysis.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ust.finance_analysis.Clinets.EmployeeClient;
import com.ust.finance_analysis.Clinets.ProjectClient;
import com.ust.finance_analysis.Clinets.PurchaseOrderClient;
import com.ust.finance_analysis.DTO.Employee;
import com.ust.finance_analysis.DTO.FinanceReport;
import com.ust.finance_analysis.DTO.Project;
import com.ust.finance_analysis.DTO.PurchaseOrderDTO;
import com.ust.finance_analysis.Model.FinanceRecord;
import com.ust.finance_analysis.Model.Transaction;
import com.ust.finance_analysis.Repository.FinanceRecordRepository;
import com.ust.finance_analysis.Repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FinanceService {

    private final EmployeeClient employeeClient;
    private final ProjectClient projectClient;
    private final PurchaseOrderClient purchaseOrderClient;
    private final FinanceRecordRepository financeRecordRepository;
    private final TransactionRepository transactionRepository;

    public FinanceService(EmployeeClient employeeClient, ProjectClient projectClient, PurchaseOrderClient purchaseOrderClient, 
                          FinanceRecordRepository financeRecordRepository, TransactionRepository transactionRepository) {
        this.employeeClient = employeeClient;
        this.projectClient = projectClient;
        this.purchaseOrderClient = purchaseOrderClient;
        this.financeRecordRepository = financeRecordRepository;
        this.transactionRepository = transactionRepository;
    }

    public FinanceReport generateFinanceReport(String projectId) {
        // Fetch Project Budget
        Project project = projectClient.getProjectById(projectId);
        double projectBudget = project.getBudget();

        // Fetch Employees
        List<Employee> employees = employeeClient.getEmployeesByProjectId(projectId);

        // Fetch PO Details
        Map<String, Object> poDetails = purchaseOrderClient.getPurchaseOrderByProjectId(projectId);
        PurchaseOrderDTO purchaseOrder = new ObjectMapper().convertValue(poDetails.get("purchaseOrderDetails"), PurchaseOrderDTO.class);

        // Calculate Salary Per Employee
        double salaryPerEmployee = employees.isEmpty() ? 0 : projectBudget / employees.size();

        return new FinanceReport(projectId, projectBudget, salaryPerEmployee, employees);
    }

    @Transactional
    public String processSalaries(String projectId) {
        Optional<FinanceRecord> financeRecordOpt = financeRecordRepository.findByProjectIdOrPoId(projectId, null);

        if (financeRecordOpt.isEmpty()) {
            return "Finance record not found for project: " + projectId;
        }

        FinanceRecord financeRecord = financeRecordOpt.get();
        List<Employee> employees = employeeClient.getEmployeesByProjectId(projectId);

        double salaryPerEmployee = financeRecord.getTotalBudget() / employees.size();
        double totalSalariesPaid = 0;

        for (Employee emp : employees) {
            if (financeRecord.getRemainingBudget() >= salaryPerEmployee) {
                Transaction salaryTransaction = new Transaction();
                salaryTransaction.setFinanceRecord(financeRecord);
                salaryTransaction.setEmployeeId(emp.getEmployeeid());
                salaryTransaction.setAmount(salaryPerEmployee);
                salaryTransaction.setTransactionType("SALARY");

                transactionRepository.save(salaryTransaction);
                totalSalariesPaid += salaryPerEmployee;
            } else {
                return "Insufficient budget for salaries!";
            }
        }

        financeRecord.setRemainingBudget(financeRecord.getRemainingBudget() - totalSalariesPaid);
        financeRecord.setTotalSalariesPaid(financeRecord.getTotalSalariesPaid() + totalSalariesPaid);
        financeRecordRepository.save(financeRecord);

        return "Salaries processed successfully for project: " + projectId;
    }

    @Transactional
public String recordExpense(String projectId, double amount, String description) {
    // Fetch project budget
    Project project = projectClient.getProjectById(projectId);
    
    // Ensure finance record exists
    FinanceRecord financeRecord = getOrCreateFinanceRecord(projectId, null, project.getBudget());

    if (financeRecord.getRemainingBudget() < amount) {
        return "Insufficient budget for this expense!";
    }

    // Create and save transaction
    Transaction expenseTransaction = new Transaction();
    expenseTransaction.setFinanceRecord(financeRecord);
    expenseTransaction.setEmployeeId(null);
    expenseTransaction.setAmount(amount);
    expenseTransaction.setTransactionType("PURCHASE");

    transactionRepository.save(expenseTransaction);

    // Update remaining budget
    financeRecord.setRemainingBudget(financeRecord.getRemainingBudget() - amount);
    financeRecordRepository.save(financeRecord);

    return "Expense recorded successfully for project: " + projectId;
}

@Transactional
public FinanceRecord getOrCreateFinanceRecord(String projectId, String poId, double totalBudget) {
    Optional<FinanceRecord> financeRecordOpt = financeRecordRepository.findByProjectIdOrPoId(projectId, poId);

    if (financeRecordOpt.isPresent()) {
        return financeRecordOpt.get();
    }

    // Create a new FinanceRecord if not found
    FinanceRecord newRecord = new FinanceRecord();
    newRecord.setProjectId(projectId);
    newRecord.setPoId(poId);
    newRecord.setTotalBudget(totalBudget);
    newRecord.setRemainingBudget(totalBudget);
    newRecord.setTotalSalariesPaid(0.0);

    return financeRecordRepository.save(newRecord);
}


}
