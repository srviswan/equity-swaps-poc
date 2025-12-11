package com.finos.cashflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Main application test class for the Cash Flow Generation Service.
 * 
 * This test verifies that the Spring application context loads successfully
 * with all required beans and configurations.
 */
@SpringBootTest
@ActiveProfiles("test")
class CashflowGenerationServiceApplicationTests {

    @Test
    void contextLoads() {
        // This test will fail if the application context cannot start
        // It verifies that all required beans can be created and wired together
    }
}
