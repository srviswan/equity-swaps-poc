package com.finos.tradecapture.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Trade Processing Service
 * 
 * Main service orchestrating the trade processing pipeline.
 * Handles raw trade processing, enrichment, and contract generation.
 * 
 * @version 1.0.0
 */
@Service
public class TradeProcessingService {

    private static final Logger logger = LoggerFactory.getLogger(TradeProcessingService.class);

    @Autowired
    private TradeValidationService tradeValidationService;

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

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * Process raw trade from JMS queue (JSON string)
     */
    @ServiceActivator(inputChannel = "rawTradeChannel")
    public EnrichedContract processRawTrade(String jsonMessage) {
        try {
            logger.info("Processing raw trade from JMS queue: {}", jsonMessage);
            
            // Deserialize JSON string to RawTrade object
            RawTrade rawTrade = objectMapper.readValue(jsonMessage, RawTrade.class);
            logger.info("Deserialized trade: {}", rawTrade.getTradeId());
            
            return processRawTrade(rawTrade);
            
        } catch (Exception e) {
            logger.error("Failed to process raw trade from JMS queue", e);
            throw new RuntimeException("Failed to process raw trade from queue", e);
        }
    }

    /**
     * Process raw trade object
     */
    @Transactional
    public EnrichedContract processRawTrade(RawTrade rawTrade) {
        logger.info("Processing raw trade: {}", rawTrade.getTradeId());

        try {
            // Step 1: Validate raw trade
            logger.info("Step 1: Validating raw trade");
            tradeValidationService.validateTrade(rawTrade);

            // Step 2: Enrich with reference data
            logger.info("Step 2: Enriching with reference data");
            EnrichedContract enrichedContract = referenceDataEnrichmentService.enrichWithReferenceData(rawTrade);

            // Step 3: Apply economic rules
            logger.info("Step 3: Applying economic rules");
            enrichedContract = economicRulesEnrichmentService.applyEconomicRules(enrichedContract);

            // Step 4: Apply non-economic rules
            logger.info("Step 4: Applying non-economic rules");
            enrichedContract = nonEconomicRulesEnrichmentService.applyNonEconomicRules(enrichedContract);

            // Step 5: Generate final contract
            logger.info("Step 5: Generating final contract");
            enrichedContract = contractGenerationService.generateContract(enrichedContract);

            // Step 6: Send to instruction service
            logger.info("Step 6: Sending to instruction service");
            instructionServiceClient.sendContract(enrichedContract);

            logger.info("Successfully processed trade: {} -> Contract: {}", 
                       rawTrade.getTradeId(), enrichedContract.getContractId());

            return enrichedContract;

        } catch (Exception e) {
            logger.error("Failed to process trade: {}", rawTrade.getTradeId(), e);
            throw new RuntimeException("Trade processing failed", e);
        }
    }

    /**
     * Manual trade processing (for REST API)
     */
    @Transactional
    public EnrichedContract processTradeManually(RawTrade rawTrade) {
        logger.info("Manual trade processing for: {}", rawTrade.getTradeId());
        return processRawTrade(rawTrade);
    }
} 