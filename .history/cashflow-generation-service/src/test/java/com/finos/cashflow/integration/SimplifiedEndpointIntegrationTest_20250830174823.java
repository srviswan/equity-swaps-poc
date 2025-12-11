package com.finos.cashflow.integration;

import com.finos.cashflow.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.UUID;
import java.time.Duration;

/**
 * Simplified integration test that validates core endpoints with correct model usage.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SimplifiedEndpointIntegrationTest {

    @LocalServerPort
    private int port;

    private WebTestClient webTestClient;

    @BeforeEach
    void setUp() {
        this.webTestClient = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .responseTimeout(Duration.ofSeconds(30))
                .build();
    }

    @Test
    @Order(1)
    void testHealthEndpoint() {
        webTestClient.get().uri("/health")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").exists();
    }

    @Test
    @Order(2) 
    void testBasicCashflowGeneration() {
        CashflowGenerationRequest request = createBasicRequest();
        
        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.status").isEqualTo("ACCEPTED");
    }

    @Test
    @Order(3)
    void testInterestCashflowGeneration() {
        InterestCashflowGenerationRequest request = new InterestCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        request.setCalculationDate(LocalDate.now());
        request.setInterestRate(BigDecimal.valueOf(0.05));
        
        webTestClient.post()
                .uri("/cashflows/generate/interest")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(4)
    void testDividendCashflowGeneration() {
        DividendCashflowGenerationRequest request = new DividendCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        request.setDividendAmount(BigDecimal.valueOf(50.0));
        
        webTestClient.post()
                .uri("/cashflows/generate/dividend")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(5)
    void testPerformanceCashflowGeneration() {
        PerformanceCashflowGenerationRequest request = new PerformanceCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        
        webTestClient.post()
                .uri("/cashflows/generate/performance")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(6)
    void testBatchCashflowGeneration() {
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest();
        batchRequest.setRequests(Arrays.asList(createBasicRequest()));
        
        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(7)
    void testReactiveCashflowGeneration() {
        CashflowGenerationRequest request = createBasicRequest();
        
        webTestClient.post()
                .uri("/cashflows/generate/reactive")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(8)
    void testStreamingCashflowGeneration() {
        CashflowGenerationRequest request = createBasicRequest();
        
        webTestClient.post()
                .uri("/cashflows/generate/stream")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM);
    }

    @Test
    @Order(9)
    void testActorBasedCashflowGeneration() {
        CashflowGenerationRequest request = createBasicRequest();
        
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
    @Order(10)
    void testDailyAccrualsGeneration() {
        DailyAccrualGenerationRequest request = new DailyAccrualGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        request.setStartDate(LocalDate.now().minusDays(7));
        request.setEndDate(LocalDate.now());
        
        webTestClient.post()
                .uri("/cashflows/generate/daily-accruals")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(11)
    void testCashflowQuery() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cashflows")
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").exists()
                .jsonPath("$.totalElements").exists();
    }

    @Test
    @Order(12)
    void testCashflowSearch() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cashflows/search")
                        .queryParam("contractId", UUID.randomUUID().toString())
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(13)
    void testCashflowStatusUpdate() {
        CashflowStatusUpdateRequest request = new CashflowStatusUpdateRequest();
        request.setCashflowIds(Arrays.asList(UUID.randomUUID()));
        request.setNewStatus(CashflowStatus.REALIZED_DEFERRED);
        request.setUpdatedBy("integration-test");
        
        webTestClient.put()
                .uri("/cashflows/status")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(14)
    void testCashflowDeferral() {
        CashflowDeferralRequest request = new CashflowDeferralRequest();
        request.setDeferralReason(CashflowDeferralRequest.DeferralReason.MARKET_CONDITIONS);
        request.setExpectedRealizationDate(LocalDate.now().plusDays(30));
        request.setBusinessJustification("Market conditions require deferral");
        
        webTestClient.put()
                .uri("/cashflows/defer")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(15)
    void testCashflowRealization() {
        CashflowRealizationRequest request = new CashflowRealizationRequest();
        request.setCashflowIds(Arrays.asList(UUID.randomUUID()));
        request.setRealizedAmount(BigDecimal.valueOf(100000.0));
        request.setRealizedDate(LocalDate.now());
        request.setUpdatedBy("integration-test");
        
        webTestClient.put()
                .uri("/cashflows/realize")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(16)
    void testCashflowSettlement() {
        CashflowSettlementRequest request = new CashflowSettlementRequest();
        request.setCashflowIds(Arrays.asList(UUID.randomUUID()));
        request.setSettlementDate(LocalDate.now());
        request.setSettlementAmount(BigDecimal.valueOf(100000.0));
        request.setUpdatedBy("integration-test");
        
        webTestClient.put()
                .uri("/cashflows/settle")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @Order(17)
    void testThreadPartitioningStatus() {
        webTestClient.get()
                .uri("/threads/partitions")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists();
    }

    @Test
    @Order(18)
    void testBatchInterestGeneration() {
        BatchInterestGenerationRequest request = new BatchInterestGenerationRequest();
        request.setInterestRequests(Arrays.asList(createInterestRequest()));
        
        webTestClient.post()
                .uri("/cashflows/generate/interest/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(19)
    void testBatchEquityGeneration() {
        BatchEquityGenerationRequest request = new BatchEquityGenerationRequest();
        request.setEquityRequests(Arrays.asList(createPerformanceRequest()));
        
        webTestClient.post()
                .uri("/cashflows/generate/equity/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(20)
    void testDetailedHealthCheck() {
        webTestClient.get()
                .uri("/health/detailed")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").exists()
                .jsonPath("$.components").exists();
    }

    @Test
    @Order(21)
    void testErrorHandling() {
        // Test with invalid request
        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"invalid\": \"json\"}")
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    @Order(22)
    void testLargeDataHandling() {
        // Test with larger payload
        CashflowGenerationRequest request = createBasicRequest();
        // Add multiple contract IDs
        for (int i = 0; i < 20; i++) {
            request.getContractIds().add(UUID.randomUUID());
        }
        
        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    // Helper methods
    private CashflowGenerationRequest createBasicRequest() {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setCalculationDate(LocalDate.now());
        request.setCreatedBy("integration-test");
        return request;
    }

    private InterestCashflowGenerationRequest createInterestRequest() {
        InterestCashflowGenerationRequest request = new InterestCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        request.setCalculationDate(LocalDate.now());
        request.setInterestRate(BigDecimal.valueOf(0.05));
        return request;
    }

    private PerformanceCashflowGenerationRequest createPerformanceRequest() {
        PerformanceCashflowGenerationRequest request = new PerformanceCashflowGenerationRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID()));
        return request;
    }
}
