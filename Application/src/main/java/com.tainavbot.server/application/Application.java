package com.tainavbot.server.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //scan base packages?
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
