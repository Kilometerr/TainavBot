package com.tainavbot.server.discordbot.infrastructure.api;

import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;

public interface HealthCheck {
    HealthStatusDto checkHealth();
}
