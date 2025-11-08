package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDto;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt dao = null;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDto dto) {

		return dao.add(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDto dto) {

		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDto dto) {

		dao.delete(dto);

	}

	@Transactional(readOnly = true)
	public List search(UserDto dto, int pageNo, int pageSize) {

		return dao.search(dto, pageNo, pageSize);
	}

	@Transactional(readOnly = true)
	public UserDto findByLogin(String login) {
		
		return dao.findByLogin(login);
		
		 
	}
	
	@Transactional(readOnly = true)
	public UserDto aunthenticate(String login, String password) {
		
		return dao.aunthenticate(login, password);
		
	}

}
