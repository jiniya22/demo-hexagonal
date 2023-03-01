package me.jiniworld.demohx.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(
    @Value("\${demo-app.version}") val version: String,
    @Value("\${spring.profiles.active}") val profile: String,
    @Value("\${demo-app.url}") val url: String,
) {

    @Bean
    fun openAPI(): OpenAPI =
        OpenAPI()
//            .components(
//                Components()
//                .addSecuritySchemes("access_token",
//                    SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
//                        .`in`(SecurityScheme.In.HEADER).name("Authorization")))
//            .addSecurityItem(SecurityRequirement().addList("access_token"))
            .info(
                Info().title("demo-reactive-app API - $profile")
                    .description("Hexagonal Architecture 구조로 만든 코프링 웹 애플리케이션")
                    .contact(Contact().name("jini").url("https://blog.jiniworld.me/").email("jini@jiniworld.me"))
                    .license(License().name("MIT License").url("https://github.com/jiniya22/demo-hexagonal/blob/master/LICENSE")))
            .servers(
                listOf(
                    Server().url(url).description(
                        "demo-reactive-app api ($profile)"
                    )
                )
            )

}