package com.yooinkeun.webservice.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.*;

@Slf4j
@Component
@Aspect
public class PreProcessRequestDataAspect {

    private static final String PARAMETER_KEY = "parameterKey";

    @Around("@annotation(PreProcessRequestData)")
    public Object preProcessRequestData(ProceedingJoinPoint pjp) throws Throwable {
        final List<Object> valueList = getParamterValue(pjp.getArgs());
        return checkValue(pjp, valueList);
    }

    private List<Object> getParamterValue(Object[] requestParameters) {
        List<Object> valueList = new ArrayList<>();

        for (Object requestParameter: requestParameters) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                final Map<String, Object> requestParameterMap = objectMapper.convertValue(requestParameter, HashMap.class);
                valueList = (ArrayList<Object>) requestParameterMap.get(PARAMETER_KEY);
                break;
            } catch (IllegalArgumentException e) {
                // 요청 파라미터가 Class 형태가 아니여서 Map으로 변환 못할 때 발생
            } catch (ClassCastException e) {
                // 타입 변환 못할 때 발생
            }
        }

        return valueList;
    }

    private Object checkValue(ProceedingJoinPoint pjp, List<Object> value) throws Throwable {
        // checkValue
        return pjp.proceed();
    }
}
