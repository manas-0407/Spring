package com.example.project.static_config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
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

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf( csrf -> csrf.ignoringRequestMatchers("/saveContact")).
                authorizeHttpRequests(authorize -> authorize.requestMatchers(("/dashboard")).authenticated()
                .requestMatchers("/","/home").permitAll()
                .requestMatchers("/courses").permitAll()
                .requestMatchers("/holidays/**").permitAll()
                .requestMatchers("/about").permitAll()
                .requestMatchers("/contact").permitAll()
                .requestMatchers("/assets/**").permitAll()
                .requestMatchers("/login").permitAll()
                .requestMatchers("/logout").permitAll()
                .requestMatchers("/saveContact").permitAll())
                        .formLogin( loginCOnfig -> loginCOnfig.loginPage("/login")
                                .defaultSuccessUrl("/dashboard")
                                .failureUrl("/login?error=true").permitAll())
//                .logout(logoutConfigurer -> logoutConfigurer.logoutSuccessUrl("/login?logout=true")
//                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());


        /* Login handle */
//        http.formLogin( formLogin ->
//                formLogin.loginPage("/login")
//                        .successHandler(successHandler)
//                        .failureHandler(failureHandler)
//                        .permitAll());

//        http.formLogin(formLogin -> formLogin.loginPage("/login.html")
//                        .loginProcessingUrl("/login").defaultSuccessUrl("/dashboard"));
        /*

        /* Logout Handle */
//        http.logout(
//                logout ->logout.logoutSuccessUrl("/login?logout=true")
//                        .invalidateHttpSession(true)
//                        .permitAll()
//        );

        // API auth handle
//        http.httpBasic(withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        System.err.println("Instantiating InMemory Bean");
        UserDetails users = User.withDefaultPasswordEncoder()
                .username("manas")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("54321")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(users , admin);
    }
}
