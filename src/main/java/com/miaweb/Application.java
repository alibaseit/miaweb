package com.miaweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = {Application.class, Jsr310JpaConverters.class}
)

@SpringBootApplication
public class Application {
	final static String ACTIVE_PROFILE = "dev";
	private final static Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private static Environment environment;

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

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
		log.info("********************************" + System.getProperty("orc_passwd"));
	}
}
