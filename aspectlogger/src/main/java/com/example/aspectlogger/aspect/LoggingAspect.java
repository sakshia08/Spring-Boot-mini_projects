package com.example.aspectlogger.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut: any method in our app’s packages (controller, service, etc.)
    @Pointcut("execution(* com.example.aspectlogger..*(..))")
    public void appPackage() {}

    // Log method name + args BEFORE execution
    @Before("appPackage()")
    public void logMethodEntry(JoinPoint jp) {
        String method = jp.getSignature().toShortString();
        String args = Arrays.toString(jp.getArgs());
        log.debug("Entering {} with args {}", method, args);
    }

    // Log return value AFTER successful execution
    @AfterReturning(pointcut = "appPackage()", returning = "result")
    public void logReturn(JoinPoint jp, Object result) {
        String method = jp.getSignature().toShortString();
        log.debug("{} returned {}", method, result);
    }

    // Log exceptions (if any)
    @AfterThrowing(pointcut = "appPackage()", throwing = "ex")
    public void logException(JoinPoint jp, Throwable ex) {
        String method = jp.getSignature().toShortString();
        log.error("{} threw {}", method, ex.toString());
    }

    // Measure execution time AROUND method
    @Around("appPackage()")
    public Object timeExecution(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        try {
            return pjp.proceed();
        } finally {
            long end = System.nanoTime();
            String method = pjp.getSignature().toShortString();
            long ms = (end - start) / 1_000_000;
            log.debug("{} took {} ms", method, ms);
        }
    }
}

