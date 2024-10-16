package com.tainavbot.server.orchestrator.domain.model;

import com.tainavbot.server.orchestrator.domain.enumeration.HealthStatusEnum;

public record HealthStatus(HealthStatusEnum healthStatusEnum, String message) { }
