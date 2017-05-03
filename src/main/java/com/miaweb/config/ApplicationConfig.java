package com.miaweb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages="com.miaweb.repository.jpa")
@EnableAspectJAutoProxy
@EnableTransactionManagement	
public class ApplicationConfig {

}
