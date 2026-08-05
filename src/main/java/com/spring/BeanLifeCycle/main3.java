package com.spring.BeanLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main3 {
    static void main() {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig3.class);
       context.close();
    }
}
