package com.finos.synthetics.instruction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Instruction Service Application
 * 
 * Main Spring Boot application for handling CDM primitive instructions
 * and delegating to specialized handler microservices.
 * 
 * @version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
public class InstructionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InstructionServiceApplication.class, args);
    }
} 