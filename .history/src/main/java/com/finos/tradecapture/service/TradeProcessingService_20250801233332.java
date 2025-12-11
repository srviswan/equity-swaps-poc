package com.finos.tradecapture.service;

import com.finos.tradecapture.model.RawTrade;
import com.finos.tradecapture.model.EnrichedContract;
import com.finos.tradecapture.service.validation.TradeValidationService;
import com.finos.tradecapture.service.enrichment.ReferenceDataEnrichmentService;
import com.finos.tradecapture.service.enrichment.EconomicRulesEnrichmentService;
import com.finos.tradecapture.service.enrichment.NonEconomicRulesEnrichmentService;
import com.finos.tradecapture.service.contract.ContractGenerationService;
import com.finos.tradecapture.service.messaging.InstructionServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Trade Processing Service
 * 
 * Main service for processing raw trades from Solace queue and transforming them
 * into enriched contracts for the instruction service.
 * 
 * @version 1.0.0
 */
@Service
public class TradeProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(TradeProcessingService.class);

    @Autowired
    private TradeValidationService validationService;

    @Autowired
    private ReferenceDataEnrichmentService referenceDataEnrichmentService;

    @Autowired
    private EconomicRulesEnrichmentService economicRulesEnrichmentService;

    @Autowired
    private NonEconomicRulesEnrichmentService nonEconomicRulesEnrichmentService;

    @Autowired
    private ContractGenerationService contractGenerationService;

    @Autowired
    private InstructionServiceClient instructionServiceClient;

    /**
     * Process raw trade message from Solace queue
     */
    @ServiceActivator(inputChannel = "rawTradeChannel")
    @Transactional
    public void processRawTrade(Message<RawTrade> message) {
        RawTrade rawTrade = message.getPayload();
        String correlationId = message.getHeaders().get("correlationId", String.class);
        
        logger.info("Processing raw trade: {} with correlation ID: {}", rawTrade.getTradeId(), correlationId);
        
        try {
            // Step 1: Validate the raw trade
            if (!validationService.validateTrade(rawTrade)) {
                logger.error("Trade validation failed for trade ID: {}", rawTrade.getTradeId());
                handleValidationFailure(rawTrade, correlationId);
                return;
            }

            // Step 2: Enrich with reference data
            EnrichedContract enrichedContract = referenceDataEnrichmentService.enrichWithReferenceData(rawTrade);
            if (enrichedContract == null) {
                logger.error("Reference data enrichment failed for trade ID: {}", rawTrade.getTradeId());
                handleEnrichmentFailure(rawTrade, correlationId, "Reference data enrichment failed");
                return;
            }

            // Step 3: Apply economic rules
            enrichedContract = economicRulesEnrichmentService.applyEconomicRules(enrichedContract);
            if (enrichedContract == null) {
                logger.error("Economic rules application failed for trade ID: {}", rawTrade.getTradeId());
                handleEnrichmentFailure(rawTrade, correlationId, "Economic rules application failed");
                return;
            }

            // Step 4: Apply non-economic rules
            enrichedContract = nonEconomicRulesEnrichmentService.applyNonEconomicRules(enrichedContract);
            if (enrichedContract == null) {
                logger.error("Non-economic rules application failed for trade ID: {}", rawTrade.getTradeId());
                handleEnrichmentFailure(rawTrade, correlationId, "Non-economic rules application failed");
                return;
            }

            // Step 5: Generate final contract
            EnrichedContract finalContract = contractGenerationService.generateContract(enrichedContract);
            if (finalContract == null) {
                logger.error("Contract generation failed for trade ID: {}", rawTrade.getTradeId());
                handleEnrichmentFailure(rawTrade, correlationId, "Contract generation failed");
                return;
            }

            // Step 6: Send to instruction service
            sendToInstructionService(finalContract, correlationId);

            logger.info("Successfully processed trade: {} -> Contract: {}", 
                       rawTrade.getTradeId(), finalContract.getContractId());

        } catch (Exception e) {
            logger.error("Error processing trade: {}", rawTrade.getTradeId(), e);
            handleProcessingError(rawTrade, correlationId, e);
        }
    }

    /**
     * Handle validation failure
     */
    private void handleValidationFailure(RawTrade rawTrade, String correlationId) {
        // Log validation errors
        logger.warn("Trade validation failed for trade ID: {}", rawTrade.getTradeId());
        
        // Could send to error queue or dead letter queue
        // For now, just log the failure
    }

    /**
     * Handle enrichment failure
     */
    private void handleEnrichmentFailure(RawTrade rawTrade, String correlationId, String reason) {
        logger.warn("Enrichment failed for trade ID: {} - Reason: {}", rawTrade.getTradeId(), reason);
        
        // Could send to error queue or retry queue
        // For now, just log the failure
    }

    /**
     * Handle processing error
     */
    private void handleProcessingError(RawTrade rawTrade, String correlationId, Exception e) {
        logger.error("Processing error for trade ID: {} - Error: {}", rawTrade.getTradeId(), e.getMessage());
        
        // Could send to error queue or dead letter queue
        // For now, just log the error
    }

    /**
     * Send enriched contract to instruction service
     */
    private void sendToInstructionService(EnrichedContract contract, String correlationId) {
        try {
            logger.info("Sending contract to instruction service: {}", contract.getContractId());
            
            // Call instruction service via HTTP client
            boolean success = instructionServiceClient.sendContract(contract);
            
            if (success) {
                logger.info("Successfully sent contract to instruction service: {}", contract.getContractId());
            } else {
                logger.error("Failed to send contract to instruction service: {}", contract.getContractId());
                // Could implement retry logic here
            }
            
        } catch (Exception e) {
            logger.error("Error sending contract to instruction service: {}", contract.getContractId(), e);
            // Could implement retry logic or send to error queue
        }
    }

    /**
     * Process trade with manual trigger (for testing)
     */
    @Transactional
    public EnrichedContract processTradeManually(RawTrade rawTrade) {
        logger.info("Manually processing trade: {}", rawTrade.getTradeId());
        
        try {
            // Step 1: Validate
            if (!validationService.validateTrade(rawTrade)) {
                logger.error("Trade validation failed for trade ID: {}", rawTrade.getTradeId());
                return null;
            }

            // Step 2: Enrich with reference data
            EnrichedContract enrichedContract = referenceDataEnrichmentService.enrichWithReferenceData(rawTrade);
            if (enrichedContract == null) {
                logger.error("Reference data enrichment failed for trade ID: {}", rawTrade.getTradeId());
                return null;
            }

            // Step 3: Apply economic rules
            enrichedContract = economicRulesEnrichmentService.applyEconomicRules(enrichedContract);
            if (enrichedContract == null) {
                logger.error("Economic rules application failed for trade ID: {}", rawTrade.getTradeId());
                return null;
            }

            // Step 4: Apply non-economic rules
            enrichedContract = nonEconomicRulesEnrichmentService.applyNonEconomicRules(enrichedContract);
            if (enrichedContract == null) {
                logger.error("Non-economic rules application failed for trade ID: {}", rawTrade.getTradeId());
                return null;
            }

            // Step 5: Generate final contract
            EnrichedContract finalContract = contractGenerationService.generateContract(enrichedContract);
            if (finalContract == null) {
                logger.error("Contract generation failed for trade ID: {}", rawTrade.getTradeId());
                return null;
            }

            logger.info("Successfully processed trade manually: {} -> Contract: {}", 
                       rawTrade.getTradeId(), finalContract.getContractId());

            return finalContract;

        } catch (Exception e) {
            logger.error("Error manually processing trade: {}", rawTrade.getTradeId(), e);
            return null;
        }
    }
} 