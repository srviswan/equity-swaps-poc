package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request for generating daily accruals for specified contracts and date range.
 */
public class DailyAccrualGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Start date is required")
    private LocalDate startDate;
    
    @NotNull(message = "End date is required")
    private LocalDate endDate;
    
    private List<AccrualType> accrualTypes;
    private BusinessDayAdjustment businessDayAdjustment = BusinessDayAdjustment.FOLLOWING;
    
    // Constructors
    public DailyAccrualGenerationRequest() {}
    
    public DailyAccrualGenerationRequest(List<UUID> contractIds, LocalDate startDate, LocalDate endDate) {
        this.contractIds = contractIds;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public List<AccrualType> getAccrualTypes() {
        return accrualTypes;
    }
    
    public void setAccrualTypes(List<AccrualType> accrualTypes) {
        this.accrualTypes = accrualTypes;
    }
    
    public BusinessDayAdjustment getBusinessDayAdjustment() {
        return businessDayAdjustment;
    }
    
    public void setBusinessDayAdjustment(BusinessDayAdjustment businessDayAdjustment) {
        this.businessDayAdjustment = businessDayAdjustment;
    }
    
    // Enums
    public enum AccrualType {
        INTEREST, DIVIDEND, PERFORMANCE
    }
    
    public enum BusinessDayAdjustment {
        FOLLOWING, PRECEDING, MODIFIED_FOLLOWING
    }
}
