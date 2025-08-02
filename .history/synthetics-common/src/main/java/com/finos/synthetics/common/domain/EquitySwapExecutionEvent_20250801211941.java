package com.finos.synthetics.common.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Fresh Execution Event Design for Equity Swaps
 * 
 * This represents a modern execution event that captures:
 * - Algorithmic execution details
 * - Smart contract integration
 * - Real-time settlement tracking
 * - Multi-venue execution
 * - Regulatory compliance tracking
 * 
 * @version 1.0.0
 */
public class EquitySwapExecutionEvent {
    
    private static final Logger logger = LoggerFactory.getLogger(EquitySwapExecutionEvent.class);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    // Core Execution Fields
    private final String executionId;
    private final ExecutionType executionType;
    private final ExecutionStatus status;
    private final LocalDateTime executionTimestamp;
    private final LocalDateTime settlementTimestamp;
    
    // Venue and Regulatory Information
    private final ExecutionVenue primaryVenue;
    private final List<ExecutionVenue> secondaryVenues;
    private final RegulatoryCompliance regulatoryCompliance;
    
    // Algorithmic Trading Details
    private final AlgorithmicExecutionDetails algorithmicDetails;
    private final SmartContractDetails smartContractDetails;
    
    // Financial Details
    private final ExecutionPricing pricing;
    private final SettlementDetails settlement;
    
    // Risk and Compliance
    private final RiskMetrics riskMetrics;
    private final ComplianceChecks complianceChecks;
    
    // Metadata
    private final ExecutionMetadata metadata;
    
    /**
     * Execution Types - Modern execution methods
     */
    public enum ExecutionType {
        ALGORITHMIC("Algorithmic execution via smart algorithms"),
        SMART_CONTRACT("Blockchain-based smart contract execution"),
        HYBRID("Combination of traditional and modern execution"),
        REAL_TIME("Real-time streaming execution"),
        BATCH("Batch processing execution"),
        CROSS_VENUE("Multi-venue simultaneous execution");
        
        private final String description;
        
        ExecutionType(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * Execution Status - Real-time status tracking
     */
    public enum ExecutionStatus {
        PENDING("Pending execution"),
        IN_PROGRESS("Execution in progress"),
        PARTIALLY_FILLED("Partially filled"),
        FILLED("Fully filled"),
        CANCELLED("Execution cancelled"),
        FAILED("Execution failed"),
        SETTLED("Settlement completed");
        
        private final String description;
        
        ExecutionStatus(String description) {
            this.description = description;
        }
        
        public String getDescription() {
            return description;
        }
    }
    
    /**
     * Execution Venue - Modern trading venues
     */
    public static class ExecutionVenue {
        private final String venueId;
        private final String venueName;
        private final VenueType venueType;
        private final String jurisdiction;
        private final boolean isRegulated;
        
        public enum VenueType {
            DARK_POOL("Dark pool trading"),
            LIT_VENUE("Lit trading venue"),
            BLOCKCHAIN("Blockchain-based venue"),
            HYBRID("Hybrid venue"),
            OTC("Over-the-counter"),
            EXCHANGE("Traditional exchange");
            
            private final String description;
            
            VenueType(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
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
    
    /**
     * Algorithmic Execution Details
     */
    public static class AlgorithmicExecutionDetails {
        private final String algorithmId;
        private final String algorithmName;
        private final AlgorithmType algorithmType;
        private final ExecutionParameters parameters;
        private final PerformanceMetrics performance;
        
        public enum AlgorithmType {
            VWAP("Volume Weighted Average Price"),
            TWAP("Time Weighted Average Price"),
            POV("Percentage of Volume"),
            ICEBERG("Iceberg order algorithm"),
            ADAPTIVE("Adaptive algorithm"),
            MACHINE_LEARNING("ML-based algorithm");
            
            private final String description;
            
            AlgorithmType(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
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
    
    /**
     * Smart Contract Details
     */
    public static class SmartContractDetails {
        private final String contractAddress;
        private final String blockchainNetwork;
        private final String smartContractId;
        private final ContractState contractState;
        private final List<String> transactionHashes;
        
        public enum ContractState {
            DEPLOYED("Smart contract deployed"),
            EXECUTING("Contract execution in progress"),
            COMPLETED("Contract execution completed"),
            FAILED("Contract execution failed"),
            CANCELLED("Contract execution cancelled");
            
            private final String description;
            
            ContractState(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
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
    
    /**
     * Execution Pricing
     */
    public static class ExecutionPricing {
        private final double executionPrice;
        private final String currency;
        private final double quantity;
        private final double totalValue;
        private final PricingModel pricingModel;
        
        public enum PricingModel {
            MARKET("Market price execution"),
            LIMIT("Limit price execution"),
            VWAP("VWAP-based pricing"),
            TWAP("TWAP-based pricing"),
            CUSTOM("Custom pricing model");
            
            private final String description;
            
            PricingModel(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
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
    
    /**
     * Settlement Details
     */
    public static class SettlementDetails {
        private final SettlementType settlementType;
        private final LocalDateTime expectedSettlementDate;
        private final LocalDateTime actualSettlementDate;
        private final String settlementCurrency;
        private final double settlementAmount;
        private final SettlementStatus status;
        
        public enum SettlementType {
            T_PLUS_2("T+2 settlement"),
            T_PLUS_1("T+1 settlement"),
            SAME_DAY("Same day settlement"),
            REAL_TIME("Real-time settlement"),
            BLOCKCHAIN("Blockchain settlement");
            
            private final String description;
            
            SettlementType(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
        }
        
        public enum SettlementStatus {
            PENDING("Settlement pending"),
            IN_PROGRESS("Settlement in progress"),
            COMPLETED("Settlement completed"),
            FAILED("Settlement failed"),
            PARTIAL("Partial settlement");
            
            private final String description;
            
            SettlementStatus(String description) {
                this.description = description;
            }
            
            public String getDescription() {
                return description;
            }
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
    
    /**
     * Risk Metrics
     */
    public static class RiskMetrics {
        private final double var95; // Value at Risk 95%
        private final double var99; // Value at Risk 99%
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
    
    /**
     * Compliance Checks
     */
    public static class ComplianceChecks {
        private final boolean preTradeCompliance;
        private final boolean postTradeCompliance;
        private final boolean regulatoryReporting;
        private final boolean riskLimitCheck;
        private final List<String> complianceViolations;
        
        public ComplianceChecks(boolean preTradeCompliance, boolean postTradeCompliance,
                             boolean regulatoryReporting, boolean riskLimitCheck,
                             List<String> complianceViolations) {
            this.preTradeCompliance = preTradeCompliance;
            this.postTradeCompliance = postTradeCompliance;
            this.regulatoryReporting = regulatoryReporting;
            this.riskLimitCheck = riskLimitCheck;
            this.complianceViolations = complianceViolations;
        }
        
        // Getters
        public boolean isPreTradeCompliance() { return preTradeCompliance; }
        public boolean isPostTradeCompliance() { return postTradeCompliance; }
        public boolean isRegulatoryReporting() { return regulatoryReporting; }
        public boolean isRiskLimitCheck() { return riskLimitCheck; }
        public List<String> getComplianceViolations() { return complianceViolations; }
    }
    
    /**
     * Regulatory Compliance
     */
    public static class RegulatoryCompliance {
        private final String regulatoryFramework;
        private final String reportingJurisdiction;
        private final boolean isReported;
        private final String reportingReference;
        private final LocalDateTime reportingTimestamp;
        
        public RegulatoryCompliance(String regulatoryFramework, String reportingJurisdiction,
                                 boolean isReported, String reportingReference,
                                 LocalDateTime reportingTimestamp) {
            this.regulatoryFramework = regulatoryFramework;
            this.reportingJurisdiction = reportingJurisdiction;
            this.isReported = isReported;
            this.reportingReference = reportingReference;
            this.reportingTimestamp = reportingTimestamp;
        }
        
        // Getters
        public String getRegulatoryFramework() { return regulatoryFramework; }
        public String getReportingJurisdiction() { return reportingJurisdiction; }
        public boolean isReported() { return isReported; }
        public String getReportingReference() { return reportingReference; }
        public LocalDateTime getReportingTimestamp() { return reportingTimestamp; }
    }
    
    /**
     * Execution Parameters
     */
    public static class ExecutionParameters {
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
    
    /**
     * Performance Metrics
     */
    public static class PerformanceMetrics {
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
    
    /**
     * Execution Metadata
     */
    public static class ExecutionMetadata {
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
    
    // Constructor
    public EquitySwapExecutionEvent(String executionId, ExecutionType executionType, ExecutionStatus status,
                                  LocalDateTime executionTimestamp, LocalDateTime settlementTimestamp,
                                  ExecutionVenue primaryVenue, List<ExecutionVenue> secondaryVenues,
                                  RegulatoryCompliance regulatoryCompliance, AlgorithmicExecutionDetails algorithmicDetails,
                                  SmartContractDetails smartContractDetails, ExecutionPricing pricing,
                                  SettlementDetails settlement, RiskMetrics riskMetrics,
                                  ComplianceChecks complianceChecks, ExecutionMetadata metadata) {
        this.executionId = executionId;
        this.executionType = executionType;
        this.status = status;
        this.executionTimestamp = executionTimestamp;
        this.settlementTimestamp = settlementTimestamp;
        this.primaryVenue = primaryVenue;
        this.secondaryVenues = secondaryVenues;
        this.regulatoryCompliance = regulatoryCompliance;
        this.algorithmicDetails = algorithmicDetails;
        this.smartContractDetails = smartContractDetails;
        this.pricing = pricing;
        this.settlement = settlement;
        this.riskMetrics = riskMetrics;
        this.complianceChecks = complianceChecks;
        this.metadata = metadata;
    }
    
    // Getters
    public String getExecutionId() { return executionId; }
    public ExecutionType getExecutionType() { return executionType; }
    public ExecutionStatus getStatus() { return status; }
    public LocalDateTime getExecutionTimestamp() { return executionTimestamp; }
    public LocalDateTime getSettlementTimestamp() { return settlementTimestamp; }
    public ExecutionVenue getPrimaryVenue() { return primaryVenue; }
    public List<ExecutionVenue> getSecondaryVenues() { return secondaryVenues; }
    public RegulatoryCompliance getRegulatoryCompliance() { return regulatoryCompliance; }
    public AlgorithmicExecutionDetails getAlgorithmicDetails() { return algorithmicDetails; }
    public SmartContractDetails getSmartContractDetails() { return smartContractDetails; }
    public ExecutionPricing getPricing() { return pricing; }
    public SettlementDetails getSettlement() { return settlement; }
    public RiskMetrics getRiskMetrics() { return riskMetrics; }
    public ComplianceChecks getComplianceChecks() { return complianceChecks; }
    public ExecutionMetadata getMetadata() { return metadata; }
    
    /**
     * Builder pattern for creating execution events
     */
    public static class Builder {
        private String executionId = UUID.randomUUID().toString();
        private ExecutionType executionType;
        private ExecutionStatus status = ExecutionStatus.PENDING;
        private LocalDateTime executionTimestamp;
        private LocalDateTime settlementTimestamp;
        private ExecutionVenue primaryVenue;
        private List<ExecutionVenue> secondaryVenues;
        private RegulatoryCompliance regulatoryCompliance;
        private AlgorithmicExecutionDetails algorithmicDetails;
        private SmartContractDetails smartContractDetails;
        private ExecutionPricing pricing;
        private SettlementDetails settlement;
        private RiskMetrics riskMetrics;
        private ComplianceChecks complianceChecks;
        private ExecutionMetadata metadata;
        
        public Builder executionId(String executionId) {
            this.executionId = executionId;
            return this;
        }
        
        public Builder executionType(ExecutionType executionType) {
            this.executionType = executionType;
            return this;
        }
        
        public Builder status(ExecutionStatus status) {
            this.status = status;
            return this;
        }
        
        public Builder executionTimestamp(LocalDateTime executionTimestamp) {
            this.executionTimestamp = executionTimestamp;
            return this;
        }
        
        public Builder settlementTimestamp(LocalDateTime settlementTimestamp) {
            this.settlementTimestamp = settlementTimestamp;
            return this;
        }
        
        public Builder primaryVenue(ExecutionVenue primaryVenue) {
            this.primaryVenue = primaryVenue;
            return this;
        }
        
        public Builder secondaryVenues(List<ExecutionVenue> secondaryVenues) {
            this.secondaryVenues = secondaryVenues;
            return this;
        }
        
        public Builder regulatoryCompliance(RegulatoryCompliance regulatoryCompliance) {
            this.regulatoryCompliance = regulatoryCompliance;
            return this;
        }
        
        public Builder algorithmicDetails(AlgorithmicExecutionDetails algorithmicDetails) {
            this.algorithmicDetails = algorithmicDetails;
            return this;
        }
        
        public Builder smartContractDetails(SmartContractDetails smartContractDetails) {
            this.smartContractDetails = smartContractDetails;
            return this;
        }
        
        public Builder pricing(ExecutionPricing pricing) {
            this.pricing = pricing;
            return this;
        }
        
        public Builder settlement(SettlementDetails settlement) {
            this.settlement = settlement;
            return this;
        }
        
        public Builder riskMetrics(RiskMetrics riskMetrics) {
            this.riskMetrics = riskMetrics;
            return this;
        }
        
        public Builder complianceChecks(ComplianceChecks complianceChecks) {
            this.complianceChecks = complianceChecks;
            return this;
        }
        
        public Builder metadata(ExecutionMetadata metadata) {
            this.metadata = metadata;
            return this;
        }
        
        public EquitySwapExecutionEvent build() {
            return new EquitySwapExecutionEvent(executionId, executionType, status, executionTimestamp,
                    settlementTimestamp, primaryVenue, secondaryVenues, regulatoryCompliance,
                    algorithmicDetails, smartContractDetails, pricing, settlement, riskMetrics,
                    complianceChecks, metadata);
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Convert to JSON representation
     */
    public String toJson() {
        return gson.toJson(this);
    }
    
    /**
     * Create from JSON representation
     */
    public static EquitySwapExecutionEvent fromJson(String json) {
        return gson.fromJson(json, EquitySwapExecutionEvent.class);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquitySwapExecutionEvent that = (EquitySwapExecutionEvent) o;
        return Objects.equals(executionId, that.executionId) &&
               executionType == that.executionType &&
               status == that.status &&
               Objects.equals(executionTimestamp, that.executionTimestamp) &&
               Objects.equals(settlementTimestamp, that.settlementTimestamp);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(executionId, executionType, status, executionTimestamp, settlementTimestamp);
    }
    
    @Override
    public String toString() {
        return "EquitySwapExecutionEvent{" +
                "executionId='" + executionId + '\'' +
                ", executionType=" + executionType +
                ", status=" + status +
                ", executionTimestamp=" + executionTimestamp +
                ", primaryVenue=" + primaryVenue +
                '}';
    }
    
    /**
     * Demonstrate usage of the new execution event
     */
    public static void demonstrateUsage() {
        logger.info("Creating a modern equity swap execution event...");
        
        // Create execution event with modern features
        EquitySwapExecutionEvent event = EquitySwapExecutionEvent.builder()
                .executionType(ExecutionType.ALGORITHMIC)
                .status(ExecutionStatus.IN_PROGRESS)
                .executionTimestamp(LocalDateTime.now())
                .primaryVenue(new ExecutionVenue("VENUE001", "Digital Exchange", 
                        ExecutionVenue.VenueType.HYBRID, "US", true))
                .pricing(new ExecutionPricing(150.25, "USD", 1000.0, 150250.0, 
                        ExecutionPricing.PricingModel.VWAP))
                .settlement(new SettlementDetails(SettlementDetails.SettlementType.T_PLUS_2,
                        LocalDateTime.now().plusDays(2), null, "USD", 150250.0,
                        SettlementDetails.SettlementStatus.PENDING))
                .metadata(new ExecutionMetadata("system", LocalDateTime.now(), "system", 
                        LocalDateTime.now(), "1.0.0", "TradingSystem"))
                .build();
        
        logger.info("Execution Event Created: {}", event.toJson());
        logger.info("Event Status: {}", event.getStatus());
        logger.info("Execution Type: {}", event.getExecutionType());
    }
} 