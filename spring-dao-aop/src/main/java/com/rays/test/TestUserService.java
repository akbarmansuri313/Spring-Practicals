package com.rays.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.rays.dto.UserDTO;
import com.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt userService;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService test = (TestUserService) context.getBean("testUserService");

//		test.testFindByPk();
//		test.testAdd();
//		test.testUpdate();
		test.testSearch();
//		test.testAuthenticate();

	}

	public void testSearch() {
		UserDTO udto = new UserDTO();

		List<UserDTO> list = userService.search(udto, 0, 0);

		
		for(UserDTO dto : list) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());

		} 

	}

	public void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(2);
		dto.setFirstName("yusuf");
		dto.setLastName("Khan");
		dto.setLogin("yusuf@gmail.com");
		dto.setPassword("1234");
		long pk = userService.add(dto);
		
		System.out.println("Data Added" + pk);
	}

	public void testUpdate() {
		UserDTO dto = new UserDTO();

		dto.setId(1);
		dto.setFirstName("Shaad");
		dto.setLastName("Khan");
		dto.setLogin("Shaad@gmail.com");
		dto.setPassword("1234");
		userService.update(dto);

		System.out.println("Data  updated");
	}

	public void testFindByPk() {
		UserDTO dto = userService.findByPK(1);

		if (dto != null) {

			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Id not Found");
		}
	}

	public void testAuthenticate() {
		
		UserDTO dto = userService.authenticate("Shaad@gmail.com", "1234");
		
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("User not exist");
		}
	}

}
