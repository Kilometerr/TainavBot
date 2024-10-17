package com.tainavbot.server.discordbot.domain.port.primary;

import com.tainavbot.server.discordbot.domain.model.HealthStatus;

public interface HealthCheckPort {
    HealthStatus checkHealth();
}
