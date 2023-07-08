package com.org.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
/*@EnableWebfluxSecurity*/
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
                .pathMatchers("/actuator/**")
                .permitAll()
                .and()
                .authorizeExchange()
                .anyExchange()
                .authenticated();
              /*   .and()
                .oauth2Login(); */// to redirect to oauth2 login page.

        return http.build();
    }

 /*   @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
             http
                .authorizeExchange(exchange -> exchange.anyExchange().authenticated())
                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);

        http.csrf().disable();
        return http.build();
    }*/

}
