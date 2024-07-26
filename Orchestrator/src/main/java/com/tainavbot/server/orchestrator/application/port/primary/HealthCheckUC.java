package com.tainavbot.server.orchestrator.application.port.primary;

import com.tainavbot.server.orchestrator.domain.model.HealthStatus;

import java.util.concurrent.CompletableFuture;

public interface HealthCheckUC {

    CompletableFuture<HealthStatus> checkHealth();

}
