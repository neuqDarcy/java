package com.nio.flash.activity.aop;

import com.nio.flash.activity.common.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ResultAspect {
    @Around("@annotation(com.nio.flash.activity.annotation.ResultHandler)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            return Response.failure(e.getMessage());
        }
        return proceed;
    }
}
