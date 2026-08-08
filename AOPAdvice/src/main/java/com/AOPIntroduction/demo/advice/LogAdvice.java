package com.AOPIntroduction.demo.advice;

import com.AOPIntroduction.demo.Student;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvice {
//    @Before("execution(* com.AOPIntroduction.demo.service.StudentService.createstudent(..))")
//    public void beforemethod(JoinPoint joinPoint){
//        System.out.println("Method name : "+joinPoint.getSignature().getName());
//        System.out.println("Class name : "+joinPoint.getTarget().getClass().getName());
//        System.out.println("Before method calling.....");
//    }
//
//    @AfterReturning("execution(* com.AOPIntroduction.demo.service.StudentService.createstudent(..))")
//    public void afterreturningmethod(JoinPoint joinPoint){
//           System.out.println("Method name : "+joinPoint.getSignature().getName());
//        System.out.println("Class name : "+joinPoint.getTarget().getClass().getName());
//        System.out.println("after method calling.....");
//    }
//
//    @AfterThrowing("execution(* com.AOPIntroduction.demo.service.StudentService.createstudent(..))")
//    public void afterthrowingerror(){
//        System.out.println("after method throwing error.....");
//    }
//
//    @After("execution(* com.AOPIntroduction.demo.service.*.*(..))")
//    public void aftermethod(){
//        System.out.println("after method calling even if there any error or succesfull message.....");
//    }


    @Around(@Within)
    public Object aroundmethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("before calling the method");
        try {
          Object result=proceedingJoinPoint.proceed();
          if(result instanceof Student){
              Student student=(Student) result;
//             student.setName(student.getName().toUpperCase());
              student.setName("rohit");
              student.setEmail("rohit@gmail.com");
          }
            System.out.println("after method calling ");
            return result;
        } catch (Throwable e) {
            System.out.println("After method throwing a error");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        finally {
            System.out.println("after complete the execution process");
        }

    }
}
