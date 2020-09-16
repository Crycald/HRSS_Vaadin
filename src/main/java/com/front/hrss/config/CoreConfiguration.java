package com.front.hrss.config;

import com.front.hrss.service.RecruiterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CoreConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RecruiterService recruiterService() {
        return new RecruiterService();
    }
}