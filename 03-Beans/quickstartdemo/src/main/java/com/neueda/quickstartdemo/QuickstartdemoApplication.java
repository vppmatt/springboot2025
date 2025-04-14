package com.neueda.quickstartdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class QuickstartdemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(QuickstartdemoApplication.class, args);
		PasswordGenerator bean = context.getBean(PasswordGenerator.class);
		System.out.println("Bean as created at start up: " + bean.getClass());
		System.out.println(bean.getNewPassword());
	}

}
