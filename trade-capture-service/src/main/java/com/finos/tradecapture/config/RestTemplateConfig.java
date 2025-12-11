package com.finos.tradecapture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Rest Template Configuration
 * 
 * Configuration for RestTemplate used by the instruction service client.
 * 
 * @version 1.0.0
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Rest Template Bean
     */
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(30000); // 30 seconds
        factory.setReadTimeout(30000); // 30 seconds
        
        return new RestTemplate(factory);
    }
} 