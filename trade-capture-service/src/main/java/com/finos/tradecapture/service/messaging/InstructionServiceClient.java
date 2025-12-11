package com.finos.tradecapture.service.messaging;

import com.finos.tradecapture.model.EnrichedContract;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Instruction Service Client
 * 
 * HTTP client for sending enriched contracts to the instruction service.
 * 
 * @version 1.0.0
 */
@Service
public class InstructionServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(InstructionServiceClient.class);

    @Value("${instruction.service.url}")
    private String instructionServiceUrl;

    @Value("${instruction.service.timeout:30000}")
    private int timeout;

    private final RestTemplate restTemplate;

    public InstructionServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Send contract to instruction service
     */
    public boolean sendContract(EnrichedContract contract) {
        logger.info("Sending contract to instruction service: {}", contract.getContractId());

        try {
            // Prepare headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("X-Correlation-ID", contract.getCorrelationId());
            headers.set("X-Contract-ID", contract.getContractId());
            headers.set("X-Source-System", "TRADE_CAPTURE_SERVICE");

            // Prepare request body
            HttpEntity<EnrichedContract> request = new HttpEntity<>(contract, headers);

            // Send request
            String url = instructionServiceUrl + "/api/v1/instruction/process";
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                logger.info("Successfully sent contract to instruction service: {} - Status: {}", 
                           contract.getContractId(), response.getStatusCode());
                return true;
            } else {
                logger.error("Failed to send contract to instruction service: {} - Status: {}", 
                            contract.getContractId(), response.getStatusCode());
                return false;
            }

        } catch (Exception e) {
            logger.error("Error sending contract to instruction service: {}", contract.getContractId(), e);
            return false;
        }
    }

    /**
     * Send contract with retry logic
     */
    public boolean sendContractWithRetry(EnrichedContract contract, int maxRetries) {
        logger.info("Sending contract to instruction service with retry: {} - Max retries: {}", 
                   contract.getContractId(), maxRetries);

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                boolean success = sendContract(contract);
                if (success) {
                    logger.info("Successfully sent contract on attempt {}: {}", attempt, contract.getContractId());
                    return true;
                } else {
                    logger.warn("Failed to send contract on attempt {}: {}", attempt, contract.getContractId());
                    if (attempt < maxRetries) {
                        // Wait before retry (exponential backoff)
                        long waitTime = (long) Math.pow(2, attempt - 1) * 1000;
                        Thread.sleep(waitTime);
                    }
                }
            } catch (Exception e) {
                logger.error("Error sending contract on attempt {}: {}", attempt, contract.getContractId(), e);
                if (attempt < maxRetries) {
                    try {
                        // Wait before retry
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }

        logger.error("Failed to send contract after {} attempts: {}", maxRetries, contract.getContractId());
        return false;
    }

    /**
     * Check instruction service health
     */
    public boolean checkHealth() {
        try {
            String healthUrl = instructionServiceUrl + "/api/v1/instruction/health";
            ResponseEntity<String> response = restTemplate.getForEntity(healthUrl, String.class);
            
            boolean healthy = response.getStatusCode().is2xxSuccessful();
            logger.info("Instruction service health check: {}", healthy ? "HEALTHY" : "UNHEALTHY");
            return healthy;

        } catch (Exception e) {
            logger.error("Error checking instruction service health", e);
            return false;
        }
    }
} 