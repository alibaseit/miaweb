package com.miaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // Enable swagger 2.0 spec
public class SwaggerConfig { // @formatter:off
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.miaweb.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	} // @formatter:on

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("My REST API", "Some custom description of API.", "API TOS", "Terms of service",
				contact("Ali Dogan", "alibaseit.com", "myeaddress@company.com"), "License of API", "API license URL");
		return apiInfo;
	}

	private Contact contact(String name, String url, String email) {
		return new Contact(name, url, email);
	}
}
