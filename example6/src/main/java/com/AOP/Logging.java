package com.AOP;

import com.interfaces.LogAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class Logging {
    private final Logger log = Logger.getLogger(Logging.class.getName());

    @Around("execution(* com.classes.*.*(..))")
    public Object logs(ProceedingJoinPoint joinPoint) throws Throwable{
//        log.info("Logging from "+joinPoint.getSignature().toString());
        Instant start = Instant.now();
        System.out.println("Transfering to "+joinPoint.getSignature());
        Object obj = joinPoint.proceed();
        Instant end = Instant.now();
//        log.info("Logging from "+joinPoint.getSignature().toString());
        long duration = Duration.between(start,end).toMillis();
//        log.info("Execution duration "+ duration);
        return obj;
    }

//    @Around("@annotation(com.interfaces.LogAspect)") // best for marking specific classes
//    public Object logsWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable{
////        log.info("Logging from "+joinPoint.getSignature().toString());
//        Instant start = Instant.now();
//        System.out.println("Transfering to "+joinPoint.getSignature());
//        Object obj = joinPoint.proceed();
//        Instant end = Instant.now();
////        log.info("Logging from "+joinPoint.getSignature().toString());
//        long duration = Duration.between(start,end).toMillis();
////        log.info("Execution duration "+ duration);
//        return obj;
//    }
}
