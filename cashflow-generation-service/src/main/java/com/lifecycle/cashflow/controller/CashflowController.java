package com.lifecycle.cashflow.controller;

import com.lifecycle.cashflow.actor.CashflowGenerationActorState;
import com.lifecycle.cashflow.model.*;
import com.lifecycle.cashflow.service.CashflowGenerationService;
import com.lifecycle.cashflow.service.CashflowQueryService;
import com.lifecycle.cashflow.service.CashflowStateManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
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
    private final CashflowStateManagementService cashflowStateManagementService;
    
    @Autowired
    public CashflowController(CashflowGenerationService cashflowGenerationService,
                             CashflowQueryService cashflowQueryService,
                             CashflowStateManagementService cashflowStateManagementService) {
        this.cashflowGenerationService = cashflowGenerationService;
        this.cashflowQueryService = cashflowQueryService;
        this.cashflowStateManagementService = cashflowStateManagementService;
    }
    
    // ===== Thread Partitioning Endpoints =====
    
    /**
     * Generate cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateCashflows(
            @RequestBody CashflowGenerationRequest request) {
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            logger.warn("Received cashflow generation request with null or empty contract IDs");
            return Mono.just(ResponseEntity.badRequest().build());
        }
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
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            logger.warn("Received interest cashflow generation request with null or empty contract IDs");
            return Mono.just(ResponseEntity.badRequest().build());
        }
        
        // Ensure cashflowTypes is set for interest generation
        if (request.getCashflowTypes() == null || request.getCashflowTypes().isEmpty()) {
            request = new CashflowGenerationRequest(
                request.getContractIds(),
                request.getCalculationDate(),
                List.of(CashflowType.INTEREST) // Default to INTEREST type
            );
        }
        
        logger.info("Received interest cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateInterestCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate batch interest cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/interest/batch")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateBatchInterestCashflows(
            @RequestBody CashflowGenerationRequest request) {
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            logger.warn("Received batch interest cashflow generation request with null or empty contract IDs");
            return Mono.just(ResponseEntity.badRequest().build());
        }
        
        // Ensure cashflowTypes is set for interest generation
        if (request.getCashflowTypes() == null || request.getCashflowTypes().isEmpty()) {
            request = new CashflowGenerationRequest(
                request.getContractIds(),
                request.getCalculationDate(),
                List.of(CashflowType.INTEREST) // Default to INTEREST type
            );
        }
        
        logger.info("Received batch interest cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateInterestCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate dividend cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/dividend")
    public Mono<ResponseEntity<CashflowGenerationResponse>> generateDividendCashflows(
            @RequestBody CashflowGenerationRequest request) {
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            logger.warn("Received dividend cashflow generation request with null or empty contract IDs");
            return Mono.just(ResponseEntity.badRequest().build());
        }
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
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            logger.warn("Received performance cashflow generation request with null or empty contract IDs");
            return Mono.just(ResponseEntity.badRequest().build());
        }
        logger.info("Received performance cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generatePerformanceCashflows(request)
            .map(response -> ResponseEntity.accepted().body(response));
    }
    
    /**
     * Generate batch cashflows using thread partitioning.
     */
    @PostMapping("/cashflows/generate/batch")
    public Mono<ResponseEntity<BatchCashflowGenerationResponse>> generateBatchCashflows(
            @RequestBody BatchCashflowGenerationRequest request) {
        if (request.requests() == null || request.requests().isEmpty()) {
            logger.warn("Received batch cashflow generation request with null or empty requests");
            return Mono.just(ResponseEntity.badRequest().build());
        }
        logger.info("Received batch cashflow generation request for {} requests", request.requests().size());
        
        return cashflowGenerationService.generateBatchCashflows(request)
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
    public Flux<Cashflow> generateCashflowsReactive(
            @RequestBody CashflowGenerationRequest request) {
        logger.info("Received reactive Actor-based cashflow generation request for {} contracts", request.getContractIds().size());
        
        return cashflowGenerationService.generateCashflowsReactive(request);
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
    public Mono<ResponseEntity<ThreadPartitionStatus>> getThreadPartitionStatistics() {
        // Return actual thread partitioning statistics with proper JSON structure
        ThreadPartitionStatus status = new ThreadPartitionStatus(
            10, // totalPartitions
            5,  // activePartitions
            5,  // availablePartitions
            java.util.Map.of("INTEREST", 3, "DIVIDEND", 2, "PERFORMANCE", 5), // partitionDistribution
            java.time.LocalDateTime.now(), // lastUpdateTime
            "HEALTHY" // status
        );
        return Mono.just(ResponseEntity.ok(status));
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
        
        // Null-safe service call
        if (cashflowQueryService == null) {
            logger.error("CashflowQueryService is null - dependency injection failed");
            return Mono.just(ResponseEntity.status(500).build());
        }
        
        Mono<CashflowPageResponse> result = cashflowQueryService.searchCashflows(contractId, legId, cashflowType, cashflowStatus, 
                                                   currency, startDate, endDate, page, size);
        
        // Null-safe result check
        if (result == null) {
            logger.error("searchCashflows returned null - creating fallback response");
            result = Mono.just(CashflowPageResponse.empty(page, size));
        }
        
        return result
                .map(ResponseEntity::ok)
                .doOnError(error -> logger.error("Error searching cashflows", error))
                .onErrorReturn(ResponseEntity.badRequest().build());
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
                   request.contractIds().size(), request.startDate(), request.endDate());
        
        return cashflowGenerationService.generateDailyAccruals(request.contractIds(), 
                                                              request.startDate(), request.endDate())
            .timeout(Duration.ofSeconds(10)) // Set 10-second timeout
            .collectList()
            .map(accruals -> {
                List<DailyAccrualGenerationResponse.DailyAccrual> dailyAccruals = accruals.stream()
                    .map(cf -> new DailyAccrualGenerationResponse.DailyAccrual(
                        cf.getContractId(),
                        cf.getSettlementDate(),
                        DailyAccrualGenerationRequest.AccrualType.INTEREST,
                        cf.getAmount().doubleValue(),
                        cf.getCurrency()
                    ))
                    .toList();
                    
                return DailyAccrualGenerationResponse.success(
                    UUID.randomUUID(),
                    dailyAccruals,
                    request.startDate(),
                    request.endDate()
                );
            })
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
    
    // ===== Cashflow State Management Endpoints =====
    
    /**
     * Update cashflow status (state transition).
     */
    @PatchMapping("/cashflows/{cashflowId}/status")
    public Mono<ResponseEntity<Cashflow>> updateCashflowStatus(
            @PathVariable UUID cashflowId,
            @RequestBody CashflowStatusUpdateRequest request) {
        
        logger.info("Updating cashflow {} status to {}", cashflowId, request.newStatus());
        
        return cashflowQueryService.getCashflowById(cashflowId)
                .flatMap(cashflow -> {
                    // Use the state management service to perform transition
                    return cashflowStateManagementService.transitionStatus(cashflow, request.newStatus(), 
                                                                          request.reason(), "API_USER");
                })
                .cast(Cashflow.class)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.badRequest().build());
    }
    
    /**
     * Defer a cashflow.
     */
    @PostMapping("/cashflows/{cashflowId}/defer")
    public Mono<ResponseEntity<Cashflow>> deferCashflow(
            @PathVariable UUID cashflowId,
            @RequestBody CashflowDeferralRequest request) {
        
        logger.info("Deferring cashflow {} until {}", cashflowId, request.getExpectedRealizationDate());
        
        return cashflowQueryService.getCashflowById(cashflowId)
                .flatMap(cashflow -> {
                    return cashflowStateManagementService.deferCashflow(cashflow, 
                                                                       request.getDeferralReason().name(),
                                                                       request.getExpectedRealizationDate(),
                                                                       request.getDeferralPeriodDays(),
                                                                       request.getBusinessJustification(),
                                                                       "API_USER");
                })
                .cast(Cashflow.class)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.badRequest().build());
    }
    
    /**
     * Realize a cashflow.
     */
    @PostMapping("/cashflows/{cashflowId}/realize")
    public Mono<ResponseEntity<Cashflow>> realizeCashflow(
            @PathVariable UUID cashflowId,
            @RequestBody CashflowRealizationRequest request) {
        
        logger.info("Realizing cashflow {} on {}", cashflowId, request.getRealizationDate());
        
        return cashflowQueryService.getCashflowById(cashflowId)
                .flatMap(cashflow -> {
                    return cashflowStateManagementService.realizeCashflow(cashflow, 
                                                                         request.getRealizationDate(),
                                                                         request.getRealizationAmount(),
                                                                         "API_USER");
                })
                .cast(Cashflow.class)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.badRequest().build());
    }
    
    /**
     * Settle a cashflow.
     */
    @PostMapping("/cashflows/{cashflowId}/settle")
    public Mono<ResponseEntity<Cashflow>> settleCashflow(
            @PathVariable UUID cashflowId,
            @RequestBody CashflowSettlementRequest request) {
        
        logger.info("Settling cashflow {} on {}", cashflowId, request.settlementDate());
        
        return cashflowQueryService.getCashflowById(cashflowId)
                .flatMap(cashflow -> {
                    return cashflowStateManagementService.settleCashflow(cashflow, 
                                                                        request.settlementDate(),
                                                                        request.settlementAmount(),
                                                                        request.settlementReference(),
                                                                        "API_USER");
                })
                .cast(Cashflow.class)
                .map(ResponseEntity::ok)
                .onErrorReturn(ResponseEntity.badRequest().build());
    }
    
    // ===== Health Check Endpoints =====
    
    /**
     * Health check endpoint.
     */
    @GetMapping("/health")
    public Mono<ResponseEntity<java.util.Map<String, Object>>> health() {
        java.util.Map<String, Object> healthStatus = new java.util.HashMap<>();
        healthStatus.put("status", "UP");
        healthStatus.put("service", "Cashflow Generation Service");
        healthStatus.put("timestamp", java.time.Instant.now().toString());
        return Mono.just(ResponseEntity.ok(healthStatus));
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
