package com.yooinkeun.webservice.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yooinkeun.webservice.service.posts.PostsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

@Component
@Aspect
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 수행 시간 로그 찍기
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // @LogExecutionTime 애노테이션이 붙어있는 타겟 메소드를 실행
        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return proceed;
    }
}
