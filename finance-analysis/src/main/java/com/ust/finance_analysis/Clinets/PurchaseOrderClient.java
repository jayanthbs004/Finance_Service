    package com.ust.finance_analysis.Clinets;

    import java.util.Map;

    import org.springframework.cloud.openfeign.FeignClient;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;

    @FeignClient(name = "poservice", url = "http://localhost:3032/api/po")
    public interface PurchaseOrderClient {
        @GetMapping("/project/{projectId}") // Must match `po-service` controller
        Map<String, Object> getPurchaseOrderByProjectId(@PathVariable String projectId);
    }
    