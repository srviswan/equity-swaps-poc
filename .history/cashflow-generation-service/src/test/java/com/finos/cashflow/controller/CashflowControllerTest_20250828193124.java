package com.finos.cashflow.controller;

import com.finos.cashflow.model.*;
import com.finos.cashflow.service.CashflowGenerationService;
import com.finos.cashflow.service.ThreadPartitioningService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for CashflowController.
 * 
 * This test verifies the REST API endpoints and their behavior
 * using WebTestClient for reactive testing.
 */
@WebFluxTest(CashflowController.class)
class CashflowControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CashflowGenerationService cashflowGenerationService;

    @MockBean
    private ThreadPartitioningService threadPartitioningService;

    @Autowired
    private ObjectMapper objectMapper;

    private UUID contractId;
    private LocalDate calculationDate;
    private CashflowGenerationRequest request;

    @BeforeEach
    void setUp() {
        contractId = UUID.randomUUID();
        calculationDate = LocalDate.now();
        request = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, List.of(CashflowType.INTEREST));
    }

    @Test
    void generateCashflows_ShouldReturnAcceptedResponse() {
        // Given
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(), 1, "Cashflow generation accepted for processing");
        
        when(cashflowGenerationService.generateCashflows(any()))
            .thenReturn(Mono.just(response));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isAccepted()
            .expectBody(CashflowGenerationResponse.class)
            .value(resp -> {
                assertThat(resp.getJobId()).isNotNull();
                assertThat(resp.getContractsProcessed()).isEqualTo(1);
                assertThat(resp.getMessage()).contains("accepted");
            });
    }

    @Test
    void generateCashflowsReactive_ShouldReturnStreamOfCashflows() {
        // Given
        Cashflow cashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            CalculationType.INTEREST, CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "TEST");
        
        when(cashflowGenerationService.generateCashflowsReactive(any()))
            .thenReturn(Flux.just(cashflow));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/reactive")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_NDJSON_VALUE)
            .expectBodyList(Cashflow.class)
            .hasSize(1)
            .contains(cashflow);
    }

    @Test
    void generateCashflowsStream_ShouldReturnServerSentEvents() {
        // Given
        Cashflow cashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            CalculationType.INTEREST, CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "TEST");
        
        when(cashflowGenerationService.generateCashflowsReactive(any()))
            .thenReturn(Flux.just(cashflow));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/stream")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM_VALUE + ";charset=UTF-8");
    }

    @Test
    void generateInterestCashflows_ShouldReturnAcceptedResponse() {
        // Given
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(), 1, "Interest cashflow generation accepted");
        
        when(cashflowGenerationService.generateCashflows(any()))
            .thenReturn(Mono.just(response));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/interest")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(request)
            .exchange()
            .expectStatus().isAccepted()
            .expectBody(CashflowGenerationResponse.class)
            .value(resp -> {
                assertThat(resp.getJobId()).isNotNull();
                assertThat(resp.getContractsProcessed()).isEqualTo(1);
                assertThat(resp.getMessage()).contains("Interest cashflow generation accepted");
            });
    }

    @Test
    void generateInterestCashflows_WithNonInterestTypes_ShouldReturnBadRequest() {
        // Given
        CashflowGenerationRequest nonInterestRequest = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, List.of(CashflowType.PERFORMANCE));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/interest")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(nonInterestRequest)
            .exchange()
            .expectStatus().isBadRequest();
    }

    @Test
    void generateDividendCashflows_ShouldReturnAcceptedResponse() {
        // Given
        CashflowGenerationRequest dividendRequest = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, List.of(CashflowType.DIVIDEND));
        
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(), 1, "Dividend cashflow generation accepted");
        
        when(cashflowGenerationService.generateCashflows(any()))
            .thenReturn(Mono.just(response));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/dividend")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(dividendRequest)
            .exchange()
            .expectStatus().isAccepted()
            .expectBody(CashflowGenerationResponse.class)
            .value(resp -> {
                assertThat(resp.getJobId()).isNotNull();
                assertThat(resp.getContractsProcessed()).isEqualTo(1);
                assertThat(resp.getMessage()).contains("Dividend cashflow generation accepted");
            });
    }

    @Test
    void generatePerformanceCashflows_ShouldReturnAcceptedResponse() {
        // Given
        CashflowGenerationRequest performanceRequest = new CashflowGenerationRequest(
            List.of(contractId), calculationDate, List.of(CashflowType.PERFORMANCE));
        
        CashflowGenerationResponse response = new CashflowGenerationResponse(
            UUID.randomUUID(), 1, "Performance cashflow generation accepted");
        
        when(cashflowGenerationService.generateCashflows(any()))
            .thenReturn(Mono.just(response));

        // When & Then
        webTestClient.post()
            .uri("/cashflows/generate/performance")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(performanceRequest)
            .exchange()
            .expectStatus().isAccepted()
            .expectBody(CashflowGenerationResponse.class)
            .value(resp -> {
                assertThat(resp.getJobId()).isNotNull();
                assertThat(resp.getContractsProcessed()).isEqualTo(1);
                assertThat(resp.getMessage()).contains("Performance cashflow generation accepted");
            });
    }

    @Test
    void generateDailyAccruals_ShouldReturnStreamOfCashflows() {
        // Given
        Cashflow cashflow = new Cashflow(
            contractId, UUID.randomUUID(), "DEFAULT", 
            CalculationType.INTEREST, CashflowType.INTEREST,
            java.math.BigDecimal.valueOf(100.00), "USD", calculationDate, "TEST");
        
        when(cashflowGenerationService.generateDailyAccruals(any(), any(), any()))
            .thenReturn(Flux.just(cashflow));

        // When & Then
        webTestClient.post()
            .uri(uriBuilder -> uriBuilder
                .path("/cashflows/accruals/daily")
                .queryParam("contractIds", contractId.toString())
                .queryParam("startDate", calculationDate.minusDays(7).toString())
                .queryParam("endDate", calculationDate.toString())
                .build())
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_NDJSON_VALUE)
            .expectBodyList(Cashflow.class)
            .hasSize(1)
            .contains(cashflow);
    }

    @Test
    void getThreadPartitionStatus_ShouldReturnPartitionStatistics() {
        // Given
        java.util.Map<String, Object> stats = new java.util.HashMap<>();
        stats.put("test.partition.activeThreads", 5);
        stats.put("test.partition.poolSize", 10);
        
        when(threadPartitioningService.getPartitionStatistics())
            .thenReturn(new java.util.concurrent.ConcurrentHashMap<>(stats));

        // When & Then
        webTestClient.get()
            .uri("/threads/partitions")
            .exchange()
            .expectStatus().isOk()
            .expectBody(java.util.Map.class)
            .value(map -> {
                assert map.containsKey("test.partition.activeThreads");
                assert map.containsKey("test.partition.poolSize");
            });
    }

    @Test
    void health_ShouldReturnUpStatus() {
        // When & Then
        webTestClient.get()
            .uri("/health")
            .exchange()
            .expectStatus().isOk()
            .expectBody(java.util.Map.class)
            .value(map -> {
                assert "UP".equals(map.get("status"));
                assert "Cash Flow Generation Service".equals(map.get("service"));
            });
    }

    @Test
    void detailedHealth_ShouldReturnComponentStatus() {
        // When & Then
        webTestClient.get()
            .uri("/health/detailed")
            .exchange()
            .expectStatus().isOk()
            .expectBody(java.util.Map.class)
            .value(map -> {
                assert "UP".equals(map.get("status"));
                assert map.containsKey("components");
                
                @SuppressWarnings("unchecked")
                java.util.Map<String, Object> components = (java.util.Map<String, Object>) map.get("components");
                assert "UP".equals(components.get("threadPartitioning"));
                assert "UP".equals(components.get("cashflowGeneration"));
            });
    }
}
