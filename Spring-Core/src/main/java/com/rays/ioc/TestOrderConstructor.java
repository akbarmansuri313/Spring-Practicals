package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrderConstructor {
	
	public static void main(String[] args) {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("OrderConstructor.xml");
		
		OrderConstructor o1 = (OrderConstructor) context.getBean("OrderConstructor");
		
		o1.bookATicket(3);
		
	}

}
