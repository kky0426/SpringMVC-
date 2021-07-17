package com.example.jy.myboard.service;

import org.springframework.stereotype.Service;

@Service
public interface BoardService {

	
	public void write(String title,String name,String content) throws Exception;
	
}
