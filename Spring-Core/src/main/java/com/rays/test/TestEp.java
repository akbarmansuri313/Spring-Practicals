package com.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEp {

	public static void main(String[] args) {
		
		ApplicationContext ap = new ClassPathXmlApplicationContext(new String[] {"person.xml", "employee.xml"});
		
		Person p = ap.getBean("person", Person.class);
		
		System.out.println(p.getName());
		System.out.println(p.getAddress());
		
		System.out.println("--------------");
		
		Employee e = ap.getBean("employee", Employee.class);
		
		System.out.println(e.getEmpName());
		System.out.println(e.getSalary());
	}
}
