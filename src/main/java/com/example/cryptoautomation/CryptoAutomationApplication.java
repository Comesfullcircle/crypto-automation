package com.example.cryptoautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CryptoAutomationApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CryptoAutomationApplication.class, args);
        SpringApplication.exit(context); // context로 변경
    }
}