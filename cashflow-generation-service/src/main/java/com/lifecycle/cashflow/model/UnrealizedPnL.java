package com.lifecycle.cashflow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("unrealized_pnl_timeseries")
public class UnrealizedPnL {
    
    @Id
    private UUID id;
    
    @Column("contract_id")
    private UUID contractId;
    
    @Column("security_id")
    private String securityId;
    
    @Column("calculation_date")
    private LocalDate calculationDate;
    
    @Column("unrealized_pnl")
    private BigDecimal unrealizedPnL;
    
    @Column("market_value")
    private BigDecimal marketValue;
    
    @Column("book_value")
    private BigDecimal bookValue;
    
    @Column("quantity")
    private BigDecimal quantity;
    
    @Column("market_price")
    private BigDecimal marketPrice;
    
    @Column("book_price")
    private BigDecimal bookPrice;
    
    @Column("currency")
    private String currency;
    
    @Column("pnl_type")
    private String pnlType; // EQUITY, INTEREST, TOTAL
    
    @Column("calculation_method")
    private String calculationMethod; // MARK_TO_MARKET, FAIR_VALUE, etc.
    
    @Column("volatility_factor")
    private BigDecimal volatilityFactor;
    
    @Column("risk_metrics")
    private String riskMetrics; // JSON string for additional risk metrics
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
    
    @Column("created_by")
    private String createdBy;
    
    @Column("updated_by")
    private String updatedBy;
    
    // Default constructor
    public UnrealizedPnL() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with required fields
    public UnrealizedPnL(UUID contractId, String securityId, LocalDate calculationDate, 
                         BigDecimal unrealizedPnL, BigDecimal marketValue, BigDecimal bookValue, 
                         String currency) {
        this();
        this.contractId = contractId;
        this.securityId = securityId;
        this.calculationDate = calculationDate;
        this.unrealizedPnL = unrealizedPnL;
        this.marketValue = marketValue;
        this.bookValue = bookValue;
        this.currency = currency;
    }
    
    // Constructor for equity P&L
    public UnrealizedPnL(UUID contractId, String securityId, LocalDate calculationDate, 
                         BigDecimal unrealizedPnL, BigDecimal marketValue, BigDecimal bookValue,
                         BigDecimal quantity, BigDecimal marketPrice, BigDecimal bookPrice, 
                         String currency) {
        this(contractId, securityId, calculationDate, unrealizedPnL, marketValue, bookValue, currency);
        this.quantity = quantity;
        this.marketPrice = marketPrice;
        this.bookPrice = bookPrice;
        this.pnlType = "EQUITY";
    }
    
    // Constructor for interest P&L
    public UnrealizedPnL(UUID contractId, String securityId, LocalDate calculationDate, 
                         BigDecimal unrealizedPnL, BigDecimal marketValue, BigDecimal bookValue,
                         String currency, BigDecimal volatilityFactor) {
        this(contractId, securityId, calculationDate, unrealizedPnL, marketValue, bookValue, currency);
        this.pnlType = "INTEREST";
        this.volatilityFactor = volatilityFactor;
    }
    
    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public UUID getContractId() { return contractId; }
    public void setContractId(UUID contractId) { this.contractId = contractId; }
    
    public String getSecurityId() { return securityId; }
    public void setSecurityId(String securityId) { this.securityId = securityId; }
    
    public LocalDate getCalculationDate() { return calculationDate; }
    public void setCalculationDate(LocalDate calculationDate) { this.calculationDate = calculationDate; }
    
    public BigDecimal getUnrealizedPnL() { return unrealizedPnL; }
    public void setUnrealizedPnL(BigDecimal unrealizedPnL) { this.unrealizedPnL = unrealizedPnL; }
    
    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }
    
    public BigDecimal getBookValue() { return bookValue; }
    public void setBookValue(BigDecimal bookValue) { this.bookValue = bookValue; }
    
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    
    public BigDecimal getMarketPrice() { return marketPrice; }
    public void setMarketPrice(BigDecimal marketPrice) { this.marketPrice = marketPrice; }
    
    public BigDecimal getBookPrice() { return bookPrice; }
    public void setBookPrice(BigDecimal bookPrice) { this.bookPrice = bookPrice; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public String getPnlType() { return pnlType; }
    public void setPnlType(String pnlType) { this.pnlType = pnlType; }
    
    public String getCalculationMethod() { return calculationMethod; }
    public void setCalculationMethod(String calculationMethod) { this.calculationMethod = calculationMethod; }
    
    public BigDecimal getVolatilityFactor() { return volatilityFactor; }
    public void setVolatilityFactor(BigDecimal volatilityFactor) { this.volatilityFactor = volatilityFactor; }
    
    public String getRiskMetrics() { return riskMetrics; }
    public void setRiskMetrics(String riskMetrics) { this.riskMetrics = riskMetrics; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
    
    // Business methods
    public boolean isEquityPnL() {
        return "EQUITY".equals(pnlType);
    }
    
    public boolean isInterestPnL() {
        return "INTEREST".equals(pnlType);
    }
    
    public boolean isTotalPnL() {
        return "TOTAL".equals(pnlType);
    }
    
    public BigDecimal calculatePnLPercentage() {
        if (bookValue != null && bookValue.compareTo(BigDecimal.ZERO) != 0) {
            return unrealizedPnL.divide(bookValue, 4, BigDecimal.ROUND_HALF_UP)
                    .multiply(new BigDecimal("100"));
        }
        return BigDecimal.ZERO;
    }
    
    public void updateMarketValue(BigDecimal newMarketValue) {
        this.marketValue = newMarketValue;
        this.unrealizedPnL = marketValue.subtract(bookValue);
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateMarketPrice(BigDecimal newMarketPrice) {
        this.marketPrice = newMarketPrice;
        if (quantity != null) {
            this.marketValue = quantity.multiply(newMarketPrice);
            this.unrealizedPnL = marketValue.subtract(bookValue);
        }
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateBookValue(BigDecimal newBookValue) {
        this.bookValue = newBookValue;
        this.unrealizedPnL = marketValue.subtract(bookValue);
        this.updatedAt = LocalDateTime.now();
    }
    
    public boolean isPositivePnL() {
        return unrealizedPnL != null && unrealizedPnL.compareTo(BigDecimal.ZERO) > 0;
    }
    
    public boolean isNegativePnL() {
        return unrealizedPnL != null && unrealizedPnL.compareTo(BigDecimal.ZERO) < 0;
    }
    
    public boolean isZeroPnL() {
        return unrealizedPnL != null && unrealizedPnL.compareTo(BigDecimal.ZERO) == 0;
    }
    
    @Override
    public String toString() {
        return "UnrealizedPnL{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", securityId='" + securityId + '\'' +
                ", calculationDate=" + calculationDate +
                ", unrealizedPnL=" + unrealizedPnL +
                ", marketValue=" + marketValue +
                ", bookValue=" + bookValue +
                ", quantity=" + quantity +
                ", marketPrice=" + marketPrice +
                ", bookPrice=" + bookPrice +
                ", currency='" + currency + '\'' +
                ", pnlType='" + pnlType + '\'' +
                ", calculationMethod='" + calculationMethod + '\'' +
                ", volatilityFactor=" + volatilityFactor +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
