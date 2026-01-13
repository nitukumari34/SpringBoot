package com.springboot.nitu.module1Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication  implements CommandLineRunner {

//	@Autowired
//	PaymentService paymentServiceObj1;
//	@Autowired
//	PaymentService getPaymentServiceObj2;
//
//	final  NotificationService notificationServiceObj;//constructor di ,the perefered way to doing
//	 public   Module1IntroductionApplication(NotificationService notificationServiceObj){
//      this.notificationServiceObj=notificationServiceObj;
//	}

	@Autowired
	Map<String,NotificationService> notificationServiceMap=new HashMap<>();
	public static void main(String[] args) {

		SpringApplication.run(Module1IntroductionApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(paymentServiceObj1.hashCode());
//		System.out.println(getPaymentServiceObj2.hashCode());
//		System.out.println("before");
//		paymentServiceObj1.pay();
//		getPaymentServiceObj2.pay();
//		emailSendNotificationService.send("hi");
//		notificationService=new SMSSendNotificationService();
//		notificationServiceObj.send("hi");

		for(var notificationservice:notificationServiceMap.entrySet()){
			System.out.println(notificationservice.getKey());
			notificationservice.getValue().send("hello");
		}
	}

}
