package com.tainavbot.server.discordbot.infrastructure.api.dto;

import com.tainavbot.server.discordbot.infrastructure.api.enumeration.HealthStatusEnumDto;

public record HealthStatusDto(HealthStatusEnumDto healthStatusEnumDto, String message) {
}
