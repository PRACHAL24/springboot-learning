package com.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class order {
private final payment payment;
    public order(@Lazy payment payment){
        this.payment = payment;
        System.out.println("order service created");
    }

    public void place_order(){
        payment.pay();
        System.out.println("order place sucessfully.....");
    }
}
