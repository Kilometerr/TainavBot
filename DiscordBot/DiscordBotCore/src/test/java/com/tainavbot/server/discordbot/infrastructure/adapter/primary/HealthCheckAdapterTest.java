package com.tainavbot.server.discordbot.infrastructure.adapter.primary;

import com.tainavbot.server.discordbot.infrastructure.adapter.primary.configuration.HealthCheckAdapterTestConfiguration;
import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import com.tainavbot.server.discordbot.infrastructure.api.enumeration.HealthStatusEnumDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = HealthCheckAdapterTestConfiguration.class)
class HealthCheckAdapterTest {

    @Autowired
    @Qualifier("discordHealthCheck")
    private HealthCheckAdapter healthCheckAdapter;

    @Test
    void shouldReturnOkHealthStatus() {
        //given
        //when
        HealthStatusDto result = healthCheckAdapter.checkHealth();
        //then
        HealthStatusDto healthStatusDto = new HealthStatusDto(HealthStatusEnumDto.OK, "OK");
        assertEquals(healthStatusDto, result);
    }
}