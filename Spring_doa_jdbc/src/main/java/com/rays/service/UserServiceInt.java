package com.rays.service;

import java.util.List;

import com.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto) throws Exception;

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findByLogin(String login);

	public UserDTO aunthenticate(String login, String password);

	public List search(UserDTO dto);
	
	public List search(UserDTO dto, int pageNo, int pageSize);


}
