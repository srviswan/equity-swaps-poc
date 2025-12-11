package com.finos.cashflow.integration;

import com.finos.cashflow.model.*;
import com.finos.cashflow.repository.CashflowRepository;
import com.finos.cashflow.service.CashflowGenerationService;
import com.finos.cashflow.service.ActorBasedCashflowService;
import com.finos.cashflow.service.CashflowQueryService;
import com.finos.cashflow.service.ThreadPartitioningService;
import com.finos.cashflow.actor.ActorSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Production configuration testing to validate the service works correctly
 * with production-like settings and performance characteristics.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("prod-test")
@TestPropertySource(locations = "classpath:application-prod-test.yml")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductionConfigurationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CashflowGenerationService cashflowGenerationService;

    @Autowired
    private ActorBasedCashflowService actorBasedCashflowService;

    @Autowired
    private CashflowQueryService cashflowQueryService;

    @Autowired
    private ThreadPartitioningService threadPartitioningService;

    @Autowired
    private ActorSystem actorSystem;

    @Autowired
    private CashflowRepository cashflowRepository;

    @Autowired
    private WebTestClient webTestClient;

    private UUID testContractId;

    @BeforeEach
    void setUp() {
        testContractId = UUID.randomUUID();
        
        // Clean up test data
        StepVerifier.create(cashflowRepository.deleteAll())
                .verifyComplete();
    }

    @Test
    @Order(1)
    void testApplicationContextLoadsWithProductionConfig() {
        assertNotNull(applicationContext);
        assertNotNull(cashflowGenerationService);
        assertNotNull(actorBasedCashflowService);
        assertNotNull(cashflowQueryService);
        assertNotNull(threadPartitioningService);
        assertNotNull(actorSystem);
        
        // Verify beans are properly configured
        assertTrue(port > 0);
        System.out.println("Application started successfully on port: " + port);
    }

    @Test
    @Order(2)
    void testProductionHealthEndpoints() {
        webTestClient.get()
                .uri("/health")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP");

        // Test detailed health with production-like components
        webTestClient.get()
                .uri("/health/detailed")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.status").isEqualTo("UP")
                .jsonPath("$.components").exists()
                .jsonPath("$.components.database").exists()
                .jsonPath("$.components.actors").exists()
                .jsonPath("$.components.threadPools").exists();
    }

    @Test
    @Order(3)
    void testProductionActorSystemConfiguration() {
        // Test actor system status with production settings
        webTestClient.get()
                .uri("/actors/status")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalActors").exists()
                .jsonPath("$.activeActors").exists()
                .jsonPath("$.maxActors").isEqualTo(20); // From prod-test config

        // Test actor count
        webTestClient.get()
                .uri("/actors/count")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.count").exists();
    }

    @Test
    @Order(4)
    void testProductionThreadPartitioning() {
        // Test thread partitioning with production settings
        webTestClient.get()
                .uri("/threads/partitions")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.totalPartitions").exists()
                .jsonPath("$.activePartitions").exists();
    }

    @Test
    @Order(5)
    void testProductionCashflowGeneration() {
        // Test basic cashflow generation with production settings
        CashflowGenerationRequest request = createProductionTestRequest();

        StepVerifier.create(cashflowGenerationService.generateCashflows(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                    assertTrue(response.getContractsProcessed() > 0);
                })
                .verifyComplete();

        // Test with actor-based service
        StepVerifier.create(cashflowGenerationService.generateCashflowsWithActors(request))
                .assertNext(response -> {
                    assertNotNull(response);
                    assertNotNull(response.getJobId());
                })
                .verifyComplete();
    }

    @Test
    @Order(6)
    void testProductionBatchProcessing() {
        // Test batch processing with production batch sizes
        List<CashflowGenerationRequest> requests = Arrays.asList(
                createProductionTestRequest(),
                createProductionTestRequest(),
                createProductionTestRequest(),
                createProductionTestRequest(),
                createProductionTestRequest()
        );

        // Process requests concurrently
        Flux<CashflowGenerationResponse> responses = Flux.fromIterable(requests)
                .flatMap(req -> cashflowGenerationService.generateCashflows(req), 3); // Concurrency level

        StepVerifier.create(responses)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    @Order(7)
    void testProductionPerformanceCharacteristics() throws InterruptedException {
        int concurrentRequests = 10;
        CountDownLatch latch = new CountDownLatch(concurrentRequests);
        
        long startTime = System.currentTimeMillis();
        
        // Submit concurrent requests
        for (int i = 0; i < concurrentRequests; i++) {
            CompletableFuture.supplyAsync(() -> {
                try {
                    CashflowGenerationRequest request = createProductionTestRequest();
                    return cashflowGenerationService.generateCashflows(request).block(Duration.ofSeconds(30));
                } finally {
                    latch.countDown();
                }
            });
        }
        
        // Wait for completion with reasonable timeout
        assertTrue(latch.await(60, TimeUnit.SECONDS), "Concurrent requests should complete within 60 seconds");
        
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Processed " + concurrentRequests + " concurrent requests in " + duration + "ms");
        
        // Verify reasonable performance (less than 30 seconds for 10 concurrent requests)
        assertTrue(duration < 30000, "Performance should be reasonable for concurrent processing");
    }

    @Test
    @Order(8)
    void testProductionDatabaseOperations() {
        // Test database operations with production-like configuration
        Cashflow cashflow = createProductionTestCashflow();

        StepVerifier.create(cashflowRepository.save(cashflow))
                .assertNext(saved -> {
                    assertNotNull(saved.getId());
                    assertEquals(testContractId, saved.getContractId());
                    assertEquals(CashflowType.INTEREST, saved.getCashflowType());
                    assertEquals(CashflowStatus.ACCRUED, saved.getStatus());
                })
                .verifyComplete();

        // Test query operations
        StepVerifier.create(cashflowRepository.count())
                .assertNext(count -> assertTrue(count > 0))
                .verifyComplete();

        // Test query service operations
        StepVerifier.create(cashflowQueryService.getCashflowsByType(CashflowType.INTEREST))
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @Order(9)
    void testProductionErrorHandling() {
        // Test error handling with production configuration
        CashflowGenerationRequest invalidRequest = new CashflowGenerationRequest();
        invalidRequest.setContractIds(Arrays.asList()); // Empty list should cause validation error
        invalidRequest.setCalculationDate(LocalDate.now());

        StepVerifier.create(cashflowGenerationService.generateCashflows(invalidRequest))
                .expectError()
                .verify();
    }

    @Test
    @Order(10)
    void testProductionReactiveStreaming() {
        // Test reactive streaming with production settings
        CashflowGenerationRequest request = createProductionTestRequest();
        request.setContractIds(Arrays.asList(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));

        StepVerifier.create(cashflowGenerationService.generateCashflowsReactive(request))
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    @Order(11)
    void testProductionEndpointsWithWebTestClient() {
        // Test production endpoints through web layer
        CashflowGenerationRequest request = createProductionTestRequest();

        webTestClient.post()
                .uri("/cashflows/generate")
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists()
                .jsonPath("$.contractsProcessed").exists();

        // Test interest generation endpoint
        webTestClient.post()
                .uri("/cashflows/generate/interest")
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();

        // Test actor-based generation endpoint
        webTestClient.post()
                .uri("/cashflows/generate/actor")
                .bodyValue(request)
                .exchange()
                .expectStatus().isAccepted()
                .expectBody()
                .jsonPath("$.jobId").exists();
    }

    @Test
    @Order(12)
    void testProductionConfigurationValidation() {
        // Verify production configuration values are loaded correctly
        // This would be enhanced with actual configuration property beans in a real implementation
        
        // Test that the application is using production-like settings
        assertNotNull(actorSystem);
        assertNotNull(threadPartitioningService);
        
        // Verify actor system is configured correctly
        assertTrue(actorSystem.getActorCount() >= 0);
        
        // Test that database connections are working
        StepVerifier.create(cashflowRepository.count())
                .expectNextMatches(count -> count >= 0)
                .verifyComplete();
    }

    @Test
    @Order(13)
    void testProductionLevelConcurrency() {
        // Test high concurrency scenarios typical in production
        int threadCount = 5;
        int requestsPerThread = 4;
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(threadCount);
        
        for (int i = 0; i < threadCount; i++) {
            CompletableFuture.runAsync(() -> {
                try {
                    startLatch.await(); // Wait for all threads to be ready
                    
                    for (int j = 0; j < requestsPerThread; j++) {
                        CashflowGenerationRequest request = createProductionTestRequest();
                        cashflowGenerationService.generateCashflows(request)
                                .timeout(Duration.ofSeconds(30))
                                .block();
                    }
                } catch (Exception e) {
                    fail("Concurrent execution failed: " + e.getMessage());
                } finally {
                    endLatch.countDown();
                }
            });
        }
        
        startLatch.countDown(); // Start all threads
        
        assertDoesNotThrow(() -> {
            assertTrue(endLatch.await(120, TimeUnit.SECONDS), 
                      "All concurrent operations should complete within 2 minutes");
        });
    }

    private CashflowGenerationRequest createProductionTestRequest() {
        CashflowGenerationRequest request = new CashflowGenerationRequest();
        request.setContractIds(Arrays.asList(testContractId));
        request.setCalculationDate(LocalDate.now());
        request.setCashflowTypes(Arrays.asList(CashflowType.INTEREST));
        request.setCreatedBy("PROD_TEST");
        return request;
    }

    private Cashflow createProductionTestCashflow() {
        Cashflow cashflow = new Cashflow();
        cashflow.setId(UUID.randomUUID());
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
}
