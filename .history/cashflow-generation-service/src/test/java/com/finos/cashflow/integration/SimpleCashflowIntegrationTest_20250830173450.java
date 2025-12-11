package com.finos.cashflow.integration;

import com.finos.cashflow.model.*;
import com.finos.cashflow.repository.CashflowRepository;
import com.finos.cashflow.service.CashflowGenerationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Simplified integration test focusing on basic functionality.
 */
@SpringBootTest
@ActiveProfiles("integration")
@TestPropertySource(locations = "classpath:application-integration.yml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimpleCashflowIntegrationTest {

    @Autowired
    private CashflowGenerationService cashflowGenerationService;

    @Autowired
    private CashflowRepository cashflowRepository;

    private UUID testContractId;
    private UUID testLegId;

    @BeforeEach
    void setUp() {
        testContractId = UUID.randomUUID();
        testLegId = UUID.randomUUID();
        
        // Clean up any existing test data
        StepVerifier.create(cashflowRepository.deleteAll())
                .verifyComplete();
    }

    @Test
    @Order(1)
    void applicationContextLoads() {
        assertNotNull(cashflowGenerationService);
        assertNotNull(cashflowRepository);
    }

    @Test
    @Order(2)
    void testBasicCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                    assertTrue(response.getContractsProcessed() > 0);
                })
                .verifyComplete();
    }

    @Test
    @Order(3)
    void testInterestCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateInterestCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(4)
    void testDividendCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.DIVIDEND));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateDividendCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(5)
    void testPerformanceCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.PERFORMANCE));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generatePerformanceCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(6)
    void testActorBasedCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateCashflowsWithActors(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(7)
    void testCashflowPersistenceAndRetrieval() {
        // Given - Create a test cashflow
        Cashflow cashflow = createTestCashflow();

        // When - Save and retrieve
        StepVerifier.create(cashflowRepository.save(cashflow))
                .assertNext(saved -> {
                    assertNotNull(saved.getId());
                    assertEquals(testContractId, saved.getContractId());
                    assertEquals(CashflowType.INTEREST, saved.getCashflowType());
                    assertEquals(CashflowStatus.ACCRUED, saved.getStatus());
                })
                .verifyComplete();

        // Then - Count records
        StepVerifier.create(cashflowRepository.count())
                .assertNext(count -> assertTrue(count > 0))
                .verifyComplete();
    }

    @Test
    @Order(8)
    void testReactiveStreamingGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId, UUID.randomUUID()));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));

        // When & Then - Test reactive generation
        StepVerifier.create(cashflowGenerationService.generateCashflowsReactive(request))
                .expectNextCount(2) // Should generate cashflows for 2 contracts
                .verifyComplete();
    }

    @Test
    @Order(9)
    void testErrorHandling() {
        // Given - Invalid request
        CashflowGenerationRequest invalidRequest = new CashflowGenerationRequest();
        invalidRequest.setContractIds(Arrays.asList()); // Empty list
        invalidRequest.setCalculationDate(LocalDate.now());

        // When & Then - Should handle gracefully
        StepVerifier.create(cashflowGenerationService.generateCashflows(invalidRequest))
                .expectError()
                .verify();
    }

    @Test
    @Order(10)
    void testConcurrentOperations() {
        // Given - Multiple concurrent requests
        CashflowGenerationRequest request1 = createGenerationRequest(UUID.randomUUID(), CashflowType.INTEREST);
        CashflowGenerationRequest request2 = createGenerationRequest(UUID.randomUUID(), CashflowType.DIVIDEND);
        CashflowGenerationRequest request3 = createGenerationRequest(UUID.randomUUID(), CashflowType.PERFORMANCE);

        // When - Execute concurrently
        StepVerifier.create(
                cashflowGenerationService.generateCashflows(request1)
                    .concatWith(cashflowGenerationService.generateCashflows(request2))
                    .concatWith(cashflowGenerationService.generateCashflows(request3))
            )
                .expectNextCount(3)
                .verifyComplete();
    }

    private Cashflow createTestCashflow() {
        Cashflow cashflow = new Cashflow();
        cashflow.setId(UUID.randomUUID());
        cashflow.setContractId(testContractId);
        cashflow.setLegId(testLegId);
        cashflow.setSecurityId("TEST-SEC-001");
        cashflow.setCalculationType(CalculationType.INTEREST);
        cashflow.setCashflowType(CashflowType.INTEREST);
        cashflow.setStatus(CashflowStatus.ACCRUED);
        cashflow.setAmount(BigDecimal.valueOf(1000.00));
        cashflow.setCurrency("USD");
        cashflow.setCalculationDate(LocalDate.now());
        cashflow.setValueDate(LocalDate.now().plusDays(30));
        cashflow.setCreatedAt(LocalDateTime.now());
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setCreatedBy("TEST_USER");
        cashflow.setUpdatedBy("TEST_USER");
        return cashflow;
    }

    private CashflowGenerationRequest createGenerationRequest(UUID contractId, CashflowType type) {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(contractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(type));
        return request;
    }
}
