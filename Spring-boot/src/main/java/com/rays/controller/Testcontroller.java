package com.rays.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Testcontroller {
	
	@GetMapping("test1")
	
	public String display() {
		
		return "in display method mapping";
		
	}
	
	@PostMapping("submit")
	public String submit() {
		
		return "in display method of post";
	}
	

}
