package com.finos.tradecapture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

/**
 * Enriched Contract Model
 * 
 * Represents a fully developed contract after processing and enriching a raw trade.
 * This is the final contract that will be sent to the instruction service.
 * 
 * @version 1.0.0
 */
public class EnrichedContract {

    @NotBlank(message = "Contract ID is required")
    @JsonProperty("contractId")
    private String contractId;

    @NotBlank(message = "Original trade ID is required")
    @JsonProperty("originalTradeId")
    private String originalTradeId;

    @NotBlank(message = "Instrument ID is required")
    @JsonProperty("instrumentId")
    private String instrumentId;

    @NotBlank(message = "Instrument name is required")
    @JsonProperty("instrumentName")
    private String instrumentName;

    @NotBlank(message = "Instrument type is required")
    @JsonProperty("instrumentType")
    private String instrumentType;

    @NotBlank(message = "Counterparty ID is required")
    @JsonProperty("counterpartyId")
    private String counterpartyId;

    @NotBlank(message = "Counterparty name is required")
    @JsonProperty("counterpartyName")
    private String counterpartyName;

    @NotBlank(message = "Book ID is required")
    @JsonProperty("bookId")
    private String bookId;

    @NotBlank(message = "Book name is required")
    @JsonProperty("bookName")
    private String bookName;

    @NotBlank(message = "Trader ID is required")
    @JsonProperty("traderId")
    private String traderId;

    @NotBlank(message = "Trader name is required")
    @JsonProperty("traderName")
    private String traderName;

    @NotNull(message = "Trade side is required")
    @JsonProperty("side")
    private RawTrade.TradeSide side;

    @NotNull(message = "Quantity is required")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0")
    @JsonProperty("quantity")
    private BigDecimal quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull(message = "Notional amount is required")
    @DecimalMin(value = "0.01", message = "Notional amount must be greater than 0")
    @JsonProperty("notionalAmount")
    private BigDecimal notionalAmount;

    @NotBlank(message = "Currency is required")
    @JsonProperty("currency")
    private String currency;

    @NotBlank(message = "Trade date is required")
    @JsonProperty("tradeDate")
    private String tradeDate;

    @NotBlank(message = "Settlement date is required")
    @JsonProperty("settlementDate")
    private String settlementDate;

    @JsonProperty("strategyId")
    private String strategyId;

    @JsonProperty("strategyName")
    private String strategyName;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("executionVenue")
    private String executionVenue;

    @JsonProperty("commission")
    private BigDecimal commission;

    @JsonProperty("fees")
    private BigDecimal fees;

    @JsonProperty("totalCost")
    private BigDecimal totalCost;

    @JsonProperty("marketValue")
    private BigDecimal marketValue;

    @JsonProperty("profitLoss")
    private BigDecimal profitLoss;

    @JsonProperty("riskMetrics")
    private Map<String, Object> riskMetrics = new HashMap<>();

    @JsonProperty("economicRules")
    private Map<String, Object> economicRules = new HashMap<>();

    @JsonProperty("nonEconomicRules")
    private Map<String, Object> nonEconomicRules = new HashMap<>();

    @JsonProperty("validationStatus")
    private ValidationStatus validationStatus;

    @JsonProperty("enrichmentStatus")
    private EnrichmentStatus enrichmentStatus;

    @JsonProperty("processingTimestamp")
    private LocalDateTime processingTimestamp;

    @JsonProperty("sourceSystem")
    private String sourceSystem;

    @JsonProperty("correlationId")
    private String correlationId;

    // Default constructor
    public EnrichedContract() {
        this.processingTimestamp = LocalDateTime.now();
        this.validationStatus = ValidationStatus.PENDING;
        this.enrichmentStatus = EnrichmentStatus.PENDING;
    }

    // Getters and Setters
    public String getContractId() { return contractId; }
    public void setContractId(String contractId) { this.contractId = contractId; }

    public String getOriginalTradeId() { return originalTradeId; }
    public void setOriginalTradeId(String originalTradeId) { this.originalTradeId = originalTradeId; }

    public String getInstrumentId() { return instrumentId; }
    public void setInstrumentId(String instrumentId) { this.instrumentId = instrumentId; }

    public String getInstrumentName() { return instrumentName; }
    public void setInstrumentName(String instrumentName) { this.instrumentName = instrumentName; }

    public String getInstrumentType() { return instrumentType; }
    public void setInstrumentType(String instrumentType) { this.instrumentType = instrumentType; }

    public String getCounterpartyId() { return counterpartyId; }
    public void setCounterpartyId(String counterpartyId) { this.counterpartyId = counterpartyId; }

    public String getCounterpartyName() { return counterpartyName; }
    public void setCounterpartyName(String counterpartyName) { this.counterpartyName = counterpartyName; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getTraderId() { return traderId; }
    public void setTraderId(String traderId) { this.traderId = traderId; }

    public String getTraderName() { return traderName; }
    public void setTraderName(String traderName) { this.traderName = traderName; }

    public RawTrade.TradeSide getSide() { return side; }
    public void setSide(RawTrade.TradeSide side) { this.side = side; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public BigDecimal getNotionalAmount() { return notionalAmount; }
    public void setNotionalAmount(BigDecimal notionalAmount) { this.notionalAmount = notionalAmount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getTradeDate() { return tradeDate; }
    public void setTradeDate(String tradeDate) { this.tradeDate = tradeDate; }

    public String getSettlementDate() { return settlementDate; }
    public void setSettlementDate(String settlementDate) { this.settlementDate = settlementDate; }

    public String getStrategyId() { return strategyId; }
    public void setStrategyId(String strategyId) { this.strategyId = strategyId; }

    public String getStrategyName() { return strategyName; }
    public void setStrategyName(String strategyName) { this.strategyName = strategyName; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getExecutionVenue() { return executionVenue; }
    public void setExecutionVenue(String executionVenue) { this.executionVenue = executionVenue; }

    public BigDecimal getCommission() { return commission; }
    public void setCommission(BigDecimal commission) { this.commission = commission; }

    public BigDecimal getFees() { return fees; }
    public void setFees(BigDecimal fees) { this.fees = fees; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }

    public BigDecimal getMarketValue() { return marketValue; }
    public void setMarketValue(BigDecimal marketValue) { this.marketValue = marketValue; }

    public BigDecimal getProfitLoss() { return profitLoss; }
    public void setProfitLoss(BigDecimal profitLoss) { this.profitLoss = profitLoss; }

    public Map<String, Object> getRiskMetrics() { return riskMetrics; }
    public void setRiskMetrics(Map<String, Object> riskMetrics) { this.riskMetrics = riskMetrics; }

    public Map<String, Object> getEconomicRules() { return economicRules; }
    public void setEconomicRules(Map<String, Object> economicRules) { this.economicRules = economicRules; }

    public Map<String, Object> getNonEconomicRules() { return nonEconomicRules; }
    public void setNonEconomicRules(Map<String, Object> nonEconomicRules) { this.nonEconomicRules = nonEconomicRules; }

    public ValidationStatus getValidationStatus() { return validationStatus; }
    public void setValidationStatus(ValidationStatus validationStatus) { this.validationStatus = validationStatus; }

    public EnrichmentStatus getEnrichmentStatus() { return enrichmentStatus; }
    public void setEnrichmentStatus(EnrichmentStatus enrichmentStatus) { this.enrichmentStatus = enrichmentStatus; }

    public LocalDateTime getProcessingTimestamp() { return processingTimestamp; }
    public void setProcessingTimestamp(LocalDateTime processingTimestamp) { this.processingTimestamp = processingTimestamp; }

    public String getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(String sourceSystem) { this.sourceSystem = sourceSystem; }

    public String getCorrelationId() { return correlationId; }
    public void setCorrelationId(String correlationId) { this.correlationId = correlationId; }

    @Override
    public String toString() {
        return "EnrichedContract{" +
                "contractId='" + contractId + '\'' +
                ", originalTradeId='" + originalTradeId + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", instrumentName='" + instrumentName + '\'' +
                ", instrumentType='" + instrumentType + '\'' +
                ", counterpartyId='" + counterpartyId + '\'' +
                ", counterpartyName='" + counterpartyName + '\'' +
                ", bookId='" + bookId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", traderId='" + traderId + '\'' +
                ", traderName='" + traderName + '\'' +
                ", side=" + side +
                ", quantity=" + quantity +
                ", price=" + price +
                ", notionalAmount=" + notionalAmount +
                ", currency='" + currency + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", settlementDate='" + settlementDate + '\'' +
                ", strategyId='" + strategyId + '\'' +
                ", strategyName='" + strategyName + '\'' +
                ", orderId='" + orderId + '\'' +
                ", executionVenue='" + executionVenue + '\'' +
                ", commission=" + commission +
                ", fees=" + fees +
                ", totalCost=" + totalCost +
                ", marketValue=" + marketValue +
                ", profitLoss=" + profitLoss +
                ", riskMetrics=" + riskMetrics +
                ", economicRules=" + economicRules +
                ", nonEconomicRules=" + nonEconomicRules +
                ", validationStatus=" + validationStatus +
                ", enrichmentStatus=" + enrichmentStatus +
                ", processingTimestamp=" + processingTimestamp +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    /**
     * Validation Status Enumeration
     */
    public enum ValidationStatus {
        PENDING("PENDING"),
        VALIDATED("VALIDATED"),
        REJECTED("REJECTED"),
        ERROR("ERROR");

        private final String value;

        ValidationStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Enrichment Status Enumeration
     */
    public enum EnrichmentStatus {
        PENDING("PENDING"),
        ENRICHED("ENRICHED"),
        PARTIAL("PARTIAL"),
        FAILED("FAILED");

        private final String value;

        EnrichmentStatus(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
} 