package com.example.project.AOP;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.io.*;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    /* @Around("execution(* com.example.project..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Starting method: "+joinPoint.getSignature().toString());
        Instant start = Instant.now();
        Object ret = joinPoint.proceed();
        Instant end = Instant.now();
        long timelapse = Duration.between(start,end).toMillis();
        log.info("Ending Method "+joinPoint.getSignature().toString());
        log.info("Time take "+timelapse);
        return ret;
    }

    @AfterThrowing(value = "execution(* com.example.project..*.*(..))", throwing = "ex")
    public void logExceptionHandler(JoinPoint joinPoint,Exception ex){
        log.error(joinPoint.getSignature().toLongString()+" Caused the error due to "+ex.getMessage());
    } */
}
