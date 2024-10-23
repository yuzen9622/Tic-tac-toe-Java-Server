package com.seroter.azure_basic_app.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean(name = "userCommandLineRunner")
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {

        };

    }
;

};
