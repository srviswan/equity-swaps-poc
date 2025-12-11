package com.finos.cashflow.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Request for generating dividend cashflows based on corporate actions.
 */
public class DividendCashflowGenerationRequest {
    
    @NotEmpty(message = "Contract IDs cannot be empty")
    private List<UUID> contractIds;
    
    @NotNull(message = "Dividend date is required")
    private LocalDate dividendDate;
    
    @NotNull(message = "Dividend amount is required")
    @Positive(message = "Dividend amount must be positive")
    private BigDecimal dividendAmount;
    
    private DividendType dividendType = DividendType.ORDINARY;
    
    private LocalDate exDate;
    private LocalDate recordDate;
    
    // Constructors
    public DividendCashflowGenerationRequest() {}
    
    public DividendCashflowGenerationRequest(List<UUID> contractIds, LocalDate dividendDate, BigDecimal dividendAmount) {
        this.contractIds = contractIds;
        this.dividendDate = dividendDate;
        this.dividendAmount = dividendAmount;
    }
    
    // Getters and Setters
    public List<UUID> getContractIds() {
        return contractIds;
    }
    
    public void setContractIds(List<UUID> contractIds) {
        this.contractIds = contractIds;
    }
    
    public LocalDate getDividendDate() {
        return dividendDate;
    }
    
    public void setDividendDate(LocalDate dividendDate) {
        this.dividendDate = dividendDate;
    }
    
    public BigDecimal getDividendAmount() {
        return dividendAmount;
    }
    
    public void setDividendAmount(BigDecimal dividendAmount) {
        this.dividendAmount = dividendAmount;
    }
    
    public DividendType getDividendType() {
        return dividendType;
    }
    
    public void setDividendType(DividendType dividendType) {
        this.dividendType = dividendType;
    }
    
    public LocalDate getExDate() {
        return exDate;
    }
    
    public void setExDate(LocalDate exDate) {
        this.exDate = exDate;
    }
    
    public LocalDate getRecordDate() {
        return recordDate;
    }
    
    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }
    
    // Enum
    public enum DividendType {
        ORDINARY, SPECIAL, RETURN_OF_CAPITAL
    }
}
