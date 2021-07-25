package com.example.jy.myboard.service;

import com.example.jy.myboard.dto.UserDto;

public interface UserService {
	
	public void createUser(UserDto user) throws Exception;
	
	public UserDto login(UserDto user) throws Exception;
}
