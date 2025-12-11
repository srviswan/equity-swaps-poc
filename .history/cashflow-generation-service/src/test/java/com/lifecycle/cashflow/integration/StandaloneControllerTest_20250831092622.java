package com.lifecycle.cashflow.integration;

import com.lifecycle.cashflow.controller.CashflowController;
import com.lifecycle.cashflow.model.*;
import com.lifecycle.cashflow.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Standalone controller test that bypasses Spring context loading completely.
 * Uses pure Mockito without @MockBean for complete isolation.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StandaloneControllerTest {

    private WebTestClient webTestClient;

    @Mock
    private CashflowGenerationService cashflowGenerationService;

    @Mock
    private ActorBasedCashflowService actorBasedCashflowService;

    @Mock
    private CashflowQueryService cashflowQueryService;

    @Mock
    private CashflowStateManagementService cashflowStateManagementService;

    @Mock
    private ThreadPartitioningService threadPartitioningService;

    private CashflowController controller;
    private UUID testContractId;
    private UUID testCashflowId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Create controller with mocked dependencies
        controller = new CashflowController(
            cashflowGenerationService,
            cashflowQueryService,
            cashflowStateManagementService
        );
        
        // Create WebTestClient without Spring context
        webTestClient = WebTestClient.bindToController(controller).build();
        
        testContractId = UUID.randomUUID();
        testCashflowId = UUID.randomUUID();
        
        setupMocks();
    }

    private void setupMocks() {
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

        // Mock cashflow query responses
        when(cashflowQueryService.getCashflowById(any(UUID.class)))
                .thenReturn(Mono.just(createMockCashflow()));
        
        when(cashflowQueryService.getCashflowsByType(any(CashflowType.class)))
                .thenReturn(Flux.just(createMockCashflow()));

        // Mock search response
        List<Cashflow> mockCashflows = List.of(
            createMockCashflow(),
            createMockCashflow()
        );
        CashflowPageResponse mockPageResponse = CashflowPageResponse.of(mockCashflows, 0, 10, 2);
        
        when(cashflowQueryService.searchCashflows(any(UUID.class), any(UUID.class), any(CashflowType.class),
                any(CashflowStatus.class), any(String.class), any(LocalDate.class), any(LocalDate.class), 
                any(Integer.class), any(Integer.class)))
                .thenReturn(Mono.just(mockPageResponse));

        // Mock state management responses
        when(cashflowStateManagementService.updateCashflowStatus(any(UUID.class), any(CashflowStatus.class)))
                .thenReturn(Mono.just(createMockCashflow()));

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
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.status").isEqualTo("SUCCESS");
    }

    @Test
    @Order(3)
    void testInterestCashflowGenerationEndpoint() {
        CashflowGenerationRequest request = createTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate/interest")
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
                .uri("/cashflows/generate/actors")
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
                .uri("/cashflows/{id}", testCashflowId)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.contractId").exists()
                .jsonPath("$.cashflowType").exists();
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
                .jsonPath("$.totalElements").exists();
    }

    @Test
    @Order(8)
    void testUpdateCashflowStatusEndpoint() {
        webTestClient.put()
                .uri("/cashflows/{id}/status", testCashflowId)
                .bodyValue(Map.of("status", "SETTLED"))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.contractId").exists();
    }

    @Test
    @Order(9)
    void testGetCashflowsByTypeEndpoint() {
        webTestClient.get()
                .uri("/cashflows/type/{type}", "INTEREST")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cashflow.class)
                .hasSize(1);
    }

    @Test
    @Order(10)
    void testBatchCashflowGenerationEndpoint() {
        List<CashflowGenerationRequest> requests = Arrays.asList(
            createTestRequest(),
            createTestRequest()
        );
        BatchCashflowGenerationRequest batchRequest = new BatchCashflowGenerationRequest(requests);

        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .bodyValue(batchRequest)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.totalRequests").isEqualTo(2)
                .jsonPath("$.successfulRequests").isEqualTo(2)
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(11)
    void testDetailedHealthEndpoint() {
        webTestClient.get()
                .uri("/health/detailed")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP")
                .jsonPath("$.actorSystem").exists();
    }

    @Test
    @Order(12)
    void testThreadPartitioningStatusEndpoint() {
        webTestClient.get()
                .uri("/threads/partitions")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists()
                .jsonPath("$.availablePartitions").exists();
    }

    @Test
    @Order(13)
    void testInputValidation() {
        CashflowGenerationRequest invalidRequest = createTestRequest();
        invalidRequest.setContractIds(null);

        webTestClient.post()
                .uri("/cashflows/generate")
                .bodyValue(invalidRequest)
                .exchange()
                .expectStatus().isBadRequest();
    }

    // Helper methods
    private CashflowGenerationRequest createTestRequest() {
        CashflowGenerationRequest request = new CashflowGenerationRequest(
            List.of(testContractId),
            LocalDate.now(),
            "PROD_TEST"
        );
        request.setCashflowTypes(List.of(CashflowType.INTEREST));
        return request;
    }

    private Cashflow createMockCashflow() {
        return new Cashflow(
            testContractId,
            UUID.randomUUID(),
            "TEST_SECURITY",
            CalculationType.INTEREST,
            CashflowType.INTEREST,
            BigDecimal.valueOf(1000.00),
            "USD",
            LocalDate.now(),
            "PROD_TEST"
        );
    }

    private CashflowGenerationResponse createMockCashflowGenerationResponse() {
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(),
            1,
            "SUCCESS"
        );
        response.setStatus("COMPLETED");
        return response;
    }

    private ThreadPartitionStatus createMockPartitionStatus() {
        return new ThreadPartitionStatus(
            10,
            5,
            5,
            Map.of("partition1", 2, "partition2", 3),
            LocalDateTime.now(),
            "ACTIVE"
        );
    }
}
