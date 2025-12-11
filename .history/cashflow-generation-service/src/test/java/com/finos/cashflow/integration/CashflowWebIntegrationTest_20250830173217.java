package com.finos.cashflow.integration;

import com.finos.cashflow.model.*;
import com.finos.cashflow.repository.CashflowRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("integration")
@TestPropertySource(locations = "classpath:application-integration.yml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CashflowWebIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private CashflowRepository cashflowRepository;

    private UUID testContractId;
    private UUID testCashflowId;

    @BeforeEach
    void setUp() {
        testContractId = UUID.randomUUID();
        
        // Clean up any existing test data
        StepVerifier.create(cashflowRepository.deleteAll())
                .verifyComplete();
    }

    @Test
    @Order(1)
    void testHealthEndpoints() {
        // Test basic health endpoint
        webTestClient.get()
                .uri("/health")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");

        // Test detailed health endpoint
        webTestClient.get()
                .uri("/health/detailed")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");
    }

    @Test
    @Order(2)
    void testActorSystemEndpoints() {
        // Test actor status
        webTestClient.get()
                .uri("/actors/status")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalActors").exists()
                .jsonPath("$.activeActors").exists();

        // Test actor count
        webTestClient.get()
                .uri("/actors/count")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.count").exists();

        // Test actor names
        webTestClient.get()
                .uri("/actors/names")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.names").isArray();
    }

    @Test
    @Order(3)
    void testThreadPartitioningEndpoints() {
        // Test thread partitions status
        webTestClient.get()
                .uri("/threads/partitions")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists()
                .jsonPath("$.activePartitions").exists();
    }

    @Test
    @Order(4)
    void testCashflowGenerationEndpoints() {
        // Test basic cashflow generation
        CashflowGenerationRequest request = createBasicGenerationRequest();

        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.contractsProcessed").exists();

        // Test interest cashflow generation
        InterestCashflowGenerationRequest interestRequest = new InterestCashflowGenerationRequest();
        interestRequest.setContractIds(Arrays.asList(testContractId));
        interestRequest.setCalculationDate(LocalDate.now());
        interestRequest.setInterestRate(BigDecimal.valueOf(0.05));
        interestRequest.setDayCountConvention(InterestCashflowGenerationRequest.DayCountConvention.ACT_365);

        webTestClient.post()
                .uri("/cashflows/generate/interest")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(interestRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();

        // Test dividend cashflow generation
        DividendCashflowGenerationRequest dividendRequest = new DividendCashflowGenerationRequest();
        dividendRequest.setContractIds(Arrays.asList(testContractId));
        dividendRequest.setDividendDate(LocalDate.now());
        dividendRequest.setDividendAmount(BigDecimal.valueOf(50.00));
        dividendRequest.setDividendType("ORDINARY");

        webTestClient.post()
                .uri("/cashflows/generate/dividend")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(dividendRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();

        // Test performance cashflow generation
        PerformanceCashflowGenerationRequest performanceRequest = new PerformanceCashflowGenerationRequest();
        performanceRequest.setContractIds(Arrays.asList(testContractId));
        performanceRequest.setValuationDate(LocalDate.now());
        performanceRequest.setIncludeComponents(true);

        webTestClient.post()
                .uri("/cashflows/generate/performance")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(performanceRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(5)
    void testActorBasedGeneration() {
        CashflowGenerationRequest request = createBasicGenerationRequest();

        webTestClient.post()
                .uri("/cashflows/generate/actor")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(6)
    void testReactiveGeneration() {
        CashflowGenerationRequest request = createBasicGenerationRequest();

        webTestClient.post()
                .uri("/cashflows/generate/reactive")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_STREAM_JSON);
    }

    @Test
    @Order(7)
    void testDailyAccrualGeneration() {
        DailyAccrualGenerationRequest request = new DailyAccrualGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setStartDate(LocalDate.now().minusDays(7));
        request.setEndDate(LocalDate.now());
        request.setAccrualTypes(Arrays.asList("INTEREST"));

        webTestClient.post()
                .uri("/cashflows/accruals/daily")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(8)
    void testBatchOperations() {
        // Test batch cashflow generation
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest();
        batchRequest.setRequests(Arrays.asList(
                createBasicGenerationRequest(),
                createBasicGenerationRequest()
        ));

        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.totalRequests").isEqualTo(2);

        // Test batch interest generation
        BatchInterestGenerationRequest batchInterestRequest = new BatchInterestGenerationRequest();
        batchInterestRequest.setContractIds(Arrays.asList(testContractId, UUID.randomUUID()));
        batchInterestRequest.setCalculationDate(LocalDate.now());
        batchInterestRequest.setInterestRate(BigDecimal.valueOf(0.03));

        webTestClient.post()
                .uri("/cashflows/generate/interest/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchInterestRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();

        // Test batch equity generation
        BatchEquityGenerationRequest batchEquityRequest = new BatchEquityGenerationRequest();
        batchEquityRequest.setContractIds(Arrays.asList(testContractId, UUID.randomUUID()));
        batchEquityRequest.setValuationDate(LocalDate.now());

        webTestClient.post()
                .uri("/cashflows/generate/equity/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchEquityRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(9)
    void testCashflowQueryEndpoints() {
        // First, create a test cashflow
        createTestCashflow();

        // Test search cashflows
        webTestClient.get()
                .uri("/cashflows?page=0&size=10")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isArray()
                .jsonPath("$.totalElements").exists();

        // Test search with filters
        webTestClient.get()
                .uri("/cashflows?cashflowType=INTEREST&page=0&size=5")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isArray();

        // Test get cashflow by ID (will work with any existing cashflow)
        if (testCashflowId != null) {
            webTestClient.get()
                    .uri("/cashflows/{cashflowId}", testCashflowId)
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.id").isEqualTo(testCashflowId.toString());
        }
    }

    @Test
    @Order(10)
    void testCashflowStateManagement() {
        // First, create a test cashflow
        createTestCashflow();

        if (testCashflowId != null) {
            // Test status update
            CashflowStatusUpdateRequest statusRequest = new CashflowStatusUpdateRequest();
            statusRequest.setNewStatus(CashflowStatus.REALIZED_DEFERRED);
            statusRequest.setReason("Integration test");

            webTestClient.patch()
                    .uri("/cashflows/{cashflowId}/status", testCashflowId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(statusRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.cashflowStatus").isEqualTo("REALIZED_DEFERRED");

            // Test deferral
            CashflowDeferralRequest deferralRequest = new CashflowDeferralRequest();
            deferralRequest.setDeferralReason(DeferralReason.BUSINESS_RULE);
            deferralRequest.setExpectedRealizationDate(LocalDate.now().plusDays(30));

            webTestClient.post()
                    .uri("/cashflows/{cashflowId}/defer", testCashflowId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(deferralRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.deferralReason").isEqualTo("BUSINESS_RULE");

            // Test realization
            CashflowRealizationRequest realizationRequest = new CashflowRealizationRequest();
            realizationRequest.setRealizationDate(LocalDate.now());
            realizationRequest.setRealizationAmount(BigDecimal.valueOf(1000.00));

            webTestClient.post()
                    .uri("/cashflows/{cashflowId}/realize", testCashflowId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(realizationRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.cashflowStatus").isEqualTo("REALIZED_UNSETTLED");

            // Test settlement
            CashflowSettlementRequest settlementRequest = new CashflowSettlementRequest();
            settlementRequest.setSettlementDate(LocalDate.now());
            settlementRequest.setSettlementAmount(BigDecimal.valueOf(1000.00));
            settlementRequest.setPaymentReference("TEST-REF");

            webTestClient.post()
                    .uri("/cashflows/{cashflowId}/settle", testCashflowId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(settlementRequest)
                    .exchange()
                    .expectStatus().isOk()
                    .expectBody()
                    .jsonPath("$.cashflowStatus").isEqualTo("REALIZED_SETTLED");
        }
    }

    @Test
    @Order(11)
    void testErrorHandling() {
        // Test invalid request - empty contract IDs
        CashflowGenerationRequest invalidRequest = new CashflowGenerationRequest();
        invalidRequest.setContractIds(Arrays.asList());
        invalidRequest.setCalculationDate(LocalDate.now());

        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(invalidRequest)
                .exchange()
                .expectStatus().isBadRequest();

        // Test non-existent cashflow
        webTestClient.get()
                .uri("/cashflows/{cashflowId}", UUID.randomUUID())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(12)
    void testServerSentEventsGeneration() {
        CashflowGenerationRequest request = createBasicGenerationRequest();

        webTestClient.post()
                .uri("/cashflows/generate/stream")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .accept(MediaType.TEXT_EVENT_STREAM)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM);
    }

    private void createTestCashflow() {
        Cashflow cashflow = new Cashflow();
        cashflow.setId(UUID.randomUUID());
        cashflow.setContractId(testContractId);
        cashflow.setLegId(UUID.randomUUID());
        cashflow.setCashflowType(CashflowType.INTEREST);
        cashflow.setCashflowStatus(CashflowStatus.ACCRUED);
        cashflow.setAmount(BigDecimal.valueOf(1000.00));
        cashflow.setCurrency("USD");
        cashflow.setCalculationDate(LocalDate.now());
        cashflow.setPaymentDate(LocalDate.now().plusDays(30));
        cashflow.setPayerPartyId(UUID.randomUUID());
        cashflow.setReceiverPartyId(UUID.randomUUID());

        StepVerifier.create(cashflowRepository.save(cashflow))
                .assertNext(saved -> testCashflowId = saved.getId())
                .verifyComplete();
    }

    private CashflowGenerationRequest createBasicGenerationRequest() {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setPrimaryCalculationType(CalculationType.INTEREST);
        return request;
    }
}
