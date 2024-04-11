package com.configure6;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.classes", "com.AOP"})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class Configure {
}
