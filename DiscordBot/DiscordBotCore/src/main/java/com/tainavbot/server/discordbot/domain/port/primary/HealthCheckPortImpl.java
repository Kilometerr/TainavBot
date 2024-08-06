package com.tainavbot.server.discordbot.domain.port.primary;

import com.tainavbot.server.discordbot.domain.enumeration.HealthStatusEnum;
import com.tainavbot.server.discordbot.domain.model.HealthStatus;
import com.tainavbot.server.discordbot.service.CheckHealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HealthCheckPortImpl implements HealthCheckPort {
    protected final CheckHealthService checkHealthService;

    @Override
    public HealthStatus checkHealth() {
        checkHealthService.checkHealthStatus();
        return new HealthStatus(HealthStatusEnum.OK, "OK"); //TODO fix return type, add more error handling
    }
}
