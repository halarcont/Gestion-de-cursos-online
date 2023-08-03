package com.onlinecourse.notificationservice.eurekaConfig;

import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EurekaClientConfig {

    @Bean
    public AbstractDiscoveryClientOptionalArgs<?> optionalArgs() {
        return null;
    }
}
