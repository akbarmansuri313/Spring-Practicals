package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.ORSResponce;
import com.rays.dto.TestDTO;

@RestController
@RequestMapping(value = "TestCtl")
public class TestCtl {

	@GetMapping
	public String display() {
		return "Display Method In TestCtl";
	}

	@GetMapping("display1")
	public TestDTO display1() {

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("SRK");
		dto.setLastName("Khan");
		dto.setLoginId("Srk@gmail.com");
		dto.setPassword("12345");
		dto.setDob("19-11-2025");
		return dto;

	}

	@GetMapping("display2")
	public ORSResponce display2() {

		ORSResponce res = new ORSResponce();
		return res;

	}

	@GetMapping("display3")

	public ORSResponce display3() {

		ORSResponce res = new ORSResponce();

		Map errors = new HashMap();

		errors.put("firstName", "firstName is required");
		errors.put("lastName", "LasName is required");
		errors.put("LoginId", "loginId is required");
		errors.put("password", "password is required");

		res.addInputError(errors);
		return res;

	}

	@GetMapping("display4")

	public ORSResponce display4() {

		ORSResponce res = new ORSResponce();

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("Salman");
		dto.setLastName("Khan");
		dto.setLoginId("Salman@gmail.com");
		dto.setPassword("12356");
		dto.setDob("18-11-2025");

		res.setSuccess(true);
		res.addData(dto);
		return res;
	}

	@GetMapping("display5")

	public ORSResponce display5() {

		ORSResponce res = new ORSResponce();

		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("Salman");
		dto.setLastName("Khan");
		dto.setLoginId("Salman@gmail.com");
		dto.setPassword("12356");
		dto.setDob("18-11-2025");

		TestDTO dto1 = new TestDTO();
		dto1.setId(1L);
		dto1.setFirstName("SRK");
		dto1.setLastName("Khan");
		dto1.setLoginId("Srk@gmail.com");
		dto1.setPassword("12345");
		dto1.setDob("19-11-2025");

		List list = new ArrayList();

		list.add(dto);
		list.add(dto1);

		res.addData(list);
		return res;

	}

	@GetMapping("display6")

	public ORSResponce display6() {

		ORSResponce res = new ORSResponce();

		res.setSuccess(false);
		res.addResult("preload", "preload is working");
		return res;

	}
	@PostMapping("submit")
	public String submit() {
		return "Method Post";	
	}
}
