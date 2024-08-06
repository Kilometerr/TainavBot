package com.tainavbot.server.orchestrator.infrastructure.adapter.primary;

import com.tainavbot.server.orchestrator.application.port.primary.HealthCheckUC;
import com.tainavbot.server.orchestrator.domain.model.HealthStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthCheckController {
    private final HealthCheckUC healthCheckUC;

    @GetMapping
    public HealthStatus getHealthStatus() {
        return healthCheckUC.checkHealth();
    }
}
