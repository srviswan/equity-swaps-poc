package com.finos.cashflow.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request for batch generating equity cashflows.
 */
public class BatchEquityGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Valuation date is required")
    private LocalDate valuationDate;
    
    private boolean includeComponents = true;
    
    // Constructors
    public BatchEquityGenerationRequest() {}
    
    public BatchEquityGenerationRequest(List<UUID> contractIds, LocalDate valuationDate) {
        this.contractIds = contractIds;
        this.valuationDate = valuationDate;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public LocalDate getValuationDate() {
        return valuationDate;
    }
    
    public void setValuationDate(LocalDate valuationDate) {
        this.valuationDate = valuationDate;
    }
    
    public boolean isIncludeComponents() {
        return includeComponents;
    }
    
    public void setIncludeComponents(boolean includeComponents) {
        this.includeComponents = includeComponents;
    }
    
    @Override
    public String toString() {
        return "BatchEquityGenerationRequest{" +
                "contractIds=" + contractIds +
                ", valuationDate=" + valuationDate +
                ", includeComponents=" + includeComponents +
                '}';
    }
}
