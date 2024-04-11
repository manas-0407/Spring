package com.example.project.static_config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

import static org.springframework.security.config.Customizer.withDefaults;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf( csrf -> csrf.ignoringRequestMatchers("/saveContact").ignoringRequestMatchers("/public/**")
                        .ignoringRequestMatchers(PathRequest.toH2Console()))
        .authorizeHttpRequests(authorize -> authorize.requestMatchers(("/dashboard")).authenticated()
                .requestMatchers("/displayMessages").hasRole("ADMIN")
                .requestMatchers("/closeMsg").hasRole("ADMIN")
                .requestMatchers("/","/home").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/saveContact").permitAll()
                .requestMatchers(PathRequest.toH2Console()).permitAll())
                        .formLogin( loginCOnfig -> loginCOnfig.loginPage("/login")
                                .defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?error=true").permitAll())
                .httpBasic(Customizer.withDefaults());

        http.headers(httpSecurityHeadersConfigurer -> {
            httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable);
        });
        // disabling frame security for rendering H2 COnsole

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails users = User.withDefaultPasswordEncoder()
                .username("manas")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(users , admin);
    }
}
