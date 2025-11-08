package com.rays.dao;

import java.util.List;

import com.rays.dto.UserDto;

public interface UserDAOInt {
	
	public long add(UserDto dto);
	
	public void update(UserDto dto);
	
	public void delete(UserDto dto);
	
	public UserDto findByLogin(String login);
	
	public List search(UserDto dto, int pageNo, int pageSize);
	
	public UserDto aunthenticate(String login, String password);
	
	
}
