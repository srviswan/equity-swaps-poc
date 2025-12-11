package com.finos.cashflow.service;

import com.finos.cashflow.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Test class for CashflowGenerationService.
 * 
 * This test verifies the business logic and thread partitioning behavior
 * of the cashflow generation service.
 */
@ExtendWith(MockitoExtension.class)
class CashflowGenerationServiceTest {

    @Mock
    private ThreadPartitioningService threadPartitioningService;

    private CashflowGenerationService cashflowGenerationService;

    @BeforeEach
    void setUp() {
        cashflowGenerationService = new CashflowGenerationService(threadPartitioningService);
    }

    @Test
    void generateCashflows_ShouldReturnAcceptedResponse() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock thread partitioning service
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(new ThreadPartitionKey(contractId, "DEFAULT", CalculationType.INTEREST));
        
        // Mock executeInPartition to return a valid CompletableFuture
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> {
                java.util.concurrent.Callable<Cashflow> task = invocation.getArgument(1);
                try {
                    Cashflow cashflow = task.call();
                    return java.util.concurrent.CompletableFuture.completedFuture(cashflow);
                } catch (Exception e) {
                    return java.util.concurrent.CompletableFuture.failedFuture(e);
                }
            });
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateCashflows(request);
        
        // Then
        StepVerifier.create(result)
            .assertNext(response -> {
                assertThat(response.getJobId()).isNotNull();
                assertThat(response.getContractsProcessed()).isEqualTo(1);
                assertThat(response.getMessage()).contains("accepted");
                assertThat(response.isAccepted()).isTrue();
            })
            .verifyComplete();
    }

    @Test
    void generateCashflows_WithMultipleContracts_ShouldProcessAll() {
        // Given
        UUID contractId1 = UUID.randomUUID();
        UUID contractId2 = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId1, contractId2), calculationDate, cashflowTypes);
        
        // Mock thread partitioning service
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(new ThreadPartitionKey(contractId1, "DEFAULT", CalculationType.INTEREST));
        
        // Mock executeInPartition to return a valid CompletableFuture
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> {
                java.util.concurrent.Callable<Cashflow> task = invocation.getArgument(1);
                try {
                    Cashflow cashflow = task.call();
                    return java.util.concurrent.CompletableFuture.completedFuture(cashflow);
                } catch (Exception e) {
                    return java.util.concurrent.CompletableFuture.failedFuture(e);
                }
            });
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateCashflows(request);
        
        // Then
        StepVerifier.create(result)
            .assertNext(response -> {
                assertThat(response.getContractsProcessed()).isEqualTo(2);
            })
            .verifyComplete();
    }

    @Test
    void generateCashflowsReactive_ShouldReturnFluxOfCashflows() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock thread partitioning service
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(new ThreadPartitionKey(contractId, "DEFAULT", CalculationType.INTEREST));
        
        when(threadPartitioningService.executeReactiveInPartition(any(), any()))
            .thenAnswer(invocation -> {
                reactor.core.publisher.Mono<Cashflow> mono = invocation.getArgument(1);
                return mono;
            });
        
        // When
        var result = cashflowGenerationService.generateCashflowsReactive(request);
        
        // Then
        StepVerifier.create(result)
            .assertNext(cashflow -> {
                assertThat(cashflow.getContractId()).isEqualTo(contractId);
                assertThat(cashflow.getCalculationType()).isEqualTo(CalculationType.INTEREST);
                assertThat(cashflow.getCashflowType()).isEqualTo(CashflowType.INTEREST);
            })
            .verifyComplete();
    }

    @Test
    void generateDailyAccruals_ShouldReturnFluxOfInterestCashflows() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate startDate = LocalDate.now().minusDays(7);
        LocalDate endDate = LocalDate.now();
        
        // Mock thread partitioning service
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(new ThreadPartitionKey(contractId, "DEFAULT", CalculationType.INTEREST));
        
        when(threadPartitioningService.executeReactiveInPartition(any(), any()))
            .thenAnswer(invocation -> {
                reactor.core.publisher.Mono<Cashflow> mono = invocation.getArgument(1);
                return mono;
            });
        
        // When
        var result = cashflowGenerationService.generateDailyAccruals(
            List.of(contractId), startDate, endDate);
        
        // Then
        StepVerifier.create(result)
            .assertNext(cashflow -> {
                assertThat(cashflow.getCalculationType()).isEqualTo(CalculationType.INTEREST);
                assertThat(cashflow.getCashflowType()).isEqualTo(CashflowType.INTEREST);
            })
            .verifyComplete();
    }

    @Test
    void generateCashflows_WithInterestRequest_ShouldSetCorrectCalculationType() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // When
        CalculationType calculationType = request.getPrimaryCalculationType();
        
        // Then
        assertThat(calculationType).isEqualTo(CalculationType.INTEREST);
        assertThat(request.isInterestRequest()).isTrue();
        assertThat(request.isEquityRequest()).isFalse();
    }

    @Test
    void generateCashflows_WithEquityRequest_ShouldSetCorrectCalculationType() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.PERFORMANCE);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // When
        CalculationType calculationType = request.getPrimaryCalculationType();
        
        // Then
        assertThat(calculationType).isEqualTo(CalculationType.EQUITY);
        assertThat(request.isInterestRequest()).isFalse();
        assertThat(request.isEquityRequest()).isTrue();
    }
}
