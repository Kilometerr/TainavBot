package com.tainavbot.server.orchestrator.infrastructure.adapter.secondary;

import com.tainavbot.server.discordbot.infrastructure.api.HealthCheck;
import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import com.tainavbot.server.orchestrator.domain.model.HealthStatus;
import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.mapper.HealthStatusOutputMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DiscordBotAdapter {

    private final HealthCheck healthCheck;

    private final HealthStatusOutputMapper healthStatusOutputMapper;

    public HealthStatus sendHealthCheckMessage() {

        HealthStatusDto healthStatusDto = healthCheck.checkHealth();
        return healthStatusOutputMapper.map(healthStatusDto);

    }
}
