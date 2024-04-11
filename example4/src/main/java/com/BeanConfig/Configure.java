package com.BeanConfig;

import com.Bean4.Person;
import com.Bean4.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackages = "com.Bean4")
public class Configure {

}
