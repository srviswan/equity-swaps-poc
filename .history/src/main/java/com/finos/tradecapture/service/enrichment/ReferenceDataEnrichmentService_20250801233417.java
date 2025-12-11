package com.finos.tradecapture.service.enrichment;

import com.finos.tradecapture.model.RawTrade;
import com.finos.tradecapture.model.EnrichedContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Reference Data Enrichment Service
 * 
 * Enriches raw trades with reference data including book, product/instrument,
 * and counterparty information.
 * 
 * @version 1.0.0
 */
@Service
public class ReferenceDataEnrichmentService {

    private static final Logger logger = LoggerFactory.getLogger(ReferenceDataEnrichmentService.class);

    /**
     * Enrich raw trade with reference data
     */
    public EnrichedContract enrichWithReferenceData(RawTrade rawTrade) {
        logger.info("Enriching trade with reference data: {}", rawTrade.getTradeId());

        try {
            EnrichedContract enrichedContract = new EnrichedContract();

            // Set basic contract information
            enrichedContract.setContractId(generateContractId(rawTrade.getTradeId()));
            enrichedContract.setOriginalTradeId(rawTrade.getTradeId());
            enrichedContract.setCorrelationId(rawTrade.getMessageId());

            // Enrich instrument data
            enrichInstrumentData(enrichedContract, rawTrade);

            // Enrich counterparty data
            enrichCounterpartyData(enrichedContract, rawTrade);

            // Enrich book data
            enrichBookData(enrichedContract, rawTrade);

            // Enrich trader data
            enrichTraderData(enrichedContract, rawTrade);

            // Set trade details
            enrichedContract.setSide(rawTrade.getSide());
            enrichedContract.setQuantity(rawTrade.getQuantity());
            enrichedContract.setPrice(rawTrade.getPrice());
            enrichedContract.setCurrency(rawTrade.getCurrency());
            enrichedContract.setTradeDate(rawTrade.getTradeDate());
            enrichedContract.setSettlementDate(rawTrade.getSettlementDate());

            // Calculate notional amount
            enrichedContract.setNotionalAmount(calculateNotionalAmount(rawTrade));

            // Set additional fields
            enrichedContract.setStrategyId(rawTrade.getStrategyId());
            enrichedContract.setOrderId(rawTrade.getOrderId());
            enrichedContract.setExecutionVenue(rawTrade.getExecutionVenue());
            enrichedContract.setCommission(rawTrade.getCommission());
            enrichedContract.setFees(rawTrade.getFees());
            enrichedContract.setSourceSystem(rawTrade.getSourceSystem());

            // Set processing status
            enrichedContract.setValidationStatus(EnrichedContract.ValidationStatus.VALIDATED);
            enrichedContract.setEnrichmentStatus(EnrichedContract.EnrichmentStatus.ENRICHED);
            enrichedContract.setProcessingTimestamp(LocalDateTime.now());

            logger.info("Successfully enriched trade with reference data: {}", rawTrade.getTradeId());
            return enrichedContract;

        } catch (Exception e) {
            logger.error("Error enriching trade with reference data: {}", rawTrade.getTradeId(), e);
            return null;
        }
    }

    /**
     * Enrich instrument data
     */
    private void enrichInstrumentData(EnrichedContract contract, RawTrade rawTrade) {
        try {
            // In production, this would call a reference data service
            Map<String, Object> instrumentData = getInstrumentReferenceData(rawTrade.getInstrumentId());

            contract.setInstrumentId(rawTrade.getInstrumentId());
            contract.setInstrumentName((String) instrumentData.get("name"));
            contract.setInstrumentType((String) instrumentData.get("type"));

            logger.debug("Enriched instrument data for trade: {}", rawTrade.getTradeId());

        } catch (Exception e) {
            logger.error("Error enriching instrument data for trade: {}", rawTrade.getTradeId(), e);
            // Set default values
            contract.setInstrumentName("Unknown Instrument");
            contract.setInstrumentType("EQUITY");
        }
    }

    /**
     * Enrich counterparty data
     */
    private void enrichCounterpartyData(EnrichedContract contract, RawTrade rawTrade) {
        try {
            // In production, this would call a reference data service
            Map<String, Object> counterpartyData = getCounterpartyReferenceData(rawTrade.getCounterpartyId());

            contract.setCounterpartyId(rawTrade.getCounterpartyId());
            contract.setCounterpartyName((String) counterpartyData.get("name"));

            logger.debug("Enriched counterparty data for trade: {}", rawTrade.getTradeId());

        } catch (Exception e) {
            logger.error("Error enriching counterparty data for trade: {}", rawTrade.getTradeId(), e);
            // Set default values
            contract.setCounterpartyName("Unknown Counterparty");
        }
    }

    /**
     * Enrich book data
     */
    private void enrichBookData(EnrichedContract contract, RawTrade rawTrade) {
        try {
            String bookId = rawTrade.getBookId() != null ? rawTrade.getBookId() : "DEFAULT_BOOK";
            
            // In production, this would call a reference data service
            Map<String, Object> bookData = getBookReferenceData(bookId);

            contract.setBookId(bookId);
            contract.setBookName((String) bookData.get("name"));

            logger.debug("Enriched book data for trade: {}", rawTrade.getTradeId());

        } catch (Exception e) {
            logger.error("Error enriching book data for trade: {}", rawTrade.getTradeId(), e);
            // Set default values
            contract.setBookId("DEFAULT_BOOK");
            contract.setBookName("Default Book");
        }
    }

    /**
     * Enrich trader data
     */
    private void enrichTraderData(EnrichedContract contract, RawTrade rawTrade) {
        try {
            // In production, this would call a reference data service
            Map<String, Object> traderData = getTraderReferenceData(rawTrade.getTraderId());

            contract.setTraderId(rawTrade.getTraderId());
            contract.setTraderName((String) traderData.get("name"));

            logger.debug("Enriched trader data for trade: {}", rawTrade.getTradeId());

        } catch (Exception e) {
            logger.error("Error enriching trader data for trade: {}", rawTrade.getTradeId(), e);
            // Set default values
            contract.setTraderName("Unknown Trader");
        }
    }

    /**
     * Calculate notional amount
     */
    private BigDecimal calculateNotionalAmount(RawTrade rawTrade) {
        if (rawTrade.getQuantity() != null && rawTrade.getPrice() != null) {
            return rawTrade.getQuantity().multiply(rawTrade.getPrice());
        }
        return BigDecimal.ZERO;
    }

    /**
     * Generate contract ID
     */
    private String generateContractId(String tradeId) {
        return "CONTRACT_" + tradeId + "_" + UUID.randomUUID().toString().substring(0, 8);
    }

    /**
     * Get instrument reference data (cached)
     */
    @Cacheable("instrumentReferenceData")
    public Map<String, Object> getInstrumentReferenceData(String instrumentId) {
        // In production, this would call a reference data service
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Sample Instrument " + instrumentId);
        data.put("type", "EQUITY");
        data.put("isin", "US" + instrumentId + "123");
        data.put("currency", "USD");
        return data;
    }

    /**
     * Get counterparty reference data (cached)
     */
    @Cacheable("counterpartyReferenceData")
    public Map<String, Object> getCounterpartyReferenceData(String counterpartyId) {
        // In production, this would call a reference data service
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Sample Counterparty " + counterpartyId);
        data.put("type", "BANK");
        data.put("country", "US");
        return data;
    }

    /**
     * Get book reference data (cached)
     */
    @Cacheable("bookReferenceData")
    public Map<String, Object> getBookReferenceData(String bookId) {
        // In production, this would call a reference data service
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Sample Book " + bookId);
        data.put("type", "TRADING");
        data.put("desk", "EQUITY_DESK");
        return data;
    }

    /**
     * Get trader reference data (cached)
     */
    @Cacheable("traderReferenceData")
    public Map<String, Object> getTraderReferenceData(String traderId) {
        // In production, this would call a reference data service
        Map<String, Object> data = new HashMap<>();
        data.put("name", "Sample Trader " + traderId);
        data.put("desk", "EQUITY_DESK");
        data.put("location", "NYC");
        return data;
    }
} 