package com.codeexample.springbootrestapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

/*
Using such a config class we can customise the SecurityFilterChain to add or remove any specific filters or to redirect
to a different login page instead of the default one.

 */

@Configuration
@EnableWebSecurity // This tells Spring to let us configure the SecurityFilterChain through this class
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/allemployees").permitAll()
                        // All employees is now permitted for all without authentication
                        .anyRequest().authenticated())
                // Through this method, Any Request that comes will get authenticated
                .formLogin(Customizer.withDefaults());
                //.formLogin(formLoginConfig -> formLoginConfig.loginPage("AddLoginPage")) Customised Login Page Redirection

        return httpSecurity.build();
    }

}
