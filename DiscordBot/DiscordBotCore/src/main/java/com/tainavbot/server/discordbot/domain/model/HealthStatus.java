package com.tainavbot.server.discordbot.domain.model;

import com.tainavbot.server.discordbot.domain.enumeration.HealthStatusEnum;

public record HealthStatus(HealthStatusEnum healthStatusEnum, String message) {
}
