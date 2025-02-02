package com.example.springaopapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class HelloAspect {

    @Around("@annotation(HelloAspectAnnot))")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice");
        joinPoint.proceed();
    }
   /* @Before("execution(void com.example.springaopapp.Hello.sayHello())")
    public void beforeAdvice() {
        System.out.println("Before advice");
    }*/

   /* @Around("execution(void com.example.springaopapp.Hello.sayHello())")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around advice");
        joinPoint.proceed();
    }*/

/*    @After("execution(void com.example.springaopapp.Hello.sayHello())")
    public void afterAdvice() {
        System.out.println("After advice");
    }*/

}
