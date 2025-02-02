package com.example.videoapiapp.aspect;

import com.example.videoapiapp.service.MailCreatorService;
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
public class MailAspect {

    private final MailCreatorService mailService;

    @Around("@annotation(SendMailAspect)")
    public Object sendMail(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        mailService.sendMail();
        return result;
    }
}
