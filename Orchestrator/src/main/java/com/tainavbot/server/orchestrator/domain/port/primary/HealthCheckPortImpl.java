package com.tainavbot.server.orchestrator.domain.port.primary;

import com.tainavbot.server.orchestrator.domain.port.primary.mapper.HealthCheckMapper;
import com.tainavbot.server.orchestrator.domain.port.secondary.DiscordBotPort;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.HealthStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static org.mapstruct.factory.Mappers.getMapper;

@Service
@RequiredArgsConstructor
public class HealthCheckPortImpl implements HealthCheckPort {

    private final HealthCheckMapper mapper = getMapper(HealthCheckMapper.class);

    private final DiscordBotPort discordBotPort;

    @Override
    public HealthStatusResponse checkHealth() {
        return mapper.map(discordBotPort.getDiscordBotHealth());
    }
}
