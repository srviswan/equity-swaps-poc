package com.finos.synthetics.instruction.service;

import com.finos.synthetics.instruction.client.HandlerServiceClient;
import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Instruction Processor Service
 * 
 * Main service that processes CDM primitive instructions and delegates
 * to specialized handler microservices.
 * 
 * @version 1.0.0
 */
@Service
public class InstructionProcessorService {

    private static final Logger logger = LoggerFactory.getLogger(InstructionProcessorService.class);

    @Autowired
    private HandlerServiceClient handlerServiceClient;

    @Autowired
    private InstructionValidationService validationService;

    /**
     * Process an instruction request and delegate to appropriate handler
     */
    public InstructionResponse processInstruction(InstructionRequest request) {
        long startTime = System.currentTimeMillis();
        
        try {
            logger.info("Processing instruction: {} of type: {}", 
                request.getInstructionId(), request.getInstructionType());

            // Validate the instruction request
            InstructionResponse validationResponse = validationService.validateRequest(request);
            if (validationResponse.getStatus() != InstructionResponse.Status.SUCCESS) {
                logger.error("Instruction validation failed: {}", validationResponse.getErrorMessage());
                return validationResponse;
            }

            // Delegate to appropriate handler based on instruction type
            ResponseEntity<InstructionResponse> handlerResponse = delegateToHandler(request);
            
            // Process the response
            InstructionResponse response = handlerResponse.getBody();
            if (response != null) {
                response.setProcessingTime(System.currentTimeMillis() - startTime);
                response.setCorrelationId(request.getCorrelationId());
            }

            logger.info("Instruction processing completed: {} with status: {}", 
                request.getInstructionId(), response != null ? response.getStatus() : "NULL");

            return response;

        } catch (Exception e) {
            logger.error("Error processing instruction: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Processing error: " + e.getMessage(), startTime);
        }
    }

    /**
     * Process instruction asynchronously
     */
    public CompletableFuture<InstructionResponse> processInstructionAsync(InstructionRequest request) {
        return CompletableFuture.supplyAsync(() -> processInstruction(request));
    }

    /**
     * Process instruction with timeout
     */
    public InstructionResponse processInstructionWithTimeout(InstructionRequest request, long timeoutSeconds) {
        try {
            return processInstructionAsync(request)
                .get(timeoutSeconds, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("Instruction processing timeout or error: {}", request.getInstructionId(), e);
            return createErrorResponse(request, "Processing timeout or error: " + e.getMessage(), 0);
        }
    }

    /**
     * Delegate instruction to appropriate handler service
     */
    private ResponseEntity<InstructionResponse> delegateToHandler(InstructionRequest request) {
        switch (request.getInstructionType()) {
            case CONTRACT_FORMATION:
                return handlerServiceClient.processContractFormation(request);
                
            case EXECUTION:
                return handlerServiceClient.processExecution(request);
                
            case EXERCISE:
                return handlerServiceClient.processExercise(request);
                
            case RESET:
                return handlerServiceClient.processReset(request);
                
            case PARTY_CHANGE:
                return handlerServiceClient.processPartyChange(request);
                
            case SPLIT:
                return handlerServiceClient.processSplit(request);
                
            case QUANTITY_CHANGE:
                return handlerServiceClient.processQuantityChange(request);
                
            case TERMS_CHANGE:
                return handlerServiceClient.processTermsChange(request);
                
            case TRANSFER:
                return handlerServiceClient.processTransfer(request);
                
            case INDEX_TRANSITION:
                return handlerServiceClient.processIndexTransition(request);
                
            case STOCK_SPLIT:
                return handlerServiceClient.processStockSplit(request);
                
            case OBSERVATION:
                return handlerServiceClient.processObservation(request);
                
            case VALUATION:
                return handlerServiceClient.processValuation(request);
                
            default:
                logger.error("Unknown instruction type: {}", request.getInstructionType());
                return ResponseEntity.status(400).body(
                    createErrorResponse(request, "Unknown instruction type: " + request.getInstructionType(), 0)
                );
        }
    }

    /**
     * Create error response
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage, long startTime) {
        InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("INSTRUCTION_SERVICE");
        response.setCorrelationId(request.getCorrelationId());
        response.setProcessingTime(System.currentTimeMillis() - startTime);
        return response;
    }

    /**
     * Get handler service health status
     */
    public boolean isHandlerServiceHealthy() {
        try {
            ResponseEntity<String> healthResponse = handlerServiceClient.healthCheck();
            return healthResponse.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            logger.warn("Handler service health check failed", e);
            return false;
        }
    }

    /**
     * Get handler service information
     */
    public String getHandlerServiceInfo() {
        try {
            ResponseEntity<String> infoResponse = handlerServiceClient.getServiceInfo();
            return infoResponse.getBody();
        } catch (Exception e) {
            logger.warn("Handler service info request failed", e);
            return "Handler service unavailable";
        }
    }
} 