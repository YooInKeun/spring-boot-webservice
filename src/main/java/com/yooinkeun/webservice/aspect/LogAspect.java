package com.yooinkeun.webservice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Before("execution(* com.yooinkeun.webservice.service.posts.*.*Aop(..))")
    public void onBeforeHandler(JoinPoint joinPoint) {
        log.info("onBeforeHandler");
    }

    @After("execution(* com.yooinkeun.webservice.service.posts.*.*Aop(..))")
    public void onAfterHandler(JoinPoint joinPoint) {
        log.info("onAfterHandler");
    }

    @AfterReturning(pointcut = "execution(* com.yooinkeun.webservice.service.posts.*.*Aop(..))", returning = "str")
    public void onAfterReturningHandler(JoinPoint joinPoint, Object str) {
        log.info("onAfterReturningHandler");
    }

    @Pointcut("execution(* com.yooinkeun.webservice.service.posts.*.*Aop(..))")
    public void onPointcut(JoinPoint joinPoint) {
        log.info("onPointcut");
    }
}
