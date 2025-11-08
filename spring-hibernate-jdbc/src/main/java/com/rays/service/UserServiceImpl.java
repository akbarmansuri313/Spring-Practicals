package com.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rays.dao.UserDAOHibImpl;
import com.rays.dao.UserDAOInt;
import com.rays.dao.UserDAOJDBCImp;
import com.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOHibImpl hiberdao;
	
	@Autowired
	private UserDAOJDBCImp jdbcdao ;

	public long add(UserDTO dto) {
		long pk = jdbcdao.add(dto);
		return pk;
	}

	public void update(UserDTO dto) {
		hiberdao.update(dto);
	}

	public void delete(UserDTO dto) {
		jdbcdao.delete(dto);
	}

	public UserDTO findByLogin(String login) {
		return hiberdao.fingBylogin(login);
	}

	public UserDTO findByPK(long pk) {
		return jdbcdao.findByPK(pk);
	}

	public List search(UserDTO dto) {
		return jdbcdao.search(dto);
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {
		return hiberdao.search(dto, pageNo, pageSize);
	}

	public UserDTO authenticate(String login, String password) {
		UserDTO user = hiberdao.authenticate(login, password);
		return user;
	}	
}
