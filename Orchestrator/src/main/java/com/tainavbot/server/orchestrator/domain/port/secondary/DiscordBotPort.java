package com.tainavbot.server.orchestrator.domain.port.secondary;

import com.tainavbot.server.orchestrator.domain.vo.HealthStatusVO;

public interface DiscordBotPort {
    HealthStatusVO getDiscordBotHealth();
}
