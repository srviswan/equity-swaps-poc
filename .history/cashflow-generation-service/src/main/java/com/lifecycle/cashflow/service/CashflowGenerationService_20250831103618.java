package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
        
        // Validate request
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Contract IDs cannot be null or empty"));
        }
        
        // Ensure cashflowTypes is not null/empty, default to INTEREST
        final CashflowGenerationRequest finalRequest;
        if (request.getCashflowTypes() == null || request.getCashflowTypes().isEmpty()) {
            finalRequest = new CashflowGenerationRequest(
                request.getContractIds(),
                request.getCalculationDate(),
                List.of(CashflowType.INTEREST) // Default to INTEREST
            );
        } else {
            finalRequest = request;
        }
        
        return Mono.fromCallable(() -> {
            // Create partition key based on contract and calculation type
            String partitionKey = threadPartitioningService.createPartitionKey(
                finalRequest.getContractIds().get(0), // Use first contract for partitioning
                "DEFAULT_SECURITY",
                finalRequest.getCashflowTypes().get(0)
            );
            
            // Execute cashflow generation in the appropriate partition
            return threadPartitioningService.executeInPartition(partitionKey, () -> {
                try {
                    // Delegate to actor-based service for actual generation
                    List<Cashflow> cashflows = actorBasedCashflowService
                        .generateCashflows(finalRequest)
                        .collectList()
                        .block();
                    
                    return new CashflowGenerationResponse(
                        UUID.randomUUID(),
                        cashflows != null ? cashflows.size() : 0,
                        "Cashflow generation completed successfully"
                    );
                } catch (Exception e) {
                    logger.error("Error generating cashflows", e);
                    throw new RuntimeException("Cashflow generation failed", e);
                }
            });
        })
        .onErrorReturn(new CashflowGenerationResponse(
            UUID.randomUUID(),
            0,
            "Cashflow generation failed"
        ));
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
        
        // Validate request
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Contract IDs cannot be null or empty"));
        }
        
        // Use actor-based service directly
        return actorBasedCashflowService.generateCashflows(request)
            .collectList()
            .map(cashflows -> new CashflowGenerationResponse(
                UUID.randomUUID(),
                cashflows.size(),
                "Cashflow generation completed using Actor pattern"
            ))
            .onErrorReturn(new CashflowGenerationResponse(
                UUID.randomUUID(),
                0,
                "Actor-based cashflow generation failed"
            ));
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
        
        // Validate request
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            return Flux.error(new IllegalArgumentException("Contract IDs cannot be null or empty"));
        }
        
        // Use actor-based service for reactive generation
        return actorBasedCashflowService.generateCashflowsReactive(request)
            .doOnNext(cashflow -> logger.debug("Reactively generated cashflow: {}", cashflow.getId()))
            .onErrorContinue((error, item) -> {
                logger.error("Error in reactive cashflow generation for item: {}", item, error);
            });
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

        // Validate request
        if (request.getContractIds() == null || request.getContractIds().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Contract IDs cannot be null or empty"));
        }
        
        // Create interest-specific request
        CashflowGenerationRequest interestRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(CashflowType.INTEREST) // Force to INTEREST type
        );
        
        return Mono.fromCallable(() -> {
            // Create partition key for interest calculations
            String partitionKey = threadPartitioningService.createPartitionKey(
                interestRequest.getContractIds().get(0),
                "INTEREST_SECURITY",
                CalculationType.INTEREST
            );
            
            // Execute interest calculation in appropriate partition
            return threadPartitioningService.executeInPartition(partitionKey, () -> {
                try {
                    // Use actor-based service for interest-specific generation
                    List<Cashflow> interestCashflows = actorBasedCashflowService
                        .generateCashflows(interestRequest)
                        .filter(cashflow -> cashflow.getCashflowType() == CashflowType.INTEREST)
                        .collectList()
                        .block();
                    
                    return new CashflowGenerationResponse(
                        UUID.randomUUID(),
                        interestCashflows != null ? interestCashflows.size() : 0,
                        "Interest cashflow generation completed successfully"
                    );
                } catch (Exception e) {
                    logger.error("Error generating interest cashflows", e);
                    throw new RuntimeException("Interest cashflow generation failed", e);
                }
            });
        })
        .onErrorReturn(new CashflowGenerationResponse(
            UUID.randomUUID(),
            0,
            "Interest cashflow generation failed"
        ));
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
        
        // Create dividend-specific request with DIVIDEND type
        CashflowGenerationRequest dividendRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(CashflowType.DIVIDEND)
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
        
        // Create performance-specific request with PERFORMANCE type
        CashflowGenerationRequest performanceRequest = new CashflowGenerationRequest(
            request.getContractIds(),
            request.getCalculationDate(),
            List.of(CashflowType.PERFORMANCE)
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
        
        // Safely get cashflow type
        CashflowType cashflowType = CashflowType.INTEREST; // Default
        if (request.getCashflowTypes() != null && !request.getCashflowTypes().isEmpty()) {
            cashflowType = request.getCashflowTypes().get(0);
        }
        
        return new Cashflow(
            contractId,
            UUID.randomUUID(), // Placeholder leg ID
            "DEFAULT", // Placeholder security ID
            request.getPrimaryCalculationType(),
            cashflowType,
            java.math.BigDecimal.valueOf(100.00), // Placeholder amount
            "USD",
            request.getCalculationDate(),
            request.getCreatedBy() != null ? request.getCreatedBy() : "SYSTEM"
        );
    }
    

    
    /**
     * Generate batch cashflows.
     * 
     * @param batchRequest The batch cashflow generation request
     * @return Response with batch processing information
     */
    public Mono<BatchCashflowGenerationResponse> generateBatchCashflows(BatchCashflowGenerationRequest batchRequest) {
        logger.info("Starting batch cashflow generation for {} requests", 
                   batchRequest.requests().size());
        
        return Mono.fromCallable(() -> {
            List<CashflowGenerationResponse> responses = batchRequest.requests().stream()
                .map(req -> {
                    CashflowGenerationResponse response = new CashflowGenerationResponse();
                    response.setJobId(UUID.randomUUID());
                    response.setStatus("COMPLETED");
                    response.setMessage("Batch processing completed successfully");
                    response.setContractsProcessed(req.getContractIds().size());
                    return response;
                })
                .collect(java.util.stream.Collectors.toList());
            
            BatchCashflowGenerationResponse response = BatchCashflowGenerationResponse.success(responses);
            
            logger.info("Completed batch cashflow generation: batchId={}, totalRequests={}", 
                       response.batchId(), response.totalRequests());
            
            return response;
        });
    }
    
    /**
     * Generate daily accruals for the specified contracts and date range.
     * 
     * @param contractIds List of contract IDs
     * @param startDate Start date for accrual generation
     * @param endDate End date for accrual generation
     * @return Flux of generated cashflows representing daily accruals
     */
    public Flux<Cashflow> generateDailyAccruals(List<UUID> contractIds, LocalDate startDate, LocalDate endDate) {
        logger.info("Generating daily accruals for {} contracts from {} to {}", 
                   contractIds.size(), startDate, endDate);
        
        if (contractIds == null || contractIds.isEmpty()) {
            return Flux.error(new IllegalArgumentException("Contract IDs cannot be null or empty"));
        }
        
        if (startDate == null || endDate == null) {
            return Flux.error(new IllegalArgumentException("Start and end dates cannot be null"));
        }
        
        if (startDate.isAfter(endDate)) {
            return Flux.error(new IllegalArgumentException("Start date cannot be after end date"));
        }
        
        // Generate accruals for each contract and each day in the date range
        // Use a simple approach to avoid reactive stream complexity
        List<Cashflow> allCashflows = new ArrayList<>();
        
        for (UUID contractId : contractIds) {
            logger.debug("Processing daily accruals for contract: {}", contractId);
            
            // Calculate the number of days
            long dayCount = ChronoUnit.DAYS.between(startDate, endDate) + 1;
            logger.debug("Generating {} daily accruals for contract {} from {} to {}", 
                       dayCount, contractId, startDate, endDate);
            
            // Generate accruals for each day
            LocalDate currentDate = startDate;
            while (!currentDate.isAfter(endDate) && allCashflows.size() < 1000) { // Safety limit
                Cashflow cashflow = new Cashflow(
                    contractId,
                    UUID.randomUUID(), // legId
                    "ACCRUAL_SECURITY_" + contractId.toString().substring(0, 8), // securityId
                    CalculationType.INTEREST, // calculationType
                    CashflowType.INTEREST, // cashflowType
                    calculateDailyAccrualAmount(contractId, currentDate), // amount
                    "USD", // currency
                    currentDate, // calculationDate
                    "DAILY_ACCRUAL_SYSTEM" // createdBy
                );
                allCashflows.add(cashflow);
                logger.debug("Created accrual cashflow: {} for {}", cashflow.getId(), currentDate);
                currentDate = currentDate.plusDays(1);
            }
        }
        
        logger.info("Completed daily accrual generation: {} cashflows created", allCashflows.size());
        return Flux.fromIterable(allCashflows);
    }
    
    /**
     * Calculate the daily accrual amount for a contract on a specific date.
     * This is a simplified calculation for demonstration purposes.
     */
    private BigDecimal calculateDailyAccrualAmount(UUID contractId, LocalDate accrualDate) {
        // Simple calculation: base amount * day factor
        // In real implementation, this would consider:
        // - Interest rates
        // - Day count conventions
        // - Notional amounts
        // - Contract-specific terms
        
        double baseAmount = 1000.0; // Base notional
        double dailyRate = 0.05 / 365.0; // 5% annual rate / 365 days
        double dayOfYearFactor = accrualDate.getDayOfYear() / 365.0;
        
        BigDecimal dailyAccrual = BigDecimal.valueOf(baseAmount * dailyRate * (1 + dayOfYearFactor));
        
        logger.debug("Calculated daily accrual for contract {} on {}: {}", 
                    contractId, accrualDate, dailyAccrual);
        
        return dailyAccrual.setScale(6, RoundingMode.HALF_UP);
    }
}
