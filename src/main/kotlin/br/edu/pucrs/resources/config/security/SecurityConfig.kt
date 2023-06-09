package br.edu.pucrs.resources.config.security

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class SecurityConfig {

    @Bean
    fun filterChain(
        httpSecurity: HttpSecurity,
        @Qualifier("customAuthenticationEntryPoint") authEntryPoint: RestAuthenticationEntryPoint
    ): SecurityFilterChain {
        httpSecurity.authorizeHttpRequests()
            .requestMatchers("/actuator/**")
            .permitAll()
            .requestMatchers("/swagger-ui/**")
            .permitAll()
            .requestMatchers("/swagger-ui.html")
            .permitAll()
            .requestMatchers("/v3/api-docs/**")
            .permitAll()
            .and()
            .authorizeHttpRequests()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(authEntryPoint).and()
            .httpBasic().and()
            .cors().and().csrf().disable()

        httpSecurity.oauth2ResourceServer {
            it.jwt()
                .and()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
        }

        return httpSecurity.build()
    }

    @Bean
    fun jwtAuthenticationConverterForKeycloak(): JwtAuthenticationConverter? {
        val jwtGrantedAuthoritiesConverter: Converter<Jwt, Collection<GrantedAuthority>> =
            Converter<Jwt, Collection<GrantedAuthority>> { jwt ->
                val realmAccess: Map<String, Collection<String>> =
                    jwt.getClaim("realm_access")
                val roles = realmAccess["roles"]!!

                roles.map { role: String ->
                        SimpleGrantedAuthority(
                            role
                        )
                    }
            }
        val jwtAuthenticationConverter = JwtAuthenticationConverter()
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter)
        return jwtAuthenticationConverter
    }
}