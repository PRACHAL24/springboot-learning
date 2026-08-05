package com.Springboot.Interceptos.demo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggingInterceptors implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("Logging Interceptors");
        request.setAttribute("startTime",System.currentTimeMillis());
        System.out.println("INCOMING REQUEST----------------------");
        System.out.println("HTTP method :"+request.getMethod());
        System.out.println("Request URI :"+request.getRequestURI());
        System.out.println("token name :"+request.getHeader("token"));
        System.out.println("client ip :"+request.getRemoteUser());

        if(handler instanceof HandlerMethod handlerMethod){
            String ControllerName=handlerMethod.getBeanType().getName();
            String MethodName=handlerMethod.getMethod().getName();

            System.out.println("PREHANDLER");
            System.out.println("Controller name :"+ControllerName);
            System.out.println("Method name :"+MethodName);
        }
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("POSTHANDLER");
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("Response status :"+response.getStatus());
        System.out.println("AFTERCOMPLETION");
    }
}

