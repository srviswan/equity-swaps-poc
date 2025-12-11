# FINOS CDM Rosetta Analysis for Cashflow Generation Service

## Overview

This document analyzes the FINOS Common Domain Model (CDM) Rosetta source files to understand how our Cashflow Generation Service should be structured to achieve full CDM compliance.

## CDM Rosetta Structure Analysis

### 1. Core Event Model Structure

Based on the `event-common-type.rosetta` file, the CDM Event Model is built around four key components:

#### **TradeState**
```rosetta
type TradeState:
  [metadata key]
  [rootType]
  trade Trade (1..1)                    # The trade itself
  state State (0..1)                    # Current state information
  resetHistory Reset (0..*)             # History of resets
  transferHistory TransferState (0..*)  # History of transfers
  observationHistory ObservationEvent (0..*) # Observed events
  valuationHistory Valuation (0..*)     # Valuation history
```

#### **BusinessEvent**
```rosetta
type BusinessEvent extends EventInstruction:
  [metadata key]
  [rootType]
  eventQualifier string (0..1)          # CDM event qualifier
  after TradeState (0..*)               # New trade states created
  
  condition EventDate:
    eventDate exists
```

#### **PrimitiveInstruction**
```rosetta
type PrimitiveInstruction:
  contractFormation ContractFormationInstruction (0..1)
  execution ExecutionInstruction (0..1)
  exercise ExerciseInstruction (0..1)
  partyChange PartyChangeInstruction (0..1)
  quantityChange QuantityChangeInstruction (0..1)
  reset ResetInstruction (0..1)         # Key for cashflow generation
  split SplitInstruction (0..1)
  termsChange TermsChangeInstruction (0..1)
  transfer TransferInstruction (0..1)
  indexTransition IndexTransitionInstruction (0..1)
  stockSplit StockSplitInstruction (0..1)
  observation ObservationInstruction (0..1)
  valuation ValuationInstruction (0..1)
```

### 2. Cashflow Structure (from `product-common-settlement-type.rosetta`)

#### **Cashflow Definition**
```rosetta
type Cashflow extends AssetFlowBase:
  payerReceiver PayerReceiver (1..1)    # Who pays/receives
  cashflowType CashflowType (1..1)      # Type of cashflow
  paymentDiscounting PaymentDiscounting (0..1) # Discounting info

type AssetFlowBase:
  quantity NonNegativeQuantity (1..1)   # Amount to transfer
  asset Asset (1..1)                    # Asset being transferred
  settlementDate AdjustableOrAdjustedOrRelativeDate (1..1) # When due
```

#### **Cashflow Types**
```rosetta
type CashflowType:
  cashflowType ScheduledTransferEnum (0..1)  # Scheduled event type
  cashPrice CashPrice (0..1)                 # Non-scheduled event price
  priceExpression PriceExpressionEnum (0..1)
  
  condition:
    required choice cashflowType, cashPrice
```

### 3. Product Structure (from `product-template-type.rosetta`)

#### **TransferableProduct**
```rosetta
type TransferableProduct extends Asset:
  economicTerms EconomicTerms (1..1)    # Price-forming features

type EconomicTerms:
  effectiveDate AdjustableOrRelativeDate (0..1)    # First day of terms
  terminationDate AdjustableOrRelativeDate (0..1)  # Last day of terms
  dateAdjustments BusinessDayAdjustments (0..1)    # Business day conventions
  payout Payout (1..*)                            # Cashflow computation methodology
  terminationProvision TerminationProvision (0..1) # Termination characteristics
  calculationAgent CalculationAgent (0..1)         # ISDA calculation agent
  nonStandardisedTerms boolean (0..1)              # Additional terms flag
  collateral Collateral (0..1)                     # Collateral obligations
```

### 4. Reset Mechanism (from `event-common-type.rosetta`)

#### **Reset Structure**
```rosetta
type Reset:
  [metadata key]
  resetValue Price (1..1)               # Reset/fixing value
  resetDate date (1..1)                 # When reset occurred
  rateRecordDate date (0..1)            # Rate record day for fallback
  observations Observation (1..*)       # Audit of observations used
  averagingMethodology AveragingCalculation (0..1) # Aggregation method
```

## CDM Compliance Requirements for Our Service

### 1. Event-Driven Architecture

Our Cashflow Generation Service must follow the CDM Event Model:

```java
// CDM-compliant cashflow generation event
@CDMEntity(type = "BusinessEvent")
public class CashflowGeneratedEvent extends BusinessEvent {
    
    @CDMField(name = "before")
    private List<TradeState> beforeTradeStates; // Current contract state
    
    @CDMField(name = "after") 
    private List<TradeState> afterTradeStates;  // New state with cashflows
    
    @CDMField(name = "primitiveInstruction")
    private List<PrimitiveInstruction> instructions; // Cashflow generation logic
    
    @CDMField(name = "eventDate")
    private LocalDate eventDate; // When event was created
    
    @CDMField(name = "eventQualifier")
    private String eventQualifier; // CDM event qualifier
}
```

### 2. TradeState Management

Each cashflow generation must create a new TradeState:

```java
@CDMEntity(type = "TradeState")
public class CashflowTradeState extends TradeState {
    
    @CDMField(name = "trade")
    private Trade trade; // The underlying trade
    
    @CDMField(name = "state")
    private State state; // Current state (e.g., CASHFLOW_GENERATED)
    
    @CDMField(name = "resetHistory")
    private List<Reset> resetHistory; // Cashflow reset history
    
    @CDMField(name = "transferHistory")
    private List<TransferState> transferHistory; // Payment transfers
}
```

### 3. Primitive Instructions

Cashflow generation should use the Reset primitive instruction:

```java
@CDMEntity(type = "ResetInstruction")
public class CashflowResetInstruction extends ResetInstruction {
    
    @CDMField(name = "payout")
    private List<Payout> payout; // Payouts to reset
    
    @CDMField(name = "resetDate")
    private LocalDate resetDate; // When reset occurs
    
    @CDMField(name = "rateRecordDate")
    private LocalDate rateRecordDate; // Rate record date
}
```

### 4. Cashflow Structure

Generated cashflows must follow CDM Cashflow structure:

```java
@CDMEntity(type = "Cashflow")
public class CDMCashflow extends Cashflow {
    
    @CDMField(name = "quantity")
    private NonNegativeQuantity quantity; // Cashflow amount
    
    @CDMField(name = "asset")
    private Asset asset; // Currency asset
    
    @CDMField(name = "settlementDate")
    private AdjustableOrAdjustedOrRelativeDate settlementDate; // Payment date
    
    @CDMField(name = "payerReceiver")
    private PayerReceiver payerReceiver; // Payer/receiver parties
    
    @CDMField(name = "cashflowType")
    private CashflowType cashflowType; // Type of cashflow
}
```

## Implementation Strategy

### 1. Use CDM Java Distribution

Rather than recreating Rosetta definitions, use the pre-built CDM Java classes:

```xml
<dependency>
    <groupId>org.finos.cdm</groupId>
    <artifactId>cdm-java</artifactId>
    <version>7.0.0-dev.14</version>
</dependency>
```

### 2. CDM-Compliant Service Structure

```java
@Service
public class CDMCompliantCashflowGenerationService {
    
    public BusinessEvent generateCashflows(CashflowGenerationRequest request) {
        // 1. Get current trade state from CDM Event Store
        TradeState beforeState = getCurrentTradeState(request.getContractId());
        
        // 2. Create reset instruction for cashflow generation
        ResetInstruction resetInstruction = createCashflowResetInstruction(request);
        
        // 3. Apply reset to generate new cashflows
        List<Cashflow> cashflows = applyResetInstruction(beforeState, resetInstruction);
        
        // 4. Create new trade state with cashflows
        TradeState afterState = createNewTradeState(beforeState, cashflows);
        
        // 5. Create CDM-compliant business event
        return BusinessEvent.builder()
            .beforeTradeStates(List.of(beforeState))
            .afterTradeStates(List.of(afterState))
            .primitiveInstructions(List.of(resetInstruction))
            .eventDate(LocalDate.now())
            .eventQualifier("CASHFLOW_GENERATED")
            .build();
    }
}
```

### 3. CDM Event Store Integration

```java
@Component
public class CDMEventStore {
    
    public void storeEvent(BusinessEvent event) {
        // Store CDM-compliant event
        eventRepository.save(event);
        
        // Update trade state lineage
        updateTradeStateLineage(event);
        
        // Publish to CDM event bus
        cdmEventBus.publish(event);
    }
    
    public TradeState getCurrentTradeState(String contractId) {
        // Retrieve latest trade state from CDM event store
        return tradeStateRepository.findLatestByContractId(contractId);
    }
}
```

## Key CDM Principles to Follow

### 1. **State Lineage Preservation**
- Each cashflow generation creates a new TradeState
- Maintain complete audit trail through event history
- Support state reconstruction at any point in time

### 2. **Product Immutability**
- Contract terms remain unchanged
- Only trade state evolves through events
- Cashflows are state, not product, attributes

### 3. **Primitive Instruction Composition**
- Break down cashflow generation into fundamental operations
- Use Reset primitive for cashflow calculations
- Compose complex events from simple primitives

### 4. **Event Qualification**
- Use CDM event qualifiers (e.g., "CASHFLOW_GENERATED")
- Implement event qualification logic
- Support automated event classification

### 5. **Business Day Adjustments**
- Follow CDM business day conventions
- Support adjustable and relative dates
- Implement proper date adjustment logic

## Validation Rules

Based on the Rosetta conditions, implement these validations:

```java
@Component
public class CDMValidationService {
    
    public void validateCashflowGeneration(CashflowGenerationRequest request) {
        // Validate effective date is after trade date
        if (request.getEffectiveDate().isBefore(request.getTradeDate())) {
            throw new CDMValidationException("Effective date must be after trade date");
        }
        
        // Validate contract exists and is active
        if (!contractService.isActive(request.getContractId())) {
            throw new CDMValidationException("Contract must be active");
        }
        
        // Validate market data availability
        if (!marketDataService.hasRequiredData(request.getUnderlierIds(), request.getCalculationDate())) {
            throw new CDMValidationException("Required market data not available");
        }
    }
}
```

## Next Steps

1. **Download CDM Java Distribution** from FINOS releases
2. **Implement CDM-compliant data models** using pre-built classes
3. **Create CDM Event Store** for state management
4. **Implement Reset primitive logic** for cashflow generation
5. **Add CDM validation rules** based on Rosetta conditions
6. **Test CDM compliance** using CDM validation tools

This analysis ensures our Cashflow Generation Service will be fully compliant with FINOS CDM standards and can integrate seamlessly with other CDM-compliant systems.
