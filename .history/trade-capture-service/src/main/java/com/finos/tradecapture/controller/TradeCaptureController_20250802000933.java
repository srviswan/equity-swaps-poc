package com.finos.tradecapture.controller;

import com.finos.tradecapture.model.RawTrade;
import com.finos.tradecapture.model.EnrichedContract;
import com.finos.tradecapture.service.TradeProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import com.finos.tradecapture.jms.JmsMessageSender;

/**
 * Trade Capture Controller
 * 
 * REST endpoints for manual testing and monitoring of the trade capture service.
 * 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/trade-capture")
@CrossOrigin(origins = "*")
public class TradeCaptureController {

    private static final Logger logger = LoggerFactory.getLogger(TradeCaptureController.class);

    @Autowired
    private TradeProcessingService tradeProcessingService;

    @Autowired
    private JmsMessageSender jmsMessageSender;

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "HEALTHY");
        health.put("service", "Trade Capture Service");
        health.put("version", "1.0.0");
        health.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(health);
    }

    /**
     * Process trade manually
     */
    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processTrade(@Valid @RequestBody RawTrade rawTrade) {
        logger.info("Manual trade processing requested for trade: {}", rawTrade.getTradeId());

        try {
            EnrichedContract enrichedContract = tradeProcessingService.processTradeManually(rawTrade);

            Map<String, Object> response = new HashMap<>();
            if (enrichedContract != null) {
                response.put("status", "SUCCESS");
                response.put("message", "Trade processed successfully");
                response.put("contractId", enrichedContract.getContractId());
                response.put("originalTradeId", enrichedContract.getOriginalTradeId());
                response.put("validationStatus", enrichedContract.getValidationStatus());
                response.put("enrichmentStatus", enrichedContract.getEnrichmentStatus());
                response.put("processingTimestamp", enrichedContract.getProcessingTimestamp());
                
                logger.info("Successfully processed trade manually: {} -> Contract: {}", 
                           rawTrade.getTradeId(), enrichedContract.getContractId());
                
                return ResponseEntity.ok(response);
            } else {
                response.put("status", "FAILED");
                response.put("message", "Trade processing failed");
                response.put("originalTradeId", rawTrade.getTradeId());
                
                logger.error("Failed to process trade manually: {}", rawTrade.getTradeId());
                
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            logger.error("Error processing trade manually: {}", rawTrade.getTradeId(), e);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "ERROR");
            response.put("message", "Internal server error");
            response.put("originalTradeId", rawTrade.getTradeId());
            response.put("error", e.getMessage());
            
            return ResponseEntity.internalServerError().body(response);
        }
    }

    /**
     * Send a test message to the JMS queue
     */
    @PostMapping("/send-to-queue")
    public ResponseEntity<Map<String, Object>> sendToQueue(@Valid @RequestBody RawTrade rawTrade) {
        try {
            logger.info("Sending trade {} to JMS queue", rawTrade.getTradeId());
            
            // Send to JMS queue
            jmsMessageSender.sendRawTrade(rawTrade);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "SUCCESS");
            response.put("message", "Trade sent to queue successfully");
            response.put("tradeId", rawTrade.getTradeId());
            response.put("queueName", "raw-trades-queue");
            response.put("timestamp", LocalDateTime.now());
            
            logger.info("Successfully sent trade {} to JMS queue", rawTrade.getTradeId());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Failed to send trade {} to JMS queue", rawTrade.getTradeId(), e);
            
            Map<String, Object> response = new HashMap<>();
            response.put("status", "ERROR");
            response.put("message", "Failed to send trade to queue: " + e.getMessage());
            response.put("tradeId", rawTrade.getTradeId());
            response.put("timestamp", LocalDateTime.now());
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Get service information
     */
    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        return ResponseEntity.ok("Trade Capture Service v1.0.0 - Raw Trade Processing and Enrichment");
    }

    /**
     * Get processing statistics
     */
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getProcessingStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("service", "Trade Capture Service");
        stats.put("version", "1.0.0");
        stats.put("status", "RUNNING");
        stats.put("uptime", System.currentTimeMillis());
        stats.put("processedTrades", 0); // In production, this would be from metrics
        stats.put("failedTrades", 0);
        stats.put("averageProcessingTime", 0);
        stats.put("lastProcessedTrade", null);
        
        return ResponseEntity.ok(stats);
    }

    /**
     * Test endpoint for creating sample raw trade
     */
    @GetMapping("/sample-trade")
    public ResponseEntity<RawTrade> getSampleTrade() {
        RawTrade sampleTrade = new RawTrade();
        sampleTrade.setTradeId("SAMPLE_TRADE_001");
        sampleTrade.setInstrumentId("AAPL");
        sampleTrade.setCounterpartyId("BANK_A");
        sampleTrade.setTraderId("TRADER_001");
        sampleTrade.setSide(RawTrade.TradeSide.BUY);
        sampleTrade.setQuantity(new java.math.BigDecimal("100"));
        sampleTrade.setPrice(new java.math.BigDecimal("150.50"));
        sampleTrade.setCurrency("USD");
        sampleTrade.setTradeDate("2024-01-15");
        sampleTrade.setSettlementDate("2024-01-17");
        sampleTrade.setBookId("EQUITY_BOOK");
        sampleTrade.setStrategyId("STRATEGY_001");
        sampleTrade.setOrderId("ORDER_001");
        sampleTrade.setExecutionVenue("NYSE");
        sampleTrade.setCommission(new java.math.BigDecimal("5.00"));
        sampleTrade.setFees(new java.math.BigDecimal("2.50"));
        sampleTrade.setSourceSystem("TRADING_SYSTEM");
        sampleTrade.setMessageId("MSG_001");
        
        return ResponseEntity.ok(sampleTrade);
    }
} 