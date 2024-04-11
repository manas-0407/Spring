package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.example.project.repository")
@EntityScan(value = "com.example.project.models")
public class ProjectWebJPAApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectWebJPAApplication.class, args);
    }
}
