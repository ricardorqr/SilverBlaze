package com.silverblaze;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.silverblaze.service.storage.StorageService;

@SpringBootApplication
public class SilverBlazeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SilverBlazeApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
