package com.lifecycle.cashflow.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Table("daily_accruals")
public class DailyAccrual {
    
    @Id
    private UUID id;
    
    @Column("contract_id")
    private UUID contractId;
    
    @Column("security_id")
    private String securityId;
    
    @Column("type")
    private String type; // INTEREST, DIVIDEND, PERFORMANCE
    
    @Column("accrual_date")
    private LocalDate accrualDate;
    
    @Column("accrual_amount")
    private BigDecimal accrualAmount;
    
    @Column("rate")
    private BigDecimal rate;
    
    @Column("quantity")
    private BigDecimal quantity;
    
    @Column("price")
    private BigDecimal price;
    
    @Column("currency")
    private String currency;
    
    @Column("business_days")
    private Integer businessDays;
    
    @Column("total_days")
    private Integer totalDays;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
    
    @Column("created_by")
    private String createdBy;
    
    @Column("updated_by")
    private String updatedBy;
    
    // Default constructor
    public DailyAccrual() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    // Constructor with required fields
    public DailyAccrual(UUID contractId, String securityId, String type, LocalDate accrualDate, 
                        BigDecimal accrualAmount, String currency) {
        this();
        this.contractId = contractId;
        this.securityId = securityId;
        this.type = type;
        this.accrualDate = accrualDate;
        this.accrualAmount = accrualAmount;
        this.currency = currency;
    }
    
    // Constructor for interest accruals
    public DailyAccrual(UUID contractId, String securityId, LocalDate accrualDate, 
                        BigDecimal accrualAmount, BigDecimal rate, String currency, 
                        Integer businessDays, Integer totalDays) {
        this(contractId, securityId, "INTEREST", accrualDate, accrualAmount, currency);
        this.rate = rate;
        this.businessDays = businessDays;
        this.totalDays = totalDays;
    }
    
    // Constructor for dividend accruals
    public DailyAccrual(UUID contractId, String securityId, LocalDate accrualDate, 
                        BigDecimal accrualAmount, BigDecimal quantity, BigDecimal price, 
                        String currency) {
        this(contractId, securityId, "DIVIDEND", accrualDate, accrualAmount, currency);
        this.quantity = quantity;
        this.price = price;
    }
    
    // Constructor for performance accruals
    public DailyAccrual(UUID contractId, String securityId, LocalDate accrualDate, 
                        BigDecimal accrualAmount, BigDecimal price, String currency) {
        this(contractId, securityId, "PERFORMANCE", accrualDate, accrualAmount, currency);
        this.price = price;
    }
    
    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    
    public UUID getContractId() { return contractId; }
    public void setContractId(UUID contractId) { this.contractId = contractId; }
    
    public String getSecurityId() { return securityId; }
    public void setSecurityId(String securityId) { this.securityId = securityId; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public LocalDate getAccrualDate() { return accrualDate; }
    public void setAccrualDate(LocalDate accrualDate) { this.accrualDate = accrualDate; }
    
    public BigDecimal getAccrualAmount() { return accrualAmount; }
    public void setAccrualAmount(BigDecimal accrualAmount) { this.accrualAmount = accrualAmount; }
    
    public BigDecimal getRate() { return rate; }
    public void setRate(BigDecimal rate) { this.rate = rate; }
    
    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }
    
    public Integer getBusinessDays() { return businessDays; }
    public void setBusinessDays(Integer businessDays) { this.businessDays = businessDays; }
    
    public Integer getTotalDays() { return totalDays; }
    public void setTotalDays(Integer totalDays) { this.totalDays = totalDays; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    
    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    
    public String getUpdatedBy() { return updatedBy; }
    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }
    
    // Business methods
    public boolean isInterestAccrual() {
        return "INTEREST".equals(type);
    }
    
    public boolean isDividendAccrual() {
        return "DIVIDEND".equals(type);
    }
    
    public boolean isPerformanceAccrual() {
        return "PERFORMANCE".equals(type);
    }
    
    public void updateAccrualAmount(BigDecimal newAmount) {
        this.accrualAmount = newAmount;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updatePrice(BigDecimal newPrice) {
        this.price = newPrice;
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateRate(BigDecimal newRate) {
        this.rate = newRate;
        this.updatedAt = LocalDateTime.now();
    }
    
    @Override
    public String toString() {
        return "DailyAccrual{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", securityId='" + securityId + '\'' +
                ", type='" + type + '\'' +
                ", accrualDate=" + accrualDate +
                ", accrualAmount=" + accrualAmount +
                ", rate=" + rate +
                ", quantity=" + quantity +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", businessDays=" + businessDays +
                ", totalDays=" + totalDays +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
