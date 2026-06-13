package com.pb.tcs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pb.tcs")
public class TradeCaptureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeCaptureServiceApplication.class, args);
    }
}
