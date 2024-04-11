package com.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;
import java.io.*;

@Aspect
@Component
@Order(1)
public class VehicleStartCheck {

    @Before("execution( * com.classes.Vehicle.*(..)) && args(vehicle_start)")
    void check(JoinPoint joinPoint , boolean vehicle_start) throws Exception {
        System.out.println("Before check AOP for method "+joinPoint.getSignature());
        if(!vehicle_start) throw new Exception("Vehicle not start by AOP !");
    }

//    @Before("annotation(com.interfaces.LogAspect)")
//    void checkWithAnnotation(JoinPoint joinPoint , boolean vehicle_start) throws Exception {
//        System.out.println("Before check AOP for method "+joinPoint.getSignature());
//        if(!vehicle_start) throw new Exception("Vehicle not start by AOP !");
//    }
}
