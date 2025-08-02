package com.finos.synthetics.instruction.client;

import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Handler Service Client Fallback
 * 
 * Fallback implementation for handler service client when services are unavailable.
 * 
 * @version 1.0.0
 */
@Component
public class HandlerServiceClientFallback implements HandlerServiceClient {

    private static final Logger logger = LoggerFactory.getLogger(HandlerServiceClientFallback.class);

    @Override
    public ResponseEntity<InstructionResponse> processContractFormation(InstructionRequest request) {
        logger.warn("Contract formation handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Contract Formation Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processExecution(InstructionRequest request) {
        logger.warn("Execution handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Execution Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processExercise(InstructionRequest request) {
        logger.warn("Exercise handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Exercise Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processReset(InstructionRequest request) {
        logger.warn("Reset handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Reset Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processPartyChange(InstructionRequest request) {
        logger.warn("Party change handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Party Change Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processSplit(InstructionRequest request) {
        logger.warn("Split handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Split Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processQuantityChange(InstructionRequest request) {
        logger.warn("Quantity change handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Quantity Change Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processTermsChange(InstructionRequest request) {
        logger.warn("Terms change handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Terms Change Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processTransfer(InstructionRequest request) {
        logger.warn("Transfer handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Transfer Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processIndexTransition(InstructionRequest request) {
        logger.warn("Index transition handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Index Transition Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processStockSplit(InstructionRequest request) {
        logger.warn("Stock split handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Stock Split Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processObservation(InstructionRequest request) {
        logger.warn("Observation handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Observation Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<InstructionResponse> processValuation(InstructionRequest request) {
        logger.warn("Valuation handler service unavailable for instruction: {}", request.getInstructionId());
        return createFallbackResponse(request, "Valuation Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<String> healthCheck() {
        logger.warn("Handler service health check failed - service unavailable");
        return ResponseEntity.status(503).body("Handler Service Unavailable");
    }

    @Override
    public ResponseEntity<String> getServiceInfo() {
        logger.warn("Handler service info request failed - service unavailable");
        return ResponseEntity.status(503).body("Handler Service Unavailable");
    }

    /**
     * Create a fallback response for failed handler service calls
     */
    private ResponseEntity<InstructionResponse> createFallbackResponse(InstructionRequest request, String errorMessage) {
        InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("FALLBACK");
        response.setCorrelationId(request.getCorrelationId());
        
        return ResponseEntity.status(503).body(response);
    }
} 