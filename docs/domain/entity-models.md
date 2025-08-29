# Entity Models - Core Business Entities

## Overview
This document defines the core business entities for the Equity Swaps Lifecycle Management System. These entities represent the fundamental business concepts and follow CDM principles for standardization and interoperability.

## Entity Hierarchy

```
┌─────────────────────────────────────────────────────────────────────────────────┐
│                              ENTITY HIERARCHY                                  │
├─────────────────────────────────────────────────────────────────────────────────┤
│                                                                                 │
│  SwapBlotter                                                                   │
│  └── EquitySwapProduct                                                         │
│      ├── EquityLeg                                                             │
│      │   └── Underlier (Single Stock/Index/Basket)                            │
│      │       └── Lot (Trade: New/Increase/Decrease/Close)                     │
│      └── InterestLeg                                                           │
│                                                                                 │
│  Contract                                                                      │
│  ├── ContractState                                                            │
│  ├── EquityLeg                                                                │
│  ├── InterestLeg                                                              │
│  └── Lot                                                                      │
│                                                                                 │
│  Position                                                                      │
│  ├── PositionHistory                                                          │
│  └── PositionAggregation                                                      │
│                                                                                 │
│  Cashflow                                                                      │
│  ├── PaymentSchedule                                                          │
│  └── Payment                                                                   │
│                                                                                 │
└─────────────────────────────────────────────────────────────────────────────────┘
```

## Core Entities

### 1. SwapBlotter

#### **Purpose**
Represents an enriched trade that has been captured and processed by the Trade Capture service. This is the primary input to the Contract Lifecycle Management service.

#### **CDM Alignment**
- Maps to CDM `Trade` primitive
- Contains all trade details and enrichment results
- Represents the state before contract formation

#### **Entity Definition**
```java
@CDMEntity(type = "Trade")
@Entity
@Table(name = "swap_blotters")
public class SwapBlotter {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String blotterId;
    
    @CDMField(name = "tradeIdentifier")
    @Column(name = "trade_id", nullable = false)
    private String tradeId;
    
    @CDMField(name = "tradeDate")
    @Column(name = "trade_date", nullable = false)
    private LocalDate tradeDate;
    
    @CDMField(name = "tradeTime")
    @Column(name = "trade_time")
    private LocalTime tradeTime;
    
    @CDMField(name = "party")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "blotter_parties",
        joinColumns = @JoinColumn(name = "blotter_id"),
        inverseJoinColumns = @JoinColumn(name = "party_id")
    )
    private List<Party> parties;
    
    @CDMField(name = "partyRole")
    @OneToMany(mappedBy = "blotter", cascade = CascadeType.ALL)
    private List<PartyRole> partyRoles;
    
    @CDMField(name = "executionDetails")
    @Embedded
    private ExecutionDetails executionDetails;
    
    @CDMField(name = "contractDetails")
    @Embedded
    private ContractDetails contractDetails;
    
    // Equity swap specific fields
    @Embedded
    private EquitySwapProduct equitySwapProduct;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "enrichment_status")
    private EnrichmentStatus enrichmentStatus;
    
    @Column(name = "enrichment_rules_applied")
    private String enrichmentRulesApplied;
    
    @Column(name = "validation_errors")
    private String validationErrors;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isReadyForContractFormation() {
        return enrichmentStatus == EnrichmentStatus.SUCCESS && 
               validationErrors == null;
    }
    
    public boolean requiresManualReview() {
        return enrichmentStatus == EnrichmentStatus.FAILED ||
               enrichmentStatus == EnrichmentStatus.PARTIAL;
    }
}
```

### 2. EquitySwapProduct

#### **Purpose**
Defines the economic and legal terms of an equity swap. This entity represents the product structure that will be used to create contracts.

#### **CDM Alignment**
- Maps to CDM `TradableProduct` primitive
- Contains economic terms and legal agreements
- Defines the structure of equity and interest legs

#### **Entity Definition**
```java
@CDMEntity(type = "TradableProduct")
@Entity
@Table(name = "equity_swap_products")
public class EquitySwapProduct {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productId;
    
    @CDMField(name = "productIdentifier")
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductIdentifier> productIdentifiers;
    
    @CDMField(name = "productType")
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductTypeEnum productType;
    
    @CDMField(name = "economicTerms")
    @Embedded
    private EquitySwapEconomicTerms economicTerms;
    
    @CDMField(name = "legalAgreement")
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "product_legal_agreements",
        joinColumns = @JoinColumn(name = "product_id"),
        inverseJoinColumns = @JoinColumn(name = "agreement_id")
    )
    private List<LegalAgreement> legalAgreements;
    
    // Equity swap specific fields
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<EquityLeg> equityLegs;
    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InterestLeg> interestLegs;
    
    @Embedded
    private PricingModel pricingModel;
    
    @Column(name = "product_name")
    private String productName;
    
    @Column(name = "product_description")
    private String productDescription;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isBasketProduct() {
        return equityLegs.stream()
            .anyMatch(leg -> leg.getUnderlier().getType() == UnderlierType.BASKET);
    }
    
    public List<Underlier> getAllUnderliers() {
        return equityLegs.stream()
            .map(EquityLeg::getUnderlier)
            .collect(Collectors.toList());
    }
}
```

### 3. EquityLeg

#### **Purpose**
Represents the equity component of an equity swap. Each leg defines the underlying equity instrument and its terms.

#### **CDM Alignment**
- Maps to CDM `Leg` primitive within `TradableProduct`
- Contains underlier information and economic terms
- Defines equity-specific calculations and handling

#### **Entity Definition**
```java
@Entity
@Table(name = "equity_legs")
public class EquityLeg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String legId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private EquitySwapProduct product;
    
    @Embedded
    private EquityLegTerms terms;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "underlier_id")
    private Underlier underlier;
    
    @Column(name = "leg_number")
    private int legNumber;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "leg_type")
    private LegTypeEnum legType;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isBasketLeg() {
        return underlier.getType() == UnderlierType.BASKET;
    }
    
    public List<SingleStockUnderlier> getBasketComponents() {
        if (isBasketLeg()) {
            return ((BasketUnderlier) underlier).getComponents();
        }
        return List.of();
    }
}
```

### 4. Underlier

#### **Purpose**
Represents the underlying equity instrument that the swap is based on. Can be a single stock, index, or basket.

#### **CDM Alignment**
- Maps to CDM `Underlier` primitive
- Contains instrument identification and characteristics
- Supports different underlier types and structures

#### **Entity Definition**
```java
@Entity
@Table(name = "underliers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Underlier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String underlierId;
    
    @Column(name = "underlier_code", nullable = false, unique = true)
    private String underlierCode;
    
    @Column(name = "underlier_name")
    private String underlierName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "underlier_type", nullable = false)
    private UnderlierType type;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "exchange")
    private String exchange;
    
    @Column(name = "is_active")
    private boolean isActive;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Abstract methods
    public abstract String getDisplayName();
    public abstract List<String> getIdentifiers();
}

@Entity
@Table(name = "single_stock_underliers")
public class SingleStockUnderlier extends Underlier {
    
    @Column(name = "isin")
    private String isin;
    
    @Column(name = "cusip")
    private String cusip;
    
    @Column(name = "sedol")
    private String sedol;
    
    @Column(name = "ticker")
    private String ticker;
    
    @Column(name = "sector")
    private String sector;
    
    @Column(name = "country")
    private String country;
    
    @Override
    public String getDisplayName() {
        return String.format("%s (%s)", getUnderlierName(), getTicker());
    }
    
    @Override
    public List<String> getIdentifiers() {
        return List.of(isin, cusip, sedol, ticker).stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
}

@Entity
@Table(name = "basket_underliers")
public class BasketUnderlier extends Underlier {
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "basket_components",
        joinColumns = @JoinColumn(name = "basket_id"),
        inverseJoinColumns = @JoinColumn(name = "component_id")
    )
    private List<SingleStockUnderlier> components;
    
    @Column(name = "basket_methodology")
    private String basketMethodology;
    
    @Column(name = "rebalancing_frequency")
    private String rebalancingFrequency;
    
    @Override
    public String getDisplayName() {
        return String.format("Basket: %s (%d components)", 
            getUnderlierName(), components.size());
    }
    
    @Override
    public List<String> getIdentifiers() {
        return components.stream()
            .flatMap(comp -> comp.getIdentifiers().stream())
            .collect(Collectors.toList());
    }
}
```

### 5. Contract

#### **Purpose**
Represents a legal contract between parties for an equity swap. Contains the contract terms, state, and associated lots.

#### **CDM Alignment**
- Maps to CDM `Contract` primitive
- Contains contractual product and trade information
- Manages contract lifecycle and state

#### **Entity Definition**
```java
@CDMEntity(type = "Contract")
@Entity
@Table(name = "contracts")
public class Contract {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String contractId;
    
    @CDMField(name = "contractIdentifier")
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<ContractIdentifier> contractIdentifiers;
    
    @CDMField(name = "contractualProduct")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private EquitySwapProduct contractualProduct;
    
    @CDMField(name = "trade")
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Trade> trades;
    
    @CDMField(name = "state")
    @Embedded
    private ContractState state;
    
    // Equity swap specific fields
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<EquityLeg> equityLegs;
    
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<InterestLeg> interestLegs;
    
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Lot> lots;
    
    @Column(name = "contract_number")
    private String contractNumber;
    
    @Column(name = "effective_date")
    private LocalDate effectiveDate;
    
    @Column(name = "maturity_date")
    private LocalDate maturityDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_status")
    private ContractStatus status;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isActive() {
        return status == ContractStatus.ACTIVE;
    }
    
    public boolean isMatured() {
        return maturityDate != null && maturityDate.isBefore(LocalDate.now());
    }
    
    public BigDecimal getTotalNotional() {
        return lots.stream()
            .map(Lot::getNotional)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public List<Lot> getActiveLots() {
        return lots.stream()
            .filter(Lot::isActive)
            .collect(Collectors.toList());
    }
}
```

### 6. Lot

#### **Purpose**
Represents an individual trade lot within a contract. Tracks the specific trade details and lot status.

#### **CDM Alignment**
- Maps to CDM `Trade` primitive within `Contract`
- Contains trade execution details and lot-specific information
- Manages lot lifecycle and status

#### **Entity Definition**
```java
@Entity
@Table(name = "lots")
public class Lot {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String lotId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;
    
    @Column(name = "lot_number")
    private String lotNumber;
    
    @Column(name = "trade_date")
    private LocalDate tradeDate;
    
    @Column(name = "quantity")
    private BigDecimal quantity;
    
    @Column(name = "price")
    private BigDecimal price;
    
    @Column(name = "notional")
    private BigDecimal notional;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "lot_type")
    private LotType lotType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "lot_status")
    private LotStatus status;
    
    @Column(name = "closing_date")
    private LocalDate closingDate;
    
    @Column(name = "closing_method")
    private String closingMethod;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isActive() {
        return status == LotStatus.ACTIVE;
    }
    
    public boolean isClosed() {
        return status == LotStatus.CLOSED;
    }
    
    public boolean requiresCashflowRegeneration() {
        return lotType == LotType.INCREASE || lotType == LotType.DECREASE;
    }
    
    public BigDecimal getMarketValue() {
        // Calculate current market value based on quantity and current price
        return quantity.multiply(getCurrentMarketPrice());
    }
    
    private BigDecimal getCurrentMarketPrice() {
        // Implementation to get current market price from market data service
        return BigDecimal.ZERO; // Placeholder
    }
}
```

### 7. Position

#### **Purpose**
Represents the current position for a specific underlier across all contracts. Tracks net position and P&L.

#### **CDM Alignment**
- Maps to CDM `Position` primitive
- Contains position state and history
- Manages position calculations and updates

#### **Entity Definition**
```java
@Entity
@Table(name = "positions")
public class Position {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String positionId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "underlier_id")
    private Underlier underlier;
    
    @Column(name = "net_quantity")
    private BigDecimal netQuantity;
    
    @Column(name = "average_price")
    private BigDecimal averagePrice;
    
    @Column(name = "market_value")
    private BigDecimal marketValue;
    
    @Column(name = "unrealized_pnl")
    private BigDecimal unrealizedPnl;
    
    @Column(name = "realized_pnl")
    private BigDecimal realizedPnl;
    
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Business methods
    public boolean isLong() {
        return netQuantity.compareTo(BigDecimal.ZERO) > 0;
    }
    
    public boolean isShort() {
        return netQuantity.compareTo(BigDecimal.ZERO) < 0;
    }
    
    public boolean isFlat() {
        return netQuantity.compareTo(BigDecimal.ZERO) == 0;
    }
    
    public BigDecimal getTotalPnl() {
        return unrealizedPnl.add(realizedPnl);
    }
}
```

### 8. Cashflow

#### **Purpose**
Represents a scheduled or generated cashflow for a contract. Manages payment schedules and execution.

#### **CDM Alignment**
- Maps to CDM `Cashflow` primitive
- Contains payment calculation and scheduling
- Manages cashflow lifecycle and status

#### **Entity Definition**
```java
@CDMEntity(type = "Cashflow")
@Entity
@Table(name = "cashflows")
public class Cashflow {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String cashflowId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private Contract contract;
    
    @Column(name = "cashflow_type")
    @Enumerated(EnumType.STRING)
    private CashflowType type;
    
    @Column(name = "amount")
    private BigDecimal amount;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "due_date")
    private LocalDate dueDate;
    
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CashflowStatus status;
    
    @Column(name = "calculation_date")
    private LocalDate calculationDate;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Business methods
    public boolean isOverdue() {
        return dueDate.isBefore(LocalDate.now()) && status != CashflowStatus.PAID;
    }
    
    public boolean isScheduled() {
        return status == CashflowStatus.SCHEDULED;
    }
    
    public boolean isPaid() {
        return status == CashflowStatus.PAID;
    }
}
```

## Entity Relationships

### 1. One-to-Many Relationships
```
Contract → Lots (One contract can have multiple lots)
Contract → EquityLegs (One contract can have multiple equity legs)
Contract → InterestLegs (One contract can have multiple interest legs)
EquityLeg → Underlier (One leg has one underlier)
```

### 2. Many-to-Many Relationships
```
Contract ↔ Parties (Contracts can have multiple parties)
Product ↔ LegalAgreements (Products can have multiple legal agreements)
```

### 3. Inheritance Relationships
```
Underlier (abstract)
├── SingleStockUnderlier
├── IndexUnderlier
└── BasketUnderlier
```

## Data Validation Rules

### 1. Business Rules
- All contracts must have at least one equity leg and one interest leg
- Lots must have positive quantities and prices
- Positions cannot have negative quantities without proper short selling setup
- Cashflows must have valid due dates and amounts

### 2. CDM Compliance Rules
- All entities must have proper CDM annotations
- Required CDM fields must be populated
- Data types must match CDM specifications
- Event structures must follow CDM Event Model

### 3. Referential Integrity
- Foreign key relationships must be maintained
- Deletion of parent entities must be handled appropriately
- Cascade operations must be defined for dependent entities

## Next Steps
1. Review [Event Models](event-models.md) for event structures
2. Examine [Service Architecture](../microservices/service-architecture.md) for entity usage
3. Review [Trade Lifecycle](../business/trade-lifecycle.md) for business processes
4. Begin with [Technology Stack](../implementation/technology-stack.md) for implementation details
