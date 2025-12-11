package com.finos.cashflow.model;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Request for batch cashflow generation operations.
 */
public class BatchCashflowGenerationRequest {
    
    @NotEmpty(message = "Requests cannot be empty")
    private List<CashflowGenerationRequest> requests;
    
    // Constructors
    public BatchCashflowGenerationRequest() {}
    
    public BatchCashflowGenerationRequest(List<CashflowGenerationRequest> requests) {
        this.requests = requests;
    }
    
    // Getters and Setters
    public List<CashflowGenerationRequest> getRequests() {
        return requests;
    }
    
    public void setRequests(List<CashflowGenerationRequest> requests) {
        this.requests = requests;
    }
}
