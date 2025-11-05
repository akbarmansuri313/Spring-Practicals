package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto) throws Exception;
	
	public void update(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO fingBylogin(String login);
	
	public UserDTO aunthenticate(String login,String password);
	
	public List search(UserDTO dto);

	public List search(UserDTO dto, int pageNo, int pageSize);
}
