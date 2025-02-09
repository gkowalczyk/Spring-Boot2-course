package com.example.carapiappdb.aspect;

import com.example.carapiappdb.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class GetNewsAspect {

    private final CarService carService;

    @Around("@annotation(com.example.carapiappdb.aspect.SaveNewsToDb)")
    public Object getData(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        carService.saveNewsToDb();
        return result;
    }
}
