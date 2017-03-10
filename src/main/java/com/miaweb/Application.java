package com.miaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication
public class Application {
	final static String ACTIVE_PROFILE = "dev";

	private static boolean noAnyProfilesAssigned(String[] args) {
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		return (!source.containsProperty("spring.profiles.active")
				&& !System.getenv().containsKey("SPRING_PROFILES_ACTIVE"));
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		if (noAnyProfilesAssigned(args)) {
			app.setAdditionalProfiles(ACTIVE_PROFILE);
		}
		app.run(args);
	}
}