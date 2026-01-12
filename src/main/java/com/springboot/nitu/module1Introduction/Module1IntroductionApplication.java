package com.springboot.nitu.module1Introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.json.GsonBuilderUtils;

@SpringBootApplication
public class Module1IntroductionApplication  implements CommandLineRunner {

	@Autowired
	PaymentService paymentServiceObj1;
	@Autowired
	PaymentService getPaymentServiceObj2;
	public static void main(String[] args) {

		SpringApplication.run(Module1IntroductionApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(paymentServiceObj1.hashCode());
		System.out.println(getPaymentServiceObj2.hashCode());
		System.out.println("before");
		paymentServiceObj1.pay();
		getPaymentServiceObj2.pay();
	}
}
