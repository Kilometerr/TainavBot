package com.tainavbot.server.orchestrator.application.service;

import com.tainavbot.server.orchestrator.application.port.primary.HealthCheckUC;
import com.tainavbot.server.orchestrator.domain.model.HealthStatus;
import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.DiscordBotAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckService implements HealthCheckUC {
    private final DiscordBotAdapter discordBotAdapter;

    @Override
    public HealthStatus checkHealth() {
        return discordBotAdapter.sendHealthCheckMessage();
    }
}
