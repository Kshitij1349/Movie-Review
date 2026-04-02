package com.kshitu.MovieRating.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserInputValidation {

    @Around("execution(* com.kshitu.MovieRating.service.MovieService.*(..)) && args(id)")
    public Object checkinput(ProceedingJoinPoint jp, int id) throws Throwable {

        if (id < 0) {
            id = -id;
        }

        Object[] args = jp.getArgs();
        args[0] = id;  // assumes id is first param

        return jp.proceed(args);
    }

}