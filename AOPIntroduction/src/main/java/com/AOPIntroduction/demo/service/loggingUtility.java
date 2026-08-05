package com.AOPIntroduction.demo.service;

import org.springframework.stereotype.Component;

@Component
public class loggingUtility {
    public static void logStart(String classNmae,String methodName){
        System.out.println("executing :"+classNmae+" : "+methodName);
    }

    public static void logEnd(String classNmae,String methodName){
        System.out.println("Finishing :"+classNmae+" : "+methodName);
    }


}
