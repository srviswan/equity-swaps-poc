package com.finos.synthetics.instruction.controller;

import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import com.finos.synthetics.instruction.service.InstructionProcessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

/**
 * Instruction Controller
 * 
 * REST controller for handling CDM primitive instruction requests.
 * 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/instructions")
@CrossOrigin(origins = "*")
public class InstructionController {

    private static final Logger logger = LoggerFactory.getLogger(InstructionController.class);

    @Autowired
    private InstructionProcessorService instructionProcessorService;

    /**
     * Process a single instruction
     */
    @PostMapping("/process")
    public ResponseEntity<InstructionResponse> processInstruction(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received instruction processing request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = instructionProcessorService.processInstruction(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing instruction: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process instruction asynchronously
     */
    @PostMapping("/process/async")
    public ResponseEntity<CompletableFuture<InstructionResponse>> processInstructionAsync(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received async instruction processing request: {}", request.getInstructionId());
        
        try {
            CompletableFuture<InstructionResponse> future = instructionProcessorService.processInstructionAsync(request);
            return ResponseEntity.accepted().body(future);
        } catch (Exception e) {
            logger.error("Error processing instruction async: {}", request.getInstructionId(), e);
            CompletableFuture<InstructionResponse> errorFuture = CompletableFuture.completedFuture(
                createErrorResponse(request, "Async processing error: " + e.getMessage())
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorFuture);
        }
    }

    /**
     * Process instruction with timeout
     */
    @PostMapping("/process/timeout")
    public ResponseEntity<InstructionResponse> processInstructionWithTimeout(
            @Valid @RequestBody InstructionRequest request,
            @RequestParam(defaultValue = "30") long timeoutSeconds) {
        
        logger.info("Received instruction processing request with timeout: {} ({}s)", 
            request.getInstructionId(), timeoutSeconds);
        
        try {
            InstructionResponse response = instructionProcessorService.processInstructionWithTimeout(request, timeoutSeconds);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing instruction with timeout: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = createErrorResponse(request, "Timeout processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(errorResponse);
        }
    }

    /**
     * Get service health status
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check requested");
        
        boolean handlerServiceHealthy = instructionProcessorService.isHandlerServiceHealthy();
        String status = handlerServiceHealthy ? "HEALTHY" : "UNHEALTHY";
        
        return ResponseEntity.ok("Instruction Service Status: " + status);
    }

    /**
     * Get service information
     */
    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        logger.info("Service info requested");
        
        String handlerServiceInfo = instructionProcessorService.getHandlerServiceInfo();
        String serviceInfo = String.format(
            "Instruction Service v1.0.0\n" +
            "Handler Service: %s\n" +
            "Supported Instructions: CONTRACT_FORMATION, EXECUTION, EXERCISE, RESET, " +
            "PARTY_CHANGE, SPLIT, QUANTITY_CHANGE, TERMS_CHANGE, TRANSFER, " +
            "INDEX_TRANSITION, STOCK_SPLIT, OBSERVATION, VALUATION",
            handlerServiceInfo
        );
        
        return ResponseEntity.ok(serviceInfo);
    }

    /**
     * Get supported instruction types
     */
    @GetMapping("/types")
    public ResponseEntity<InstructionRequest.InstructionType[]> getSupportedInstructionTypes() {
        logger.info("Supported instruction types requested");
        return ResponseEntity.ok(InstructionRequest.InstructionType.values());
    }

    /**
     * Get instruction priorities
     */
    @GetMapping("/priorities")
    public ResponseEntity<InstructionRequest.Priority[]> getInstructionPriorities() {
        logger.info("Instruction priorities requested");
        return ResponseEntity.ok(InstructionRequest.Priority.values());
    }

    /**
     * Create error response
     */
    private InstructionResponse createErrorResponse(InstructionRequest request, String errorMessage) {
        InstructionResponse response = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
        response.setErrorMessage(errorMessage);
        response.setHandlerService("INSTRUCTION_SERVICE");
        response.setCorrelationId(request.getCorrelationId());
        return response;
    }
} 