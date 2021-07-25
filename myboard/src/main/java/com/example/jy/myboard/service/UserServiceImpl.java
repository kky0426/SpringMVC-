package com.example.jy.myboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jy.myboard.dao.UserDaoImpl;
import com.example.jy.myboard.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoImpl dao;
	
	@Override
	public void createUser(UserDto user) throws Exception {
		dao.createUser(user);
	}

	@Override
	public UserDto login(UserDto user) throws Exception {
		return dao.login(user);
	}
	
}
