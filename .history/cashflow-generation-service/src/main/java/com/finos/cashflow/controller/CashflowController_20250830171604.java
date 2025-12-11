package com.finos.cashflow.controller;

import com.finos.cashflow.actor.CashflowGenerationActorState;
import com.finos.cashflow.model.*;
import com.finos.cashflow.service.CashflowGenerationService;
import com.finos.cashflow.service.CashflowQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * This controller provides endpoints for both thread partitioning and Actor pattern approaches.
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CashflowController {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowController.class);
    
    private final CashflowGenerationService cashflowGenerationService;
    private final CashflowQueryService cashflowQueryService;
    
    @Autowired
    public CashflowController(CashflowGenerationService cashflowGenerationService,
                             CashflowQueryService cashflowQueryService) {
        this.cashflowGenerationService = cashflowGenerationService;
        this.cashflowQueryService = cashflowQueryService;
    }
    
    // ===== Thread Partitioning Endpoints =====
    
    /**
     * Generate cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateCashflows(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate interest cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/interest")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateInterestCashflows(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received interest cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateInterestCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate dividend cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/dividend")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateDividendCashflows(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received dividend cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateDividendCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate performance cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/performance")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generatePerformanceCashflows(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received performance cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generatePerformanceCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    // ===== Actor Pattern Endpoints =====
    
    /**
     * Generate cashflows using the Actor pattern.
     */
    @PostMapping("/cashflows/generate/actor")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateCashflowsWithActors(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received Actor-based cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsWithActors(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate cashflows reactively using the Actor pattern.
     */
    @PostMapping("/cashflows/generate/reactive")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateCashflowsReactive(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received reactive Actor-based cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsReactive(request)
            .collectList()
            .map(cashflows -> new CashflowGenerationResponse(
                UUID.randomUUID(),
                cashflows.size(),
                "Reactive cashflow generation completed using Actor pattern"
            ))
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate cashflows with streaming response using the Actor pattern.
     */
    @PostMapping(value = "/cashflows/generate/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Cashflow> generateCashflowsStream(@RequestBody CashflowGenerationRequest request) {
        logger.info("Received streaming Actor-based cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsReactive(request);
    }
    
    /**
     * Generate daily accruals using the Actor pattern.
     */
    @PostMapping("/cashflows/generate/accruals")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateDailyAccruals(
            @RequestParam List<UUID> contractIds,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        logger.info("Received daily accrual generation request for {} contracts from {} to {}", 
                   contractIds.size(), startDate, endDate);
        
        return cashflowGenerationService.generateDailyAccruals(contractIds, startDate, endDate)
            .collectList()
            .map(accruals -> new CashflowGenerationResponse(
                UUID.randomUUID(),
                accruals.size(),
                "Daily accrual generation completed using Actor pattern"
            ))
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    // ===== Actor System Management Endpoints =====
    
    /**
     * Get actor system status.
     */
    @GetMapping("/actors/status")
    public Mono<ResponseEntity<String>> getActorSystemStatus() {
        boolean isRunning = cashflowGenerationService.isActorSystemRunning();
        String status = isRunning ? "RUNNING" : "STOPPED";
        
        return Mono.just(ResponseEntity.ok("Actor system status: " + status));
    }
    
    /**
     * Get actor count.
     */
    @GetMapping("/actors/count")
    public Mono<ResponseEntity<Integer>> getActorCount() {
        int count = cashflowGenerationService.getActorCount();
        return Mono.just(ResponseEntity.ok(count));
    }
    
    /**
     * Get all actor names.
     */
    @GetMapping("/actors/names")
    public Mono<ResponseEntity<String[]>> getActorNames() {
        String[] names = cashflowGenerationService.getActorNames();
        return Mono.just(ResponseEntity.ok(names));
    }
    
    // ===== Thread Partitioning Management Endpoints =====
    
    /**
     * Get thread partition statistics.
     */
    @GetMapping("/threads/partitions")
    public Mono<ResponseEntity<String>> getThreadPartitionStatistics() {
        // This would return thread partitioning statistics
        return Mono.just(ResponseEntity.ok("Thread partitioning statistics endpoint"));
    }
    
    /**
     * Get thread partition status for a specific partition.
     */
    @GetMapping("/threads/partitions/{partitionKey}")
    public Mono<ResponseEntity<String>> getThreadPartitionStatus(@PathVariable String partitionKey) {
        // This would return status for a specific partition
        return Mono.just(ResponseEntity.ok("Thread partition status for: " + partitionKey));
    }
    
    /**
     * Get thread partition operations for a specific partition.
     */
    @GetMapping("/threads/partitions/{partitionKey}/operations")
    public Mono<ResponseEntity<String>> getThreadPartitionOperations(@PathVariable String partitionKey) {
        // This would return operations for a specific partition
        return Mono.just(ResponseEntity.ok("Thread partition operations for: " + partitionKey));
    }
    
    // ===== Cashflow Query Endpoints =====
    
    /**
     * Search cashflows with filters and pagination.
     */
    @GetMapping("/cashflows")
    public Mono<ResponseEntity<CashflowPageResponse>> searchCashflows(
            @RequestParam(required = false) UUID contractId,
            @RequestParam(required = false) UUID legId,
            @RequestParam(required = false) CashflowType cashflowType,
            @RequestParam(required = false) CashflowStatus cashflowStatus,
            @RequestParam(required = false) String currency,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        
        logger.info("Searching cashflows with filters - contractId: {}, page: {}, size: {}", contractId, page, size);
        
        return cashflowQueryService.searchCashflows(contractId, legId, cashflowType, cashflowStatus, 
                                                   currency, startDate, endDate, page, size)
                .map(ResponseEntity::ok);
    }
    
    /**
     * Get cashflow by ID.
     */
    @GetMapping("/cashflows/{cashflowId}")
    public Mono<ResponseEntity<Cashflow>> getCashflowById(@PathVariable UUID cashflowId) {
        logger.info("Retrieving cashflow by ID: {}", cashflowId);
        
        return cashflowQueryService.getCashflowById(cashflowId)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    // ===== Daily Accrual Management Endpoints =====
    
    /**
     * Generate daily accruals.
     */
    @PostMapping("/cashflows/accruals/daily")
    public Mono<ResponseEntity<DailyAccrualGenerationResponse>> generateDailyAccruals(
            @RequestBody DailyAccrualGenerationRequest request) {
        logger.info("Received daily accrual generation request for {} contracts from {} to {}", 
                   request.getContractIds().size(), request.getStartDate(), request.getEndDate());
        
        return cashflowGenerationService.generateDailyAccruals(request.getContractIds(), 
                                                              request.getStartDate(), request.getEndDate())
            .collectList()
            .map(accruals -> new DailyAccrualGenerationResponse(
                UUID.randomUUID(),
                request.getContractIds().size(),
                accruals.size(),
                "Daily accrual generation completed"
            ))
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Get daily accruals for a specific contract.
     */
    @GetMapping("/cashflows/accruals/daily/{contractId}")
    public Mono<ResponseEntity<DailyAccrualPageResponse>> getDailyAccruals(
            @PathVariable UUID contractId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size) {
        
        logger.info("Retrieving daily accruals for contract {} from {} to {}", contractId, startDate, endDate);
        
        return cashflowQueryService.getDailyAccruals(contractId, startDate, endDate, page, size)
                .map(ResponseEntity::ok);
    }
    
    // ===== Health Check Endpoints =====
    
    /**
     * Health check endpoint.
     */
    @GetMapping("/health")
    public Mono<ResponseEntity<String>> health() {
        return Mono.just(ResponseEntity.ok("Cashflow Generation Service is healthy"));
    }
    
    /**
     * Detailed health check including Actor system status.
     */
    @GetMapping("/health/detailed")
    public Mono<ResponseEntity<String>> detailedHealth() {
        boolean actorSystemRunning = cashflowGenerationService.isActorSystemRunning();
        int actorCount = cashflowGenerationService.getActorCount();
        
        String health = String.format(
            "Cashflow Generation Service Health:\n" +
            "- Service Status: HEALTHY\n" +
            "- Actor System: %s\n" +
            "- Active Actors: %d",
            actorSystemRunning ? "RUNNING" : "STOPPED",
            actorCount
        );
        
        return Mono.just(ResponseEntity.ok(health));
    }
}
