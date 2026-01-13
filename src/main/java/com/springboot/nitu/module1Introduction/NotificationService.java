package com.springboot.nitu.module1Introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public interface NotificationService {
      void send(String message);
}
