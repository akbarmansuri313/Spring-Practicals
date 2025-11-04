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
	public UserServiceInt service = null;

	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("TestUserService");

//		test.testAdd();
//		test.testUpdate();
//		test.testDelete();
//		test.testLogin();
		test.testAuthenticte();

	}

	private void testUpdate() {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Yusuf");
		dto.setLastName("Khan");
		dto.setLogin("Khan@gamil.com");
		dto.setPassword("123456789");
		System.out.println("Data Update");
		service.update(dto);
	}

	private void testAdd() throws Exception {

		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Akbar");
		dto.setLastName("Mansuri");
		dto.setLogin("akbar");
		dto.setPassword("123456789");
		long pk = service.add(dto);
		System.out.println("Add Data " + pk);

	}

	private void testDelete() {

		UserDTO dto = new UserDTO();

		dto.setId(1);

		service.delete(dto);

	}

	private void testLogin() {

		UserDTO dto = service.findByLogin("akbar");

		if (dto != null) {

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {

			System.out.println("Email Doest not exist");
		}

	}

	private void testAuthenticte() {

		UserDTO dto = service.aunthenticate("akbar", "12345678");

		if (dto != null) {

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Invalid login And Password");
		}

	}

}
