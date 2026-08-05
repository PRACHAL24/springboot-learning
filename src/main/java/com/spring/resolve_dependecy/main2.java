package com.spring.resolve_dependecy;

import com.spring.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main2 {
    static void main() {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig2.class);
        Order order=context.getBean(Order.class);
        order.place_order();
    }
}
