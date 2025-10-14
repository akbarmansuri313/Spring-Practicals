package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestPerson {
	
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("person.xml"));
		
		Person p = (Person) factory.getBean("person");
		
		System.out.println(" Person's name : " + p.getName());
		System.out.println("Person's address : " + p.getAddress());
		
//		System.out.println("---------");
//		
//		System.out.println(" Person's name : " + p.getName());
//		System.out.println("Person's address : " + p.getAddress());
				
	}

}
