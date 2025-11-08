package com.rays.service;

import java.util.List;

import com.rays.dto.UserDto;

public interface UserServiceInt {

	public long add(UserDto dto);

	public void update(UserDto dto);

	public void delete(UserDto dto);

	public UserDto findByLogin(String login);

	public UserDto aunthenticate(String login, String password);

	public List search(UserDto dto, int pageNo, int pageSize);

}
