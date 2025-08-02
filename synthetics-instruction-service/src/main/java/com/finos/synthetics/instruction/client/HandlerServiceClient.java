package com.finos.synthetics.instruction.client;

import com.finos.synthetics.instruction.model.InstructionRequest;
import com.finos.synthetics.instruction.model.InstructionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Handler Service Client
 * 
 * Feign client interface for communicating with specialized handler microservices.
 * 
 * @version 1.0.0
 */
@FeignClient(name = "handler-service", fallback = HandlerServiceClientFallback.class)
public interface HandlerServiceClient {

    /**
     * Process contract formation instruction
     */
    @PostMapping("/api/v1/handlers/contract-formation")
    ResponseEntity<InstructionResponse> processContractFormation(@RequestBody InstructionRequest request);

    /**
     * Process execution instruction
     */
    @PostMapping("/api/v1/handlers/execution")
    ResponseEntity<InstructionResponse> processExecution(@RequestBody InstructionRequest request);

    /**
     * Process exercise instruction
     */
    @PostMapping("/api/v1/handlers/exercise")
    ResponseEntity<InstructionResponse> processExercise(@RequestBody InstructionRequest request);

    /**
     * Process reset instruction
     */
    @PostMapping("/api/v1/handlers/reset")
    ResponseEntity<InstructionResponse> processReset(@RequestBody InstructionRequest request);

    /**
     * Process party change instruction
     */
    @PostMapping("/api/v1/handlers/party-change")
    ResponseEntity<InstructionResponse> processPartyChange(@RequestBody InstructionRequest request);

    /**
     * Process split instruction
     */
    @PostMapping("/api/v1/handlers/split")
    ResponseEntity<InstructionResponse> processSplit(@RequestBody InstructionRequest request);

    /**
     * Process quantity change instruction
     */
    @PostMapping("/api/v1/handlers/quantity-change")
    ResponseEntity<InstructionResponse> processQuantityChange(@RequestBody InstructionRequest request);

    /**
     * Process terms change instruction
     */
    @PostMapping("/api/v1/handlers/terms-change")
    ResponseEntity<InstructionResponse> processTermsChange(@RequestBody InstructionRequest request);

    /**
     * Process transfer instruction
     */
    @PostMapping("/api/v1/handlers/transfer")
    ResponseEntity<InstructionResponse> processTransfer(@RequestBody InstructionRequest request);

    /**
     * Process index transition instruction
     */
    @PostMapping("/api/v1/handlers/index-transition")
    ResponseEntity<InstructionResponse> processIndexTransition(@RequestBody InstructionRequest request);

    /**
     * Process stock split instruction
     */
    @PostMapping("/api/v1/handlers/stock-split")
    ResponseEntity<InstructionResponse> processStockSplit(@RequestBody InstructionRequest request);

    /**
     * Process observation instruction
     */
    @PostMapping("/api/v1/handlers/observation")
    ResponseEntity<InstructionResponse> processObservation(@RequestBody InstructionRequest request);

    /**
     * Process valuation instruction
     */
    @PostMapping("/api/v1/handlers/valuation")
    ResponseEntity<InstructionResponse> processValuation(@RequestBody InstructionRequest request);

    /**
     * Health check endpoint
     */
    @GetMapping("/api/v1/handlers/health")
    ResponseEntity<String> healthCheck();

    /**
     * Get handler service info
     */
    @GetMapping("/api/v1/handlers/info")
    ResponseEntity<String> getServiceInfo();
} 