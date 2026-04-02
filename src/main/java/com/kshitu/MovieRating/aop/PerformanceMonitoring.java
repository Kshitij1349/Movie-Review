package com.kshitu.MovieRating.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoring {

    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitoring.class);

    @Around("execution(* com.kshitu.MovieRating.service.MovieService.*(..)) || execution(* com.kshitu.MovieRating.service.ReviewService.*(..))")
    public Object TimeMonitoring(ProceedingJoinPoint jp) throws Throwable
    {
        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();

        LOGGER.info("Time required for : "+jp.getSignature().getName()+" is "+(end-start) +" ms.");

        return obj;
    }
}
