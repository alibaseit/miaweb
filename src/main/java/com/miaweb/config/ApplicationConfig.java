package com.miaweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.miaweb.repository.jpa")
@EnableTransactionManagement	
public class ApplicationConfig {

}
