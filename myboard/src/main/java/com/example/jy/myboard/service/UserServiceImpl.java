package com.example.jy.myboard.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jy.myboard.dao.UserDaoImpl;
import com.example.jy.myboard.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	final static Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
	
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

	@Override
	public void updateUser(UserDto user) throws Exception {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(UserDto user) throws Exception {
		dao.deleteUser(user);
		
	}

	@Override
	public int checkPass(UserDto user) throws Exception {
		return dao.checkPass(user);
	}

	@Override
	public int checkId(UserDto user) throws Exception {
		return dao.checkId(user);
	}
	
}
