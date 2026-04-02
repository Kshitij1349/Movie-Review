package com.kshitu.MovieRating.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.kshitu.MovieRating.service.MovieService.*(..)) || execution(* com.kshitu.MovieRating.service.ReviewService.*(..))")
    public void MethodCalled(JoinPoint jp)
    {
        LOGGER.info("Method called  " + jp.getSignature().getName());
    }

    @After("execution(* com.kshitu.MovieRating.service.MovieService.*(..)) || execution(* com.kshitu.MovieRating.service.ReviewService.*(..))")
    public void MethodExecuted(JoinPoint jp)
    {
        LOGGER.info("Method execution completed  "+jp.getSignature().getName());
    }

}
