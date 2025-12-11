# Domain Models

## Overview

This document defines the core domain models for the Cash Flow Generation Service, including business entities, their relationships, and alignment with the FINOS Common Domain Model (CDM).

## Core Domain Entities

### **1. Cashflow Entity**

```java
@Entity
@Table(name = "cashflows")
public class Cashflow {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "contract_id", nullable = false)
    private UUID contractId;
    
    @Column(name = "leg_id", nullable = false)
    private UUID legId;
    
    @Column(name = "security_id", nullable = false)
    private String securityId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "calculation_type", nullable = false)
    private CalculationType calculationType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "cashflow_type", nullable = false)
    private CashflowType cashflowType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private CashflowStatus status;
    
    @Column(name = "amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal amount;
    
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;
    
    @Column(name = "calculation_date", nullable = false)
    private LocalDate calculationDate;
    
    @Column(name = "value_date")
    private LocalDate valueDate;
    
    @Column(name = "settlement_date")
    private LocalDate settlementDate;
    
    @Column(name = "deferral_date")
    private LocalDate deferralDate;
    
    @Column(name = "deferral_reason")
    private String deferralReason;
    
    @Column(name = "deferral_period_days")
    private Integer deferralPeriodDays;
    
    @Column(name = "expected_realization_date")
    private LocalDate expectedRealizationDate;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @Column(name = "created_by", nullable = false)
    private String createdBy;
    
    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", insertable = false, updatable = false)
    private Contract contract;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leg_id", insertable = false, updatable = false)
    private ContractLeg leg;
    
    @OneToMany(mappedBy = "cashflow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DailyAccrual> dailyAccruals;
    
    @OneToMany(mappedBy = "cashflow", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CashflowStatusHistory> statusHistory;
    
    // Business methods
    public boolean canTransitionTo(CashflowStatus newStatus) {
        return status.getValidTransitions().contains(newStatus);
    }
    
    public void transitionTo(CashflowStatus newStatus, String reason) {
        if (!canTransitionTo(newStatus)) {
            throw new InvalidStateTransitionException(
                "Cannot transition from " + status + " to " + newStatus);
        }
        
        CashflowStatusHistory history = new CashflowStatusHistory();
        history.setCashflowId(this.id);
        history.setFromStatus(this.status);
        history.setToStatus(newStatus);
        history.setTransitionReason(reason);
        history.setTransitionDate(LocalDateTime.now());
        
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
        this.statusHistory.add(history);
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
}
```

### **2. Contract Entity**

```java
@Entity
@Table(name = "contracts")
public class Contract {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "contract_number", nullable = false, unique = true)
    private String contractNumber;
    
    @Column(name = "contract_type", nullable = false)
    private String contractType;
    
    @Column(name = "trade_date", nullable = false)
    private LocalDate tradeDate;
    
    @Column(name = "effective_date", nullable = false)
    private LocalDate effectiveDate;
    
    @Column(name = "maturity_date")
    private LocalDate maturityDate;
    
    @Column(name = "notional_amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal notionalAmount;
    
    @Column(name = "notional_currency", nullable = false, length = 3)
    private String notionalCurrency;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ContractStatus status;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    // Relationships
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractLeg> legs;
    
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cashflow> cashflows;
    
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractParty> parties;
    
    // Business methods
    public boolean isActive() {
        return status == ContractStatus.ACTIVE;
    }
    
    public boolean isMatured() {
        return maturityDate != null && maturityDate.isBefore(LocalDate.now());
    }
    
    public List<ContractLeg> getEquityLegs() {
        return legs.stream()
            .filter(leg -> leg.getLegType() == LegType.EQUITY)
            .collect(Collectors.toList());
    }
    
    public List<ContractLeg> getInterestLegs() {
        return legs.stream()
            .filter(leg -> leg.getLegType() == LegType.INTEREST)
            .collect(Collectors.toList());
    }
}
```

### **3. ContractLeg Entity**

```java
@Entity
@Table(name = "contract_legs")
public class ContractLeg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "contract_id", nullable = false)
    private UUID contractId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "leg_type", nullable = false)
    private LegType legType;
    
    @Column(name = "leg_number", nullable = false)
    private Integer legNumber;
    
    @Column(name = "notional_amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal notionalAmount;
    
    @Column(name = "notional_currency", nullable = false, length = 3)
    private String notionalCurrency;
    
    @Column(name = "direction", nullable = false)
    private String direction; // PAY or RECEIVE
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id", insertable = false, updatable = false)
    private Contract contract;
    
    @OneToMany(mappedBy = "leg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cashflow> cashflows;
    
    @OneToMany(mappedBy = "leg", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LegUnderlier> underliers;
    
    // Business methods
    public boolean isEquityLeg() {
        return legType == LegType.EQUITY;
    }
    
    public boolean isInterestLeg() {
        return legType == LegType.INTEREST;
    }
    
    public boolean isPayLeg() {
        return "PAY".equals(direction);
    }
    
    public boolean isReceiveLeg() {
        return "RECEIVE".equals(direction);
    }
}
```

### **4. LegUnderlier Entity**

```java
@Entity
@Table(name = "leg_underliers")
public class LegUnderlier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "leg_id", nullable = false)
    private UUID legId;
    
    @Column(name = "security_id", nullable = false)
    private String securityId;
    
    @Column(name = "security_type", nullable = false)
    private String securityType;
    
    @Column(name = "quantity", nullable = false, precision = 19, scale = 6)
    private BigDecimal quantity;
    
    @Column(name = "weight", precision = 5, scale = 4)
    private BigDecimal weight;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "leg_id", insertable = false, updatable = false)
    private ContractLeg leg;
    
    // Business methods
    public boolean isSingleStock() {
        return "SINGLE_STOCK".equals(securityType);
    }
    
    public boolean isIndex() {
        return "INDEX".equals(securityType);
    }
    
    public boolean isBasket() {
        return "BASKET".equals(securityType);
    }
}
```

## Enums and Value Objects

### **1. CashflowStatus Enum**

```java
public enum CashflowStatus {
    
    ACCRUED("Accrued", "Initial state with daily accrual tracking"),
    REALIZED_DEFERRED("Realized Deferred", "Deferred due to business rules or regulatory requirements"),
    REALIZED_UNSETTLED("Realized Unsettled", "Realized but not yet settled"),
    REALIZED_SETTLED("Realized Settled", "Fully settled and confirmed"),
    CANCELLED("Cancelled", "Cancelled cashflow"),
    ADJUSTED("Adjusted", "Adjusted due to corrections or changes");
    
    private final String displayName;
    private final String description;
    
    CashflowStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    public Set<CashflowStatus> getValidTransitions() {
        return switch (this) {
            case ACCRUED -> Set.of(REALIZED_DEFERRED, REALIZED_UNSETTLED, CANCELLED, ADJUSTED);
            case REALIZED_DEFERRED -> Set.of(REALIZED_UNSETTLED, ACCRUED, CANCELLED);
            case REALIZED_UNSETTLED -> Set.of(REALIZED_SETTLED, ACCRUED, CANCELLED);
            case REALIZED_SETTLED -> Set.of(ADJUSTED);
            case CANCELLED -> Set.of(ACCRUED);
            case ADJUSTED -> Set.of(REALIZED_UNSETTLED, CANCELLED);
        };
    }
    
    public boolean isFinal() {
        return this == REALIZED_SETTLED || this == CANCELLED;
    }
    
    public boolean isActive() {
        return this == ACCRUED || this == REALIZED_DEFERRED || this == REALIZED_UNSETTLED;
    }
}
```

### **2. CalculationType Enum**

```java
public enum CalculationType {
    
    INTEREST("Interest", "Interest accruals and rate calculations"),
    EQUITY("Equity", "Equity P&L and dividend calculations");
    
    private final String displayName;
    private final String description;
    
    CalculationType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
    
    public boolean isInterest() {
        return this == INTEREST;
    }
    
    public boolean isEquity() {
        return this == EQUITY;
    }
}
```

### **3. CashflowType Enum**

```java
public enum CashflowType {
    
    INTEREST("Interest", "Interest rate accruals and payments"),
    DIVIDEND("Dividend", "Dividend entitlements and payments"),
    PERFORMANCE("Performance", "Equity return and unrealized P&L"),
    FEES("Fees", "Management fees, performance fees, and other charges");
    
    private final String displayName;
    private final String description;
    
    CashflowType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
}
```

### **4. LegType Enum**

```java
public enum LegType {
    
    EQUITY("Equity", "Equity leg with underlier exposure"),
    INTEREST("Interest", "Interest rate leg with floating rate");
    
    private final String displayName;
    private final String description;
    
    LegType(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }
}
```

## Supporting Entities

### **1. DailyAccrual Entity**

```java
@Entity
@Table(name = "daily_accruals")
public class DailyAccrual {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "cashflow_id", nullable = false)
    private UUID cashflowId;
    
    @Column(name = "accrual_date", nullable = false)
    private LocalDate accrualDate;
    
    @Column(name = "accrual_amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal accrualAmount;
    
    @Column(name = "rate", precision = 10, scale = 6)
    private BigDecimal rate;
    
    @Column(name = "day_count", nullable = false)
    private Integer dayCount;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashflow_id", insertable = false, updatable = false)
    private Cashflow cashflow;
    
    // Business methods
    public BigDecimal getAnnualizedAmount() {
        if (rate == null || dayCount == 0) {
            return BigDecimal.ZERO;
        }
        return accrualAmount.multiply(BigDecimal.valueOf(365))
            .divide(BigDecimal.valueOf(dayCount), 6, RoundingMode.HALF_UP);
    }
}
```

### **2. CashflowStatusHistory Entity**

```java
@Entity
@Table(name = "cashflow_status_history")
public class CashflowStatusHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "cashflow_id", nullable = false)
    private UUID cashflowId;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", nullable = false)
    private CashflowStatus fromStatus;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", nullable = false)
    private CashflowStatus toStatus;
    
    @Column(name = "transition_reason")
    private String transitionReason;
    
    @Column(name = "transition_date", nullable = false)
    private LocalDateTime transitionDate;
    
    @Column(name = "transitioned_by", nullable = false)
    private String transitionedBy;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashflow_id", insertable = false, updatable = false)
    private Cashflow cashflow;
}
```

### **3. UnrealizedPnLTimeseries Entity**

```java
@Entity
@Table(name = "unrealized_pnl_timeseries")
public class UnrealizedPnLTimeseries {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Column(name = "cashflow_id", nullable = false)
    private UUID cashflowId;
    
    @Column(name = "valuation_date", nullable = false)
    private LocalDate valuationDate;
    
    @Column(name = "unrealized_amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal unrealizedAmount;
    
    @Column(name = "market_price", precision = 19, scale = 6)
    private BigDecimal marketPrice;
    
    @Column(name = "reference_price", precision = 19, scale = 6)
    private BigDecimal referencePrice;
    
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    
    // Relationships
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cashflow_id", insertable = false, updatable = false)
    private Cashflow cashflow;
    
    // Business methods
    public BigDecimal getPriceChange() {
        if (marketPrice == null || referencePrice == null) {
            return BigDecimal.ZERO;
        }
        return marketPrice.subtract(referencePrice);
    }
    
    public BigDecimal getPriceChangePercent() {
        if (referencePrice == null || referencePrice.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return getPriceChange()
            .divide(referencePrice, 6, RoundingMode.HALF_UP)
            .multiply(BigDecimal.valueOf(100));
    }
}
```

## CDM Alignment

### **1. CDM Primitive Mapping**

| CDM Primitive | Service Entity | Description |
|---------------|----------------|-------------|
| `Trade` | `Contract` | Represents the equity swap trade |
| `Contract` | `Contract` | Legal agreement between parties |
| `Product` | `ContractLeg` | Product specification for each leg |
| `Event` | `Cashflow` | Cashflow events throughout lifecycle |
| `Cashflow` | `Cashflow` | Monetary flows between parties |
| `Payment` | `Cashflow` | Payment instructions and settlements |
| `Settlement` | `Cashflow` | Settlement status and confirmations |
| `Schedule` | `DailyAccrual` | Scheduled accruals and calculations |
| `State` | `CashflowStatus` | Lifecycle state management |
| `Leg` | `ContractLeg` | Individual legs of the contract |
| `Underlier` | `LegUnderlier` | Underlying securities or indices |

### **2. CDM Event Model Alignment**

```java
// CDM Event structure alignment
public interface CDMEvent {
    String getEventId();
    String getEventType();
    LocalDateTime getEventTime();
    String getEventSource();
    Map<String, Object> getEventData();
}

// Cashflow event implementation
public class CashflowGeneratedEvent implements CDMEvent {
    private final UUID eventId;
    private final String eventType = "CASHFLOW_GENERATED";
    private final LocalDateTime eventTime;
    private final String eventSource = "CASHFLOW_SERVICE";
    private final CashflowEventData eventData;
    
    // Implementation details...
}
```

### **3. CDM Product Model Alignment**

```java
// CDM Product structure alignment
public interface CDMProduct {
    String getProductId();
    String getProductType();
    Map<String, Object> getProductTerms();
    List<String> getUnderliers();
}

// Equity swap product implementation
public class EquitySwapProduct implements CDMProduct {
    private final String productId;
    private final String productType = "EQUITY_SWAP";
    private final EquitySwapTerms productTerms;
    private final List<String> underliers;
    
    // Implementation details...
}
```

## Domain Services

### **1. CashflowCalculationService**

```java
@Service
public class CashflowCalculationService {
    
    public Mono<Cashflow> calculateInterestCashflow(
        UUID contractId, 
        UUID legId, 
        LocalDate calculationDate
    ) {
        return Mono.fromCallable(() -> {
            // Get contract and leg data
            Contract contract = contractRepository.findById(contractId);
            ContractLeg leg = contractLegRepository.findById(legId);
            
            // Calculate interest accrual
            BigDecimal accrualAmount = calculateInterestAccrual(contract, leg, calculationDate);
            
            // Create cashflow
            Cashflow cashflow = new Cashflow();
            cashflow.setContractId(contractId);
            cashflow.setLegId(legId);
            cashflow.setCalculationType(CalculationType.INTEREST);
            cashflow.setCashflowType(CashflowType.INTEREST);
            cashflow.setStatus(CashflowStatus.ACCRUED);
            cashflow.setAmount(accrualAmount);
            cashflow.setCalculationDate(calculationDate);
            
            return cashflow;
        }).subscribeOn(Schedulers.boundedElastic());
    }
    
    public Mono<Cashflow> calculateEquityCashflow(
        UUID contractId, 
        UUID legId, 
        LocalDate valuationDate
    ) {
        return Mono.fromCallable(() -> {
            // Get contract and leg data
            Contract contract = contractRepository.findById(contractId);
            ContractLeg leg = contractLegRepository.findById(legId);
            
            // Calculate equity P&L
            BigDecimal pnlAmount = calculateEquityPnL(contract, leg, valuationDate);
            
            // Create cashflow
            Cashflow cashflow = new Cashflow();
            cashflow.setContractId(contractId);
            cashflow.setLegId(legId);
            cashflow.setCalculationType(CalculationType.EQUITY);
            cashflow.setCashflowType(CashflowType.PERFORMANCE);
            cashflow.setStatus(CashflowStatus.ACCRUED);
            cashflow.setAmount(pnlAmount);
            cashflow.setCalculationDate(valuationDate);
            
            return cashflow;
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
```

### **2. CashflowStateManagementService**

```java
@Service
public class CashflowStateManagementService {
    
    public Mono<Cashflow> transitionState(
        UUID cashflowId, 
        CashflowStatus newStatus, 
        String reason
    ) {
        return Mono.fromCallable(() -> {
            Cashflow cashflow = cashflowRepository.findById(cashflowId);
            
            if (cashflow == null) {
                throw new CashflowNotFoundException(cashflowId);
            }
            
            cashflow.transitionTo(newStatus, reason);
            return cashflowRepository.save(cashflow);
        }).subscribeOn(Schedulers.boundedElastic());
    }
    
    public Mono<Cashflow> deferCashflow(
        UUID cashflowId, 
        String deferralReason, 
        Integer deferralPeriodDays
    ) {
        return Mono.fromCallable(() -> {
            Cashflow cashflow = cashflowRepository.findById(cashflowId);
            
            if (cashflow == null) {
                throw new CashflowNotFoundException(cashflowId);
            }
            
            cashflow.setDeferralReason(deferralReason);
            cashflow.setDeferralPeriodDays(deferralPeriodDays);
            cashflow.setDeferralDate(LocalDate.now());
            cashflow.setExpectedRealizationDate(
                LocalDate.now().plusDays(deferralPeriodDays));
            
            cashflow.transitionTo(CashflowStatus.REALIZED_DEFERRED, 
                "Deferred: " + deferralReason);
            
            return cashflowRepository.save(cashflow);
        }).subscribeOn(Schedulers.boundedElastic());
    }
}
```

## Data Validation

### **1. Bean Validation Annotations**

```java
@Entity
@Table(name = "cashflows")
public class Cashflow {
    
    @NotNull(message = "Contract ID is required")
    @Column(name = "contract_id", nullable = false)
    private UUID contractId;
    
    @NotNull(message = "Leg ID is required")
    @Column(name = "leg_id", nullable = false)
    private UUID legId;
    
    @NotBlank(message = "Security ID is required")
    @Size(max = 50, message = "Security ID must not exceed 50 characters")
    @Column(name = "security_id", nullable = false)
    private String securityId;
    
    @NotNull(message = "Calculation type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "calculation_type", nullable = false)
    private CalculationType calculationType;
    
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Amount must be positive")
    @Digits(integer = 13, fraction = 6, message = "Amount must have max 13 digits and 6 decimal places")
    @Column(name = "amount", nullable = false, precision = 19, scale = 6)
    private BigDecimal amount;
    
    @NotBlank(message = "Currency is required")
    @Pattern(regexp = "^[A-Z]{3}$", message = "Currency must be 3 uppercase letters")
    @Column(name = "currency", nullable = false, length = 3)
    private String currency;
    
    @NotNull(message = "Calculation date is required")
    @PastOrPresent(message = "Calculation date cannot be in the future")
    @Column(name = "calculation_date", nullable = false)
    private LocalDate calculationDate;
}
```

### **2. Custom Validation**

```java
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CashflowValidator.class)
public @interface ValidCashflow {
    String message() default "Invalid cashflow";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

public class CashflowValidator implements ConstraintValidator<ValidCashflow, Cashflow> {
    
    @Override
    public boolean isValid(Cashflow cashflow, ConstraintValidatorContext context) {
        if (cashflow == null) {
            return true;
        }
        
        // Validate amount sign based on direction
        if (cashflow.getLeg() != null && cashflow.getLeg().isPayLeg()) {
            if (cashflow.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                    "Pay leg cashflows must have negative amounts")
                    .addPropertyNode("amount")
                    .addConstraintViolation();
                return false;
            }
        }
        
        // Validate calculation date is not in the future
        if (cashflow.getCalculationDate().isAfter(LocalDate.now())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                "Calculation date cannot be in the future")
                .addPropertyNode("calculationDate")
                .addConstraintViolation();
            return false;
        }
        
        return true;
    }
}
```

## Summary

The domain models provide a comprehensive foundation for the Cash Flow Generation Service with:

- **Core Entities**: Cashflow, Contract, ContractLeg, LegUnderlier
- **Supporting Entities**: DailyAccrual, CashflowStatusHistory, UnrealizedPnLTimeseries
- **Enums**: CashflowStatus, CalculationType, CashflowType, LegType
- **CDM Alignment**: Proper mapping to FINOS Common Domain Model
- **Business Logic**: Encapsulated in domain services
- **Validation**: Comprehensive data validation rules

These models support the high-performance, thread-partitioned architecture while maintaining data consistency and business rule enforcement.

---

**Next Steps**:
1. Review [Database Schema](database-schema.md)
2. Explore [Implementation Guide](../implementation/service-implementation.md)
3. Understand [Business Logic](../business/calculation-engines.md)
4. Review [Data Migration](data-migration.md)
