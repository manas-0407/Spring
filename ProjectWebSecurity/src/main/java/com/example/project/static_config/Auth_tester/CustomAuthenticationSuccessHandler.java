package com.example.project.static_config.Auth_tester;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Slf4j
@Component
@Lazy
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    CustomAuthenticationSuccessHandler(){
        System.err.println("Failure Bean");
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("SuccessFul Manas");
        response.sendRedirect("/dashboard");
    }
}