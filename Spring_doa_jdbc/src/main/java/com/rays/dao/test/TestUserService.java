package com.rays.dao.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("TestUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt serviceInt = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("TestUserService");

		test.testAdd();
	}

	private void testAdd() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLogin("akbar@gamil.com");
		dto.setPassword("123456789");
		long pk = serviceInt.add(dto);
		System.out.println("Add Data " + pk);

	}

}
