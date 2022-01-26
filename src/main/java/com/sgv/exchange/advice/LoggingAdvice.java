package com.sgv.exchange.advice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    @Around("execution(* com.sgv.exchange.controller.*.*(..)) && args(request)")
    public Object logForController(ProceedingJoinPoint proceedingJoinPoint, Object request) throws Throwable
    {
        ObjectMapper objectMapper = new ObjectMapper();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //Log request
        log.info(className + "." + methodName + " :: "
                + "Incoming Request" + " -> " + objectMapper.writeValueAsString(request));

        Object response = proceedingJoinPoint.proceed();

        //Log response
        log.info(className + "." + methodName + " :: "
                + "Returning Response" + " -> " + objectMapper.writeValueAsString(response));

        return response;
    }

    @Around("execution(* com.sgv.exchange.service.*.*(..)) && args(request)")
    public Object logForService(ProceedingJoinPoint proceedingJoinPoint, Object request) throws Throwable
    {
        ObjectMapper objectMapper = new ObjectMapper();

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        //Get intercepted method details
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        //Log request
        log.info(className + "." + methodName + " :: "
                + "Incoming Value" + " -> " + objectMapper.writeValueAsString(request));

        Object response = proceedingJoinPoint.proceed();

        //Log response
        log.info(className + "." + methodName + " :: "
                + "Returning Value" + " -> " + objectMapper.writeValueAsString(response));

        return response;
    }
}
