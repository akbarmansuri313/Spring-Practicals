package com.rays.ctl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponce;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleService;

@RestController
@RequestMapping(value = "RoleCtl")
public class RoleCtl extends BaseCtl {

	@Autowired
	public RoleService roleService;

	@PostMapping("save")
	public ORSResponce save(@RequestBody @Valid RoleForm form, BindingResult bindingResult) {

		ORSResponce res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}
		RoleDTO dto = (RoleDTO) form.getDto();
		long pk = roleService.add(dto);
		res.addData(pk);
		res.addMessage("Role addedd successfully..!!!");
		return res;

	}

	@PostMapping("update")
	public ORSResponce update(@RequestBody @Valid RoleForm form, BindingResult br) {

		ORSResponce res = validate(br);

		if (!res.isSuccess()) {
			return res;

		}
		RoleDTO dto = (RoleDTO) form.getDto();
		roleService.update(dto);
		res.addMessage("Role update Successfully !!");
		return res;

	}

	@PostMapping("delete/{ids}")
	public ORSResponce delete(@PathVariable long[] ids) {

		ORSResponce res = new ORSResponce();

		for (long id : ids) {
			roleService.delete(id);
		}
		res.addMessage("Data Delete successFully...");
		res.setSuccess(true);
		return res;
	}

	@GetMapping("get/{id}")
	public ORSResponce get(@PathVariable long id) {
		ORSResponce res = new ORSResponce();
		RoleDTO dto = roleService.findByPk(id);

		if (dto != null) {

			res.setSuccess(true);
		}
		res.addData(dto);
		return res;

	}
	
	@PostMapping("search/{pageNo}")
	public ORSResponce search(@RequestBody RoleForm form, @PathVariable int pageNo) {	
		
		ORSResponce res  = new ORSResponce();
		
		RoleDTO dto = (RoleDTO) form.getDto();
		List list  = roleService.search(dto, pageNo, 0);
		
		if (list != null && list.size() > 0) {			
			res.setSuccess(true);			
		}	
		res.addData(list);
		return res;
		
	}
}
