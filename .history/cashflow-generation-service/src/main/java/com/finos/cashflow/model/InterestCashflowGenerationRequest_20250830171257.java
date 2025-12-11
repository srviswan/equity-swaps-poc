package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request for generating interest cashflows with specific interest rate parameters.
 */
public class InterestCashflowGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Calculation date is required")
    private LocalDate calculationDate;
    
    @NotNull(message = "Interest rate is required")
    @Positive(message = "Interest rate must be positive")
    private BigDecimal interestRate;
    
    private DayCountConvention dayCountConvention = DayCountConvention.ACT_365;
    private BusinessDayAdjustment businessDayAdjustment = BusinessDayAdjustment.FOLLOWING;
    
    // Constructors
    public InterestCashflowGenerationRequest() {}
    
    public InterestCashflowGenerationRequest(List<UUID> contractIds, LocalDate calculationDate, BigDecimal interestRate) {
        this.contractIds = contractIds;
        this.calculationDate = calculationDate;
        this.interestRate = interestRate;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public LocalDate getCalculationDate() {
        return calculationDate;
    }
    
    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }
    
    public BigDecimal getInterestRate() {
        return interestRate;
    }
    
    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
    
    public DayCountConvention getDayCountConvention() {
        return dayCountConvention;
    }
    
    public void setDayCountConvention(DayCountConvention dayCountConvention) {
        this.dayCountConvention = dayCountConvention;
    }
    
    public BusinessDayAdjustment getBusinessDayAdjustment() {
        return businessDayAdjustment;
    }
    
    public void setBusinessDayAdjustment(BusinessDayAdjustment businessDayAdjustment) {
        this.businessDayAdjustment = businessDayAdjustment;
    }
    
    // Enums
    public enum DayCountConvention {
        ACT_365, ACT_360, ACT_ACT, THIRTY_360
    }
    
    public enum BusinessDayAdjustment {
        FOLLOWING, PRECEDING, MODIFIED_FOLLOWING
    }
}
