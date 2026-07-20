package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    // Runs right before any method in the com.library.service package executes
    @Before("execution(* com.library.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP logBefore] - About to execute: " + joinPoint.getSignature().getName());
    }

    // Runs right after any method in the com.library.service package finishes
    @After("execution(* com.library.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP logAfter] - Successfully finished: " + joinPoint.getSignature().getName());
    }
}