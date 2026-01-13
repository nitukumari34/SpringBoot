package com.springboot.nitu.module1Introduction.impl;

import com.springboot.nitu.module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SMSNotify")
//@ConditionalOnProperty(name = "notification.type" ,havingValue = "sms")
public class SMSSendNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email notification sending");
    }
}
