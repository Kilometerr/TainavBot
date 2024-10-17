package com.tainavbot.server.discordbot.configuration;

import com.tainavbot.server.discordbot.domain.port.primary.HealthCheckPort;
import com.tainavbot.server.discordbot.domain.port.primary.HealthCheckPortImpl;
import com.tainavbot.server.discordbot.infrastructure.adapter.primary.HealthCheckAdapter;
import com.tainavbot.server.discordbot.infrastructure.adapter.primary.mapper.HealthStatusOutputMapper;
import com.tainavbot.server.discordbot.infrastructure.api.HealthCheck;
import com.tainavbot.server.discordbot.service.CheckHealthService;
import com.tainavbot.server.discordbot.service.CheckHealthServiceImpl;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthCheckConfiguration {

    @Bean
    public HealthCheck healthCheck(HealthCheckPort healthCheckPort, HealthStatusOutputMapper healthStatusOutputMapper) {
        return new HealthCheckAdapter(healthCheckPort, healthStatusOutputMapper);
    }

    @Bean
    public HealthCheckPort healthCheckPort(CheckHealthService checkHealthService) {
        return new HealthCheckPortImpl(checkHealthService);
    }

    @Bean
    public CheckHealthService checkHealthService() {
        return new CheckHealthServiceImpl();
    }

    @Bean
    public HealthStatusOutputMapper healthStatusOutputMapper() {
        return Mappers.getMapper(HealthStatusOutputMapper.class);
    }

}
