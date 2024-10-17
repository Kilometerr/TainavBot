package com.tainavbot.server.discordbot.service;

import com.tainavbot.server.discordbot.domain.model.HealthStatus;

public interface CheckHealthService {
    HealthStatus checkHealthStatus();
}
