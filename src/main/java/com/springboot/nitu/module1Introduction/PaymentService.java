package com.springboot.nitu.module1Introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    void pay(){
        System.out.println("paying......");
    }
@PostConstruct
    public  void beforeRun(){
        System.out.println("before paying");
    }
    @PreDestroy
    public  void afterRun(){
        System.out.println("after payment is done!");
    }
}
