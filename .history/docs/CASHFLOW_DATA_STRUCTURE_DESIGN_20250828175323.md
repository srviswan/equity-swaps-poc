# Cashflow Data Structure Design

## Overview

This document designs a comprehensive data structure for the Cashflow Generation Engine that aligns with FINOS CDM principles while supporting the specific business requirements for accruals, realized unsettled, and realized settled cashflows.

## CDM-Aligned Data Structure Design

### 1. **Base Payout Structure** (CDM-Compliant Foundation)

```java
/**
 * Base payout structure following CDM principles
 * Each payout type extends this base class
 */
@CDMEntity(type = "PayoutBase")
public abstract class BasePayout {
    
    @CDMField(name = "payerReceiver")
    private PayerReceiver payerReceiver; // CDM-compliant payer/receiver
    
    @CDMField(name = "priceQuantity")
    private ResolvablePriceQuantity priceQuantity; // CDM quantity structure
    
    @CDMField(name = "principalPayment")
    private PrincipalPayments principalPayment; // CDM principal payments
    
    @CDMField(name = "settlementTerms")
    private SettlementTerms settlementTerms; // CDM settlement terms
    
    // Common validation and business logic
    public abstract List<Cashflow> generateCashflows(CashflowGenerationContext context);
    public abstract void validatePayoutStructure();
}
```

### 2. **Equity Performance Payout** (CDM PerformancePayout Alignment)

```java
/**
 * Equity performance payout aligned with CDM PerformancePayout
 * Handles equity returns, dividends, and performance calculations
 */
@CDMEntity(type = "PerformancePayout")
public class EquityPerformancePayout extends BasePayout {
    
    @CDMField(name = "underlier")
    private EquityUnderlier underlier; // Single stock, index, or basket
    
    @CDMField(name = "returnTerms")
    private EquityReturnTerms returnTerms; // Price, dividend, variance returns
    
    @CDMField(name = "valuationDates")
    private ValuationSchedule valuationDates; // When to value positions
    
    @CDMField(name = "paymentDates")
    private PaymentSchedule paymentDates; // When payments are due
    
    @CDMField(name = "fxFeature")
    private FxFeature fxFeature; // Quanto, composite FX features
    
    // Equity-specific cashflow generation
    @Override
    public List<Cashflow> generateCashflows(CashflowGenerationContext context) {
        List<Cashflow> cashflows = new ArrayList<>();
        
        // Generate price return cashflows
        if (returnTerms.getPriceReturnTerms() != null) {
            cashflows.addAll(generatePriceReturnCashflows(context));
        }
        
        // Generate dividend cashflows
        if (returnTerms.getDividendReturnTerms() != null) {
            cashflows.addAll(generateDividendCashflows(context));
        }
        
        // Generate variance/volatility cashflows if applicable
        if (returnTerms.getVarianceReturnTerms() != null) {
            cashflows.addAll(generateVarianceCashflows(context));
        }
        
        return cashflows;
    }
}
```

### 3. **Interest Rate Payout** (CDM InterestRatePayout Alignment)

```java
/**
 * Interest rate payout aligned with CDM InterestRatePayout
 * Handles funding leg calculations for equity swaps
 */
@CDMEntity(type = "InterestRatePayout")
public class InterestRatePayout extends BasePayout {
    
    @CDMField(name = "dayCountFraction")
    private DayCountFraction dayCountFraction; // Day count convention
    
    @CDMField(name = "calculationPeriodDates")
    private CalculationPeriodSchedule calculationPeriodDates; // Interest periods
    
    @CDMField(name = "paymentDates")
    private PaymentSchedule paymentDates; // Interest payment dates
    
    @CDMField(name = "rateType")
    private RateType rateType; // Fixed, floating, inflation
    
    @CDMField(name = "spread")
    private SpreadSchedule spread; // Interest rate spread
    
    // Interest-specific cashflow generation
    @Override
    public List<Cashflow> generateCashflows(CashflowGenerationContext context) {
        List<Cashflow> cashflows = new ArrayList<>();
        
        // Generate interest accrual cashflows
        cashflows.addAll(generateInterestAccrualCashflows(context));
        
        // Generate interest payment cashflows
        cashflows.addAll(generateInterestPaymentCashflows(context));
        
        return cashflows;
    }
}
```

### 4. **Enhanced Cashflow Structure** (CDM + Business Requirements)

```java
/**
 * Enhanced cashflow structure that extends CDM Cashflow
 * Supports accruals, realized unsettled, and realized settled states
 */
@CDMEntity(type = "Cashflow")
public class EnhancedCashflow extends Cashflow {
    
    // CDM-compliant base fields
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
    
    // Enhanced business fields
    private CashflowStatus status; // ACCRUED, REALIZED_UNSETTLED, REALIZED_SETTLED
    private CashflowCategory category; // EQUITY_RETURN, DIVIDEND, INTEREST, FEES
    private CashflowSubCategory subCategory; // PRICE_RETURN, VARIANCE, VOLATILITY, etc.
    
    // Accrual and settlement tracking
    private LocalDate accrualStartDate; // When accrual period starts
    private LocalDate accrualEndDate; // When accrual period ends
    private LocalDate realizationDate; // When cashflow was realized
    private LocalDate settlementDate; // When cashflow was settled
    
    // Performance and calculation tracking
    private BigDecimal accrualAmount; // Accrued amount
    private BigDecimal realizedAmount; // Realized amount
    private BigDecimal settledAmount; // Settled amount
    private BigDecimal unrealizedAmount; // Unrealized amount
    
    // Reference and lineage
    private String contractId; // Reference to source contract
    private String legId; // Reference to specific leg
    private String lotId; // Reference to specific lot
    private String resetId; // Reference to reset event
    
    // Business metadata
    private Map<String, Object> businessMetadata; // Additional business fields
    private List<String> tags; // Business tags for categorization
}
```

### 5. **Cashflow Status and Category Enums**

```java
/**
 * Cashflow status enumeration
 */
public enum CashflowStatus {
    ACCRUED("ACCRUED", "Cashflow has been accrued but not yet realized"),
    REALIZED_UNSETTLED("REALIZED_UNSETTLED", "Cashflow has been realized but not yet settled"),
    REALIZED_SETTLED("REALIZED_SETTLED", "Cashflow has been realized and settled"),
    CANCELLED("CANCELLED", "Cashflow has been cancelled"),
    ADJUSTED("ADJUSTED", "Cashflow has been adjusted");
    
    private final String code;
    private final String description;
}

/**
 * Cashflow category enumeration
 */
public enum CashflowCategory {
    EQUITY_RETURN("EQUITY_RETURN", "Equity price return cashflows"),
    DIVIDEND("DIVIDEND", "Dividend-related cashflows"),
    INTEREST("INTEREST", "Interest rate cashflows"),
    FEES("FEES", "Fee and commission cashflows"),
    ADJUSTMENT("ADJUSTMENT", "Adjustment and correction cashflows"),
    SETTLEMENT("SETTLEMENT", "Settlement-related cashflows");
    
    private final String code;
    private final String description;
}

/**
 * Cashflow sub-category enumeration
 */
public enum CashflowSubCategory {
    // Equity returns
    PRICE_RETURN("PRICE_RETURN", "Price return cashflows"),
    VARIANCE_RETURN("VARIANCE_RETURN", "Variance return cashflows"),
    VOLATILITY_RETURN("VOLATILITY_RETURN", "Volatility return cashflows"),
    CORRELATION_RETURN("CORRELATION_RETURN", "Correlation return cashflows"),
    
    // Dividends
    ORDINARY_DIVIDEND("ORDINARY_DIVIDEND", "Ordinary dividend cashflows"),
    SPECIAL_DIVIDEND("SPECIAL_DIVIDEND", "Special dividend cashflows"),
    DIVIDEND_REINVESTMENT("DIVIDEND_REINVESTMENT", "Dividend reinvestment cashflows"),
    
    // Interest
    FIXED_INTEREST("FIXED_INTEREST", "Fixed interest cashflows"),
    FLOATING_INTEREST("FLOATING_INTEREST", "Floating interest cashflows"),
    INTEREST_ACCRUAL("INTEREST_ACCRUAL", "Interest accrual cashflows"),
    
    // Fees
    BROKERAGE_FEE("BROKERAGE_FEE", "Brokerage fee cashflows"),
    MANAGEMENT_FEE("MANAGEMENT_FEE", "Management fee cashflows"),
    PERFORMANCE_FEE("PERFORMANCE_FEE", "Performance fee cashflows");
    
    private final String code;
    private final String description;
}
```

### 6. **Cashflow Generation Context**

```java
/**
 * Context for cashflow generation
 * Contains all necessary data for generating cashflows
 */
public class CashflowGenerationContext {
    
    // Contract information
    private String contractId;
    private LocalDate calculationDate;
    private LocalDate effectiveDate;
    private LocalDate terminationDate;
    
    // Market data
    private Map<String, MarketPrice> marketPrices; // Underlier -> Price
    private Map<String, InterestRate> interestRates; // Rate index -> Rate
    private Map<String, DividendData> dividendData; // Underlier -> Dividend info
    
    // Business rules
    private BusinessDayAdjustment businessDayAdjustment;
    private CurrencyConversionRules currencyConversionRules;
    private FeeCalculationRules feeCalculationRules;
    
    // Calculation parameters
    private BigDecimal notionalAmount;
    private String baseCurrency;
    private DayCountConvention dayCountConvention;
    private PaymentFrequency paymentFrequency;
    
    // Validation and compliance
    private List<ValidationRule> validationRules;
    private ComplianceSettings complianceSettings;
    
    // Audit and lineage
    private String calculationAgent;
    private String calculationSource;
    private LocalDateTime calculationTimestamp;
}
```

### 7. **Cashflow Generation Engine**

```java
/**
 * Main cashflow generation engine
 * Orchestrates the generation of cashflows from payout structures
 */
@Service
public class CashflowGenerationEngine {
    
    @Autowired
    private List<BasePayout> payoutTypes;
    
    @Autowired
    private CashflowValidationService validationService;
    
    @Autowired
    private CashflowPersistenceService persistenceService;
    
    /**
     * Generate cashflows for an equity swap contract
     */
    public CashflowGenerationResult generateCashflows(EquitySwapContract contract, 
                                                     CashflowGenerationContext context) {
        
        List<EnhancedCashflow> allCashflows = new ArrayList<>();
        List<CashflowGenerationError> errors = new ArrayList<>();
        
        try {
            // Generate cashflows from each payout leg
            for (BasePayout payout : contract.getPayouts()) {
                List<Cashflow> baseCashflows = payout.generateCashflows(context);
                
                // Convert to enhanced cashflows
                List<EnhancedCashflow> enhancedCashflows = convertToEnhancedCashflows(
                    baseCashflows, contract, context);
                
                allCashflows.addAll(enhancedCashflows);
            }
            
            // Apply business rules and adjustments
            allCashflows = applyBusinessRules(allCashflows, context);
            
            // Validate all cashflows
            validationService.validateCashflows(allCashflows);
            
            // Persist cashflows
            persistenceService.persistCashflows(allCashflows);
            
            return CashflowGenerationResult.success(allCashflows);
            
        } catch (Exception e) {
            errors.add(new CashflowGenerationError("GENERATION_FAILED", e.getMessage()));
            return CashflowGenerationResult.failure(errors);
        }
    }
    
    /**
     * Convert CDM cashflows to enhanced cashflows
     */
    private List<EnhancedCashflow> convertToEnhancedCashflows(List<Cashflow> baseCashflows,
                                                             EquitySwapContract contract,
                                                             CashflowGenerationContext context) {
        
        return baseCashflows.stream()
            .map(baseCashflow -> {
                EnhancedCashflow enhanced = new EnhancedCashflow();
                
                // Copy CDM fields
                enhanced.setQuantity(baseCashflow.getQuantity());
                enhanced.setAsset(baseCashflow.getAsset());
                enhanced.setSettlementDate(baseCashflow.getSettlementDate());
                enhanced.setPayerReceiver(baseCashflow.getPayerReceiver());
                enhanced.setCashflowType(baseCashflow.getCashflowType());
                
                // Set enhanced fields
                enhanced.setStatus(CashflowStatus.ACCRUED);
                enhanced.setContractId(contract.getContractId());
                enhanced.setAccrualStartDate(context.getEffectiveDate());
                enhanced.setAccrualEndDate(context.getCalculationDate());
                enhanced.setRealizationDate(context.getCalculationDate());
                
                // Set category and subcategory based on payout type
                setCashflowCategories(enhanced, contract, baseCashflow);
                
                return enhanced;
            })
            .collect(Collectors.toList());
    }
    
    /**
     * Apply business rules to cashflows
     */
    private List<EnhancedCashflow> applyBusinessRules(List<EnhancedCashflow> cashflows,
                                                     CashflowGenerationContext context) {
        
        // Apply business day adjustments
        cashflows = applyBusinessDayAdjustments(cashflows, context.getBusinessDayAdjustment());
        
        // Apply currency conversions
        cashflows = applyCurrencyConversions(cashflows, context.getCurrencyConversionRules());
        
        // Apply fee calculations
        cashflows = applyFeeCalculations(cashflows, context.getFeeCalculationRules());
        
        return cashflows;
    }
}
```

### 8. **Cashflow State Management**

```java
/**
 * Service for managing cashflow state transitions
 */
@Service
public class CashflowStateManagementService {
    
    /**
     * Transition cashflow from ACCRUED to REALIZED_UNSETTLED
     */
    public void realizeCashflow(String cashflowId, LocalDate realizationDate) {
        EnhancedCashflow cashflow = findCashflow(cashflowId);
        
        if (cashflow.getStatus() != CashflowStatus.ACCRUED) {
            throw new InvalidStateTransitionException(
                "Cannot realize cashflow in state: " + cashflow.getStatus());
        }
        
        cashflow.setStatus(CashflowStatus.REALIZED_UNSETTLED);
        cashflow.setRealizationDate(realizationDate);
        cashflow.setRealizedAmount(cashflow.getAccrualAmount());
        
        // Create state transition event
        createStateTransitionEvent(cashflow, CashflowStatus.ACCRUED, CashflowStatus.REALIZED_UNSETTLED);
        
        // Persist changes
        persistCashflow(cashflow);
    }
    
    /**
     * Transition cashflow from REALIZED_UNSETTLED to REALIZED_SETTLED
     */
    public void settleCashflow(String cashflowId, LocalDate settlementDate, BigDecimal settledAmount) {
        EnhancedCashflow cashflow = findCashflow(cashflowId);
        
        if (cashflow.getStatus() != CashflowStatus.REALIZED_UNSETTLED) {
            throw new InvalidStateTransitionException(
                "Cannot settle cashflow in state: " + cashflow.getStatus());
        }
        
        cashflow.setStatus(CashflowStatus.REALIZED_SETTLED);
        cashflow.setSettlementDate(settlementDate);
        cashflow.setSettledAmount(settledAmount);
        
        // Create state transition event
        createStateTransitionEvent(cashflow, CashflowStatus.REALIZED_UNSETTLED, CashflowStatus.REALIZED_SETTLED);
        
        // Persist changes
        persistCashflow(cashflow);
    }
    
    /**
     * Get cashflows by status
     */
    public List<EnhancedCashflow> getCashflowsByStatus(CashflowStatus status) {
        return cashflowRepository.findByStatus(status);
    }
    
    /**
     * Get cashflows by category and status
     */
    public List<EnhancedCashflow> getCashflowsByCategoryAndStatus(CashflowCategory category, 
                                                                 CashflowStatus status) {
        return cashflowRepository.findByCategoryAndStatus(category, status);
    }
}
```

### 9. **Cashflow Query and Reporting**

```java
/**
 * Service for querying and reporting on cashflows
 */
@Service
public class CashflowQueryService {
    
    /**
     * Get accrual summary by contract
     */
    public AccrualSummary getAccrualSummary(String contractId, LocalDate asOfDate) {
        List<EnhancedCashflow> accruedCashflows = cashflowRepository
            .findByContractIdAndStatusAndAccrualEndDateLessThanEqual(
                contractId, CashflowStatus.ACCRUED, asOfDate);
        
        return AccrualSummary.builder()
            .contractId(contractId)
            .asOfDate(asOfDate)
            .totalAccruedAmount(calculateTotalAmount(accruedCashflows))
            .cashflowCount(accruedCashflows.size())
            .breakdownByCategory(breakdownByCategory(accruedCashflows))
            .build();
    }
    
    /**
     * Get realized unsettled summary
     */
    public RealizedUnsettledSummary getRealizedUnsettledSummary(String contractId) {
        List<EnhancedCashflow> realizedUnsettled = cashflowRepository
            .findByContractIdAndStatus(contractId, CashflowStatus.REALIZED_UNSETTLED);
        
        return RealizedUnsettledSummary.builder()
            .contractId(contractId)
            .totalRealizedAmount(calculateTotalAmount(realizedUnsettled))
            .cashflowCount(realizedUnsettled.size())
            .breakdownByCategory(breakdownByCategory(realizedUnsettled))
            .build();
    }
    
    /**
     * Get realized settled summary
     */
    public RealizedSettledSummary getRealizedSettledSummary(String contractId, 
                                                           LocalDate fromDate, 
                                                           LocalDate toDate) {
        List<EnhancedCashflow> realizedSettled = cashflowRepository
            .findByContractIdAndStatusAndSettlementDateBetween(
                contractId, CashflowStatus.REALIZED_SETTLED, fromDate, toDate);
        
        return RealizedSettledSummary.builder()
            .contractId(contractId)
            .fromDate(fromDate)
            .toDate(toDate)
            .totalSettledAmount(calculateTotalAmount(realizedSettled))
            .cashflowCount(realizedSettled.size())
            .breakdownByCategory(breakdownByCategory(realizedSettled))
            .build();
    }
}
```

## Implementation Benefits

### 1. **CDM Compliance**
- Extends CDM base types for interoperability
- Follows CDM naming conventions and structure
- Supports CDM validation and lineage tracking

### 2. **Business Requirements Support**
- **Accruals**: Tracks accrual periods and amounts
- **Realized Unsettled**: Manages realized but not yet settled cashflows
- **Realized Settled**: Tracks fully settled cashflows
- **State Transitions**: Proper workflow management

### 3. **Flexibility and Extensibility**
- Abstract base classes for easy extension
- Metadata support for business-specific fields
- Tag-based categorization system

### 4. **Performance and Scalability**
- Efficient querying by status and category
- Batch processing capabilities
- Event-driven state transitions

## Next Steps

1. **Implement Base Classes**: Create the abstract payout and cashflow base classes
2. **Create Specific Payout Types**: Implement EquityPerformancePayout and InterestRatePayout
3. **Build Cashflow Generation Engine**: Implement the main generation logic
4. **Add State Management**: Implement cashflow state transitions
5. **Create Query Services**: Build reporting and query capabilities
6. **Add Validation**: Implement CDM compliance validation
7. **Test with CDM Tools**: Validate using FINOS CDM validation tools

This design provides a solid foundation that aligns with CDM principles while meeting your specific business requirements for accruals, realized unsettled, and realized settled cashflows.
