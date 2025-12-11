package com.finos.synthetics.handler.strategy;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * Exercise Handler Strategy
 * 
 * Handles exercise-specific business logic for CDM primitive instructions.
 * Implements option exercise, early termination, and exercise notification.
 * 
 * @version 1.0.0
 */
public class ExerciseHandlerStrategy implements HandlerStrategy {
    
    private static final Logger logger = LoggerFactory.getLogger(ExerciseHandlerStrategy.class);

    @Override
    public InstructionResponse handle(InstructionRequest request) {
        long startTime = System.currentTimeMillis();
        
        if (request == null) {
            logger.error("Received null request in exercise handler");
            return createErrorResponse(null, "Request cannot be null", startTime);
        }
        
        logger.info("Processing exercise instruction: {} with strategy: {}", 
                   request.getInstructionId(), getStrategyName());
        
        try {
            // Execute business logic specific to exercise
            String result = executeBusinessLogic(request);
            
            InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.SUCCESS);
            response.setResult(result);
            response.setHandlerService("EXERCISE_HANDLER");
            response.setProcessingTime(System.currentTimeMillis() - startTime);
            response.setCorrelationId(request.getCorrelationId());
            
            logger.info("Exercise processing completed: {} in {}ms", 
                       request.getInstructionId(), response.getProcessingTime());
            return response;
            
        } catch (Exception e) {
            logger.error("Error processing exercise: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Exercise processing error: " + e.getMessage(), startTime);
        }
    }
    
    /**
     * Execute exercise-specific business logic
     */
    private String executeBusinessLogic(InstructionRequest request) {
        // Simulate exercise-specific processing
        // In real implementation, this would include:
        // - Exercise date validation
        // - Option payoff calculation
        // - Early termination processing
        // - Exercise notification to counterparty
        // - Settlement instruction generation
        // - Risk position updates
        
        return "Exercise processed successfully for instruction: " + request.getInstructionId() +
               " with data: " + request.getInstructionData();
    }
    
    /**
     * Create error response for exercise
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage, long startTime) {
        String instructionId = request != null ? request.getInstructionId() : "unknown";
        String correlationId = request != null ? request.getCorrelationId() : null;
        
        InstructionResponse response = new InstructionResponse(instructionId, InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("EXERCISE_HANDLER");
        response.setProcessingTime(System.currentTimeMillis() - startTime);
        response.setCorrelationId(correlationId);
        return response;
    }
} 