package com.tainavbot.server.discordbot.domain.port.primary;

import com.tainavbot.server.discordbot.domain.model.HealthStatus;
import com.tainavbot.server.discordbot.service.CheckHealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("discordBotHealthCheck")
@RequiredArgsConstructor
public class HealthCheckPortImpl implements HealthCheckPort {
    protected final CheckHealthService checkHealthService;

    @Override
    public HealthStatus checkHealth() {
        return checkHealthService.checkHealthStatus();
    }
}
