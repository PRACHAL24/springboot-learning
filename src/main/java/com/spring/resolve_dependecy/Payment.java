package com.spring.resolve_dependecy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Payment {
    private final Order order;

    public Payment(Order order) {
        this.order = order;
    }
    public void pay(){
        order.getdetails();
        System.out.println("payment done sucessfully....");
    }
}
