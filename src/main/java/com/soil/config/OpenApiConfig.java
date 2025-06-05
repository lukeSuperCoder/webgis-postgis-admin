package com.soil.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI (Swagger) 配置类
 */
@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("土壤信息服务平台 API")
                        .description("福建省土壤信息服务平台API文档")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("土壤信息服务团队")
                                .url("http://soil-info.example.com")
                                .email("contact@soil-info.example.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("土壤信息平台Wiki文档")
                        .url("https://soil-wiki.example.com"));
    }
} 