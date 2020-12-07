package com.yooinkeun.webservice.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@Aspect
public class PreProcessRequestDataAspect {

    @Before("@annotation(PreProcessRequestData)")
    public void preProcessRequestData(JoinPoint joinPoint) throws Throwable {
        // Object 형태 요청으로 들어온 데이터 다루기(요청 데이터에 대한 전처리 할 때 유용하지 않을까)
        Object[] signatureArgs = joinPoint.getArgs();
        for (Object signatureArg: signatureArgs) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                Map map = objectMapper.convertValue(signatureArg, Map.class);
                log.info(map.toString());
            } catch (IllegalArgumentException e) {
                log.warn(e.getMessage());
            }
        }
    }
}
