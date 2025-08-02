package com.finos.synthetics.handler.strategy;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Party Change Handler Strategy
 * 
 * Handles party change-specific business logic for CDM primitive instructions.
 * Implements counterparty changes, novation, and party validation.
 * 
 * @version 1.0.0
 */
public class PartyChangeHandlerStrategy implements HandlerStrategy {
    
    private static final Logger logger = LoggerFactory.getLogger(PartyChangeHandlerStrategy.class);

    @Override
    public InstructionResponse handle(InstructionRequest request) {
        long startTime = System.currentTimeMillis();
        
        if (request == null) {
            logger.error("Received null request in party change handler");
            return createErrorResponse(null, "Request cannot be null", startTime);
        }
        
        logger.info("Processing party change instruction: {} with strategy: {}", 
                   request.getInstructionId(), getStrategyName());
        
        try {
            // Execute business logic specific to party change
            String result = executeBusinessLogic(request);
            
            InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.SUCCESS);
            response.setResult(result);
            response.setHandlerService("PARTY_CHANGE_HANDLER");
            response.setProcessingTime(System.currentTimeMillis() - startTime);
            response.setCorrelationId(request.getCorrelationId());
            
            logger.info("Party change processing completed: {} in {}ms", 
                       request.getInstructionId(), response.getProcessingTime());
            return response;
            
        } catch (Exception e) {
            logger.error("Error processing party change: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Party change processing error: " + e.getMessage(), startTime);
        }
    }
    
    /**
     * Execute party change-specific business logic
     */
    private String executeBusinessLogic(InstructionRequest request) {
        // Simulate party change-specific processing
        // In real implementation, this would include:
        // - New counterparty validation
        // - Credit risk assessment
        // - Legal documentation updates
        // - Regulatory reporting
        // - Position transfers
        // - Notification to all parties
        
        return "Party change processed successfully for instruction: " + request.getInstructionId() +
               " with data: " + request.getInstructionData();
    }
    
    /**
     * Create error response for party change
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage, long startTime) {
        String instructionId = request != null ? request.getInstructionId() : "unknown";
        String correlationId = request != null ? request.getCorrelationId() : null;
        
        InstructionResponse response = new InstructionResponse(instructionId, InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("PARTY_CHANGE_HANDLER");
        response.setProcessingTime(System.currentTimeMillis() - startTime);
        response.setCorrelationId(correlationId);
        return response;
    }
} 