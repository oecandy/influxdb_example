package com.farota.api.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = { "com.farota.api.backend", "com.farota.api.backend.influx", })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
}
