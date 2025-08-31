package com.lifecycle.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request for realizing a cashflow (from accrued or deferred state).
 */
public class CashflowRealizationRequest {
    
    @NotNull(message = "Realization date is required")
    private LocalDate realizationDate;
    
    @Positive(message = "Realization amount must be positive")
    private BigDecimal realizationAmount;
    
    private String marketData;
    private String calculationMethod;
    
    // Constructors
    public CashflowRealizationRequest() {}
    
    public CashflowRealizationRequest(LocalDate realizationDate, BigDecimal realizationAmount) {
        this.realizationDate = realizationDate;
        this.realizationAmount = realizationAmount;
    }
    
    // Getters and Setters
    public LocalDate getRealizationDate() {
        return realizationDate;
    }
    
    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }
    
    public BigDecimal getRealizationAmount() {
        return realizationAmount;
    }
    
    public void setRealizationAmount(BigDecimal realizationAmount) {
        this.realizationAmount = realizationAmount;
    }
    
    public String getMarketData() {
        return marketData;
    }
    
    public void setMarketData(String marketData) {
        this.marketData = marketData;
    }
    
    public String getCalculationMethod() {
        return calculationMethod;
    }
    
    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod;
    }
}
