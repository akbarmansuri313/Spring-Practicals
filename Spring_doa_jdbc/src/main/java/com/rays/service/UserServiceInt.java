package com.rays.service;

import com.rays.dto.UserDTO;

public interface UserServiceInt {
	
	public long add(UserDTO dto) throws Exception;
	
	public void update(UserDTO dto);
	
	public void delete(UserDTO dto);
	
	public UserDTO findByLogin(String login);
	
	public UserDTO aunthenticate(String login, String password);
	
	

}
