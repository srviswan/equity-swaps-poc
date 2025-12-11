package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Request for settling a cashflow.
 */
public class CashflowSettlementRequest {
    
    @NotNull(message = "Settlement date is required")
    private LocalDate settlementDate;
    
    @NotNull(message = "Settlement amount is required")
    @Positive(message = "Settlement amount must be positive")
    private BigDecimal settlementAmount;
    
    private String paymentReference;
    private SettlementMethod settlementMethod;
    
    // Constructors
    public CashflowSettlementRequest() {}
    
    public CashflowSettlementRequest(LocalDate settlementDate, BigDecimal settlementAmount) {
        this.settlementDate = settlementDate;
        this.settlementAmount = settlementAmount;
    }
    
    // Getters and Setters
    public LocalDate getSettlementDate() {
        return settlementDate;
    }
    
    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }
    
    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }
    
    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }
    
    public String getPaymentReference() {
        return paymentReference;
    }
    
    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }
    
    public SettlementMethod getSettlementMethod() {
        return settlementMethod;
    }
    
    public void setSettlementMethod(SettlementMethod settlementMethod) {
        this.settlementMethod = settlementMethod;
    }
    
    // Enum
    public enum SettlementMethod {
        WIRE, ACH, CHAPS, SEPA
    }
}

