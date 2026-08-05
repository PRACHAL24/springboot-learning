package com.Springboot.Interceptos.demo.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class AutherizationInterceptors implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("Authorization Interceptors");
        String UserRole=request.getHeader("user-role");
        if(UserRole==null ||!UserRole.equals("ADMIN")){
            response.setStatus(403);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"msg\":\"YOU ARE NOT AUTHORIZED TO PERFORM THIS ACTION\"\n" +
                    "}");
            return false;
        }
        return true;
    }
}
