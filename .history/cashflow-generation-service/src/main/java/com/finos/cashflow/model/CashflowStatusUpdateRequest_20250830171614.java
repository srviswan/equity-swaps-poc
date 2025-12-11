package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Map;

/**
 * Request for updating cashflow status (state transition).
 */
public class CashflowStatusUpdateRequest {
    
    @NotNull(message = "New status is required")
    private CashflowStatus newStatus;
    
    @NotBlank(message = "Reason is required")
    private String reason;
    
    private LocalDate effectiveDate;
    private Map<String, Object> metadata;
    
    // Constructors
    public CashflowStatusUpdateRequest() {}
    
    public CashflowStatusUpdateRequest(CashflowStatus newStatus, String reason) {
        this.newStatus = newStatus;
        this.reason = reason;
    }
    
    // Getters and Setters
    public CashflowStatus getNewStatus() {
        return newStatus;
    }
    
    public void setNewStatus(CashflowStatus newStatus) {
        this.newStatus = newStatus;
    }
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }
    
    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    
    public Map<String, Object> getMetadata() {
        return metadata;
    }
    
    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
