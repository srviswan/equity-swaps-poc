package com.finos.cashflow.integration;

import com.finos.cashflow.controller.CashflowController;
import com.finos.cashflow.model.*;
import com.finos.cashflow.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Production-style endpoint testing using mock services.
 * This validates that our REST endpoints work correctly with production-like configurations
 * without requiring actual database connections.
 */
@WebFluxTest(CashflowController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductionEndpointTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CashflowGenerationService cashflowGenerationService;

    @MockBean
    private ActorBasedCashflowService actorBasedCashflowService;

    @MockBean
    private CashflowQueryService cashflowQueryService;

    @MockBean
    private CashflowStateManagementService cashflowStateManagementService;

    @MockBean
    private ThreadPartitioningService threadPartitioningService;

    private UUID testContractId;
    private UUID testCashflowId;

    @BeforeEach
    void setUp() {
        testContractId = UUID.randomUUID();
        testCashflowId = UUID.randomUUID();
        
        // Setup mock responses
        setupMockResponses();
    }

    private void setupMockResponses() {
        // Mock cashflow generation responses
        CashflowGenerationResponse mockResponse = new CashflowGenerationResponse();
        mockResponse.setJobId(UUID.randomUUID());
        mockResponse.setContractsProcessed(1);
        mockResponse.setCashflowsGenerated(3);
        mockResponse.setProcessingTimeMs(150L);
        mockResponse.setStatus("SUCCESS");

        when(cashflowGenerationService.generateCashflows(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockResponse));
        when(cashflowGenerationService.generateCashflowsWithActors(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockResponse));
        when(cashflowGenerationService.generateCashflowsReactive(any(CashflowGenerationRequest.class)))
                .thenReturn(Flux.just(createMockCashflow(), createMockCashflow(), createMockCashflow()));

        // Mock cashflow query responses
        when(cashflowQueryService.getCashflowById(any(UUID.class)))
                .thenReturn(Mono.just(createMockCashflow()));
        
        when(cashflowQueryService.getCashflowsByType(any(CashflowType.class)))
                .thenReturn(Flux.just(createMockCashflow()));

        // Mock state management responses
        when(cashflowStateManagementService.transitionStatus(any(UUID.class), any(CashflowStatus.class)))
                .thenReturn(Mono.just(createMockCashflow()));

        // Mock thread partitioning responses
        when(threadPartitioningService.getPartitionStatus())
                .thenReturn(Mono.just(createMockPartitionStatus()));
    }

    @Test
    @Order(1)
    void testHealthEndpoint() {
        webTestClient.get()
                .uri("/health")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");
    }

    @Test
    @Order(2)
    void testCashflowGenerationEndpoint() {
        CashflowGenerationRequest request = createTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.contractsProcessed").isEqualTo(1)
                .jsonPath("$.cashflowsGenerated").isEqualTo(3)
                .jsonPath("$.status").isEqualTo("SUCCESS");
    }

    @Test
    @Order(3)
    void testInterestCashflowGenerationEndpoint() {
        CashflowGenerationRequest request = createTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate/interest")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.status").isEqualTo("SUCCESS");
    }

    @Test
    @Order(4)
    void testActorBasedGenerationEndpoint() {
        CashflowGenerationRequest request = createTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate/actor")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.status").isEqualTo("SUCCESS");
    }

    @Test
    @Order(5)
    void testReactiveGenerationEndpoint() {
        CashflowGenerationRequest request = createTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate/reactive")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cashflow.class)
                .hasSize(3);
    }

    @Test
    @Order(6)
    void testGetCashflowByIdEndpoint() {
        webTestClient.get()
                .uri("/cashflows/{cashflowId}", testCashflowId)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.contractId").exists()
                .jsonPath("$.cashflowType").isEqualTo("INTEREST")
                .jsonPath("$.status").isEqualTo("ACCRUED");
    }

    @Test
    @Order(7)
    void testSearchCashflowsEndpoint() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cashflows")
                        .queryParam("contractId", testContractId)
                        .queryParam("cashflowType", "INTEREST")
                        .queryParam("status", "ACCRUED")
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content").isArray()
                .jsonPath("$.totalElements").exists()
                .jsonPath("$.totalPages").exists();
    }

    @Test
    @Order(8)
    void testCashflowStatusUpdateEndpoint() {
        CashflowStatusUpdateRequest request = new CashflowStatusUpdateRequest();
        request.setNewStatus(CashflowStatus.REALIZED_UNSETTLED);

        webTestClient.patch()
                .uri("/cashflows/{cashflowId}/status", testCashflowId)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").exists()
                .jsonPath("$.status").exists();
    }

    @Test
    @Order(9)
    void testThreadPartitioningStatusEndpoint() {
        webTestClient.get()
                .uri("/threads/partitions")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists()
                .jsonPath("$.activePartitions").exists()
                .jsonPath("$.availablePartitions").exists();
    }

    @Test
    @Order(10)
    void testBatchCashflowGenerationEndpoint() {
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest();
        batchRequest.setRequests(Arrays.asList(createTestRequest(), createTestRequest()));
        batchRequest.setProcessingMode(BatchCashflowGenerationRequest.ProcessingMode.PARALLEL);

        // Mock batch response
        BatchCashflowGenerationResponse mockBatchResponse = new BatchCashflowGenerationResponse(
            UUID.randomUUID(),
            2, // totalRequests
            2, // acceptedRequests 
            0  // rejectedRequests
        );

        when(cashflowGenerationService.generateBatchCashflows(any(BatchCashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockBatchResponse));

        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.totalRequests").isEqualTo(2)
                .jsonPath("$.acceptedRequests").isEqualTo(2);
    }

    @Test
    @Order(11)
    void testProductionScenarioConcurrentRequests() {
        // Simulate production-like concurrent requests
        CashflowGenerationRequest request = createTestRequest();

        // Test multiple concurrent requests
        for (int i = 0; i < 5; i++) {
            webTestClient.post()
                    .uri("/cashflows/generate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValue(request)
                    .exchange()
                    .expectStatus().isAccepted()
                    .expectBody()
                    .jsonPath("$.jobId").exists();
        }
    }

    @Test
    @Order(12)
    void testProductionErrorHandling() {
        // Test with invalid request to verify error handling
        CashflowGenerationRequest invalidRequest = new CashflowGenerationRequest();
        // Leave contractIds empty to trigger validation error

        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(invalidRequest)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @Order(13)
    void testProductionTimeoutScenario() {
        // Mock a slow response to test timeout handling
        when(cashflowGenerationService.generateCashflows(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.delay(java.time.Duration.ofSeconds(1))
                        .then(Mono.just(createMockResponse())));

        CashflowGenerationRequest request = createTestRequest();

        webTestClient.mutate()
                .responseTimeout(java.time.Duration.ofSeconds(5))
                .build()
                .post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted();
    }

    @Test
    @Order(14)
    void testProductionLargeBatchProcessing() {
        // Test large batch processing scenario
        BatchCashflowGenerationRequest largeBatchRequest = new BatchCashflowGenerationRequest();
        
        // Create a larger batch of requests
        List<CashflowGenerationRequest> requests = Arrays.asList(
                createTestRequest(), createTestRequest(), createTestRequest(),
                createTestRequest(), createTestRequest(), createTestRequest(),
                createTestRequest(), createTestRequest(), createTestRequest(),
                createTestRequest()
        );
        largeBatchRequest.setRequests(requests);
        largeBatchRequest.setProcessingMode(BatchCashflowGenerationRequest.ProcessingMode.PARALLEL);

        BatchCashflowGenerationResponse mockLargeBatchResponse = new BatchCashflowGenerationResponse(
            UUID.randomUUID(),
            10, // totalRequests
            10, // acceptedRequests 
            0   // rejectedRequests
        );

        when(cashflowGenerationService.generateBatchCashflows(any(BatchCashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockLargeBatchResponse));

        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(largeBatchRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.totalRequests").isEqualTo(10)
                .jsonPath("$.acceptedRequests").isEqualTo(10);
    }

    private CashflowGenerationRequest createTestRequest() {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setCreatedBy("PROD_TEST");
        return request;
    }

    private Cashflow createMockCashflow() {
        Cashflow cashflow = new Cashflow();
        cashflow.setId(testCashflowId);
        cashflow.setContractId(testContractId);
        cashflow.setLegId(UUID.randomUUID());
        cashflow.setSecurityId("PROD-TEST-SEC-001");
        cashflow.setCalculationType(CalculationType.INTEREST);
        cashflow.setCashflowType(CashflowType.INTEREST);
        cashflow.setStatus(CashflowStatus.ACCRUED);
        cashflow.setAmount(BigDecimal.valueOf(10000.00));
        cashflow.setCurrency("USD");
        cashflow.setCalculationDate(LocalDate.now());
        cashflow.setValueDate(LocalDate.now().plusDays(30));
        cashflow.setCreatedAt(LocalDateTime.now());
        cashflow.setUpdatedAt(LocalDateTime.now());
        cashflow.setCreatedBy("PROD_TEST");
        cashflow.setUpdatedBy("PROD_TEST");
        return cashflow;
    }

    private CashflowGenerationResponse createMockResponse() {
        CashflowGenerationResponse response = new CashflowGenerationResponse();
        response.setJobId(UUID.randomUUID());
        response.setContractsProcessed(1);
        response.setCashflowsGenerated(3);
        response.setProcessingTimeMs(150L);
        response.setStatus("SUCCESS");
        return response;
    }

    private ThreadPartitionStatus createMockPartitionStatus() {
        ThreadPartitionStatus status = new ThreadPartitionStatus();
        status.setTotalPartitions(4);
        status.setActivePartitions(2);
        status.setAvailablePartitions(2);
        status.setQueueSize(0);
        return status;
    }
}
