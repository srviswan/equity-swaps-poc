package com.finos.cashflow.integration;

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

import java.time.Duration;

/**
 * Basic endpoint validation test that verifies core service functionality.
 * This test only validates that endpoints are accessible and respond correctly.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasicEndpointValidationTest {

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
    void testBasicCashflowGenerationEndpoint() {
        // Test with minimal valid JSON request
        String requestJson = "{\n" +
                "  \"contractIds\": [\"550e8400-e29b-41d4-a716-446655440000\"],\n" +
                "  \"cashflowTypes\": [\"INTEREST\"],\n" +
                "  \"calculationDate\": \"2023-12-01\",\n" +
                "  \"createdBy\": \"test-user\"\n" +
                "}";

        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestJson)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.status").isEqualTo("ACCEPTED");
    }

    @Test
    @Order(3)
    void testCashflowQueryEndpoint() {
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
    @Order(4)
    void testThreadPartitioningStatusEndpoint() {
        webTestClient.get()
                .uri("/threads/partitions")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists();
    }

    @Test
    @Order(5)
    void testReactiveCashflowGenerationEndpoint() {
        String requestJson = "{\n" +
                "  \"contractIds\": [\"550e8400-e29b-41d4-a716-446655440000\"],\n" +
                "  \"cashflowTypes\": [\"INTEREST\"],\n" +
                "  \"calculationDate\": \"2023-12-01\",\n" +
                "  \"createdBy\": \"test-user\"\n" +
                "}";

        webTestClient.post()
                .uri("/cashflows/generate/reactive")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestJson)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @Order(6)
    void testStreamingCashflowGenerationEndpoint() {
        String requestJson = "{\n" +
                "  \"contractIds\": [\"550e8400-e29b-41d4-a716-446655440000\"],\n" +
                "  \"cashflowTypes\": [\"INTEREST\"],\n" +
                "  \"calculationDate\": \"2023-12-01\",\n" +
                "  \"createdBy\": \"test-user\"\n" +
                "}";

        webTestClient.post()
                .uri("/cashflows/generate/stream")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestJson)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.TEXT_EVENT_STREAM);
    }

    @Test
    @Order(7)
    void testActorBasedCashflowGenerationEndpoint() {
        String requestJson = "{\n" +
                "  \"contractIds\": [\"550e8400-e29b-41d4-a716-446655440000\"],\n" +
                "  \"cashflowTypes\": [\"INTEREST\"],\n" +
                "  \"calculationDate\": \"2023-12-01\",\n" +
                "  \"createdBy\": \"test-user\"\n" +
                "}";

        webTestClient.post()
                .uri("/cashflows/generate/actor")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestJson)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(8)
    void testBatchCashflowGenerationEndpoint() {
        String batchRequestJson = "{\n" +
                "  \"requests\": [{\n" +
                "    \"contractIds\": [\"550e8400-e29b-41d4-a716-446655440000\"],\n" +
                "    \"cashflowTypes\": [\"INTEREST\"],\n" +
                "    \"calculationDate\": \"2023-12-01\",\n" +
                "    \"createdBy\": \"test-user\"\n" +
                "  }]\n" +
                "}";

        webTestClient.post()
                .uri("/cashflows/generate/batch")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(batchRequestJson)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(9)
    void testDetailedHealthEndpoint() {
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
    @Order(10)
    void testErrorHandlingWithInvalidRequest() {
        // Test with invalid request structure
        webTestClient.post()
                .uri("/cashflows/generate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"invalid\": \"json\"}")
                .exchange()
                .expectStatus().is4xxClientError();
    }

    @Test
    @Order(11)
    void testCashflowSearchEndpoint() {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/cashflows/search")
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
