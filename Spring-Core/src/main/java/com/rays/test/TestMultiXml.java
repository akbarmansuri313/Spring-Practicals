package com.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMultiXml {
	
	public static void main(String[] args) {
		
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("multi.xml"));
		
		Person p = factory.getBean("person", Person.class);
		
		System.out.println("Person :- " + p.getName());
		System.out.println("Person :- " + p.getAddress());
		
		Employee e = factory.getBean("employee", Employee.class);
		
		System.out.println("Employee :- " + e.getEmpName());
		System.out.println("Employee :- " + e.getSalary());
	}

}
