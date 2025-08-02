package com.finos.synthetics.handler.controller;

import com.finos.synthetics.handler.model.InstructionRequest;
import com.finos.synthetics.handler.model.InstructionResponse;
import com.finos.synthetics.handler.service.HandlerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Handler Controller
 * 
 * REST controller for handling specialized CDM primitive instruction processing.
 * 
 * @version 1.0.0
 */
@RestController
@RequestMapping("/api/v1/handlers")
@CrossOrigin(origins = "*")
public class HandlerController {

    private static final Logger logger = LoggerFactory.getLogger(HandlerController.class);

    @Autowired
    private HandlerService handlerService;

    /**
     * Process contract formation instruction
     */
    @PostMapping("/contract-formation")
    public ResponseEntity<InstructionResponse> processContractFormation(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received contract formation request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processContractFormation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing contract formation: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Contract formation processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process execution instruction
     */
    @PostMapping("/execution")
    public ResponseEntity<InstructionResponse> processExecution(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received execution request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processExecution(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing execution: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Execution processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process exercise instruction
     */
    @PostMapping("/exercise")
    public ResponseEntity<InstructionResponse> processExercise(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received exercise request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processExercise(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing exercise: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Exercise processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process reset instruction
     */
    @PostMapping("/reset")
    public ResponseEntity<InstructionResponse> processReset(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received reset request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processReset(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing reset: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Reset processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process party change instruction
     */
    @PostMapping("/party-change")
    public ResponseEntity<InstructionResponse> processPartyChange(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received party change request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processPartyChange(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing party change: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Party change processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process split instruction
     */
    @PostMapping("/split")
    public ResponseEntity<InstructionResponse> processSplit(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received split request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processSplit(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing split: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Split processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process quantity change instruction
     */
    @PostMapping("/quantity-change")
    public ResponseEntity<InstructionResponse> processQuantityChange(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received quantity change request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processQuantityChange(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing quantity change: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Quantity change processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process terms change instruction
     */
    @PostMapping("/terms-change")
    public ResponseEntity<InstructionResponse> processTermsChange(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received terms change request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processTermsChange(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing terms change: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Terms change processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process transfer instruction
     */
    @PostMapping("/transfer")
    public ResponseEntity<InstructionResponse> processTransfer(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received transfer request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processTransfer(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing transfer: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Transfer processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process index transition instruction
     */
    @PostMapping("/index-transition")
    public ResponseEntity<InstructionResponse> processIndexTransition(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received index transition request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processIndexTransition(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing index transition: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Index transition processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process stock split instruction
     */
    @PostMapping("/stock-split")
    public ResponseEntity<InstructionResponse> processStockSplit(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received stock split request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processStockSplit(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing stock split: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Stock split processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process observation instruction
     */
    @PostMapping("/observation")
    public ResponseEntity<InstructionResponse> processObservation(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received observation request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processObservation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing observation: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Observation processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Process valuation instruction
     */
    @PostMapping("/valuation")
    public ResponseEntity<InstructionResponse> processValuation(@Valid @RequestBody InstructionRequest request) {
        logger.info("Received valuation request: {}", request.getInstructionId());
        
        try {
            InstructionResponse response = handlerService.processValuation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error processing valuation: {}", request.getInstructionId(), e);
            InstructionResponse errorResponse = new InstructionResponse(request.getInstructionId(), InstructionResponse.Status.FAILED);
            errorResponse.setErrorMessage("Valuation processing error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    /**
     * Health check endpoint
     */
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        logger.info("Health check requested");
        return ResponseEntity.ok("Handler Service Status: HEALTHY");
    }

    /**
     * Get service information
     */
    @GetMapping("/info")
    public ResponseEntity<String> getServiceInfo() {
        logger.info("Service info requested");
        
        String serviceInfo = 
            "Handler Service v1.0.0\n" +
            "Supported Handlers:\n" +
            "- Contract Formation Handler\n" +
            "- Execution Handler\n" +
            "- Exercise Handler\n" +
            "- Reset Handler\n" +
            "- Party Change Handler\n" +
            "- Split Handler\n" +
            "- Quantity Change Handler\n" +
            "- Terms Change Handler\n" +
            "- Transfer Handler\n" +
            "- Index Transition Handler\n" +
            "- Stock Split Handler\n" +
            "- Observation Handler\n" +
            "- Valuation Handler";
        
        return ResponseEntity.ok(serviceInfo);
    }
} 