package com.tainavbot.server.orchestrator.infrastructure.adapter.primary;

import com.tainavbot.server.discordbot.infrastructure.api.HealthCheck;
import com.tainavbot.server.discordbot.infrastructure.api.dto.HealthStatusDto;
import com.tainavbot.server.discordbot.infrastructure.api.enumeration.HealthStatusEnumDto;
import com.tainavbot.server.orchestrator.infrastructure.adapter.primary.configuration.OrchestratorTestConfiguration;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.tainavbot.server.discordbot.infrastructure.api.enumeration.HealthStatusEnumDto.OK;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = OrchestratorTestConfiguration.class)
@AutoConfigureMockMvc
@EnableAutoConfiguration
class HealthCheckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HealthCheck healthCheck;

    private static final String ENDPOINT = "/health";
    private static final String ENUM_RESPONSE = "$.healthStatusEnumResponse";
    private static final String MESSAGE_RESPONSE = "$.message";
    private static final String RESPONSE_OK = "Ok";

    @Test
    void shouldReturnHealthStatus() throws Exception {
        //given
        HealthStatusDto healthStatusDto = buildHealthStatusDto(OK, RESPONSE_OK);
        when(healthCheck.checkHealth()).thenReturn(healthStatusDto);
        //when&then
        mockMvc.perform(get(ENDPOINT)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath(ENUM_RESPONSE).value(OK.toString()))
                .andExpect(jsonPath(MESSAGE_RESPONSE).value(RESPONSE_OK))
                .andReturn();
    }

    @NotNull
    private static HealthStatusDto buildHealthStatusDto(HealthStatusEnumDto healthStatusEnumDto, String message) {
        return new HealthStatusDto(healthStatusEnumDto, message);
    }
}