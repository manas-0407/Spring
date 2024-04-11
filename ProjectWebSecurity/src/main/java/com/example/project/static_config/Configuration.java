package com.example.project.static_config;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@org.springframework.context.annotation.Configuration
public class Configuration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);

        registry.addViewController("/courses").setViewName("courses.html");
        registry.addViewController("/contact").setViewName("contact.html");
        registry.addViewController("/about").setViewName("about.html");
        registry.addViewController("/holidays").setViewName("holidays.html");
        registry.addViewController("/dashboard").setViewName("dashboard.html");
    }

}
