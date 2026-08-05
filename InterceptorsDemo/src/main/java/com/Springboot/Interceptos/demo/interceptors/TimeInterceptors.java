package com.Springboot.Interceptos.demo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
@Component
public class TimeInterceptors implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {
        long starttime=(long)request.getAttribute("startTime") ;
        Long Duration= System.currentTimeMillis()-starttime;
        System.out.println("time required is :"+Duration);
    }
}
