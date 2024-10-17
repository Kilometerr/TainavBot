package com.tainavbot.server.orchestrator.application.port.primary;

import com.tainavbot.server.orchestrator.domain.model.HealthStatus;

public interface HealthCheckUC {

    HealthStatus checkHealth();

}
