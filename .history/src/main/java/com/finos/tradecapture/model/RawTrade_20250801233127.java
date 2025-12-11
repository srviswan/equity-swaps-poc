package com.finos.tradecapture.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Raw Trade Model
 * 
 * Represents a raw equity cash trade received from upstream systems via Solace queue.
 * This is the initial trade data before enrichment and validation.
 * 
 * @version 1.0.0
 */
public class RawTrade {

    @NotBlank(message = "Trade ID is required")
    @JsonProperty("tradeId")
    private String tradeId;

    @NotBlank(message = "Instrument ID is required")
    @JsonProperty("instrumentId")
    private String instrumentId;

    @NotBlank(message = "Counterparty ID is required")
    @JsonProperty("counterpartyId")
    private String counterpartyId;

    @NotBlank(message = "Trader ID is required")
    @JsonProperty("traderId")
    private String traderId;

    @NotNull(message = "Trade side is required")
    @JsonProperty("side")
    private TradeSide side;

    @NotNull(message = "Quantity is required")
    @DecimalMin(value = "0.01", message = "Quantity must be greater than 0")
    @JsonProperty("quantity")
    private BigDecimal quantity;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @JsonProperty("price")
    private BigDecimal price;

    @NotBlank(message = "Currency is required")
    @JsonProperty("currency")
    private String currency;

    @NotBlank(message = "Trade date is required")
    @JsonProperty("tradeDate")
    private String tradeDate;

    @NotBlank(message = "Settlement date is required")
    @JsonProperty("settlementDate")
    private String settlementDate;

    @JsonProperty("bookId")
    private String bookId;

    @JsonProperty("strategyId")
    private String strategyId;

    @JsonProperty("orderId")
    private String orderId;

    @JsonProperty("executionVenue")
    private String executionVenue;

    @JsonProperty("commission")
    private BigDecimal commission;

    @JsonProperty("fees")
    private BigDecimal fees;

    @JsonProperty("sourceSystem")
    private String sourceSystem;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    // Default constructor
    public RawTrade() {
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getTradeId() { return tradeId; }
    public void setTradeId(String tradeId) { this.tradeId = tradeId; }

    public String getInstrumentId() { return instrumentId; }
    public void setInstrumentId(String instrumentId) { this.instrumentId = instrumentId; }

    public String getCounterpartyId() { return counterpartyId; }
    public void setCounterpartyId(String counterpartyId) { this.counterpartyId = counterpartyId; }

    public String getTraderId() { return traderId; }
    public void setTraderId(String traderId) { this.traderId = traderId; }

    public TradeSide getSide() { return side; }
    public void setSide(TradeSide side) { this.side = side; }

    public BigDecimal getQuantity() { return quantity; }
    public void setQuantity(BigDecimal quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getTradeDate() { return tradeDate; }
    public void setTradeDate(String tradeDate) { this.tradeDate = tradeDate; }

    public String getSettlementDate() { return settlementDate; }
    public void setSettlementDate(String settlementDate) { this.settlementDate = settlementDate; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getStrategyId() { return strategyId; }
    public void setStrategyId(String strategyId) { this.strategyId = strategyId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getExecutionVenue() { return executionVenue; }
    public void setExecutionVenue(String executionVenue) { this.executionVenue = executionVenue; }

    public BigDecimal getCommission() { return commission; }
    public void setCommission(BigDecimal commission) { this.commission = commission; }

    public BigDecimal getFees() { return fees; }
    public void setFees(BigDecimal fees) { this.fees = fees; }

    public String getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(String sourceSystem) { this.sourceSystem = sourceSystem; }

    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    @Override
    public String toString() {
        return "RawTrade{" +
                "tradeId='" + tradeId + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", counterpartyId='" + counterpartyId + '\'' +
                ", traderId='" + traderId + '\'' +
                ", side=" + side +
                ", quantity=" + quantity +
                ", price=" + price +
                ", currency='" + currency + '\'' +
                ", tradeDate='" + tradeDate + '\'' +
                ", settlementDate='" + settlementDate + '\'' +
                ", bookId='" + bookId + '\'' +
                ", strategyId='" + strategyId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", executionVenue='" + executionVenue + '\'' +
                ", commission=" + commission +
                ", fees=" + fees +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", messageId='" + messageId + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    /**
     * Trade Side Enumeration
     */
    public enum TradeSide {
        BUY("BUY"),
        SELL("SELL");

        private final String value;

        TradeSide(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
} 