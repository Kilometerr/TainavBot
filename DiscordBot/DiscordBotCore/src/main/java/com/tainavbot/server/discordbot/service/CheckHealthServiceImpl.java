package com.tainavbot.server.discordbot.service;

import com.tainavbot.server.discordbot.configuration.DiscordConfig;
import com.tainavbot.server.discordbot.domain.enumeration.HealthStatusEnum;
import com.tainavbot.server.discordbot.domain.model.HealthStatus;
import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckHealthServiceImpl implements CheckHealthService {

    @Autowired
    private DiscordConfig discordConfig;

    private JDA jda;

    @SneakyThrows
    @PostConstruct
    public void init() {
        this.jda = JDABuilder.createDefault(discordConfig.getToken()).build();
        jda.awaitReady();
    }

    @Override
    public HealthStatus checkHealthStatus() {
        TextChannel channel = jda.getTextChannelById(discordConfig.getChannelId());
        if (channel == null) {
            throw new IllegalArgumentException("Channel ID is not valid");
        } else {
            channel.sendMessage("Its alive!").queue();
            return new HealthStatus(HealthStatusEnum.OK, "OK");
        }
    }
}
