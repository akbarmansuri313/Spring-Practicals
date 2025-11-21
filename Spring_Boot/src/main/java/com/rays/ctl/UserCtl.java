package com.rays.ctl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponce;
import com.rays.dto.UserDTO;
import com.rays.form.UserForm;
import com.rays.service.RoleService;
import com.rays.service.UserSerivceInt;
import com.rays.service.UserService;

@RestController
@RequestMapping(value = "UserCtl")
public class UserCtl extends BaseCtl {

	@Autowired
	public UserService userService;

	@Autowired
	public RoleService roleService;

	@PostMapping("save")
	public ORSResponce save(@RequestBody @Valid UserForm form, BindingResult br) {

		ORSResponce res = validate(br);

		if (!res.isSuccess()) {
			return res;

		}
		
		UserDTO dto = (UserDTO) form.getDto();
		
		if (dto.getId() != null && dto.getId() > 0) {
			userService.update(dto);
			res.addData(dto.getId());
			res.addMessage("Data Updated Successfully..!!");
		} else {
			long pk = userService.add(dto);
			res.addData(pk);
			res.addMessage("Data added Successfully..!!");
		}
		return res;
	}

	}


