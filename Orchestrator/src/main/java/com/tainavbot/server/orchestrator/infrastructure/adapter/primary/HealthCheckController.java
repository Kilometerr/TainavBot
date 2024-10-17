package com.tainavbot.server.orchestrator.infrastructure.adapter.primary;

import com.tainavbot.server.orchestrator.application.port.primary.HealthCheckUC;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.HealthStatusResponse;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.mapper.HealthCheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.mapstruct.factory.Mappers.getMapper;

@RestController
@RequestMapping("/health")
@RequiredArgsConstructor
public class HealthCheckController {
    private final HealthCheckUC healthCheckUC;

    private final HealthCheckMapper mapper = getMapper(HealthCheckMapper.class);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HealthStatusResponse> getHealthStatus() {
        HealthStatusResponse response = mapper.map(healthCheckUC.checkHealth());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
