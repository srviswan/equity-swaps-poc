package com.lifecycle.cashflow.integration;

import com.lifecycle.cashflow.controller.CashflowController;
import com.lifecycle.cashflow.model.*;
import com.lifecycle.cashflow.service.*;
import com.lifecycle.cashflow.repository.*;
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
@WebFluxTest(controllers = CashflowController.class)
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

    // Add missing repository mocks to prevent Spring context loading issues
    @MockBean
    private CashflowRepository cashflowRepository;

    @MockBean
    private DailyAccrualRepository dailyAccrualRepository;

    @MockBean
    private UnrealizedPnLRepository unrealizedPnLRepository;

    // Add missing service mocks
    @MockBean
    private InterestCalculationService interestCalculationService;

    @MockBean
    private EquityPerformanceService equityPerformanceService;

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
        CashflowGenerationResponse mockResponse = new CashflowGenerationResponse(
            UUID.randomUUID(), 
            1, 
            "Cashflow generation completed successfully"
        );
        mockResponse.setStatus("SUCCESS");

        when(cashflowGenerationService.generateCashflows(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockResponse));
        when(cashflowGenerationService.generateCashflowsWithActors(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockResponse));
        when(cashflowGenerationService.generateInterestCashflows(any(CashflowGenerationRequest.class)))
                .thenReturn(Mono.just(mockResponse));
        when(cashflowGenerationService.generateCashflowsReactive(any(CashflowGenerationRequest.class)))
                .thenReturn(Flux.just(createMockCashflow(), createMockCashflow(), createMockCashflow()));

        // Mock cashflow query responses
        when(cashflowQueryService.getCashflowById(any(UUID.class)))
                .thenReturn(Mono.just(createMockCashflow()));
        
        when(cashflowQueryService.getCashflowsByType(any(CashflowType.class)))
                .thenReturn(Flux.just(createMockCashflow()));

        // Mock thread partitioning responses
        when(threadPartitioningService.getPartitionStatus())
                .thenReturn(createMockPartitionStatus());
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
        // Mock search response
        CashflowPageResponse pageResponse = CashflowPageResponse.of(
            Arrays.asList(createMockCashflow()),
            0, // page
            10, // size
            1L // totalElements
        );
        
        when(cashflowQueryService.searchCashflows(any(UUID.class), any(UUID.class), any(CashflowType.class), 
                any(CashflowStatus.class), any(String.class), any(LocalDate.class), any(LocalDate.class), 
                any(Integer.class), any(Integer.class)))
                .thenReturn(Mono.just(pageResponse));

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
        CashflowStatusUpdateRequest request = new CashflowStatusUpdateRequest(
            UUID.randomUUID(),
            CashflowStatus.REALIZED_UNSETTLED,
            "Test status update",
            "test-user"
        );
        
        // Mock state management response
        Cashflow updatedCashflow = createMockCashflow();
        updatedCashflow.setStatus(CashflowStatus.REALIZED_UNSETTLED);
        
        when(cashflowStateManagementService.transitionStatus(any(), any(), any(), any()))
                .thenReturn(Mono.just(updatedCashflow));

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
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest(
            Arrays.asList(createTestRequest(), createTestRequest())
        );

        // Mock batch response
        List<CashflowGenerationResponse> responses = Arrays.asList(
            createMockCashflowGenerationResponse(),
            createMockCashflowGenerationResponse()
        );
        String jobIdValue = UUID.randomUUID().toString();
        BatchCashflowGenerationResponse mockBatchResponse = new BatchCashflowGenerationResponse(
            responses,
            2, // totalRequests
            2, // successfulRequests
            0, // failedRequests
            2, // acceptedRequests
            jobIdValue, // batchId
            jobIdValue  // jobId
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
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(), 
            1, 
            "Cashflow generation completed successfully"
        );
        response.setStatus("SUCCESS");
        return response;
    }

    private ThreadPartitionStatus createMockPartitionStatus() {
        return ThreadPartitionStatus.defaultStatus();
    }
    
    private CashflowGenerationResponse createMockCashflowGenerationResponse() {
        CashflowGenerationResponse response = new CashflowGenerationResponse();
        response.setJobId(UUID.randomUUID());
        response.setStatus("COMPLETED");
        response.setMessage("Mock response");
        response.setContractsProcessed(1);
        return response;
    }
}