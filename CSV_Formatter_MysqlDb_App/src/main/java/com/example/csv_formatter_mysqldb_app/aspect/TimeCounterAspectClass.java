package com.example.csv_formatter_mysqldb_app.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class TimeCounterAspectClass {


    @Around("@annotation(TimeCounterAspect)")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("Method execution time: " + joinPoint.getSignature().getName() + " " + (end - start) + "ms");
    }
}
