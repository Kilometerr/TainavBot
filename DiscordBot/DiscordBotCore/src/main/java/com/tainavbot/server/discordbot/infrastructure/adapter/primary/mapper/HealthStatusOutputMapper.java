package com.tainavbot.server.discordbot.infrastructure.adapter.primary.mapper;

import com.tainavbot.server.discordbot.domain.model.HealthStatus;
import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HealthStatusOutputMapper {

    @Mapping(target = "healthStatusEnumDto", source = "healthStatusEnum")
    HealthStatusDto map(HealthStatus healthStatus);
}
