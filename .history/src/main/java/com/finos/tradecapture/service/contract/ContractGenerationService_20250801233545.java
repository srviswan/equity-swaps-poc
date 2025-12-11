package com.finos.tradecapture.service.contract;

import com.finos.tradecapture.model.EnrichedContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Contract Generation Service
 * 
 * Generates the final enriched contract ready for the instruction service.
 * 
 * @version 1.0.0
 */
@Service
public class ContractGenerationService {

    private static final Logger logger = LoggerFactory.getLogger(ContractGenerationService.class);

    /**
     * Generate final contract
     */
    public EnrichedContract generateContract(EnrichedContract enrichedContract) {
        logger.info("Generating final contract: {}", enrichedContract.getContractId());

        try {
            // Validate contract completeness
            if (!validateContractCompleteness(enrichedContract)) {
                logger.error("Contract validation failed for contract: {}", enrichedContract.getContractId());
                return null;
            }

            // Apply final business rules
            applyFinalBusinessRules(enrichedContract);

            // Generate contract metadata
            generateContractMetadata(enrichedContract);

            // Set final processing status
            enrichedContract.setValidationStatus(EnrichedContract.ValidationStatus.VALIDATED);
            enrichedContract.setEnrichmentStatus(EnrichedContract.EnrichmentStatus.ENRICHED);
            enrichedContract.setProcessingTimestamp(LocalDateTime.now());

            // Add final checks
            performFinalChecks(enrichedContract);

            logger.info("Successfully generated final contract: {}", enrichedContract.getContractId());
            return enrichedContract;

        } catch (Exception e) {
            logger.error("Error generating final contract: {}", enrichedContract.getContractId(), e);
            return null;
        }
    }

    /**
     * Validate contract completeness
     */
    private boolean validateContractCompleteness(EnrichedContract contract) {
        // Check required fields
        if (contract.getContractId() == null || contract.getContractId().trim().isEmpty()) {
            logger.error("Contract ID is missing");
            return false;
        }

        if (contract.getOriginalTradeId() == null || contract.getOriginalTradeId().trim().isEmpty()) {
            logger.error("Original trade ID is missing");
            return false;
        }

        if (contract.getInstrumentId() == null || contract.getInstrumentId().trim().isEmpty()) {
            logger.error("Instrument ID is missing");
            return false;
        }

        if (contract.getCounterpartyId() == null || contract.getCounterpartyId().trim().isEmpty()) {
            logger.error("Counterparty ID is missing");
            return false;
        }

        if (contract.getBookId() == null || contract.getBookId().trim().isEmpty()) {
            logger.error("Book ID is missing");
            return false;
        }

        if (contract.getTraderId() == null || contract.getTraderId().trim().isEmpty()) {
            logger.error("Trader ID is missing");
            return false;
        }

        if (contract.getSide() == null) {
            logger.error("Trade side is missing");
            return false;
        }

        if (contract.getQuantity() == null || contract.getQuantity().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            logger.error("Quantity is missing or invalid");
            return false;
        }

        if (contract.getPrice() == null || contract.getPrice().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            logger.error("Price is missing or invalid");
            return false;
        }

        if (contract.getCurrency() == null || contract.getCurrency().trim().isEmpty()) {
            logger.error("Currency is missing");
            return false;
        }

        if (contract.getTradeDate() == null || contract.getTradeDate().trim().isEmpty()) {
            logger.error("Trade date is missing");
            return false;
        }

        if (contract.getSettlementDate() == null || contract.getSettlementDate().trim().isEmpty()) {
            logger.error("Settlement date is missing");
            return false;
        }

        if (contract.getNotionalAmount() == null || contract.getNotionalAmount().compareTo(java.math.BigDecimal.ZERO) <= 0) {
            logger.error("Notional amount is missing or invalid");
            return false;
        }

        return true;
    }

    /**
     * Apply final business rules
     */
    private void applyFinalBusinessRules(EnrichedContract contract) {
        try {
            Map<String, Object> finalRules = new HashMap<>();

            // Check if all economic rules were applied
            boolean economicRulesApplied = contract.getEconomicRules() != null && 
                                         !contract.getEconomicRules().isEmpty();
            finalRules.put("economicRulesApplied", economicRulesApplied);

            // Check if all non-economic rules were applied
            boolean nonEconomicRulesApplied = contract.getNonEconomicRules() != null && 
                                            !contract.getNonEconomicRules().isEmpty();
            finalRules.put("nonEconomicRulesApplied", nonEconomicRulesApplied);

            // Check if risk metrics were calculated
            boolean riskMetricsCalculated = contract.getRiskMetrics() != null && 
                                          !contract.getRiskMetrics().isEmpty();
            finalRules.put("riskMetricsCalculated", riskMetricsCalculated);

            // Check if contract is ready for instruction service
            boolean readyForInstructionService = economicRulesApplied && 
                                               nonEconomicRulesApplied && 
                                               riskMetricsCalculated;
            finalRules.put("readyForInstructionService", readyForInstructionService);

            contract.getNonEconomicRules().put("finalRules", finalRules);

            logger.debug("Applied final business rules for contract: {}", contract.getContractId());

        } catch (Exception e) {
            logger.error("Error applying final business rules for contract: {}", contract.getContractId(), e);
        }
    }

    /**
     * Generate contract metadata
     */
    private void generateContractMetadata(EnrichedContract contract) {
        try {
            Map<String, Object> metadata = new HashMap<>();

            // Add processing metadata
            metadata.put("processingVersion", "1.0.0");
            metadata.put("processingTimestamp", System.currentTimeMillis());
            metadata.put("processingService", "TradeCaptureService");

            // Add contract metadata
            metadata.put("contractType", "EQUITY_CASH_TRADE");
            metadata.put("contractVersion", "1.0");
            metadata.put("contractStatus", "READY");

            // Add enrichment metadata
            metadata.put("referenceDataEnriched", true);
            metadata.put("economicRulesApplied", true);
            metadata.put("nonEconomicRulesApplied", true);
            metadata.put("riskMetricsCalculated", true);

            // Add validation metadata
            metadata.put("validationStatus", contract.getValidationStatus().getValue());
            metadata.put("enrichmentStatus", contract.getEnrichmentStatus().getValue());

            contract.getNonEconomicRules().put("metadata", metadata);

            logger.debug("Generated contract metadata for contract: {}", contract.getContractId());

        } catch (Exception e) {
            logger.error("Error generating contract metadata for contract: {}", contract.getContractId(), e);
        }
    }

    /**
     * Perform final checks
     */
    private void performFinalChecks(EnrichedContract contract) {
        try {
            Map<String, Object> finalChecks = new HashMap<>();

            // Check data quality
            boolean dataQualityPassed = performDataQualityChecks(contract);
            finalChecks.put("dataQualityPassed", dataQualityPassed);

            // Check business logic
            boolean businessLogicPassed = performBusinessLogicChecks(contract);
            finalChecks.put("businessLogicPassed", businessLogicPassed);

            // Check compliance
            boolean compliancePassed = performComplianceChecks(contract);
            finalChecks.put("compliancePassed", compliancePassed);

            // Check operational readiness
            boolean operationalReady = performOperationalChecks(contract);
            finalChecks.put("operationalReady", operationalReady);

            // Overall readiness
            boolean contractReady = dataQualityPassed && 
                                  businessLogicPassed && 
                                  compliancePassed && 
                                  operationalReady;
            finalChecks.put("contractReady", contractReady);

            contract.getNonEconomicRules().put("finalChecks", finalChecks);

            logger.debug("Performed final checks for contract: {}", contract.getContractId());

        } catch (Exception e) {
            logger.error("Error performing final checks for contract: {}", contract.getContractId(), e);
        }
    }

    // Final check methods (placeholder implementations)

    private boolean performDataQualityChecks(EnrichedContract contract) {
        // In production, this would perform comprehensive data quality checks
        return true;
    }

    private boolean performBusinessLogicChecks(EnrichedContract contract) {
        // In production, this would perform business logic validation
        return true;
    }

    private boolean performComplianceChecks(EnrichedContract contract) {
        // In production, this would perform compliance validation
        return true;
    }

    private boolean performOperationalChecks(EnrichedContract contract) {
        // In production, this would perform operational readiness checks
        return true;
    }
} 