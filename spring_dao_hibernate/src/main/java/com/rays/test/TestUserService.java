package com.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDto;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt userService = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testFindByLogin();
		test.testAunthenticate();
	}

	private void testAdd() {

		UserDto dto = new UserDto();

		dto.setFirstName("Yusuf");
		dto.setLastName("Khan");
		dto.setLogin("yusuf@gmail.com");
		dto.setPassword("12345");

		long pk = userService.add(dto);
		System.out.println("Data Added Successfully " + pk);
	}

	private void testUpdate() {
		UserDto dto = new UserDto();

		dto.setId(1);
		dto.setFirstName("Shaad");
		dto.setLastName("Khan");
		dto.setLogin("Shaad@gmail.com");
		dto.setPassword("12345");

		userService.update(dto);
		System.out.println("Data update");

	}

	private void testDelete() {

		UserDto dto = new UserDto();

		dto.setId(2);

		userService.delete(dto);

	}

	private void testFindByLogin() {

		UserDto dto = userService.findByLogin("Shaad@gmail.com");

		if (dto != null) {

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());

		} else {
			System.out.println("User Not Found");
		}

	}

	private void testAunthenticate() {

		UserDto dto = userService.aunthenticate("Shaad@gmail.com", "12345");

		if (dto != null) {

			System.out.print("\t" + dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());

		} else {
			System.out.println("Login Id And Password Doest not Match");
		}

	}

}
