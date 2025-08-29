# FINOS CDM Payout Structure Analysis

## Overview

This document provides a comprehensive analysis of the Payout structure in the FINOS Common Domain Model (CDM) based on the Rosetta source files. Understanding the Payout structure is crucial for our Cashflow Generation Service as it defines how cashflows are computed and structured.

## CDM Payout Architecture

### 1. Payout Choice Definition

The CDM defines Payout as a **choice** data type, meaning one and only one of the following payout types must be used:

```rosetta
choice Payout: <"Represents the set of future cashflow methodologies in the form of specific payout data type(s) which result from the financial product. Examples: a trade in a cash asset will use only a settlement payout; for derivatives, two interest rate payouts can be combined to specify an interest rate swap; one interest rate payout can be combined with a credit default payout to specify a credit default swap.">
    [metadata key]

    AssetPayout <"Defines the assets and movements in a security financing transaction.">
    CommodityPayout <"Defines the payout for the floating leg of a Commodity Swap.">
    CreditDefaultPayout <"The credit default payout, which provides the details necessary for determining when a credit payout will be triggered as well as the parameters for calculating the payout and the settlement terms.">
    FixedPricePayout <"Defines a payout in which one or more payouts are defined as a fixed price.">
    InterestRatePayout <"All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).">
    OptionPayout <"The option payout.">
    PerformancePayout <"The performance payout, which encompasses the equity price returns, dividend returns, volatility return, variance return and correlation provisions.">
    SettlementPayout <"Represents a forward settling payout. The 'Underlier' attribute captures the underlying payout, which is settled according to the 'SettlementTerms' attribute. Both FX Spot and FX Forward should use this component.">
```

### 2. Payout Inheritance Hierarchy

All payout types extend from a base structure (though the exact `PayoutBase` definition wasn't found in the files examined, the inheritance pattern is clear):

```
Payout (choice)
├── AssetPayout extends PayoutBase
├── CommodityPayout extends PayoutBase  
├── CreditDefaultPayout extends PayoutBase
├── FixedPricePayout extends PayoutBase
├── InterestRatePayout extends PayoutBase
├── OptionPayout extends PayoutBase
├── PerformancePayout extends PayoutBase
└── SettlementPayout extends PayoutBase
```

## Key Payout Types for Equity Swaps

### 1. **PerformancePayout** - Equity Leg

The `PerformancePayout` is the primary payout type for equity swaps, handling equity returns:

```rosetta
type PerformancePayout extends PayoutBase: <"Contains the necessary specifications for all performance payouts, encompassing equity return, dividend, variance, volatility and correlation products.">
    observationTerms ObservationTerms (0..1) <"Defines how and when a performance type option or performance type swap is to be observed.">
    valuationDates ValuationDates (1..1) <"Defines how and when a performance type option or performance type swap is to be valued, including both interim and final valuation.">
    paymentDates PaymentDates (1..1) <"Defines the payment date schedule, as defined by the parameters that are needed to specify it, either in a parametric way or by reference to another schedule of dates (e.g. the valuation dates).">
    underlier Underlier (0..1) <"Identifies the underlying product that is referenced for pricing of the applicable leg in a swap.">
    fxFeature FxFeature (0..*) <"Defines quanto or composite FX features that are included in the swap leg.">
    returnTerms ReturnTerms (0..1) <"Specifies the type of return of a performance payout.">
    portfolioReturnTerms PortfolioReturnTerms (0..*) <"Specifies an individual type of return of a Performance Payout, when such individual return is part of an aggregation of multiple similar returns, at Performance Payout level">
    initialValuationPrice PriceSchedule (0..*) <"Specifies the net initial valuation price(s) of the underlier at Performance Payout level.">
    interimValuationPrice PriceSchedule (0..*) <"Specifies the net interim valuation price(s) of the underlier.">
    finalValuationPrice PriceSchedule (0..*) <"Specifies the net final valuation price(s) of the underlier.">
```

#### **ReturnTerms Structure**

```rosetta
type ReturnTerms: <"Specifies the type of return of a performance payout.">
    priceReturnTerms PriceReturnTerms (0..1) <"Return terms based upon the underlier's observed price.">
    dividendReturnTerms DividendReturnTerms (0..1) <"Return terms based upon dividend payments associated to the underlier.">
    varianceReturnTerms VarianceReturnTerms (0..1) <"Return terms based upon the observed variance of the underlier's price.">
    volatilityReturnTerms VolatilityReturnTerms (0..1) <"Return terms based upon the observed volatility of the underlier's price.">
    correlationReturnTerms CorrelationReturnTerms (0..1) <"Return terms based upon the observed correlation between the components of the underlying basket.">
```

#### **PriceReturnTerms**

```rosetta
type PriceReturnTerms:
    returnType ReturnTypeEnum (1..1) <"The type of return associated with the equity swap.">
    conversionFactor number (0..1) <"Defines the conversion applied if the quantity unit on contract is different from unit on referenced underlier.">
    performance calculation (0..1) <"Performance calculation, in accordance with Part 1 Section 12 of the 2018 ISDA CDM Equity Confirmation for Security Equity Swap, Para 75. 'Equity Performance'. Cumulative performance is used as a notional multiplier factor on both legs of an Equity Swap.">
```

### 2. **InterestRatePayout** - Funding Leg

The `InterestRatePayout` handles the funding leg of equity swaps:

```rosetta
InterestRatePayout <"All of the terms necessary to define and calculate a cash flow based on a fixed, a floating or an inflation index rate. The interest rate payout can be applied to interest rate swaps and FRA (which both have two associated interest rate payouts), credit default swaps (to represent the fee leg when subject to periodic payments) and equity swaps (to represent the funding leg).">
```

## Cashflow Structure

### 1. **Cashflow Definition**

Cashflows are defined in the settlement types:

```rosetta
type Cashflow extends AssetFlowBase: <"Class to specify a cashflow, i.e. the outcome of either of computation (e.g. interest accrual) or an assessment of some sort (e.g. a fee). The cashflow can then be turned into a cash transfer, artefact to be used as the input to a payment system or the outcome of it.">
    payerReceiver PayerReceiver (1..1) <"Specifies who pays / receives the cashflow, though a normalised Party1 / Party2 enumerator.">
    cashflowType CashflowType (1..1) <"The qualification of the type of cashflow, e.g. brokerage fee, premium, upfront fee etc. Particularly relevant when it cannot be inferred directly through lineage.">
    paymentDiscounting PaymentDiscounting (0..1) <"FpML specifies the FpML PaymentDiscounting.model group for representing the discounting elements that can be associated with a payment.">
```

### 2. **AssetFlowBase Structure**

```rosetta
type AssetFlowBase: <"Defines the basic parameters of an asset transfer, e.g. a cashflow: what (the asset), how much (the quantity) and when (the settlement date).">
    quantity NonNegativeQuantity (1..1) <"Represents the amount of the asset to be transferred. The cashflow amount is always a positive number, as the cashflow direction is implied by the payer/receiver attribute.">
    asset Asset (1..1) <"Represents the object that is subject to the transfer, it could be an asset or a reference.">
    settlementDate AdjustableOrAdjustedOrRelativeDate (1..1) <"Represents the date on which the transfer to due.">
```

### 3. **Cashflow Types**

```rosetta
type CashflowType: <"Characterises the type of cashflow, which can result from either a scheduled or a non-scheduled lifecycle event.">
    cashflowType ScheduledTransferEnum (0..1) <"Type of cashflow corresponding to a scheduled event.">
    cashPrice CashPrice (0..1) <"Type of cashflow corresponding to a non-scheduled event, where a price must be agreed between the parties.">
    priceExpression PriceExpressionEnum (0..1)
    
    condition: <"A cashflow is either specified as a type of scheduled cashflow, or as a price agreed between parties in case of a non-scheduled cashflow.">
        required choice cashflowType, cashPrice
```

## Reset Mechanism for Cashflow Generation

### 1. **Reset Structure**

The Reset mechanism is crucial for cashflow generation:

```rosetta
type Reset: <"Defines the reset value or fixing value produced in cashflow calculations, during the life-cycle of a financial instrument. The reset process defined in Create_Reset function joins product definition details with observations to compute the reset value.">
    [metadata key]
    resetValue Price (1..1) <"Specifies the reset or fixing value. The fixing value could be a cash price, interest rate, or other value.">
    resetDate date (1..1) <"Specifies the date on which the reset occurred.">
    rateRecordDate date (0..1) <"Specifies the 'Rate Record Day' for a Fallback rate.">
    observations Observation (1..*) <"Represents an audit of the observations used to produce the reset value.">
    averagingMethodology AveragingCalculation (0..1) <"Identifies the aggregation method to use in the case where multiple observations are used to compute the reset value.">
```

### 2. **ResetInstruction**

```rosetta
type ResetInstruction: <"Defines the information needed to create a Reset Business Event.">
    payout Payout (1..*) <"Payouts to be reset">
        [metadata reference]
    rateRecordDate date (0..1) <"Specifies the 'Rate Record Day' for a Fallback rate.">
    resetDate date (1..1) <"Specifies the date on which the reset is occurring.">
```

## Implementation for Our Cashflow Generation Service

### 1. **CDM-Compliant Payout Structure**

Our service should implement the CDM payout structure:

```java
@CDMEntity(type = "PerformancePayout")
public class EquitySwapPerformancePayout extends PerformancePayout {
    
    @CDMField(name = "underlier")
    private Underlier underlier; // Equity underlier (single stock, index, basket)
    
    @CDMField(name = "returnTerms")
    private ReturnTerms returnTerms; // Price return, dividend return, etc.
    
    @CDMField(name = "valuationDates")
    private ValuationDates valuationDates; // When to value the position
    
    @CDMField(name = "paymentDates")
    private PaymentDates paymentDates; // When payments are due
}

@CDMEntity(type = "InterestRatePayout")
public class EquitySwapInterestRatePayout extends InterestRatePayout {
    
    @CDMField(name = "dayCountFraction")
    private DayCountFraction dayCountFraction; // Day count convention
    
    @CDMField(name = "calculationPeriodDates")
    private CalculationPeriodDates calculationPeriodDates; // Interest periods
    
    @CDMField(name = "paymentDates")
    private PaymentDates paymentDates; // Interest payment dates
}
```

### 2. **Cashflow Generation Using Reset Primitive**

```java
@Service
public class CDMCashflowGenerationService {
    
    public List<Cashflow> generateEquitySwapCashflows(EquitySwapContract contract) {
        
        // 1. Create Reset instruction for equity leg
        ResetInstruction equityResetInstruction = createEquityResetInstruction(
            contract.getPerformancePayout(),
            contract.getValuationDate(),
            contract.getMarketData()
        );
        
        // 2. Create Reset instruction for interest leg
        ResetInstruction interestResetInstruction = createInterestResetInstruction(
            contract.getInterestRatePayout(),
            contract.getResetDate(),
            contract.getInterestRateData()
        );
        
        // 3. Apply resets to generate cashflows
        List<Cashflow> equityCashflows = applyEquityReset(equityResetInstruction);
        List<Cashflow> interestCashflows = applyInterestReset(interestResetInstruction);
        
        // 4. Combine and return all cashflows
        return Stream.concat(equityCashflows.stream(), interestCashflows.stream())
                    .collect(Collectors.toList());
    }
}
```

### 3. **CDM Cashflow Structure**

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

## Key CDM Principles for Payouts

### 1. **Choice Constraint**
- Only ONE payout type can be specified per leg
- Multiple legs can have different payout types
- Equity swaps typically have PerformancePayout + InterestRatePayout

### 2. **Underlier References**
- Payouts reference underlying assets via the `Underlier` choice
- Underliers can be Observable (single stock, index, basket) or Product
- Basket underliers contain multiple constituents with weights

### 3. **Schedule-Based Calculations**
- Payouts use schedules for dates, quantities, and prices
- Schedules can be parametric or non-parametric
- Business day adjustments apply to all scheduled dates

### 4. **Reset-Based Cashflow Generation**
- Cashflows are generated through Reset events
- Reset combines product definition with market observations
- Reset history maintains audit trail of all calculations

## Validation Rules

### 1. **Payout Type Validation**
```java
@Component
public class CDMPayoutValidationService {
    
    public void validatePayoutStructure(List<Payout> payouts) {
        // Ensure only one payout type per leg
        if (payouts.size() != payouts.stream().distinct().count()) {
            throw new CDMValidationException("Duplicate payout types not allowed");
        }
        
        // Validate underlier references
        payouts.forEach(payout -> validateUnderlierReference(payout));
        
        // Validate schedule consistency
        payouts.forEach(payout -> validateScheduleConsistency(payout));
    }
}
```

### 2. **Cashflow Validation**
```java
public void validateCashflow(Cashflow cashflow) {
    // Validate quantity is positive
    if (cashflow.getQuantity().getAmount() <= 0) {
        throw new CDMValidationException("Cashflow amount must be positive");
    }
    
    // Validate settlement date is in the future
    if (cashflow.getSettlementDate().isBefore(LocalDate.now())) {
        throw new CDMValidationException("Settlement date must be in the future");
    }
    
    // Validate payer/receiver parties exist
    if (cashflow.getPayerReceiver() == null) {
        throw new CDMValidationException("Payer/receiver must be specified");
    }
}
```

## Next Steps

1. **Implement CDM Payout Models** - Create Java classes extending CDM payout types
2. **Implement Reset Logic** - Build cashflow generation using Reset primitive
3. **Add Validation Rules** - Implement CDM compliance validation
4. **Test with CDM Tools** - Validate using FINOS CDM validation tools

This analysis ensures our Cashflow Generation Service will be fully compliant with FINOS CDM payout structures and can handle complex equity swap scenarios correctly.
