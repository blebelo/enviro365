package com.enviro.assessment.grad001.bennylebelo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Waste Sorting API")
                        .version("1.0")
                        .description("Documentation for Waste Sorting API"));
    }
}
