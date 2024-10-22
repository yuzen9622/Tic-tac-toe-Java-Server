package com.seroter.azure_basic_app.history;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HistoryConfig {

	@Bean(name = "historyCommandLineRunner")
	CommandLineRunner commandLineRunner(HistoryRepository repository) {
		return args -> {
			History oscar = new History(1L, 2L, new String[] {}, new String[] { "1", "O" }, new String[] {});
			repository.saveAll(List.of(oscar));

		};

	};
}
