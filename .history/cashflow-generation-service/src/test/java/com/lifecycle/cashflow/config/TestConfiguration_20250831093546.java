package com.lifecycle.cashflow.config;

import com.lifecycle.cashflow.service.*;
import com.lifecycle.cashflow.repository.*;
import com.lifecycle.cashflow.model.*;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Test configuration that provides working mock implementations
 * This allows us to keep business logic intact while providing test doubles
 */
@TestConfiguration
public class TestConfiguration {

    @Bean
    @Primary
    public CashflowGenerationService mockCashflowGenerationService() {
        return new CashflowGenerationService(
            mockThreadPartitioningService(), 
            mockActorBasedCashflowService()
        ) {
            @Override
            public Mono<CashflowGenerationResponse> generateCashflows(CashflowGenerationRequest request) {
                return Mono.just(new CashflowGenerationResponse(
                    UUID.randomUUID(),
                    request.getContractIds().size(),
                    "Test cashflow generation completed"
                ));
            }
            
            @Override
            public Mono<CashflowGenerationResponse> generateInterestCashflows(CashflowGenerationRequest request) {
                return Mono.just(new CashflowGenerationResponse(
                    UUID.randomUUID(),
                    request.getContractIds().size(),
                    "Test interest cashflow generation completed"
                ));
            }
            
            @Override
            public Flux<Cashflow> generateCashflowsReactive(CashflowGenerationRequest request) {
                return Flux.fromIterable(request.getContractIds())
                    .map(contractId -> new Cashflow(
                        contractId,
                        UUID.randomUUID(),
                        "TEST_SECURITY",
                        CalculationType.INTEREST,
                        CashflowType.INTEREST,
                        BigDecimal.valueOf(100.00),
                        "USD",
                        LocalDate.now(),
                        "TEST_USER"
                    ));
            }
            
            @Override
            public Mono<BatchCashflowGenerationResponse> generateBatchCashflows(BatchCashflowGenerationRequest request) {
                List<CashflowGenerationResponse> responses = request.getRequests().stream()
                    .map(req -> new CashflowGenerationResponse(
                        UUID.randomUUID(),
                        req.getContractIds().size(),
                        "Test batch generation completed"
                    ))
                    .toList();
                
                String jobId = UUID.randomUUID().toString();
                return Mono.just(new BatchCashflowGenerationResponse(
                    responses,
                    request.getRequests().size(),
                    request.getRequests().size(),
                    0,
                    request.getRequests().size(),
                    jobId,
                    jobId
                ));
            }
        };
    }

    @Bean
    @Primary 
    public CashflowQueryService mockCashflowQueryService() {
        return new CashflowQueryService(null, null, null) {
            @Override
            public Mono<CashflowPageResponse> searchCashflows(
                    UUID contractId, UUID securityId, CashflowType cashflowType,
                    CashflowStatus status, String currency, LocalDate startDate,
                    LocalDate endDate, int page, int size) {
                
                List<Cashflow> mockCashflows = List.of(
                    new Cashflow(
                        contractId != null ? contractId : UUID.randomUUID(),
                        UUID.randomUUID(),
                        "TEST_SECURITY",
                        CalculationType.INTEREST,
                        cashflowType != null ? cashflowType : CashflowType.INTEREST,
                        BigDecimal.valueOf(100.00),
                        currency != null ? currency : "USD",
                        LocalDate.now(),
                        "TEST_USER"
                    )
                );
                return Mono.just(CashflowPageResponse.of(mockCashflows, page, size, mockCashflows.size()));
            }
        };
    }

    @Bean
    @Primary
    public ThreadPartitioningService mockThreadPartitioningService() {
        return new ThreadPartitioningService() {
            @Override
            public ThreadPartitionStatus getPartitionStatus() {
                return new ThreadPartitionStatus(
                    10, 5, 5,
                    java.util.Map.of("partition1", 2, "partition2", 3),
                    java.time.LocalDateTime.now(),
                    "ACTIVE"
                );
            }
        };
    }

    @Bean
    @Primary
    public ActorBasedCashflowService mockActorBasedCashflowService() {
        return new ActorBasedCashflowService() {
            @Override
            public boolean isActorSystemRunning() {
                return true;
            }
            
            @Override
            public int getActorCount() {
                return 5;
            }
        };
    }

    @Bean
    @Primary
    public CashflowStateManagementService mockCashflowStateManagementService() {
        return new CashflowStateManagementService(null) {
            @Override
            public Mono<Cashflow> updateCashflowStatus(UUID cashflowId, CashflowStatus status) {
                Cashflow mockCashflow = new Cashflow(
                    UUID.randomUUID(),
                    cashflowId,
                    "TEST_SECURITY",
                    CalculationType.INTEREST,
                    CashflowType.INTEREST,
                    BigDecimal.valueOf(100.00),
                    "USD",
                    LocalDate.now(),
                    "TEST_USER"
                );
                mockCashflow.setStatus(status);
                return Mono.just(mockCashflow);
            }
        };
    }
}
