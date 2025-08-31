package com.lifecycle.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

/**
 * Request for deferring a cashflow with specified reason and period.
 */
public class CashflowDeferralRequest {
    
    @NotNull(message = "Deferral reason is required")
    private DeferralReason deferralReason;
    
    @NotNull(message = "Expected realization date is required")
    private LocalDate expectedRealizationDate;
    
    @Positive(message = "Deferral period days must be positive")
    private Integer deferralPeriodDays;
    
    @NotBlank(message = "Business justification is required")
    private String businessJustification;
    
    private boolean approvalRequired = false;
    
    // Constructors
    public CashflowDeferralRequest() {}
    
    public CashflowDeferralRequest(DeferralReason deferralReason, LocalDate expectedRealizationDate, String businessJustification) {
        this.deferralReason = deferralReason;
        this.expectedRealizationDate = expectedRealizationDate;
        this.businessJustification = businessJustification;
    }
    
    // Getters and Setters
    public DeferralReason getDeferralReason() {
        return deferralReason;
    }
    
    public void setDeferralReason(DeferralReason deferralReason) {
        this.deferralReason = deferralReason;
    }
    
    public LocalDate getExpectedRealizationDate() {
        return expectedRealizationDate;
    }
    
    public void setExpectedRealizationDate(LocalDate expectedRealizationDate) {
        this.expectedRealizationDate = expectedRealizationDate;
    }
    
    public Integer getDeferralPeriodDays() {
        return deferralPeriodDays;
    }
    
    public void setDeferralPeriodDays(Integer deferralPeriodDays) {
        this.deferralPeriodDays = deferralPeriodDays;
    }
    
    public String getBusinessJustification() {
        return businessJustification;
    }
    
    public void setBusinessJustification(String businessJustification) {
        this.businessJustification = businessJustification;
    }
    
    public boolean isApprovalRequired() {
        return approvalRequired;
    }
    
    public void setApprovalRequired(boolean approvalRequired) {
        this.approvalRequired = approvalRequired;
    }
    
    // Enum
    public enum DeferralReason {
        BUSINESS_RULE, REGULATORY, COUNTERPARTY_REQUEST, MARKET_CONDITIONS, TECHNICAL_ISSUE
    }
}
