package com.shreeganeshfinance.creditapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.shreeganeshfinance.creditapplication.security.filter.AuthenticationFilter;
import com.shreeganeshfinance.creditapplication.security.filter.ExceptionHandlerFilter;
import com.shreeganeshfinance.creditapplication.security.filter.JWTAuthorizationFilter;
import com.shreeganeshfinance.creditapplication.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;



@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
        http
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/h2/**").permitAll()
                .requestMatchers("/user/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstant.REGISTER_PATH).permitAll()
                .anyRequest().authenticated())
            .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
            .addFilter(authenticationFilter)
            .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return http.build();
    }
    
}
