package com.toandc.workshop.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.stereotype.Component;

/**
 * Created by toanqri on 4/1/17.
 */
@Component
@Aspect
public class LoggingAspect {

    // get logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * log class name, method name and its parameter(s) before running
     *
     * @param joinPoint joinPoint
     */
    @Before("execution(* com.toandc.workshop..*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        Class<?> clazz = AopProxyUtils.ultimateTargetClass(joinPoint.getTarget());
        // construct parameter(s) string builder
        StringBuilder sb = new StringBuilder();
        Object[] arguments = joinPoint.getArgs();
        for (Object object : arguments) {
            sb.append("\ntype=").append(object.getClass().getSimpleName()).append(" & value=").append(object);
        }
        if (!sb.toString().isEmpty()) {
            sb.append("\n");
        }
        LOGGER.info("BEFORE " + clazz.getSimpleName() + "." + joinPoint.getSignature().getName() + ": param=[" + sb.toString() + "]");
    }

    /**
     * log class name, method name, return value and execution time at the end of method
     *
     * @param pjp pjp
     * @return output
     * @throws Throwable
     */
    @Around("execution(* com.toandc.workshop..*.*(..))")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        Class<?> clazz = AopProxyUtils.ultimateTargetClass(pjp.getTarget());
        long start = System.currentTimeMillis();
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        // log return value at the end
        LOGGER.info("AFTER " + clazz.getSimpleName() + "." + pjp.getSignature().getName() + ": return=[" + (output == null ? "" : output) + "]");
        // log execution time
        LOGGER.info("EXECUTION TIME " + clazz.getSimpleName() + "." + pjp.getSignature().getName() + "=" + elapsedTime + " milliseconds.");
        return output;
    }
}
