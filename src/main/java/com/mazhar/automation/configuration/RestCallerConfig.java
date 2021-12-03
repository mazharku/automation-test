package com.mazhar.automation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestCallerConfig {

    @Bean(name = "restTemplateWithLoadBalance")
    public RestTemplate restTemplateConfig() {
        return new RestTemplate();
    }
}
