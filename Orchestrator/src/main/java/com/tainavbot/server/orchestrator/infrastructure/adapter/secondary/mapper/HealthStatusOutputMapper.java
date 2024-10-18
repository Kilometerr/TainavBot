package com.tainavbot.server.orchestrator.infrastructure.adapter.secondary.mapper;

import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import com.tainavbot.server.orchestrator.domain.vo.HealthStatusVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HealthStatusOutputMapper {

    @Mapping(target = "healthStatusEnum", source = "healthStatusEnumDto")
    HealthStatusVO map(HealthStatusDto healthStatusDto);
}
