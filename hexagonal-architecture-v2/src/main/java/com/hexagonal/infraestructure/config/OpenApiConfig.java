package com.hexagonal.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiDocConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("hexagonal-architecture-v2")
                        .description("Bookstore online - Hexagonal Architecture")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Matheus Ferreira")
                                .email("mat.s.ferreira@gmail.com")
                        )
                );
    }

}
