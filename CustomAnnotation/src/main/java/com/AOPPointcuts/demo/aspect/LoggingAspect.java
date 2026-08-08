package com.AOPPointcuts.demo.aspect;

import com.AOPPointcuts.demo.annotation.Measuretime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.AOPPointcuts.demo.service.StudentService.*(..))")
    public void logbefore(){
        System.out.println("Before Intercepted.....");
    }

    @Around("@annotation(measuretime)")
    public Object measureTime(ProceedingJoinPoint proceedingJoinPoint,Measuretime measuretime) throws Throwable {
        long starttime=System.currentTimeMillis();
        try{
          return proceedingJoinPoint.proceed();
        }
        finally {
            long finish_time=System.currentTimeMillis();
            String methodname=proceedingJoinPoint.getSignature().getName();
            long total_time=finish_time-starttime;
            System.out.println("the time taken by "+methodname+" is : "+total_time+"ms");
        }
    }


    }

