package com.lifecycle.cashflow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * DTO for cashflow generation requests.
 * 
 * This class represents the request to generate cashflows for specified contracts
 * and calculation dates.
 */
public class CashflowGenerationRequest {
    
    @NotNull(message = "Contract IDs are required")
    @Size(min = 1, message = "At least one contract ID must be provided")
    private List<UUID> contractIds;
    
    private List<UUID> legIds;
    
    @NotNull(message = "Calculation date is required")
    @PastOrPresent(message = "Calculation date cannot be in the future")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calculationDate;
    
    @NotNull(message = "Cashflow types are required")
    @Size(min = 1, message = "At least one cashflow type must be specified")
    private List<CashflowType> cashflowTypes;
    
    private String businessRules;
    
    private String createdBy;
    
    // Default constructor
    public CashflowGenerationRequest() {}
    
    // Constructor with required fields
    public CashflowGenerationRequest(List<UUID> contractIds, LocalDate calculationDate, 
                                   List<CashflowType> cashflowTypes) {
        this.contractIds = contractIds;
        this.calculationDate = calculationDate;
        this.cashflowTypes = cashflowTypes;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public List<UUID> getLegIds() {
        return legIds;
    }
    
    public void setLegIds(List<UUID> legIds) {
        this.legIds = legIds;
    }
    
    public LocalDate getCalculationDate() {
        return calculationDate;
    }
    
    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }
    
    public List<CashflowType> getCashflowTypes() {
        return cashflowTypes;
    }
    
    public void setCashflowTypes(List<CashflowType> cashflowTypes) {
        this.cashflowTypes = cashflowTypes;
    }
    
    public String getBusinessRules() {
        return businessRules;
    }
    
    public void setBusinessRules(String businessRules) {
        this.businessRules = businessRules;
    }
    
    public String getCreatedBy() {
        return createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    /**
     * Check if this request is for interest calculations.
     * 
     * @return true if interest calculations are requested
     */
    public boolean isInterestRequest() {
        return cashflowTypes != null && 
               cashflowTypes.stream().anyMatch(CashflowType::isInterest);
    }
    
    /**
     * Check if this request is for equity calculations.
     * 
     * @return true if equity calculations are requested
     */
    public boolean isEquityRequest() {
        return cashflowTypes != null && 
               cashflowTypes.stream().anyMatch(type -> 
                   type == CashflowType.PERFORMANCE || type == CashflowType.DIVIDEND);
    }
    
    /**
     * Get the calculation type for thread partitioning.
     * 
     * @return CalculationType.INTEREST if interest, EQUITY if equity
     */
    public CalculationType getPrimaryCalculationType() {
        if (isInterestRequest()) {
            return CalculationType.INTEREST;
        } else if (isEquityRequest()) {
            return CalculationType.EQUITY;
        } else {
            return CalculationType.INTEREST; // Default
        }
    }
    
    @Override
    public String toString() {
        return "CashflowGenerationRequest{" +
                "contractIds=" + contractIds +
                ", legIds=" + legIds +
                ", calculationDate=" + calculationDate +
                ", cashflowTypes=" + cashflowTypes +
                ", businessRules='" + businessRules + '\'' +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
