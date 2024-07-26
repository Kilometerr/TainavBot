package com.tainavbot.server.orchestrator.application.service;

import com.tainavbot.server.orchestrator.application.port.primary.HealthCheckUC;
import com.tainavbot.server.orchestrator.domain.enumeration.HealthStatusEnum;
import com.tainavbot.server.orchestrator.domain.model.HealthStatus;
import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.DiscordBotAdapter;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class HealthCheckService implements HealthCheckUC {
    private final DiscordBotAdapter discordBotAdapter;

    @Async
    @Override
    @Cacheable("healthStatus")
    @CircuitBreaker(name = "healthCheckService", fallbackMethod = "defaultHealthStatus")
    public CompletableFuture<HealthStatus> checkHealth() {
        return CompletableFuture.supplyAsync(() -> {
            discordBotAdapter.sendHealthCheckMessage("Health check: Nienawidze Vaniata!");
            return new HealthStatus(HealthStatusEnum.OK.name());
        });
    }

    public CompletableFuture<HealthStatus> defaultHealthStatus(Throwable throwable) {
        //log throwable in the future
        return CompletableFuture.completedFuture(new HealthStatus("DOWN"));
    }

}
