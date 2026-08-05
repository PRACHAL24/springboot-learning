package com.Springboot.Interceptos.demo.config;

import com.Springboot.Interceptos.demo.interceptors.AuthenticationInterceptors;
import com.Springboot.Interceptos.demo.interceptors.AutherizationInterceptors;
import com.Springboot.Interceptos.demo.interceptors.LoggingInterceptors;
import com.Springboot.Interceptos.demo.interceptors.TimeInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptors loggingInterceptors;
    public AuthenticationInterceptors authenticationInterceptors;
    public AutherizationInterceptors autherizationInterceptors;
    public TimeInterceptors timeInterceptors;

    public WebConfig(LoggingInterceptors loggingInterceptors,
                     AuthenticationInterceptors authenticationInterceptors,
                     AutherizationInterceptors autherizationInterceptors,
                     TimeInterceptors timeInterceptors) {
        this.loggingInterceptors = loggingInterceptors;
        this.authenticationInterceptors = authenticationInterceptors;
        this.autherizationInterceptors = autherizationInterceptors;
        this.timeInterceptors = timeInterceptors;
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptors)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public")
                .order(1);

        registry.addInterceptor(authenticationInterceptors)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public")
                .order(2);

        registry.addInterceptor(autherizationInterceptors)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public")
                .order(3);

        registry.addInterceptor(timeInterceptors)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/public")
                .order(4);


    }
}
