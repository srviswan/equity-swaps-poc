package com.pb.swap.rules.admin.config;

import com.pb.swap.rules.core.schema.SchemaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemaConfig {

    @Bean
    public SchemaService schemaService() {
        return new SchemaService();
    }
}
