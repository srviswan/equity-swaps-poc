package com.finos.synthetics.handler.controller;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.service.HandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * Handler Controller
 * 
 * REST endpoints for CDM instruction processing with comprehensive fault tolerance.
 * 
 * @version 2.0.0
 */
@RestController
@RequestMapping("/api/v1/handler")
@CrossOrigin(origins = "*")
public class HandlerController {

    private static final Logger logger = LoggerFactory.getLogger(HandlerController.class);
    
    private final HandlerService handlerService;

    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    /**
     * Process instruction with comprehensive fault tolerance
     */
    @PostMapping("/process")
    public ResponseEntity<InstructionResponse> processInstruction(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received instruction processing request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processInstruction(request);
            
            logger.info("Instruction processing completed: {} with status: {}", 
                       request.getInstructionId(), response.getStatus());
            
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error processing instruction: {}", request.getInstructionId(), e);
            
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Processing failed: " + e.getMessage());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Get comprehensive health status and fault tolerance metrics
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> getHealthStatus() {
        try {
            Map<String, Object> health = handlerService.getHealthStatus();
            return ResponseEntity.ok(health);
        } catch (Exception e) {
            logger.error("Error getting health status", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Get available strategies
     */
    @GetMapping("/strategies")
    public ResponseEntity<Map<InstructionRequest.InstructionType, String>> getAvailableStrategies() {
        try {
            Map<InstructionRequest.InstructionType, String> strategies = handlerService.getAvailableStrategies();
            return ResponseEntity.ok(strategies);
        } catch (Exception e) {
            logger.error("Error getting available strategies", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    /**
     * Legacy endpoints for backward compatibility
     */
    @PostMapping("/execution")
    public ResponseEntity<InstructionResponse> processExecution(@Valid @RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/contract-formation")
    public ResponseEntity<InstructionResponse> processContractFormation(@Valid @RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/exercise")
    public ResponseEntity<InstructionResponse> processExercise(@Valid @RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/reset")
    public ResponseEntity<InstructionResponse> processReset(@Valid @RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/party-change")
    public ResponseEntity<InstructionResponse> processPartyChange(@Valid @RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    /**
     * Simple health check endpoint
     */
    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Handler Service is running");
    }

    /**
     * Service information endpoint
     */
    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        return ResponseEntity.ok("Handler Service v2.0.0 - Fault-Tolerant CDM Instruction Processing");
    }
} 