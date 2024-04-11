package com.example.project.static_config.Auth_tester;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Slf4j
@Component
@Lazy
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    CustomAuthenticationFailureHandler(){
        System.err.println("Success Bean");
    }

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.info("Failed manas");
        response.sendRedirect("/login?error=true");
    }
}