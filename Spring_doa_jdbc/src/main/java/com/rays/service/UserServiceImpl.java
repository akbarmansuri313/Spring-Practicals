package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) throws Exception {

		UserDTO existDTO = findByLogin(dto.getLogin());

		if (existDTO != null) {

			throw new Exception("Email Already Exist !!!!");
		}
		long pk = dao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {

		dao.update(dto);

	}

	public void delete(UserDTO dto) {
		dao.delete(dto);

	}

	public UserDTO findByLogin(String login) {

		UserDTO dto = dao.fingBylogin(login);
		return dto;

	}

	public UserDTO aunthenticate(String login, String password) {

		UserDTO dto = dao.aunthenticate(login, password);
		return dto;
	}

	public List search(UserDTO dto) {

		List list = dao.search(dto);
		return list;
		
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
	
		List list  = dao.search(dto, pageNo, pageSize);
		return list;
	}

}
