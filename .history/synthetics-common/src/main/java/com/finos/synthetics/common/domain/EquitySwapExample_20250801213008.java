package com.finos.synthetics.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * Practical Example: Equity Swaps using CDM
 * 
 * This example demonstrates how to work with equity swaps using the Common Domain Model (CDM).
 * It shows the complete lifecycle from creation to execution and monitoring.
 * 
 * @version 1.0.0
 */
public class EquitySwapExample {
    
    private static final Logger logger = LoggerFactory.getLogger(EquitySwapExample.class);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    /**
     * Main method to demonstrate equity swap functionality
     */
    public static void main(String[] args) {
        logger.info("🚀 Starting Equity Swap CDM Example");
        
        // 1. Create a simple equity swap
        EquitySwapMasterConfirmation2018 simpleSwap = createSimpleEquitySwap();
        logger.info("✅ Simple Equity Swap Created: {}", simpleSwap.getTypeOfSwapElection());
        
        // 2. Create an advanced equity swap with corporate events
        EquitySwapMasterConfirmation2018 advancedSwap = createAdvancedEquitySwap();
        logger.info("✅ Advanced Equity Swap Created with Corporate Events");
        
        // 3. Demonstrate pricing calculations
        demonstratePricingCalculations(simpleSwap);
        
        // 4. Show risk management
        demonstrateRiskManagement(simpleSwap);
        
        // 5. Demonstrate execution
        demonstrateExecution(simpleSwap);
        
        // 6. Show regulatory compliance
        demonstrateRegulatoryCompliance(simpleSwap);
        
        logger.info("🎉 Equity Swap CDM Example Completed Successfully!");
    }
    
    /**
     * Create a simple equity swap using CDM
     */
    public static EquitySwapMasterConfirmation2018 createSimpleEquitySwap() {
        logger.info("📝 Creating Simple Equity Swap...");
        
        return EquitySwapMasterConfirmation2018.builder()
            // Basic swap type
            .typeOfSwapElection(ReturnTypeEnum.TOTAL_RETURN)
            
            // Pricing method - using VWAP
            .pricingMethodElection(PriceReturnTerms.builder()
                .priceReturnType(PriceReturnTypeEnum.VWAP)
                .build())
            
            // Settlement terms - cash settlement
            .settlementTerms(SettlementTerms.builder()
                .settlementType(SettlementTypeEnum.CASH)
                .settlementCurrency("USD")
                .build())
            
            // Valuation dates - monthly observations
            .valuationDates(ValuationDates.builder()
                .effectiveDate(LocalDate.now())
                .terminationDate(LocalDate.now().plusYears(1))
                .frequency(FrequencyEnum.MONTHLY)
                .build())
            
            // Payment dates - quarterly payments
            .equityCashSettlementDates(PaymentDates.builder()
                .paymentFrequency(FrequencyEnum.QUARTERLY)
                .build())
            
            .build();
    }
    
    /**
     * Create an advanced equity swap with corporate events handling
     */
    public static EquitySwapMasterConfirmation2018 createAdvancedEquitySwap() {
        logger.info("📝 Creating Advanced Equity Swap with Corporate Events...");
        
        return EquitySwapMasterConfirmation2018.builder()
            .typeOfSwapElection(ReturnTypeEnum.TOTAL_RETURN)
            
            // Corporate events handling
            .corporateEvents(EquityCorporateEvents.builder()
                .dividendAdjustment(DividendAdjustmentEnum.ADJUSTMENT_EVENT)
                .mergerEvents(MergerEventsEnum.ADJUSTMENT_EVENT)
                .build())
            
            // Additional terms for flexibility
            .additionalTerms(EquityAdditionalTerms.builder()
                .earlyTerminationProvision(true)
                .extensionProvision(true)
                .build())
            
            .build();
    }
    
    /**
     * Demonstrate pricing calculations for equity swaps
     */
    public static void demonstratePricingCalculations(EquitySwapMasterConfirmation2018 swap) {
        logger.info("💰 Demonstrating Pricing Calculations...");
        
        // Calculate price return
        double startPrice = 100.0;
        double endPrice = 110.0;
        double priceReturn = calculatePriceReturn(startPrice, endPrice);
        logger.info("📈 Price Return: {}%", priceReturn * 100);
        
        // Calculate total return (including dividends)
        double dividendYield = 0.02; // 2% dividend yield
        double totalReturn = calculateTotalReturn(priceReturn, dividendYield);
        logger.info("📊 Total Return: {}%", totalReturn * 100);
        
        // Calculate swap payment
        double notional = 1000000.0; // $1M notional
        double fixedRate = 0.05; // 5% fixed rate
        Money swapPayment = calculateSwapPayment(notional, totalReturn, fixedRate);
        logger.info("💵 Swap Payment: ${}", swapPayment.getAmount());
    }
    
    /**
     * Demonstrate risk management for equity swaps
     */
    public static void demonstrateRiskManagement(EquitySwapMasterConfirmation2018 swap) {
        logger.info("📊 Demonstrating Risk Management...");
        
        // Calculate market risk metrics
        RiskMetrics riskMetrics = calculateMarketRisk(swap);
        logger.info("🎯 VaR 95%: ${}", riskMetrics.getVar95());
        logger.info("🎯 VaR 99%: ${}", riskMetrics.getVar99());
        logger.info("📈 Volatility: {}%", riskMetrics.getVolatility() * 100);
        
        // Calculate delta exposure
        double delta = calculateDelta(swap);
        logger.info("📊 Delta: {}", delta);
        
        // Calculate counterparty risk
        double creditExposure = calculateCreditExposure(swap, 0.85);
        logger.info("🏦 Credit Exposure: ${}", creditExposure);
    }
    
    /**
     * Demonstrate execution of equity swaps
     */
    public static void demonstrateExecution(EquitySwapMasterConfirmation2018 swap) {
        logger.info("🚀 Demonstrating Equity Swap Execution...");
        
        // Create algorithmic execution
        EquitySwapExecutionEvent algoExecution = EquitySwapExecutionEvent.builder()
            .executionType(EquitySwapExecutionEvent.ExecutionType.ALGORITHMIC)
            .status(EquitySwapExecutionEvent.ExecutionStatus.IN_PROGRESS)
            .executionTimestamp(LocalDateTime.now())
            .primaryVenue(new EquitySwapExecutionEvent.ExecutionVenue("VENUE001", "Digital Exchange", 
                EquitySwapExecutionEvent.ExecutionVenue.VenueType.HYBRID, "US", true))
            .algorithmicDetails(new EquitySwapExecutionEvent.AlgorithmicExecutionDetails(
                "ALGO001", "VWAP Algorithm", 
                EquitySwapExecutionEvent.AlgorithmicExecutionDetails.AlgorithmType.VWAP,
                new EquitySwapExecutionEvent.ExecutionParameters(1000.0, 100.0, 0.5, 3600, "Conservative"),
                new EquitySwapExecutionEvent.PerformanceMetrics(0.95, 0.02, 0.01, 0.98, 0.005)
            ))
            .pricing(new EquitySwapExecutionEvent.ExecutionPricing(150.25, "USD", 1000.0, 150250.0, 
                EquitySwapExecutionEvent.ExecutionPricing.PricingModel.VWAP))
            .settlement(new EquitySwapExecutionEvent.SettlementDetails(EquitySwapExecutionEvent.SettlementDetails.SettlementType.T_PLUS_2,
                LocalDateTime.now().plusDays(2), null, "USD", 150250.0,
                EquitySwapExecutionEvent.SettlementDetails.SettlementStatus.PENDING))
            .build();
        
        logger.info("✅ Algorithmic Execution Created: {}", algoExecution.getExecutionId());
        logger.info("📊 Execution Status: {}", algoExecution.getStatus());
        logger.info("💰 Execution Price: ${}", algoExecution.getPricing().getExecutionPrice());
        
        // Create smart contract execution
        EquitySwapExecutionEvent blockchainExecution = EquitySwapExecutionEvent.builder()
            .executionType(EquitySwapExecutionEvent.ExecutionType.SMART_CONTRACT)
            .status(EquitySwapExecutionEvent.ExecutionStatus.IN_PROGRESS)
            .smartContractDetails(new EquitySwapExecutionEvent.SmartContractDetails(
                "0x1234567890abcdef", "Ethereum", "SC001",
                EquitySwapExecutionEvent.SmartContractDetails.ContractState.EXECUTING,
                Arrays.asList("0xabc123", "0xdef456")
            ))
            .build();
        
        logger.info("⛓️ Blockchain Execution Created: {}", blockchainExecution.getExecutionId());
        logger.info("🔗 Smart Contract Address: {}", blockchainExecution.getSmartContractDetails().getContractAddress());
    }
    
    /**
     * Demonstrate regulatory compliance
     */
    public static void demonstrateRegulatoryCompliance(EquitySwapMasterConfirmation2018 swap) {
        logger.info("🔒 Demonstrating Regulatory Compliance...");
        
        // Create EMIR report
        EMIRReport emirReport = EMIRReport.builder()
            .tradeId(UUID.randomUUID().toString())
            .counterpartyId("CP001")
            .productType("EQUITY_SWAP")
            .notional(1000000.0)
            .currency("USD")
            .effectiveDate(LocalDate.now())
            .terminationDate(LocalDate.now().plusYears(1))
            .build();
        
        logger.info("📋 EMIR Report Created: {}", emirReport.getTradeId());
        
        // Create Dodd-Frank report
        DoddFrankReport doddFrankReport = DoddFrankReport.builder()
            .uniqueSwapIdentifier(UUID.randomUUID().toString())
            .swapDataRecord(SwapDataRecord.builder()
                .productType("EQUITY_SWAP")
                .assetClass("EQUITY")
                .build())
            .build();
        
        logger.info("📋 Dodd-Frank Report Created: {}", doddFrankReport.getUniqueSwapIdentifier());
    }
    
    /**
     * Calculate price return
     */
    public static double calculatePriceReturn(double startPrice, double endPrice) {
        return (endPrice - startPrice) / startPrice;
    }
    
    /**
     * Calculate total return including dividends
     */
    public static double calculateTotalReturn(double priceReturn, double dividendYield) {
        return priceReturn + dividendYield;
    }
    
    /**
     * Calculate swap payment
     */
    public static Money calculateSwapPayment(double notional, double returnRate, double fixedRate) {
        double netPayment = (returnRate - fixedRate) * notional;
        return Money.builder()
            .amount(netPayment)
            .currency("USD")
            .build();
    }
    
    /**
     * Calculate market risk metrics
     */
    public static RiskMetrics calculateMarketRisk(EquitySwapMasterConfirmation2018 swap) {
        double notional = 1000000.0; // Assume $1M notional
        double volatility = 0.25; // 25% volatility
        double var95 = notional * volatility * 1.645; // 95% VaR
        double var99 = var95 * 1.645 / 1.282; // 99% VaR
        
        return new RiskMetrics(var95, var99, 0.15, volatility, 1.2, 0.8);
    }
    
    /**
     * Calculate delta exposure
     */
    public static double calculateDelta(EquitySwapMasterConfirmation2018 swap) {
        return 10000.0; // Simplified calculation
    }
    
    /**
     * Calculate credit exposure
     */
    public static double calculateCreditExposure(EquitySwapMasterConfirmation2018 swap, double counterpartyRating) {
        double notional = 1000000.0;
        double timeToMaturity = 1.0; // 1 year
        double pfe = notional * Math.sqrt(timeToMaturity) * 0.3;
        return pfe * counterpartyRating;
    }
    
    /**
     * Demonstrate usage of the new execution event
     */
    public static void demonstrateUsage() {
        logger.info("Creating a modern equity swap execution event...");
        
        // Create execution event with modern features
        EquitySwapExecutionEvent event = EquitySwapExecutionEvent.builder()
            .executionType(EquitySwapExecutionEvent.ExecutionType.ALGORITHMIC)
            .status(EquitySwapExecutionEvent.ExecutionStatus.IN_PROGRESS)
            .executionTimestamp(LocalDateTime.now())
            .primaryVenue(new EquitySwapExecutionEvent.ExecutionVenue("VENUE001", "Digital Exchange", 
                EquitySwapExecutionEvent.ExecutionVenue.VenueType.HYBRID, "US", true))
            .pricing(new EquitySwapExecutionEvent.ExecutionPricing(150.25, "USD", 1000.0, 150250.0, 
                EquitySwapExecutionEvent.ExecutionPricing.PricingModel.VWAP))
            .settlement(new EquitySwapExecutionEvent.SettlementDetails(EquitySwapExecutionEvent.SettlementDetails.SettlementType.T_PLUS_2,
                LocalDateTime.now().plusDays(2), null, "USD", 150250.0,
                EquitySwapExecutionEvent.SettlementDetails.SettlementStatus.PENDING))
            .metadata(new EquitySwapExecutionEvent.ExecutionMetadata("system", LocalDateTime.now(), "system", 
                LocalDateTime.now(), "1.0.0", "TradingSystem"))
            .build();
        
        logger.info("Execution Event Created: {}", event.toJson());
        logger.info("Event Status: {}", event.getStatus());
        logger.info("Execution Type: {}", event.getExecutionType());
    }
}

// Supporting classes for the example

/**
 * EMIR Report for regulatory compliance
 */
class EMIRReport {
    private final String tradeId;
    private final String counterpartyId;
    private final String productType;
    private final double notional;
    private final String currency;
    private final LocalDate effectiveDate;
    private final LocalDate terminationDate;
    
    public EMIRReport(String tradeId, String counterpartyId, String productType, 
                     double notional, String currency, LocalDate effectiveDate, 
                     LocalDate terminationDate) {
        this.tradeId = tradeId;
        this.counterpartyId = counterpartyId;
        this.productType = productType;
        this.notional = notional;
        this.currency = currency;
        this.effectiveDate = effectiveDate;
        this.terminationDate = terminationDate;
    }
    
    // Getters
    public String getTradeId() { return tradeId; }
    public String getCounterpartyId() { return counterpartyId; }
    public String getProductType() { return productType; }
    public double getNotional() { return notional; }
    public String getCurrency() { return currency; }
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public LocalDate getTerminationDate() { return terminationDate; }
    
    public static class Builder {
        private String tradeId;
        private String counterpartyId;
        private String productType;
        private double notional;
        private String currency;
        private LocalDate effectiveDate;
        private LocalDate terminationDate;
        
        public Builder tradeId(String tradeId) {
            this.tradeId = tradeId;
            return this;
        }
        
        public Builder counterpartyId(String counterpartyId) {
            this.counterpartyId = counterpartyId;
            return this;
        }
        
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }
        
        public Builder notional(double notional) {
            this.notional = notional;
            return this;
        }
        
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }
        
        public Builder terminationDate(LocalDate terminationDate) {
            this.terminationDate = terminationDate;
            return this;
        }
        
        public EMIRReport build() {
            return new EMIRReport(tradeId, counterpartyId, productType, notional, 
                                currency, effectiveDate, terminationDate);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

/**
 * Dodd-Frank Report for regulatory compliance
 */
class DoddFrankReport {
    private final String uniqueSwapIdentifier;
    private final SwapDataRecord swapDataRecord;
    
    public DoddFrankReport(String uniqueSwapIdentifier, SwapDataRecord swapDataRecord) {
        this.uniqueSwapIdentifier = uniqueSwapIdentifier;
        this.swapDataRecord = swapDataRecord;
    }
    
    // Getters
    public String getUniqueSwapIdentifier() { return uniqueSwapIdentifier; }
    public SwapDataRecord getSwapDataRecord() { return swapDataRecord; }
    
    public static class Builder {
        private String uniqueSwapIdentifier;
        private SwapDataRecord swapDataRecord;
        
        public Builder uniqueSwapIdentifier(String uniqueSwapIdentifier) {
            this.uniqueSwapIdentifier = uniqueSwapIdentifier;
            return this;
        }
        
        public Builder swapDataRecord(SwapDataRecord swapDataRecord) {
            this.swapDataRecord = swapDataRecord;
            return this;
        }
        
        public DoddFrankReport build() {
            return new DoddFrankReport(uniqueSwapIdentifier, swapDataRecord);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

/**
 * Swap Data Record for Dodd-Frank reporting
 */
class SwapDataRecord {
    private final String productType;
    private final String assetClass;
    
    public SwapDataRecord(String productType, String assetClass) {
        this.productType = productType;
        this.assetClass = assetClass;
    }
    
    // Getters
    public String getProductType() { return productType; }
    public String getAssetClass() { return assetClass; }
    
    public static class Builder {
        private String productType;
        private String assetClass;
        
        public Builder productType(String productType) {
            this.productType = productType;
            return this;
        }
        
        public Builder assetClass(String assetClass) {
            this.assetClass = assetClass;
            return this;
        }
        
        public SwapDataRecord build() {
            return new SwapDataRecord(productType, assetClass);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

/**
 * Money class for financial amounts
 */
class Money {
    private final double amount;
    private final String currency;
    
    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    
    // Getters
    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
    
    public static class Builder {
        private double amount;
        private String currency;
        
        public Builder amount(double amount) {
            this.amount = amount;
            return this;
        }
        
        public Builder currency(String currency) {
            this.currency = currency;
            return this;
        }
        
        public Money build() {
            return new Money(amount, currency);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

// CDM Enum placeholders for compilation
enum ReturnTypeEnum {
    TOTAL_RETURN, PRICE_RETURN, DIVIDEND_RETURN
}

// Execution Event Enums
enum ExecutionType {
    ALGORITHMIC, SMART_CONTRACT, HYBRID, REAL_TIME, BATCH, CROSS_VENUE
}

enum ExecutionStatus {
    PENDING, IN_PROGRESS, PARTIALLY_FILLED, FILLED, CANCELLED, FAILED, SETTLED
}

// Risk Metrics class
class RiskMetrics {
    private final double var95;
    private final double var99;
    private final double maxDrawdown;
    private final double volatility;
    private final double sharpeRatio;
    private final double beta;
    
    public RiskMetrics(double var95, double var99, double maxDrawdown, 
                      double volatility, double sharpeRatio, double beta) {
        this.var95 = var95;
        this.var99 = var99;
        this.maxDrawdown = maxDrawdown;
        this.volatility = volatility;
        this.sharpeRatio = sharpeRatio;
        this.beta = beta;
    }
    
    // Getters
    public double getVar95() { return var95; }
    public double getVar99() { return var99; }
    public double getMaxDrawdown() { return maxDrawdown; }
    public double getVolatility() { return volatility; }
    public double getSharpeRatio() { return sharpeRatio; }
    public double getBeta() { return beta; }
}

// Execution Venue class
class ExecutionVenue {
    private final String venueId;
    private final String venueName;
    private final VenueType venueType;
    private final String jurisdiction;
    private final boolean isRegulated;
    
    public enum VenueType {
        DARK_POOL, LIT_VENUE, BLOCKCHAIN, HYBRID, OTC, EXCHANGE
    }
    
    public ExecutionVenue(String venueId, String venueName, VenueType venueType, 
                         String jurisdiction, boolean isRegulated) {
        this.venueId = venueId;
        this.venueName = venueName;
        this.venueType = venueType;
        this.jurisdiction = jurisdiction;
        this.isRegulated = isRegulated;
    }
    
    // Getters
    public String getVenueId() { return venueId; }
    public String getVenueName() { return venueName; }
    public VenueType getVenueType() { return venueType; }
    public String getJurisdiction() { return jurisdiction; }
    public boolean isRegulated() { return isRegulated; }
}

// Algorithmic Execution Details class
class AlgorithmicExecutionDetails {
    private final String algorithmId;
    private final String algorithmName;
    private final AlgorithmType algorithmType;
    private final ExecutionParameters parameters;
    private final PerformanceMetrics performance;
    
    public enum AlgorithmType {
        VWAP, TWAP, POV, ICEBERG, ADAPTIVE, MACHINE_LEARNING
    }
    
    public AlgorithmicExecutionDetails(String algorithmId, String algorithmName, 
                                     AlgorithmType algorithmType, ExecutionParameters parameters,
                                     PerformanceMetrics performance) {
        this.algorithmId = algorithmId;
        this.algorithmName = algorithmName;
        this.algorithmType = algorithmType;
        this.parameters = parameters;
        this.performance = performance;
    }
    
    // Getters
    public String getAlgorithmId() { return algorithmId; }
    public String getAlgorithmName() { return algorithmName; }
    public AlgorithmType getAlgorithmType() { return algorithmType; }
    public ExecutionParameters getParameters() { return parameters; }
    public PerformanceMetrics getPerformance() { return performance; }
}

// Execution Parameters class
class ExecutionParameters {
    private final double maxOrderSize;
    private final double minOrderSize;
    private final double priceDeviation;
    private final int maxExecutionTime;
    private final String executionStrategy;
    
    public ExecutionParameters(double maxOrderSize, double minOrderSize, double priceDeviation,
                             int maxExecutionTime, String executionStrategy) {
        this.maxOrderSize = maxOrderSize;
        this.minOrderSize = minOrderSize;
        this.priceDeviation = priceDeviation;
        this.maxExecutionTime = maxExecutionTime;
        this.executionStrategy = executionStrategy;
    }
    
    // Getters
    public double getMaxOrderSize() { return maxOrderSize; }
    public double getMinOrderSize() { return minOrderSize; }
    public double getPriceDeviation() { return priceDeviation; }
    public int getMaxExecutionTime() { return maxExecutionTime; }
    public String getExecutionStrategy() { return executionStrategy; }
}

// Performance Metrics class
class PerformanceMetrics {
    private final double executionSpeed;
    private final double priceImprovement;
    private final double marketImpact;
    private final double fillRate;
    private final double slippage;
    
    public PerformanceMetrics(double executionSpeed, double priceImprovement,
                            double marketImpact, double fillRate, double slippage) {
        this.executionSpeed = executionSpeed;
        this.priceImprovement = priceImprovement;
        this.marketImpact = marketImpact;
        this.fillRate = fillRate;
        this.slippage = slippage;
    }
    
    // Getters
    public double getExecutionSpeed() { return executionSpeed; }
    public double getPriceImprovement() { return priceImprovement; }
    public double getMarketImpact() { return marketImpact; }
    public double getFillRate() { return fillRate; }
    public double getSlippage() { return slippage; }
}

// Smart Contract Details class
class SmartContractDetails {
    private final String contractAddress;
    private final String blockchainNetwork;
    private final String smartContractId;
    private final ContractState contractState;
    private final List<String> transactionHashes;
    
    public enum ContractState {
        DEPLOYED, EXECUTING, COMPLETED, FAILED, CANCELLED
    }
    
    public SmartContractDetails(String contractAddress, String blockchainNetwork, 
                              String smartContractId, ContractState contractState,
                              List<String> transactionHashes) {
        this.contractAddress = contractAddress;
        this.blockchainNetwork = blockchainNetwork;
        this.smartContractId = smartContractId;
        this.contractState = contractState;
        this.transactionHashes = transactionHashes;
    }
    
    // Getters
    public String getContractAddress() { return contractAddress; }
    public String getBlockchainNetwork() { return blockchainNetwork; }
    public String getSmartContractId() { return smartContractId; }
    public ContractState getContractState() { return contractState; }
    public List<String> getTransactionHashes() { return transactionHashes; }
}

// Execution Pricing class
class ExecutionPricing {
    private final double executionPrice;
    private final String currency;
    private final double quantity;
    private final double totalValue;
    private final PricingModel pricingModel;
    
    public enum PricingModel {
        MARKET, LIMIT, VWAP, TWAP, CUSTOM
    }
    
    public ExecutionPricing(double executionPrice, String currency, double quantity,
                           double totalValue, PricingModel pricingModel) {
        this.executionPrice = executionPrice;
        this.currency = currency;
        this.quantity = quantity;
        this.totalValue = totalValue;
        this.pricingModel = pricingModel;
    }
    
    // Getters
    public double getExecutionPrice() { return executionPrice; }
    public String getCurrency() { return currency; }
    public double getQuantity() { return quantity; }
    public double getTotalValue() { return totalValue; }
    public PricingModel getPricingModel() { return pricingModel; }
}

// Settlement Details class
class SettlementDetails {
    private final SettlementType settlementType;
    private final LocalDateTime expectedSettlementDate;
    private final LocalDateTime actualSettlementDate;
    private final String settlementCurrency;
    private final double settlementAmount;
    private final SettlementStatus status;
    
    public enum SettlementType {
        T_PLUS_2, T_PLUS_1, SAME_DAY, REAL_TIME, BLOCKCHAIN
    }
    
    public enum SettlementStatus {
        PENDING, IN_PROGRESS, COMPLETED, FAILED, PARTIAL
    }
    
    public SettlementDetails(SettlementType settlementType, LocalDateTime expectedSettlementDate,
                           LocalDateTime actualSettlementDate, String settlementCurrency,
                           double settlementAmount, SettlementStatus status) {
        this.settlementType = settlementType;
        this.expectedSettlementDate = expectedSettlementDate;
        this.actualSettlementDate = actualSettlementDate;
        this.settlementCurrency = settlementCurrency;
        this.settlementAmount = settlementAmount;
        this.status = status;
    }
    
    // Getters
    public SettlementType getSettlementType() { return settlementType; }
    public LocalDateTime getExpectedSettlementDate() { return expectedSettlementDate; }
    public LocalDateTime getActualSettlementDate() { return actualSettlementDate; }
    public String getSettlementCurrency() { return settlementCurrency; }
    public double getSettlementAmount() { return settlementAmount; }
    public SettlementStatus getStatus() { return status; }
}

// Execution Metadata class
class ExecutionMetadata {
    private final String createdBy;
    private final LocalDateTime createdAt;
    private final String lastModifiedBy;
    private final LocalDateTime lastModifiedAt;
    private final String version;
    private final String sourceSystem;
    
    public ExecutionMetadata(String createdBy, LocalDateTime createdAt, String lastModifiedBy,
                           LocalDateTime lastModifiedAt, String version, String sourceSystem) {
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedAt = lastModifiedAt;
        this.version = version;
        this.sourceSystem = sourceSystem;
    }
    
    // Getters
    public String getCreatedBy() { return createdBy; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getLastModifiedBy() { return lastModifiedBy; }
    public LocalDateTime getLastModifiedAt() { return lastModifiedAt; }
    public String getVersion() { return version; }
    public String getSourceSystem() { return sourceSystem; }
}

enum PriceReturnTypeEnum {
    VWAP, TWAP, CLOSE_PRICE
}

enum SettlementTypeEnum {
    CASH, PHYSICAL
}

enum FrequencyEnum {
    MONTHLY, QUARTERLY, ANNUAL
}

enum DividendAdjustmentEnum {
    ADJUSTMENT_EVENT
}

enum MergerEventsEnum {
    ADJUSTMENT_EVENT
}

// CDM class placeholders for compilation
class PriceReturnTerms {
    private final PriceReturnTypeEnum priceReturnType;
    
    public PriceReturnTerms(PriceReturnTypeEnum priceReturnType) {
        this.priceReturnType = priceReturnType;
    }
    
    public PriceReturnTypeEnum getPriceReturnType() { return priceReturnType; }
    
    public static class Builder {
        private PriceReturnTypeEnum priceReturnType;
        
        public Builder priceReturnType(PriceReturnTypeEnum priceReturnType) {
            this.priceReturnType = priceReturnType;
            return this;
        }
        
        public PriceReturnTerms build() {
            return new PriceReturnTerms(priceReturnType);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

class SettlementTerms {
    private final SettlementTypeEnum settlementType;
    private final String settlementCurrency;
    
    public SettlementTerms(SettlementTypeEnum settlementType, String settlementCurrency) {
        this.settlementType = settlementType;
        this.settlementCurrency = settlementCurrency;
    }
    
    public SettlementTypeEnum getSettlementType() { return settlementType; }
    public String getSettlementCurrency() { return settlementCurrency; }
    
    public static class Builder {
        private SettlementTypeEnum settlementType;
        private String settlementCurrency;
        
        public Builder settlementType(SettlementTypeEnum settlementType) {
            this.settlementType = settlementType;
            return this;
        }
        
        public Builder settlementCurrency(String settlementCurrency) {
            this.settlementCurrency = settlementCurrency;
            return this;
        }
        
        public SettlementTerms build() {
            return new SettlementTerms(settlementType, settlementCurrency);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

class ValuationDates {
    private final LocalDate effectiveDate;
    private final LocalDate terminationDate;
    private final FrequencyEnum frequency;
    
    public ValuationDates(LocalDate effectiveDate, LocalDate terminationDate, FrequencyEnum frequency) {
        this.effectiveDate = effectiveDate;
        this.terminationDate = terminationDate;
        this.frequency = frequency;
    }
    
    public LocalDate getEffectiveDate() { return effectiveDate; }
    public LocalDate getTerminationDate() { return terminationDate; }
    public FrequencyEnum getFrequency() { return frequency; }
    
    public static class Builder {
        private LocalDate effectiveDate;
        private LocalDate terminationDate;
        private FrequencyEnum frequency;
        
        public Builder effectiveDate(LocalDate effectiveDate) {
            this.effectiveDate = effectiveDate;
            return this;
        }
        
        public Builder terminationDate(LocalDate terminationDate) {
            this.terminationDate = terminationDate;
            return this;
        }
        
        public Builder frequency(FrequencyEnum frequency) {
            this.frequency = frequency;
            return this;
        }
        
        public ValuationDates build() {
            return new ValuationDates(effectiveDate, terminationDate, frequency);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

class PaymentDates {
    private final FrequencyEnum paymentFrequency;
    
    public PaymentDates(FrequencyEnum paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }
    
    public FrequencyEnum getPaymentFrequency() { return paymentFrequency; }
    
    public static class Builder {
        private FrequencyEnum paymentFrequency;
        
        public Builder paymentFrequency(FrequencyEnum paymentFrequency) {
            this.paymentFrequency = paymentFrequency;
            return this;
        }
        
        public PaymentDates build() {
            return new PaymentDates(paymentFrequency);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

class EquityCorporateEvents {
    private final DividendAdjustmentEnum dividendAdjustment;
    private final MergerEventsEnum mergerEvents;
    
    public EquityCorporateEvents(DividendAdjustmentEnum dividendAdjustment, MergerEventsEnum mergerEvents) {
        this.dividendAdjustment = dividendAdjustment;
        this.mergerEvents = mergerEvents;
    }
    
    public DividendAdjustmentEnum getDividendAdjustment() { return dividendAdjustment; }
    public MergerEventsEnum getMergerEvents() { return mergerEvents; }
    
    public static class Builder {
        private DividendAdjustmentEnum dividendAdjustment;
        private MergerEventsEnum mergerEvents;
        
        public Builder dividendAdjustment(DividendAdjustmentEnum dividendAdjustment) {
            this.dividendAdjustment = dividendAdjustment;
            return this;
        }
        
        public Builder mergerEvents(MergerEventsEnum mergerEvents) {
            this.mergerEvents = mergerEvents;
            return this;
        }
        
        public EquityCorporateEvents build() {
            return new EquityCorporateEvents(dividendAdjustment, mergerEvents);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

class EquityAdditionalTerms {
    private final boolean earlyTerminationProvision;
    private final boolean extensionProvision;
    
    public EquityAdditionalTerms(boolean earlyTerminationProvision, boolean extensionProvision) {
        this.earlyTerminationProvision = earlyTerminationProvision;
        this.extensionProvision = extensionProvision;
    }
    
    public boolean isEarlyTerminationProvision() { return earlyTerminationProvision; }
    public boolean isExtensionProvision() { return extensionProvision; }
    
    public static class Builder {
        private boolean earlyTerminationProvision;
        private boolean extensionProvision;
        
        public Builder earlyTerminationProvision(boolean earlyTerminationProvision) {
            this.earlyTerminationProvision = earlyTerminationProvision;
            return this;
        }
        
        public Builder extensionProvision(boolean extensionProvision) {
            this.extensionProvision = extensionProvision;
            return this;
        }
        
        public EquityAdditionalTerms build() {
            return new EquityAdditionalTerms(earlyTerminationProvision, extensionProvision);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
}

// CDM Master Confirmation placeholder
class EquitySwapMasterConfirmation2018 {
    private final ReturnTypeEnum typeOfSwapElection;
    private final PriceReturnTerms pricingMethodElection;
    private final SettlementTerms settlementTerms;
    private final ValuationDates valuationDates;
    private final PaymentDates equityCashSettlementDates;
    private final EquityCorporateEvents corporateEvents;
    private final EquityAdditionalTerms additionalTerms;
    
    public EquitySwapMasterConfirmation2018(ReturnTypeEnum typeOfSwapElection, 
                                          PriceReturnTerms pricingMethodElection,
                                          SettlementTerms settlementTerms,
                                          ValuationDates valuationDates,
                                          PaymentDates equityCashSettlementDates,
                                          EquityCorporateEvents corporateEvents,
                                          EquityAdditionalTerms additionalTerms) {
        this.typeOfSwapElection = typeOfSwapElection;
        this.pricingMethodElection = pricingMethodElection;
        this.settlementTerms = settlementTerms;
        this.valuationDates = valuationDates;
        this.equityCashSettlementDates = equityCashSettlementDates;
        this.corporateEvents = corporateEvents;
        this.additionalTerms = additionalTerms;
    }
    
    // Getters
    public ReturnTypeEnum getTypeOfSwapElection() { return typeOfSwapElection; }
    public PriceReturnTerms getPricingMethodElection() { return pricingMethodElection; }
    public SettlementTerms getSettlementTerms() { return settlementTerms; }
    public ValuationDates getValuationDates() { return valuationDates; }
    public PaymentDates getEquityCashSettlementDates() { return equityCashSettlementDates; }
    public EquityCorporateEvents getCorporateEvents() { return corporateEvents; }
    public EquityAdditionalTerms getAdditionalTerms() { return additionalTerms; }
    
    public static class Builder {
        private ReturnTypeEnum typeOfSwapElection;
        private PriceReturnTerms pricingMethodElection;
        private SettlementTerms settlementTerms;
        private ValuationDates valuationDates;
        private PaymentDates equityCashSettlementDates;
        private EquityCorporateEvents corporateEvents;
        private EquityAdditionalTerms additionalTerms;
        
        public Builder typeOfSwapElection(ReturnTypeEnum typeOfSwapElection) {
            this.typeOfSwapElection = typeOfSwapElection;
            return this;
        }
        
        public Builder pricingMethodElection(PriceReturnTerms pricingMethodElection) {
            this.pricingMethodElection = pricingMethodElection;
            return this;
        }
        
        public Builder settlementTerms(SettlementTerms settlementTerms) {
            this.settlementTerms = settlementTerms;
            return this;
        }
        
        public Builder valuationDates(ValuationDates valuationDates) {
            this.valuationDates = valuationDates;
            return this;
        }
        
        public Builder equityCashSettlementDates(PaymentDates equityCashSettlementDates) {
            this.equityCashSettlementDates = equityCashSettlementDates;
            return this;
        }
        
        public Builder corporateEvents(EquityCorporateEvents corporateEvents) {
            this.corporateEvents = corporateEvents;
            return this;
        }
        
        public Builder additionalTerms(EquityAdditionalTerms additionalTerms) {
            this.additionalTerms = additionalTerms;
            return this;
        }
        
        public EquitySwapMasterConfirmation2018 build() {
            return new EquitySwapMasterConfirmation2018(typeOfSwapElection, pricingMethodElection,
                    settlementTerms, valuationDates, equityCashSettlementDates, corporateEvents, additionalTerms);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
} 