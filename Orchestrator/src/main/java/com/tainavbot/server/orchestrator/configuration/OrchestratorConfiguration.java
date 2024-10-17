package com.tainavbot.server.orchestrator.configuration;


import com.tainavbot.server.discordbot.infrastructure.api.HealthCheck;
import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.DiscordBotAdapter;
import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.mapper.HealthStatusOutputMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrchestratorConfiguration {

    @Bean
    protected DiscordBotAdapter discordBotAdapter(HealthCheck healthCheck) {
        return new DiscordBotAdapter(healthCheck, Mappers.getMapper(HealthStatusOutputMapper.class));
    }
}
