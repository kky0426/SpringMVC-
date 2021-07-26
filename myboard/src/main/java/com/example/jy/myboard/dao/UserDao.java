package com.example.jy.myboard.dao;

import com.example.jy.myboard.dto.UserDto;

public interface UserDao {
	public int createUser(UserDto user) throws Exception;
	
	public UserDto getUser(String user) throws Exception;
	
	public UserDto login(UserDto user) throws Exception;
	
	public int updateUser(UserDto user) throws Exception;
	
}
