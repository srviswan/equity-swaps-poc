package com.finos.synthetics.handler.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Jackson Configuration
 *
 * Configures Jackson ObjectMapper to handle Java 8 date/time types properly.
 *
 * @version 1.0.0
 */
@Configuration
public class JacksonConfig {

    /**
     * Configure ObjectMapper with Java 8 date/time support
     *
     * @return configured ObjectMapper
     */
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
} 