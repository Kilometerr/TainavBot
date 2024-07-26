package com.tainavbot.server.orchestrator.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages = "com.tainavbot.server")
@EnableAsync
@EnableCaching
public class OrchestratorConfiguration {
}
