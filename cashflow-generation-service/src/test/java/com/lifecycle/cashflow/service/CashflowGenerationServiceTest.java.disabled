package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowGenerationRequest;
import com.lifecycle.cashflow.model.CashflowGenerationResponse;
import com.lifecycle.cashflow.model.CashflowType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Tests for the CashflowGenerationService.
 * 
 * These tests verify that the service correctly integrates both thread partitioning
 * and Actor pattern approaches for cashflow generation.
 */
@ExtendWith(MockitoExtension.class)
class CashflowGenerationServiceTest {
    
    @Mock
    private ThreadPartitioningService threadPartitioningService;
    
    @Mock
    private ActorBasedCashflowService actorBasedCashflowService;
    
    private CashflowGenerationService cashflowGenerationService;
    
    @BeforeEach
    void setUp() {
        cashflowGenerationService = new CashflowGenerationService(
            threadPartitioningService, actorBasedCashflowService);
    }
    
    @Test
    void generateCashflows_ShouldReturnAcceptedResponse() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock the thread partitioning service
        Cashflow mockCashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "SYSTEM");
        
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(null); // Mock will be handled by the service
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateCashflows(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getJobId()).isNotNull();
        assertThat(response.getContractsProcessed()).isEqualTo(1);
        assertThat(response.getMessage()).contains("thread partitioning");
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
        
        // Mock the thread partitioning service
        Cashflow mockCashflow1 = new Cashflow(
            contractId1, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "SYSTEM");
        
        Cashflow mockCashflow2 = new Cashflow(
            contractId2, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(200.00), "USD", calculationDate, "SYSTEM");
        
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(null); // Mock will be handled by the service
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow1))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow2));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateCashflows(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getContractsProcessed()).isEqualTo(2);
    }
    
    @Test
    void generateCashflowsWithActors_ShouldDelegateToActorService() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        CashflowGenerationResponse expectedResponse = new CashflowGenerationResponse(
            UUID.randomUUID(), 1, "Actor-based generation completed");
        
        when(actorBasedCashflowService.generateCashflows(request))
            .thenReturn(Mono.just(expectedResponse));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateCashflowsWithActors(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).contains("Actor-based generation completed");
    }
    
    @Test
    void generateInterestCashflows_ShouldFilterForInterestTypes() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST, CashflowType.PERFORMANCE);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock the thread partitioning service
        Cashflow mockCashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "SYSTEM");
        
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(null); // Mock will be handled by the service
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateInterestCashflows(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getContractsProcessed()).isEqualTo(1);
    }
    
    @Test
    void generateDividendCashflows_ShouldFilterForDividendTypes() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.DIVIDEND, CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock the thread partitioning service
        Cashflow mockCashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.DIVIDEND,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "SYSTEM");
        
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(null); // Mock will be handled by the service
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generateDividendCashflows(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getContractsProcessed()).isEqualTo(1);
    }
    
    @Test
    void generatePerformanceCashflows_ShouldFilterForPerformanceTypes() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.PERFORMANCE, CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Mock the thread partitioning service
        Cashflow mockCashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            request.getPrimaryCalculationType(), CashflowType.PERFORMANCE,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "SYSTEM");
        
        when(threadPartitioningService.createPartitionKey(any(), any(), any()))
            .thenReturn(null); // Mock will be handled by the service
        when(threadPartitioningService.executeInPartition(any(), any()))
            .thenAnswer(invocation -> CompletableFuture.completedFuture(mockCashflow));
        
        // When
        Mono<CashflowGenerationResponse> result = cashflowGenerationService.generatePerformanceCashflows(request);
        
        // Then
        CashflowGenerationResponse response = result.block();
        assertThat(response).isNotNull();
        assertThat(response.getContractsProcessed()).isEqualTo(1);
    }
    
    @Test
    void isActorSystemRunning_ShouldDelegateToActorService() {
        // Given
        when(actorBasedCashflowService.isActorSystemRunning()).thenReturn(true);
        
        // When
        boolean result = cashflowGenerationService.isActorSystemRunning();
        
        // Then
        assertThat(result).isTrue();
    }
    
    @Test
    void getActorCount_ShouldDelegateToActorService() {
        // Given
        when(actorBasedCashflowService.getActorCount()).thenReturn(5);
        
        // When
        int result = cashflowGenerationService.getActorCount();
        
        // Then
        assertThat(result).isEqualTo(5);
    }
    
    @Test
    void getActorNames_ShouldDelegateToActorService() {
        // Given
        String[] expectedNames = {"actor1", "actor2", "actor3"};
        when(actorBasedCashflowService.getActorNames()).thenReturn(expectedNames);
        
        // When
        String[] result = cashflowGenerationService.getActorNames();
        
        // Then
        assertThat(result).isEqualTo(expectedNames);
    }
}
