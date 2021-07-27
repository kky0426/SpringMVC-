package com.example.jy.myboard.service;

import com.example.jy.myboard.dto.UserDto;

public interface UserService {
	
	public void createUser(UserDto user) throws Exception;
	
	public UserDto login(UserDto user) throws Exception;
	
	public void updateUser(UserDto user) throws Exception;
	
	public void deleteUser(UserDto user) throws Exception;
	
	public int checkPass(UserDto user) throws Exception;
	
	public int checkId(UserDto user) throws Exception;
}
