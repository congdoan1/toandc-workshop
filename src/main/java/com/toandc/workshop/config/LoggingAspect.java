package com.toandc.workshop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by toanqri on 4/1/17.
 */
@Component
@Aspect
public class LoggingAspect {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.toandc.workshop..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        LOGGER.info("Before " + joinPoint.getTarget().getClass().getSimpleName() + " [" + joinPoint.getSignature().getName() + "] " + joinPoint.getArgs().length);
    }

    @AfterReturning("execution(* com.toandc.workshop..*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        LOGGER.info("After " + joinPoint.getTarget().getClass().getSimpleName() + " [" + joinPoint.getSignature().getName() + "] " + joinPoint.getArgs().length);
    }

    @Around("execution(* com.toandc.workshop..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.info("Execution time " + pjp.getTarget().getClass().getSimpleName() + " [" + pjp.getSignature().getName() + "] " + elapsedTime + " milliseconds.");
        return output;
    }
}
