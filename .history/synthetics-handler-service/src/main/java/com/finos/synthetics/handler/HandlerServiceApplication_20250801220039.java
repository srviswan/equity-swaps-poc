package com.finos.synthetics.handler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Handler Service Application
 * 
 * Main Spring Boot application for specialized handler microservices
 * that process CDM primitive instructions.
 * 
 * @version 1.0.0
 */
@SpringBootApplication
public class HandlerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HandlerServiceApplication.class, args);
    }
} 