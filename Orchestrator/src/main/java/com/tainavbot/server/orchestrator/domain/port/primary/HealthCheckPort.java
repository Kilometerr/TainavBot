package com.tainavbot.server.orchestrator.domain.port.primary;

import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.HealthStatusResponse;

public interface HealthCheckPort {

    HealthStatusResponse checkHealth();

}
