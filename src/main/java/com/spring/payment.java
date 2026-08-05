package com.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Lazy
@Component
public class payment {
    public payment() {
        System.out.println("payment done succesfully....");
    }


    public void pay() {
        System.out.println("payyyyyyyyyy....");
    }
}
