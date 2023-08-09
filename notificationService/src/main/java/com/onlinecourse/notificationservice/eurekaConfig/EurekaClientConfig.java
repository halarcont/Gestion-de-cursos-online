package com.onlinecourse.notificationservice.eurekaConfig;

import com.netflix.discovery.AbstractDiscoveryClientOptionalArgs;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * eureka me exigia esta configuracion para funcionar correctamente, le hacia falta un bean AbstractDiscoveryClientOptionalArgs
 */
@Configuration
public class EurekaClientConfig {

    @Bean
    public AbstractDiscoveryClientOptionalArgs<?> optionalArgs() {
        return null;
    }
}
