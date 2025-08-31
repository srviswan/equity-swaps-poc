package com.lifecycle.cashflow.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lifecycle.cashflow.exception.InvalidStateTransitionException;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Core Cashflow entity representing a monetary flow between parties.
 * 
 * This entity supports the complete lifecycle of cashflows from accrual to settlement,
 * with thread partitioning for high-performance processing.
 */
@Table("cashflows")
public class Cashflow {

    @Id
    @Column("id")
    private UUID id;

    @NotNull(message = "Contract ID is required")
    @Column("contract_id")
    private UUID contractId;

    @NotNull(message = "Leg ID is required")
    @Column("leg_id")
    private UUID legId;

    @NotBlank(message = "Security ID is required")
    @Size(max = 50, message = "Security ID must not exceed 50 characters")
    @Column("security_id")
    private String securityId;

    @NotNull(message = "Calculation type is required")
    @Column("calculation_type")
    private CalculationType calculationType;

    @NotNull(message = "Cashflow type is required")
    @Column("cashflow_type")
    private CashflowType cashflowType;

    @NotNull(message = "Status is required")
    @Column("status")
    private CashflowStatus status;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be positive")
    @Digits(integer = 13, fraction = 6, message = "Amount must have max 13 digits and 6 decimal places")
    @Column("amount")
    private BigDecimal amount;

    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be 3 uppercase letters")
    @Column("currency")
    private String currency;

    @NotNull(message = "Calculation date is required")
    @PastOrPresent(message = "Calculation date cannot be in the future")
    @Column("calculation_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate calculationDate;

    @Column("value_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate valueDate;

    @Column("settlement_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate settlementDate;

    @Column("deferral_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate deferralDate;

    @Column("deferral_reason")
    private String deferralReason;

    @Column("deferral_period_days")
    private Integer deferralPeriodDays;

    @Column("notes")
    private String notes;

    @Column("expected_realization_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expectedRealizationDate;

    @NotNull(message = "Created at is required")
    @Column("created_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdAt;

    @NotNull(message = "Updated at is required")
    @Column("updated_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedAt;

    @NotBlank(message = "Created by is required")
    @Column("created_by")
    private String createdBy;

    @NotBlank(message = "Updated by is required")
    @Column("updated_by")
    private String updatedBy;

    // Default constructor
    public Cashflow() {
        this.id = UUID.randomUUID();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Constructor with required fields
    public Cashflow(UUID contractId, UUID legId, String securityId, 
                    CalculationType calculationType, CashflowType cashflowType,
                    BigDecimal amount, String currency, LocalDate calculationDate,
                    String createdBy) {
        this();
        this.contractId = contractId;
        this.legId = legId;
        this.securityId = securityId;
        this.calculationType = calculationType;
        this.cashflowType = cashflowType;
        this.amount = amount;
        this.currency = currency;
        this.calculationDate = calculationDate;
        this.status = CashflowStatus.ACCRUED;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
    }

    // Business methods
    public boolean canTransitionTo(CashflowStatus newStatus) {
        return status.getValidTransitions().contains(newStatus);
    }

    public void transitionTo(CashflowStatus newStatus, String reason) {
        if (!canTransitionTo(newStatus)) {
            throw new InvalidStateTransitionException(
                "Cannot transition from " + status + " to " + newStatus);
        }
        
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = "SYSTEM"; // In real implementation, get from security context
    }

    public boolean isDeferred() {
        return status == CashflowStatus.REALIZED_DEFERRED;
    }

    public boolean isSettled() {
        return status == CashflowStatus.REALIZED_SETTLED;
    }

    public boolean isAccrued() {
        return status == CashflowStatus.ACCRUED;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getContractId() {
        return contractId;
    }

    public void setContractId(UUID contractId) {
        this.contractId = contractId;
    }

    public UUID getLegId() {
        return legId;
    }

    public void setLegId(UUID legId) {
        this.legId = legId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(CalculationType calculationType) {
        this.calculationType = calculationType;
    }

    public CashflowType getCashflowType() {
        return cashflowType;
    }

    public void setCashflowType(CashflowType cashflowType) {
        this.cashflowType = cashflowType;
    }

    public CashflowStatus getStatus() {
        return status;
    }

    public void setStatus(CashflowStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getCalculationDate() {
        return calculationDate;
    }

    public void setCalculationDate(LocalDate calculationDate) {
        this.calculationDate = calculationDate;
    }

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

    public LocalDate getDeferralDate() {
        return deferralDate;
    }

    public void setDeferralDate(LocalDate deferralDate) {
        this.deferralDate = deferralDate;
    }

    public String getDeferralReason() {
        return deferralReason;
    }

    public void setDeferralReason(String deferralReason) {
        this.deferralReason = deferralReason;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getDeferralPeriodDays() {
        return deferralPeriodDays;
    }

    public void setDeferralPeriodDays(Integer deferralPeriodDays) {
        this.deferralPeriodDays = deferralPeriodDays;
    }

    public LocalDate getExpectedRealizationDate() {
        return expectedRealizationDate;
    }

    public void setExpectedRealizationDate(LocalDate expectedRealizationDate) {
        this.expectedRealizationDate = expectedRealizationDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "Cashflow{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", legId=" + legId +
                ", securityId='" + securityId + '\'' +
                ", calculationType=" + calculationType +
                ", cashflowType=" + cashflowType +
                ", status=" + status +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", calculationDate=" + calculationDate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashflow cashflow = (Cashflow) o;
        return id != null && id.equals(cashflow.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
