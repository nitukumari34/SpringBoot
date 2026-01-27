package com.springboot.nitu.module1Introduction.impl;

import com.springboot.nitu.module1Introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component
@Qualifier("EmailNotify")
//@ConditionalOnProperty(name = "notification.type" ,havingValue = "email")
public class EmailSendNotificationService  implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("hi");
        System.out.println("Email sending"+message);
    }
}
