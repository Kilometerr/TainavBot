package com.tainavbot.server.discordbot.service;

import com.tainavbot.server.discordbot.configuration.DiscordConfig;
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
    private DiscordConfig discordConfig; //TODO fix

    private JDA jda;

    @SneakyThrows
    @PostConstruct
    public void init() {
        this.jda = JDABuilder.createDefault(discordConfig.getToken()).build();
        jda.awaitReady(); // Blocking operation until JDA is ready
    }

    @Override
    public void checkHealthStatus() {
        TextChannel channel = jda.getTextChannelById(discordConfig.getChannelId());
        if (channel != null) {
            channel.sendMessage("Its alive!").queue(); //TODO extend functionality for db
        } else {
            throw new IllegalArgumentException("Channel ID is not valid"); //TODO refactor with extansion for db
        }
    }
}
