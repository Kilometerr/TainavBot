package com.tainavbot.server.orchestrator.domain.vo;

import com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.enumeration.HealthStatusVoEnum;

public record HealthStatusVO(HealthStatusVoEnum healthStatusEnum, String message) { }
