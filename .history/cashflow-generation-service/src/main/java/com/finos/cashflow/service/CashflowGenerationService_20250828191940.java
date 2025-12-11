package com.finos.cashflow.service;

import com.finos.cashflow.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

/**
 * Service for generating cashflows with thread partitioning.
 * 
 * This service uses thread partitioning to ensure data consistency
 * and high performance for cashflow generation.
 */
@Service
public class CashflowGenerationService {
    
    private static final Logger logger = LoggerFactory.getLogger(CashflowGenerationService.class);
    
    private final ThreadPartitioningService threadPartitioningService;
    
    public CashflowGenerationService(ThreadPartitioningService threadPartitioningService) {
        this.threadPartitioningService = threadPartitioningService;
    }
    
    /**
     * Generate cashflows for the specified request.
     * 
     * @param request The cashflow generation request
     * @return Response with job tracking information
     */
    public Mono<CashflowGenerationResponse> generateCashflows(CashflowGenerationRequest request) {
        logger.info("Generating cashflows for {} contracts on {}", 
                   request.getContractIds().size(), request.getCalculationDate());
        
        // Create a unique job ID
        UUID jobId = UUID.randomUUID();
        
        // Process each contract in its appropriate partition
        List<CompletableFuture<Cashflow>> futures = request.getContractIds().stream()
            .map(contractId -> generateCashflowsForContract(contractId, request))
            .toList();
        
        // Wait for all contracts to complete
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
            .thenRun(() -> logger.info("Completed cashflow generation for job: {}", jobId));
        
        return Mono.just(new CashflowGenerationResponse(
            jobId, 
            request.getContractIds().size(), 
            "Cashflow generation accepted for processing"
        ));
    }
    
    /**
     * Generate cashflows for a specific contract using thread partitioning.
     * 
     * @param contractId Contract ID
     * @param request Generation request
     * @return CompletableFuture for the generated cashflows
     */
    private CompletableFuture<Cashflow> generateCashflowsForContract(
            UUID contractId, 
            CashflowGenerationRequest request) {
        
        // For simplicity, we'll use a default security ID
        // In a real implementation, this would come from contract data
        String securityId = "DEFAULT";
        
        // Create partition key based on calculation type
        CalculationType calculationType = request.getPrimaryCalculationType();
        ThreadPartitionKey partitionKey = threadPartitioningService.createPartitionKey(
            contractId, securityId, calculationType);
        
        logger.debug("Processing contract {} in partition: {}", contractId, partitionKey.getPartitionString());
        
        return threadPartitioningService.executeInPartition(partitionKey, () -> {
            try {
                // Generate cashflows based on type
                if (request.isInterestRequest()) {
                    return generateInterestCashflow(contractId, securityId, request);
                } else if (request.isEquityRequest()) {
                    return generateEquityCashflow(contractId, securityId, request);
                } else {
                    // Default to interest
                    return generateInterestCashflow(contractId, securityId, request);
                }
            } catch (Exception e) {
                logger.error("Error generating cashflows for contract {} in partition {}", 
                           contractId, partitionKey.getPartitionString(), e);
                throw new RuntimeException("Cashflow generation failed", e);
            }
        });
    }
    
    /**
     * Generate interest cashflow for a contract.
     * 
     * @param contractId Contract ID
     * @param securityId Security ID
     * @param request Generation request
     * @return Generated cashflow
     */
    private Cashflow generateInterestCashflow(UUID contractId, String securityId, 
                                            CashflowGenerationRequest request) {
        logger.debug("Generating interest cashflow for contract: {}", contractId);
        
        // In a real implementation, this would calculate interest based on:
        // - Contract terms
        // - Interest rates
        // - Day count conventions
        // - Business day adjustments
        
        BigDecimal amount = BigDecimal.valueOf(100.00); // Placeholder
        
        return new Cashflow(
            contractId,
            UUID.randomUUID(), // Placeholder leg ID
            securityId,
            CalculationType.INTEREST,
            CashflowType.INTEREST,
            amount,
            "USD",
            request.getCalculationDate(),
            request.getCreatedBy() != null ? request.getCreatedBy() : "SYSTEM"
        );
    }
    
    /**
     * Generate equity cashflow for a contract.
     * 
     * @param contractId Contract ID
     * @param securityId Security ID
     * @param request Generation request
     * @return Generated cashflow
     */
    private Cashflow generateEquityCashflow(UUID contractId, String securityId, 
                                          CashflowGenerationRequest request) {
        logger.debug("Generating equity cashflow for contract: {}", contractId);
        
        // In a real implementation, this would calculate equity P&L based on:
        // - Market prices
        // - Position sizes
        // - Dividend data
        // - FX rates
        
        BigDecimal amount = BigDecimal.valueOf(250.00); // Placeholder
        
        return new Cashflow(
            contractId,
            UUID.randomUUID(), // Placeholder leg ID
            securityId,
            CalculationType.EQUITY,
            CashflowType.PERFORMANCE,
            amount,
            "USD",
            request.getCalculationDate(),
            request.getCreatedBy() != null ? request.getCreatedBy() : "SYSTEM"
        );
    }
    
    /**
     * Generate cashflows reactively with streaming response.
     * 
     * @param request The cashflow generation request
     * @return Flux of generated cashflows
     */
    public Flux<Cashflow> generateCashflowsReactive(CashflowGenerationRequest request) {
        logger.info("Generating cashflows reactively for {} contracts", request.getContractIds().size());
        
        return Flux.fromIterable(request.getContractIds())
            .flatMap(contractId -> {
                String securityId = "DEFAULT";
                CalculationType calculationType = request.getPrimaryCalculationType();
                ThreadPartitionKey partitionKey = threadPartitioningService.createPartitionKey(
                    contractId, securityId, calculationType);
                
                return threadPartitioningService.executeReactiveInPartition(partitionKey,
                    Mono.fromCallable(() -> {
                        if (request.isInterestRequest()) {
                            return generateInterestCashflow(contractId, securityId, request);
                        } else {
                            return generateEquityCashflow(contractId, securityId, request);
                        }
                    }));
            })
            .doOnNext(cashflow -> logger.debug("Generated cashflow: {}", cashflow.getId()));
    }
    
    /**
     * Generate daily accruals for the specified date range.
     * 
     * @param contractIds Contract IDs
     * @param startDate Start date
     * @param endDate End date
     * @return Flux of daily accruals
     */
    public Flux<Cashflow> generateDailyAccruals(List<UUID> contractIds, 
                                               LocalDate startDate, 
                                               LocalDate endDate) {
        logger.info("Generating daily accruals for {} contracts from {} to {}", 
                   contractIds.size(), startDate, endDate);
        
        return Flux.fromIterable(contractIds)
            .flatMap(contractId -> {
                String securityId = "DEFAULT";
                ThreadPartitionKey partitionKey = threadPartitioningService.createPartitionKey(
                    contractId, securityId, CalculationType.INTEREST);
                
                return threadPartitioningService.executeReactiveInPartition(partitionKey,
                    Mono.fromCallable(() -> generateInterestCashflow(
                        contractId, securityId, 
                        new CashflowGenerationRequest(List.of(contractId), startDate, List.of(CashflowType.INTEREST))
                    )));
            });
    }
}
