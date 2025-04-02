package com.tasktracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI taskTrackerOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Task Tracker API")
                        .version("1.0")
                        .description("Task management application"));
    }
}

