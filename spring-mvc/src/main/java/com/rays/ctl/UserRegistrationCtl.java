package com.rays.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rays.dto.UserDTO;
import com.rays.form.UserRegistrationForm;
import com.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "UserRegistrationCtl")

public class UserRegistrationCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String displayy(@ModelAttribute("form") UserRegistrationForm form) {
		return "UserRegistrationView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserRegistrationForm form, Model model) {

		UserDTO dto = new UserDTO();

		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setAddress(form.getLogin());
		dto.setAddress(form.getAddress());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());

		service.add(dto);

		model.addAttribute("successMsg", "Data Add Successfully");
		return "UserRegistrationView";

	}
}