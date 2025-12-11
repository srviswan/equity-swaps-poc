package com.finos.synthetics.handler.service;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.strategy.HandlerStrategy;
import com.finos.synthetics.handler.strategy.ExecutionHandlerStrategy;
import com.finos.synthetics.handler.strategy.ContractFormationHandlerStrategy;
import com.finos.synthetics.handler.strategy.ExerciseHandlerStrategy;
import com.finos.synthetics.handler.strategy.ResetHandlerStrategy;
import com.finos.synthetics.handler.strategy.PartyChangeHandlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Handler Service
 * 
 * Delegates business logic to specialized strategy handlers using Strategy Pattern.
 * Each instruction type has its own dedicated handler strategy.
 * 
 * @version 1.0.0
 */
@Service
public class HandlerService {

    private static final Logger logger = LoggerFactory.getLogger(HandlerService.class);
    
    private final Map<InstructionRequest.InstructionType, HandlerStrategy> strategies;

    public HandlerService() {
        this.strategies = new HashMap<>();
        initializeStrategies();
    }

    /**
     * Initialize all handler strategies
     */
    private void initializeStrategies() {
        strategies.put(InstructionRequest.InstructionType.EXECUTION, new ExecutionHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.CONTRACT_FORMATION, new ContractFormationHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.EXERCISE, new ExerciseHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.RESET, new ResetHandlerStrategy());
        strategies.put(InstructionRequest.InstructionType.PARTY_CHANGE, new PartyChangeHandlerStrategy());
    }

    /**
     * Process instruction using appropriate strategy
     * 
     * @param request the instruction request
     * @return processed response
     */
    public InstructionResponse processInstruction(InstructionRequest request) {
        logger.info("Processing instruction: {} with type: {}", request.getInstructionId(), request.getInstructionType());
        
        try {
            HandlerStrategy strategy = strategies.get(request.getInstructionType());
            
            if (strategy == null) {
                logger.error("No handler strategy found for instruction type: {}", request.getInstructionType());
                return createErrorResponse(request, "Unsupported instruction type: " + request.getInstructionType());
            }
            
            return strategy.handle(request);
            
        } catch (Exception e) {
            logger.error("Error processing instruction: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Processing failed: " + e.getMessage());
        }
    }

    /**
     * Create error response
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage) {
        return InstructionResponse.builder()
                .instructionId(request.getInstructionId())
                .status(InstructionResponse.Status.FAILED)
                .message(errorMessage)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /**
     * Get available strategies for monitoring/debugging
     */
    public Map<InstructionRequest.InstructionType, String> getAvailableStrategies() {
        Map<InstructionRequest.InstructionType, String> available = new HashMap<>();
        strategies.forEach((type, strategy) -> 
            available.put(type, strategy.getClass().getSimpleName()));
        return available;
    }
} 
} 