package com.pb.swap.rules.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.pb.swap.rules")
@EntityScan(basePackages = "com.pb.swap.rules.store.entity")
@EnableJpaRepositories(basePackages = "com.pb.swap.rules.store.repo")
public class SwapRulesAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SwapRulesAdminApplication.class, args);
    }
}
