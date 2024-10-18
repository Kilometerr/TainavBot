package com.tainavbot.server.orchestrator.infrastructure.adapter.primary;

import com.tainavbot.server.orchestrator.domain.port.primary.HealthCheckPort;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.HealthStatusResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthCheckController {

    private final HealthCheckPort healthCheckPort;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HealthStatusResponse> getHealthStatus() {
        return new ResponseEntity<>(healthCheckPort.checkHealth(), HttpStatus.OK);
    }
}
