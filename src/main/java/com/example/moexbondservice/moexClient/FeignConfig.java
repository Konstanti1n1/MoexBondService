package com.example.moexbondservice.moexClient;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {

    @Bean
    feign.Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }
}
