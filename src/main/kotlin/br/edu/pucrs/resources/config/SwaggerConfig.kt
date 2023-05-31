package br.edu.pucrs.resources.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private const val SECURITY_SCHEME_NAME = "bearerAuth"
private const val BEARER_FORMAT = "JWT"
private const val SECURITY_SCHEME_TYPE = "bearer"


@Configuration
class SwaggerConfig {

    @Bean
    fun api(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Resources API - Group 4")
                    .description("Resources API documentation")
                    .version("v0.1.0")
            )
            .addSecurityItem(SecurityRequirement().addList(SECURITY_SCHEME_NAME))
            .components(
                Components()
                    .addSecuritySchemes(
                        SECURITY_SCHEME_NAME, SecurityScheme()
                            .type(SecurityScheme.Type.HTTP)
                            .scheme(SECURITY_SCHEME_TYPE)
                            .bearerFormat(BEARER_FORMAT)
                    )
            )
    }
}