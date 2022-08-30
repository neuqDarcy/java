package com.nio.flash.activity.aop;

import com.nio.flash.activity.common.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ResultAspect {
    @Around("@annotation(com.nio.flash.activity.annotation.ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.failure(e.getMessage());
        }
        return proceed;
    }
}
