package com.finos.synthetics.handler.controller;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.service.HandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Handler Controller
 * 
 * REST API endpoints for processing CDM primitive instructions.
 * Delegates to HandlerService which uses Strategy pattern for different instruction types.
 * 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/handler")
@CrossOrigin(origins = "*")
public class HandlerController {

    private static final Logger logger = LoggerFactory.getLogger(HandlerController.class);
    
    private final HandlerService handlerService;

    @Autowired
    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    /**
     * Process instruction using appropriate strategy
     * 
     * @param request the instruction request
     * @return processed response
     */
    @PostMapping("/process")
    public ResponseEntity<InstructionResponse> processInstruction(@RequestBody InstructionRequest request) {
        logger.info("Received instruction processing request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processInstruction(request);
            logger.info("Instruction processing completed: {} with status: {}", 
                       request.getInstructionId(), response.getStatus());
            return ResponseEntity.ok(response);
            
        } catch (Exception e) {
            logger.error("Error processing instruction: {}", request.getInstructionId(), e);
            return ResponseEntity.internalServerError()
                    .body(InstructionResponse.builder()
                            .instructionId(request.getInstructionId())
                            .status(InstructionResponse.Status.FAILED)
                            .message("Processing failed: " + e.getMessage())
                            .build());
        }
    }

    /**
     * Get health status
     */
    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return ResponseEntity.ok("Handler Service is running");
    }

    /**
     * Get service information
     */
    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        return ResponseEntity.ok("Handler Service v1.0.0 - CDM Instruction Processing");
    }

    /**
     * Get available strategies
     */
    @GetMapping("/strategies")
    public ResponseEntity<Map<InstructionRequest.InstructionType, String>> getAvailableStrategies() {
        Map<InstructionRequest.InstructionType, String> strategies = handlerService.getAvailableStrategies();
        return ResponseEntity.ok(strategies);
    }

    /**
     * Legacy endpoints for backward compatibility
     */
    
    @PostMapping("/execution")
    public ResponseEntity<InstructionResponse> processExecution(@RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/contract-formation")
    public ResponseEntity<InstructionResponse> processContractFormation(@RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/exercise")
    public ResponseEntity<InstructionResponse> processExercise(@RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/reset")
    public ResponseEntity<InstructionResponse> processReset(@RequestBody InstructionRequest request) {
        return processInstruction(request);
    }

    @PostMapping("/party-change")
    public ResponseEntity<InstructionResponse> processPartyChange(@RequestBody InstructionRequest request) {
        return processInstruction(request);
    }
} 