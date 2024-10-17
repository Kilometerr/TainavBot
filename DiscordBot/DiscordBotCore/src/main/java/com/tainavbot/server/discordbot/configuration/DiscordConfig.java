package com.tainavbot.server.discordbot.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class DiscordConfig {

    @Value("${discord.token}")
    private String token;

    @Value("${channel.id}")
    private Long channelId;
}
