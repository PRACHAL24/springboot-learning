package com.spring.BeanLifeCycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements BeanNameAware , ApplicationContextAware {
    public OrderService() {
        System.out.println("order service bean created...");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("the bean name is "+name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("the application context name is "+applicationContext);
    }

    @PostConstruct
        public void postConstructor(){
            System.out.println("the post constructor called automatically when bean is created and DI are resolve");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("it call automatically when bean becomes destroy");
        }
}
