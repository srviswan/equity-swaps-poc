package com.finos.cashflow.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request for batch generating interest cashflows.
 */
public class BatchInterestGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Calculation date is required")
    private LocalDate calculationDate;
    
    @NotNull(message = "Interest rate is required")
    @Positive(message = "Interest rate must be positive")
    private BigDecimal interestRate;
    
    private InterestCashflowGenerationRequest.DayCountConvention dayCountConvention = InterestCashflowGenerationRequest.DayCountConvention.ACT_365;
    private InterestCashflowGenerationRequest.BusinessDayAdjustment businessDayAdjustment = InterestCashflowGenerationRequest.BusinessDayAdjustment.FOLLOWING;
    
    // Constructors
    public BatchInterestGenerationRequest() {}
    
    public BatchInterestGenerationRequest(List<UUID> contractIds, LocalDate calculationDate, BigDecimal interestRate) {
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
    
    public InterestCashflowGenerationRequest.DayCountConvention getDayCountConvention() {
        return dayCountConvention;
    }
    
    public void setDayCountConvention(InterestCashflowGenerationRequest.DayCountConvention dayCountConvention) {
        this.dayCountConvention = dayCountConvention;
    }
    
    public InterestCashflowGenerationRequest.BusinessDayAdjustment getBusinessDayAdjustment() {
        return businessDayAdjustment;
    }
    
    public void setBusinessDayAdjustment(InterestCashflowGenerationRequest.BusinessDayAdjustment businessDayAdjustment) {
        this.businessDayAdjustment = businessDayAdjustment;
    }
    
    @Override
    public String toString() {
        return "BatchInterestGenerationRequest{" +
                "contractIds=" + contractIds +
                ", calculationDate=" + calculationDate +
                ", interestRate=" + interestRate +
                ", dayCountConvention=" + dayCountConvention +
                ", businessDayAdjustment=" + businessDayAdjustment +
                '}';
    }
}
