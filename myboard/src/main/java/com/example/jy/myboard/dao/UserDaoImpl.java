package com.example.jy.myboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jy.myboard.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int createUser(UserDto user) throws Exception {
		return sqlSession.insert("userMapper.createUser", user);
	}

	@Override
	public UserDto getUser(String userId) throws Exception {
		return sqlSession.selectOne("userMapper.getUser", userId);
	}

	@Override
	public UserDto login(UserDto user) throws Exception {
		return sqlSession.selectOne("userMapper.login", user);
	}
	
}
