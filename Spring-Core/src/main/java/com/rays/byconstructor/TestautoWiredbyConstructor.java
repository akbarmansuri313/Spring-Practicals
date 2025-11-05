package com.rays.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestautoWiredbyConstructor {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-constructor.xml");
		
		UserService service  = (UserService) context.getBean("service");
		
		service.testAdd();
	}

}
