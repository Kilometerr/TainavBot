package com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto;

import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.enumeration.HealthStatusEnumResponse;

public record HealthStatusResponse(HealthStatusEnumResponse healthStatusEnumResponse, String message) {
}
