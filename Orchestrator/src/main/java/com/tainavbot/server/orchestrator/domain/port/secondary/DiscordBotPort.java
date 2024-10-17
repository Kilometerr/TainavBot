package com.tainavbot.server.orchestrator.domain.port.secondary;

import com.tainavbot.server.orchestrator.domain.model.HealthStatus;

public interface DiscordBotPort {
    HealthStatus getDiscordBotHealth();
}
