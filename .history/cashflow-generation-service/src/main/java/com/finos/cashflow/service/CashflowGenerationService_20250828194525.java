package com.finos.cashflow.service;

import com.finos.cashflow.model.Cashflow;
import com.finos.cashflow.model.CashflowGenerationRequest;
import com.finos.cashflow.model.CashflowGenerationResponse;
import com.finos.cashflow.model.CalculationType;
import com.finos.cashflow.model.ThreadPartitionKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Cashflow generation service that integrates both the original thread partitioning approach
 * and the new Actor pattern for enhanced concurrency control.
 * 
 * This service provides a hybrid approach where:
 * - Simple operations use the original thread partitioning
 * - Complex, stateful operations use the Actor pattern
 * - Both approaches can be used simultaneously
 */
@Service
public class CashflowGenerationService {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowGenerationService.class);
    
    private final ThreadPartitioningService threadPartitioningService;
    private final ActorBasedCashflowService actorBasedCashflowService;
    
    @Autowired
    public CashflowGenerationService(ThreadPartitioningService threadPartitioningService,
                                   ActorBasedCashflowService actorBasedCashflowService) {
        this.threadPartitioningService = threadPartitioningService;
        this.actorBasedCashflowService = actorBasedCashflowService;
        logger.info("CashflowGenerationService initialized with both thread partitioning and Actor pattern support");
    }
    
    /**
     * Generate cashflows using the original thread partitioning approach.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateCashflows(CashflowGenerationRequest request) {
        logger.info("Generating cashflows for {} contracts using thread partitioning", 
                   request.getContractIds().size());
        
        // Use thread partitioning for simple operations
        List<CompletableFuture<Cashflow>> futures = request.getContractIds().stream()
            .map(contractId -> {
                ThreadPartitionKey partitionKey = threadPartitioningService.createPartitionKey(
                    contractId, "DEFAULT", request.getPrimaryCalculationType());
                return threadPartitioningService.executeInPartition(
                    partitionKey,
                    () -> generateCashflowForContract(contractId, request)
                );
            })
            .toList();
        
        // Wait for all operations to complete
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
            futures.toArray(new CompletableFuture[0])
        );
        
        return Mono.fromFuture(allFutures)
            .then(Mono.just(new CashflowGenerationResponse(
                UUID.randomUUID(),
                request.getContractIds().size(),
                "Cashflow generation completed using thread partitioning"
            )));
    }
    
    /**
     * Generate cashflows using the Actor pattern for enhanced state management.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateCashflowsWithActors(CashflowGenerationRequest request) {
        logger.info("Generating cashflows for {} contracts using Actor pattern", 
                   request.getContractIds().size());
        
        return actorBasedCashflowService.generateCashflows(request);
    }
    
    /**
     * Generate cashflows reactively using the Actor pattern.
     * 
     * @param request The cashflow generation request
     * @return Stream of generated cashflows
     */
    public Flux<Cashflow> generateCashflowsReactive(CashflowGenerationRequest request) {
        logger.info("Generating cashflows reactively for {} contracts using Actor pattern", 
                   request.getContractIds().size());
        
        return actorBasedCashflowService.generateCashflowsReactive(request);
    }
    
    /**
     * Generate daily accruals using the Actor pattern.
     * 
     * @param contractIds List of contract IDs
     * @param startDate Start date for accruals
     * @param endDate End date for accruals
     * @return Stream of daily accrual cashflows
     */
    public Flux<Cashflow> generateDailyAccruals(List<UUID> contractIds, 
                                               LocalDate startDate, 
                                               LocalDate endDate) {
        logger.info("Generating daily accruals for {} contracts using Actor pattern", 
                   contractIds.size());
        
        return actorBasedCashflowService.generateDailyAccruals(contractIds, startDate, endDate);
    }
    
    /**
     * Generate interest cashflows using thread partitioning.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateInterestCashflows(CashflowGenerationRequest request) {
        logger.info("Generating interest cashflows for {} contracts using thread partitioning", 
                   request.getContractIds().size());
        
        // Filter for interest-only requests
        CashflowGenerationRequest interestRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(request.getCashflowTypes().stream()
                .filter(type -> type.name().contains("INTEREST"))
                .findFirst()
                .orElse(request.getCashflowTypes().get(0)))
        );
        
        return generateCashflows(interestRequest);
    }
    
    /**
     * Generate dividend cashflows using thread partitioning.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateDividendCashflows(CashflowGenerationRequest request) {
        logger.info("Generating dividend cashflows for {} contracts using thread partitioning", 
                   request.getContractIds().size());
        
        // Filter for dividend-only requests
        CashflowGenerationRequest dividendRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(request.getCashflowTypes().stream()
                .filter(type -> type.name().contains("DIVIDEND"))
                .findFirst()
                .orElse(request.getCashflowTypes().get(0)))
        );
        
        return generateCashflows(dividendRequest);
    }
    
    /**
     * Generate performance cashflows using thread partitioning.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generatePerformanceCashflows(CashflowGenerationRequest request) {
        logger.info("Generating performance cashflows for {} contracts using thread partitioning", 
                   request.getContractIds().size());
        
        // Filter for performance-only requests
        CashflowGenerationRequest performanceRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(request.getCashflowTypes().stream()
                .filter(type -> type.name().contains("PERFORMANCE"))
                .findFirst()
                .orElse(request.getCashflowTypes().get(0)))
        );
        
        return generateCashflows(performanceRequest);
    }
    
    /**
     * Get actor system statistics for monitoring.
     * 
     * @return Actor system status
     */
    public boolean isActorSystemRunning() {
        return actorBasedCashflowService.isActorSystemRunning();
    }
    
    /**
     * Get the number of active actors.
     * 
     * @return Number of actors
     */
    public int getActorCount() {
        return actorBasedCashflowService.getActorCount();
    }
    
    /**
     * Get all actor names for debugging.
     * 
     * @return Array of actor names
     */
    public String[] getActorNames() {
        return actorBasedCashflowService.getActorNames();
    }
    
    /**
     * Generate a cashflow for a specific contract (placeholder implementation).
     * 
     * @param contractId Contract ID
     * @param request Generation request
     * @return Generated cashflow
     */
    private Cashflow generateCashflowForContract(UUID contractId, CashflowGenerationRequest request) {
        // This is a placeholder implementation
        // In a real system, this would contain actual cashflow calculation logic
        return new Cashflow(
            contractId,
            UUID.randomUUID(), // Placeholder leg ID
            "DEFAULT", // Placeholder security ID
            request.getPrimaryCalculationType(),
            request.getCashflowTypes().get(0),
            java.math.BigDecimal.valueOf(100.00), // Placeholder amount
            "USD",
            request.getCalculationDate(),
            request.getCreatedBy() != null ? request.getCreatedBy() : "SYSTEM"
        );
    }
}
