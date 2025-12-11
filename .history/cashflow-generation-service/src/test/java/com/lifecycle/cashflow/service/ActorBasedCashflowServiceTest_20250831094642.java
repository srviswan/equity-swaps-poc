package com.lifecycle.cashflow.service;

import com.lifecycle.cashflow.model.Cashflow;
import com.lifecycle.cashflow.model.CashflowGenerationRequest;
import com.lifecycle.cashflow.model.CashflowGenerationResponse;
import com.lifecycle.cashflow.model.CashflowType;
import com.lifecycle.cashflow.repository.CashflowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for the Actor-based cashflow service.
 * 
 * These tests verify that the Actor pattern works correctly with Project Reactor
 * for cashflow generation.
 */
@ExtendWith(MockitoExtension.class)
class ActorBasedCashflowServiceTest {
    
    @Mock
    private CashflowRepository cashflowRepository;
    
    private ActorBasedCashflowService actorBasedCashflowService;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        actorBasedCashflowService = new ActorBasedCashflowService(cashflowRepository);
    }
    
    @Test
    void generateCashflows_ShouldReturnAcceptedResponse() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // When
        Flux<Cashflow> result = actorBasedCashflowService.generateCashflows(request);
        
        // Then
        StepVerifier.create(result)
            .assertNext(cashflow -> {
                assertThat(cashflow.getContractId()).isEqualTo(contractId);
                assertThat(cashflow.getCashflowType()).isEqualTo(CashflowType.INTEREST);
                assertThat(cashflow.getAmount()).isNotNull();
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
        
        // When
        Flux<Cashflow> result = actorBasedCashflowService.generateCashflows(request);
        
        // Then
        StepVerifier.create(result)
            .expectNextCount(2) // Should generate 2 cashflows (one per contract)
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
        
        // When
        Flux<Cashflow> result = actorBasedCashflowService.generateCashflowsReactive(request);
        
        // Then
        StepVerifier.create(result)
            .assertNext(cashflow -> {
                assertThat(cashflow.getContractId()).isEqualTo(contractId);
                assertThat(cashflow.getCalculationType()).isNotNull();
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
        
        // When
        Flux<Cashflow> result = actorBasedCashflowService.generateDailyAccruals(
            List.of(contractId), startDate, endDate);
        
        // Then
        StepVerifier.create(result)
            .expectNextCount(8) // 7 days + 1 (inclusive)
            .verifyComplete();
    }
    
    @Test
    void getActorStatistics_ShouldReturnActorState() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Trigger actor creation
        actorBasedCashflowService.generateCashflows(request).block();
        
        String actorName = "contract-" + contractId;
        
        // When
        Mono<CashflowGenerationActorState> result = actorBasedCashflowService.getActorStatistics(actorName);
        
        // Then
        StepVerifier.create(result)
            .assertNext(state -> {
                assertThat(state.getActorName()).isEqualTo(actorName);
                assertThat(state.getTotalMessagesProcessed()).isGreaterThan(0);
                assertThat(state.getTotalCashflowsGenerated()).isGreaterThan(0);
            })
            .verifyComplete();
    }
    
    @Test
    void getActorNames_ShouldReturnAllActorNames() {
        // Given
        UUID contractId1 = UUID.randomUUID();
        UUID contractId2 = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId1, contractId2), calculationDate, cashflowTypes);
        
        // Trigger actor creation
        actorBasedCashflowService.generateCashflows(request).block();
        
        // When
        String[] actorNames = actorBasedCashflowService.getActorNames();
        
        // Then
        assertThat(actorNames).hasSize(2);
        assertThat(actorNames).contains("contract-" + contractId1);
        assertThat(actorNames).contains("contract-" + contractId2);
    }
    
    @Test
    void getActorCount_ShouldReturnCorrectCount() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Trigger actor creation
        actorBasedCashflowService.generateCashflows(request).block();
        
        // When
        int actorCount = actorBasedCashflowService.getActorCount();
        
        // Then
        assertThat(actorCount).isEqualTo(1);
    }
    
    @Test
    void isActorSystemRunning_ShouldReturnTrue() {
        // When
        boolean isRunning = actorBasedCashflowService.isActorSystemRunning();
        
        // Then
        assertThat(isRunning).isTrue();
    }
    
    @Test
    void stopActor_ShouldStopSpecificActor() {
        // Given
        UUID contractId = UUID.randomUUID();
        LocalDate calculationDate = LocalDate.now();
        List<CashflowType> cashflowTypes = List.of(CashflowType.INTEREST);
        
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, cashflowTypes);
        
        // Trigger actor creation
        actorBasedCashflowService.generateCashflows(request).block();
        
        String actorName = "contract-" + contractId;
        
        // When
        Mono<Void> result = actorBasedCashflowService.stopActor(actorName);
        
        // Then
        StepVerifier.create(result)
            .verifyComplete();
        
        // Verify actor is removed
        assertThat(actorBasedCashflowService.getActorCount()).isEqualTo(0);
    }
    
    @Test
    void stopActor_WithNonExistentActor_ShouldReturnError() {
        // Given
        String nonExistentActorName = "non-existent-actor";
        
        // When
        Mono<Void> result = actorBasedCashflowService.stopActor(nonExistentActorName);
        
        // Then
        StepVerifier.create(result)
            .expectError(IllegalArgumentException.class)
            .verify();
    }
    
    @Test
    void getActorStatistics_WithNonExistentActor_ShouldReturnError() {
        // Given
        String nonExistentActorName = "non-existent-actor";
        
        // When
        Mono<CashflowGenerationActorState> result = actorBasedCashflowService.getActorStatistics(nonExistentActorName);
        
        // Then
        StepVerifier.create(result)
            .expectError(IllegalArgumentException.class)
            .verify();
    }
}
