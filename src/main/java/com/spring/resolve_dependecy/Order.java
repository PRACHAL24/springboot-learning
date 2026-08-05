package com.spring.resolve_dependecy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Order {
    private final Payment payment;

    public Order(@Lazy Payment payment) {
        this.payment = payment;
        System.out.println("order object created");
    }
    public void place_order(){
        payment.pay();
        System.out.println("order place sucessfullyyyy.....");
    }

    public void getdetails(){
        System.out.println("Get order details");
    }
}
