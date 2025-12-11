package com.finos.tradecapture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Trade Capture Service Application
 * 
 * Main Spring Boot application for processing raw equity cash trades from Solace queue.
 * This service validates, enriches, and transforms raw trades into fully developed contracts.
 * 
 * @version 1.0.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableCaching
@EnableIntegration
@EnableAsync
public class TradeCaptureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeCaptureServiceApplication.class, args);
    }
} 