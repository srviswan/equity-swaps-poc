package com.finos.synthetics.handler.strategy;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Reset Handler Strategy
 * 
 * Handles reset-specific business logic for CDM primitive instructions.
 * Implements rate resets, index resets, and reset notifications.
 * 
 * @version 1.0.0
 */
public class ResetHandlerStrategy implements HandlerStrategy {
    
    private static final Logger logger = LoggerFactory.getLogger(ResetHandlerStrategy.class);

    @Override
    public InstructionResponse handle(InstructionRequest request) {
        long startTime = System.currentTimeMillis();
        
        if (request == null) {
            logger.error("Received null request in reset handler");
            return createErrorResponse(null, "Request cannot be null", startTime);
        }
        
        logger.info("Processing reset instruction: {} with strategy: {}", 
                   request.getInstructionId(), getStrategyName());
        
        try {
            // Execute business logic specific to reset
            String result = executeBusinessLogic(request);
            
            InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.SUCCESS);
            response.setResult(result);
            response.setHandlerService("RESET_HANDLER");
            response.setProcessingTime(System.currentTimeMillis() - startTime);
            response.setCorrelationId(request.getCorrelationId());
            
            logger.info("Reset processing completed: {} in {}ms", 
                       request.getInstructionId(), response.getProcessingTime());
            return response;
            
        } catch (Exception e) {
            logger.error("Error processing reset: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Reset processing error: " + e.getMessage(), startTime);
        }
    }
    
    /**
     * Execute reset-specific business logic
     */
    private String executeBusinessLogic(InstructionRequest request) {
        // Simulate reset-specific processing
        // In real implementation, this would include:
        // - Reset date validation
        // - Rate/index calculation
        // - Market data integration
        // - Reset notification to counterparty
        // - Cash flow calculation
        // - Position updates
        
        return "Reset processed successfully for instruction: " + request.getInstructionId() +
               " with data: " + request.getInstructionData();
    }
    
    /**
     * Create error response for reset
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage, long startTime) {
        String instructionId = request != null ? request.getInstructionId() : "unknown";
        String correlationId = request != null ? request.getCorrelationId() : null;
        
        InstructionResponse response = new InstructionResponse(instructionId, InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("RESET_HANDLER");
        response.setProcessingTime(System.currentTimeMillis() - startTime);
        response.setCorrelationId(correlationId);
        return response;
    }
} 