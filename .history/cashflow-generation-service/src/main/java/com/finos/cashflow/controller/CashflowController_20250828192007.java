package com.finos.cashflow.controller;

import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowGenerationRequest;
import com.finos.cashflow.model.CashflowGenerationResponse;
import com.finos.cashflow.service.CashflowGenerationService;
import com.finos.cashflow.service.ThreadPartitioningService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for cashflow generation operations.
 * 
 * This controller provides reactive endpoints for generating cashflows
 * with thread partitioning and high-performance processing.
 */
@RestController
@RequestMapping("/cashflow-management/v1")
@CrossOrigin(origins = "*")
public class CashflowController {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowController.class);
    
    private final CashflowGenerationService cashflowGenerationService;
    private final ThreadPartitioningService threadPartitioningService;
    
    public CashflowController(CashflowGenerationService cashflowGenerationService,
                            ThreadPartitioningService threadPartitioningService) {
        this.cashflowGenerationService = cashflowGenerationService;
        this.threadPartitioningService = threadPartitioningService;
    }
    
    /**
     * Generate cashflows for specified contracts.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    @PostMapping("/cashflows/generate")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateCashflows(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response))
            .doOnSuccess(response -> logger.info("Cashflow generation request accepted: {}", 
                                               response.getBody().getJobId()));
    }
    
    /**
     * Generate cashflows reactively with streaming response.
     * 
     * @param request The cashflow generation request
     * @return Stream of generated cashflows
     */
    @PostMapping(value = "/cashflows/generate/reactive", 
                produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Cashflow> generateCashflowsReactive(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received reactive cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsReactive(request)
            .doOnNext(cashflow -> logger.debug("Streaming cashflow: {}", cashflow.getId()));
    }
    
    /**
     * Generate cashflows with Server-Sent Events.
     * 
     * @param request The cashflow generation request
     * @return Server-Sent Events stream
     */
    @PostMapping(value = "/cashflows/generate/stream", 
                produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> generateCashflowsStream(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received SSE cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsReactive(request)
            .map(cashflow -> String.format("data: %s\n\n", cashflow.getId()))
            .doOnNext(event -> logger.debug("SSE event: {}", event));
    }
    
    /**
     * Generate interest cashflows for specified contracts.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    @PostMapping("/cashflows/generate/interest")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateInterestCashflows(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received interest cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        // Ensure only interest types are requested
        if (!request.isInterestRequest()) {
            return Mono.just(ResponseEntity.badRequest()
                .body(new CashflowGenerationResponse(null, 0, "Only interest cashflow types allowed")));
        }
        
        return cashflowGenerationService.generateCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate dividend cashflows for specified contracts.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    @PostMapping("/cashflows/generate/dividend")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateDividendCashflows(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received dividend cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        // Ensure only dividend types are requested
        if (!request.isEquityRequest()) {
            return Mono.just(ResponseEntity.badRequest()
                .body(new CashflowGenerationResponse(null, 0, "Only dividend cashflow types allowed")));
        }
        
        return cashflowGenerationService.generateCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate performance cashflows for specified contracts.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    @PostMapping("/cashflows/generate/performance")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generatePerformanceCashflows(
            @Valid @RequestBody CashflowGenerationRequest request) {
        
        logger.info("Received performance cashflow generation request for {} contracts", 
                   request.getContractIds().size());
        
        // Ensure only performance types are requested
        if (!request.isEquityRequest()) {
            return Mono.just(ResponseEntity.badRequest()
                .body(new CashflowGenerationResponse(null, 0, "Only performance cashflow types allowed")));
        }
        
        return cashflowGenerationService.generateCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate daily accruals for specified contracts and date range.
     * 
     * @param contractIds List of contract IDs
     * @param startDate Start date for accruals
     * @param endDate End date for accruals
     * @return Stream of daily accrual cashflows
     */
    @PostMapping(value = "/cashflows/accruals/daily", 
                produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Cashflow> generateDailyAccruals(
            @RequestParam List<UUID> contractIds,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        
        logger.info("Received daily accrual request for {} contracts from {} to {}", 
                   contractIds.size(), startDate, endDate);
        
        return cashflowGenerationService.generateDailyAccruals(contractIds, startDate, endDate);
    }
    
    /**
     * Get thread partition status.
     * 
     * @return Map of partition statistics
     */
    @GetMapping("/threads/partitions")
    public ResponseEntity<java.util.Map<String, Object>> getThreadPartitionStatus() {
        logger.debug("Retrieved thread partition status");
        
        java.util.Map<String, Object> stats = threadPartitioningService.getPartitionStatistics();
        return ResponseEntity.ok(stats);
    }
    
    /**
     * Health check endpoint.
     * 
     * @return Health status
     */
    @GetMapping("/health")
    public ResponseEntity<java.util.Map<String, Object>> health() {
        java.util.Map<String, Object> health = new java.util.HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", java.time.LocalDateTime.now());
        health.put("service", "Cash Flow Generation Service");
        health.put("version", "1.0.0");
        
        return ResponseEntity.ok(health);
    }
    
    /**
     * Detailed health check endpoint.
     * 
     * @return Detailed health status
     */
    @GetMapping("/health/detailed")
    public ResponseEntity<java.util.Map<String, Object>> detailedHealth() {
        java.util.Map<String, Object> health = new java.util.HashMap<>();
        health.put("status", "UP");
        health.put("timestamp", java.time.LocalDateTime.now());
        health.put("service", "Cash Flow Generation Service");
        health.put("version", "1.0.0");
        
        // Add partition statistics
        java.util.Map<String, Object> components = new java.util.HashMap<>();
        components.put("threadPartitioning", "UP");
        components.put("cashflowGeneration", "UP");
        
        health.put("components", components);
        
        return ResponseEntity.ok(health);
    }
}
