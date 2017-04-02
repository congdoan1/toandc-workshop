package com.toandc.workshop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
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
        Class<?> clazz = AopProxyUtils.ultimateTargetClass(joinPoint.getTarget());
        String params = "";
        Object[] arguments = joinPoint.getArgs();
        for (Object object : arguments) {
            params += object + "\n";
        }
        LOGGER.info("Before class[" + clazz.getSimpleName() + "]:\nname=[" + joinPoint.getSignature().getName() + "]\nparam=[" + params + "]");
    }


    @Around("execution(* com.toandc.workshop..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        Class<?> clazz = AopProxyUtils.ultimateTargetClass(pjp.getTarget());
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        LOGGER.info("After class[" + clazz.getSimpleName() + "]:\nname=[" + pjp.getSignature().getName() + "]\nparam=[" + pjp.proceed() + "]");
        LOGGER.info("Execution time class[" + clazz.getSimpleName() + "]:\nname=[" + pjp.getSignature().getName() + "]\nduration=" + elapsedTime + " milliseconds.");
        return output;
    }
}
