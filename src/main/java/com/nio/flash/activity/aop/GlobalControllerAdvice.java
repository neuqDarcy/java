package com.nio.flash.activity.aop;

import com.nio.flash.activity.common.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(BindException.class)
    public Response<Void> bindExceptionHandler(BindException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String collect = fieldErrors.stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
        return Response.success(collect);
    }
}

