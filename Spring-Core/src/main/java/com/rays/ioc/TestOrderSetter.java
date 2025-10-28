package com.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestOrderSetter {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("OrderSetter.xml");
		
		OrderSetter od = context.getBean("OrderSetter",OrderSetter.class);
		
		od.bookATicket(5);
	}

}
