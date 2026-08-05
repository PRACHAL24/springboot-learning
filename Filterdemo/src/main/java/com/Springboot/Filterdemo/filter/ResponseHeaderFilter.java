package com.Springboot.Filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
@Component
public class ResponseHeaderFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;

        String requestid= UUID.randomUUID().toString();
        httpServletResponse.setHeader("x-requested-id",requestid);
        String token=httpServletRequest.getHeader("token");
        System.out.println("token :"+token);
        if (token==null || !token.equals("12345")){
           httpServletResponse.setStatus(401);
           return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
