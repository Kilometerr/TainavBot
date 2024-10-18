package com.tainavbot.server.orchestrator.domain.port.primary.mapper;

import com.tainavbot.server.orchestrator.domain.vo.HealthStatusVO;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.api.dto.HealthStatusResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface HealthCheckMapper {

    @Mapping(target = "healthStatusEnumResponse", source = "healthStatusEnum")
    HealthStatusResponse map(HealthStatusVO healthStatus);
}
