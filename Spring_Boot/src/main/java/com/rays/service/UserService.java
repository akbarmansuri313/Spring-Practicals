package com.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.rays.dao.UserDAO;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserService {

	@Autowired
	public UserDAO dao;

	@Transactional(propagation  = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		long pk = dao.add(dto);
		return pk;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		dao.update(dto);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		
		UserDTO dto = dao.findByPk(id);
	}
	public UserDTO findByPk(long pk) {
		
		UserDTO dto = dao.findByPk(pk);
		return dto;
	}
}
