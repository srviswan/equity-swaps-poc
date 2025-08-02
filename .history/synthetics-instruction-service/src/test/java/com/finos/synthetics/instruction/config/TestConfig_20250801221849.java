package com.finos.synthetics.instruction.config;

import com.finos.synthetics.instruction.service.InstructionProcessorService;
import com.finos.synthetics.instruction.service.InstructionValidationService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * Test Configuration
 * 
 * Configuration for integration tests that mocks external dependencies.
 * 
 * @version 1.0.0
 */
@TestConfiguration
public class TestConfig {

    @Bean
    @Primary
    public InstructionProcessorService instructionProcessorService() {
        return Mockito.mock(InstructionProcessorService.class);
    }

    @Bean
    @Primary
    public InstructionValidationService instructionValidationService() {
        return Mockito.mock(InstructionValidationService.class);
    }
} 