package com.finos.synthetics.handler.strategy;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;

/**
 * Handler Strategy Interface
 * 
 * Defines the contract for all handler strategies.
 * Each strategy implements specific business logic for a particular instruction type.
 * 
 * @version 1.0.0
 */
public interface HandlerStrategy {
    
    /**
     * Handle the instruction request
     * 
     * @param request the instruction request to process
     * @return the processed response
     */
    InstructionResponse handle(InstructionRequest request);
    
    /**
     * Get the strategy name for logging/monitoring
     * 
     * @return strategy name
     */
    default String getStrategyName() {
        return this.getClass().getSimpleName();
    }
} 