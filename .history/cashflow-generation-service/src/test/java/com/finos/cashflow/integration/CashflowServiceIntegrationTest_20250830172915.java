package com.finos.cashflow.integration;

import com.finos.cashflow.model.*;
import com.finos.cashflow.repository.CashflowRepository;
import com.finos.cashflow.repository.DailyAccrualRepository;
import com.finos.cashflow.service.CashflowGenerationService;
import com.finos.cashflow.service.CashflowQueryService;
import com.finos.cashflow.service.CashflowStateManagementService;
import com.finos.cashflow.service.ActorBasedCashflowService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("integration")
@TestPropertySource(locations = "classpath:application-integration.yml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CashflowServiceIntegrationTest {

    @Autowired
    private CashflowGenerationService cashflowGenerationService;

    @Autowired
    private ActorBasedCashflowService actorBasedCashflowService;

    @Autowired
    private CashflowQueryService cashflowQueryService;

    @Autowired
    private CashflowStateManagementService stateManagementService;

    @Autowired
    private CashflowRepository cashflowRepository;

    @Autowired
    private DailyAccrualRepository dailyAccrualRepository;

    private UUID testContractId;
    private UUID testLegId;
    private UUID testCashflowId;

    @BeforeEach
    void setUp() {
        testContractId = UUID.randomUUID();
        testLegId = UUID.randomUUID();
        
        // Clean up any existing test data
        StepVerifier.create(cashflowRepository.deleteAll())
                .verifyComplete();
        
        StepVerifier.create(dailyAccrualRepository.deleteAll())
                .verifyComplete();
    }

    @Test
    @Order(1)
    void testBasicCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setLegIds(Arrays.asList(testLegId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setPrimaryCalculationType(CalculationType.INTEREST);

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
    @Order(2)
    void testInterestCashflowGeneration() {
        // Given
        InterestCashflowGenerationRequest request = new InterestCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setInterestRate(BigDecimal.valueOf(0.05));
        request.setDayCountConvention("ACT_365");
        request.setBusinessDayAdjustment("FOLLOWING");

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateInterestCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(3)
    void testActorBasedCashflowGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setPrimaryCalculationType(CalculationType.INTEREST);

        // When & Then
        StepVerifier.create(actorBasedCashflowService.generateCashflowsAsync(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(4)
    void testDailyAccrualGeneration() {
        // Given
        DailyAccrualGenerationRequest request = new DailyAccrualGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setStartDate(LocalDate.now().minusDays(7));
        request.setEndDate(LocalDate.now());
        request.setAccrualTypes(Arrays.asList("INTEREST"));
        request.setBusinessDayAdjustment("FOLLOWING");

        // When & Then
        StepVerifier.create(actorBasedCashflowService.generateDailyAccrualsAsync(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(5)
    void testCashflowPersistenceAndRetrieval() {
        // Given - Create a test cashflow
        Cashflow cashflow = createTestCashflow();

        // When - Save and retrieve
        StepVerifier.create(cashflowRepository.save(cashflow))
                .assertNext(saved -> {
                    assertNotNull(saved.getId());
                    testCashflowId = saved.getId();
                    assertEquals(testContractId, saved.getContractId());
                    assertEquals(CashflowType.INTEREST, saved.getCashflowType());
                    assertEquals(CashflowStatus.ACCRUED, saved.getCashflowStatus());
                })
                .verifyComplete();

        // Then - Verify retrieval
        StepVerifier.create(cashflowRepository.findById(testCashflowId))
                .assertNext(retrieved -> {
                    assertEquals(testCashflowId, retrieved.getId());
                    assertEquals(testContractId, retrieved.getContractId());
                })
                .verifyComplete();
    }

    @Test
    @Order(6)
    void testCashflowQueryService() {
        // Given - Ensure we have a cashflow from previous test
        assertNotNull(testCashflowId, "Cashflow should exist from previous test");

        // When & Then - Test query by contract ID
        StepVerifier.create(cashflowQueryService.getCashflowsByContractId(testContractId))
                .expectNextCount(1)
                .verifyComplete();

        // Test query by cashflow type
        StepVerifier.create(cashflowQueryService.getCashflowsByType(CashflowType.INTEREST))
                .expectNextCount(1)
                .verifyComplete();

        // Test get by ID
        StepVerifier.create(cashflowQueryService.getCashflowById(testCashflowId))
                .assertNext(cashflow -> {
                    assertEquals(testCashflowId, cashflow.getId());
                    assertEquals(testContractId, cashflow.getContractId());
                })
                .verifyComplete();
    }

    @Test
    @Order(7)
    void testCashflowStateTransitions() {
        // Given - Ensure we have a cashflow
        assertNotNull(testCashflowId, "Cashflow should exist from previous test");

        // When & Then - Test deferral
        CashflowDeferralRequest deferralRequest = new CashflowDeferralRequest();
        deferralRequest.setDeferralReason(DeferralReason.BUSINESS_RULE);
        deferralRequest.setExpectedRealizationDate(LocalDate.now().plusDays(30));
        deferralRequest.setBusinessJustification("Testing deferral");

        StepVerifier.create(stateManagementService.deferCashflow(testCashflowId, deferralRequest))
                .assertNext(deferred -> {
                    assertEquals(CashflowStatus.REALIZED_DEFERRED, deferred.getCashflowStatus());
                    assertEquals(DeferralReason.BUSINESS_RULE, deferred.getDeferralReason());
                })
                .verifyComplete();

        // Test realization
        CashflowRealizationRequest realizationRequest = new CashflowRealizationRequest();
        realizationRequest.setRealizationDate(LocalDate.now());
        realizationRequest.setRealizationAmount(BigDecimal.valueOf(1000.00));

        StepVerifier.create(stateManagementService.realizeCashflow(testCashflowId, realizationRequest))
                .assertNext(realized -> {
                    assertEquals(CashflowStatus.REALIZED_UNSETTLED, realized.getCashflowStatus());
                })
                .verifyComplete();

        // Test settlement
        CashflowSettlementRequest settlementRequest = new CashflowSettlementRequest();
        settlementRequest.setSettlementDate(LocalDate.now());
        settlementRequest.setSettlementAmount(BigDecimal.valueOf(1000.00));
        settlementRequest.setPaymentReference("TEST-PAYMENT-REF");

        StepVerifier.create(stateManagementService.settleCashflow(testCashflowId, settlementRequest))
                .assertNext(settled -> {
                    assertEquals(CashflowStatus.REALIZED_SETTLED, settled.getCashflowStatus());
                    assertEquals("TEST-PAYMENT-REF", settled.getPaymentReference());
                })
                .verifyComplete();
    }

    @Test
    @Order(8)
    void testBatchOperations() {
        // Given
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest();
        
        CashflowGenerationRequest request1 = new CashflowGenerationRequest();
        request1.setContractIds(Arrays.asList(UUID.randomUUID()));
        request1.setCalculationDate(LocalDate.now());
        request1.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request1.setPrimaryCalculationType(CalculationType.INTEREST);

        CashflowGenerationRequest request2 = new CashflowGenerationRequest();
        request2.setContractIds(Arrays.asList(UUID.randomUUID()));
        request2.setCalculationDate(LocalDate.now());
        request2.setCashflowTypes(Arrays.asList(CashflowType.DIVIDEND));
        request2.setPrimaryCalculationType(CalculationType.EQUITY);

        batchRequest.setRequests(Arrays.asList(request1, request2));

        // When & Then
        StepVerifier.create(cashflowGenerationService.generateCashflowsBatch(batchRequest))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                    assertEquals(2, response.getTotalRequests());
                    assertEquals(2, response.getAcceptedRequests());
                    assertEquals(0, response.getRejectedRequests());
                })
                .verifyComplete();
    }

    @Test
    @Order(9)
    void testReactiveStreamingGeneration() {
        // Given
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId, UUID.randomUUID()));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setPrimaryCalculationType(CalculationType.INTEREST);

        // When & Then - Test reactive generation
        Flux<Cashflow> cashflowStream = cashflowGenerationService.generateCashflowsReactive(request);

        StepVerifier.create(cashflowStream)
                .expectNextCount(2) // Should generate cashflows for 2 contracts
                .verifyComplete();
    }

    @Test
    @Order(10)
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
    @Order(11)
    void testDatabaseConstraintsAndValidation() {
        // Given - Cashflow with invalid data
        Cashflow invalidCashflow = new Cashflow();
        invalidCashflow.setId(UUID.randomUUID());
        // Missing required fields

        // When & Then - Should fail validation
        StepVerifier.create(cashflowRepository.save(invalidCashflow))
                .expectError()
                .verify();
    }

    @Test
    @Order(12)
    void testConcurrentOperations() {
        // Given - Multiple concurrent requests
        List<CashflowGenerationRequest> requests = Arrays.asList(
                createGenerationRequest(UUID.randomUUID()),
                createGenerationRequest(UUID.randomUUID()),
                createGenerationRequest(UUID.randomUUID())
        );

        // When - Execute concurrently
        Flux<CashflowGenerationResponse> responses = Flux.fromIterable(requests)
                .flatMap(req -> cashflowGenerationService.generateCashflows(req));

        // Then - All should complete successfully
        StepVerifier.create(responses)
                .expectNextCount(3)
                .verifyComplete();
    }

    private Cashflow createTestCashflow() {
        Cashflow cashflow = new Cashflow();
        cashflow.setId(UUID.randomUUID());
        cashflow.setContractId(testContractId);
        cashflow.setLegId(testLegId);
        cashflow.setCashflowType(CashflowType.INTEREST);
        cashflow.setCashflowStatus(CashflowStatus.ACCRUED);
        cashflow.setAmount(BigDecimal.valueOf(1000.00));
        cashflow.setCurrency("USD");
        cashflow.setCalculationDate(LocalDate.now());
        cashflow.setPaymentDate(LocalDate.now().plusDays(30));
        cashflow.setPayerPartyId(UUID.randomUUID());
        cashflow.setReceiverPartyId(UUID.randomUUID());
        return cashflow;
    }

    private CashflowGenerationRequest createGenerationRequest(UUID contractId) {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(contractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setPrimaryCalculationType(CalculationType.INTEREST);
        return request;
    }
}
