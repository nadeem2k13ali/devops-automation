/*
package com.ali.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_12)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        Contact contact= new Contact("Nadeem Ali", "", "nadeem2k13ali@gmail.com");
        return new ApiInfoBuilder().title("TEST")
                .description("SPRING BOOT TEST DOCUMENTATIONS")
                .contact(contact).license("Apache License")
                .licenseUrl("").version("2.0").build();

    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", AUTHORIZATION_HEADER, "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        springfox.documentation.service.AuthorizationScope authorizationScope = new springfox.documentation.service.AuthorizationScope("global", "accessEverything");
        springfox.documentation.service.AuthorizationScope[] authorizationScopes = new springfox.documentation.service.AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("Authorization",authorizationScopes));
    }
}*/
