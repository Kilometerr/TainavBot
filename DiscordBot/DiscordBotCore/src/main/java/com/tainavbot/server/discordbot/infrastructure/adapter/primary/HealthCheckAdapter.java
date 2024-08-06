package com.tainavbot.server.discordbot.infrastructure.adapter.primary;

import com.tainavbot.server.discordbot.domain.port.primary.HealthCheckPort;
import com.tainavbot.server.discordbot.infrastructure.adapter.primary.mapper.HealthStatusOutputMapper;
import com.tainavbot.server.discordbot.infrastructure.api.HealthCheck;
import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service("discordHealthCheck")
public class HealthCheckAdapter implements HealthCheck {

    private final HealthCheckPort healthCheckPort;

    private final HealthStatusOutputMapper healthStatusOutputMapper;

    @Override
    public HealthStatusDto checkHealth() {
        return healthStatusOutputMapper.map(healthCheckPort.checkHealth());
    }

}
