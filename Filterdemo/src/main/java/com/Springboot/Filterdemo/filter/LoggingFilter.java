package com.Springboot.Filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
//@Component
//@Order(2)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;

        //REQUEST LOG(INFORMATION)
        System.out.println("Incoming request is :"+ httpServletRequest.getRequestURI()
                +" "+httpServletRequest.getMethod());

        long start=System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long duration=start-System.currentTimeMillis();
        //RESPONSE LOG(INFORMATION)
        System.out.println("Response status is :"+httpServletResponse.getStatus());
        System.out.println("time duration is :"+duration);
    }
}
