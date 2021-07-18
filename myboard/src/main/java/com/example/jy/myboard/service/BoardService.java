package com.example.jy.myboard.service;

import java.util.List;

import com.example.jy.myboard.dto.BoardDto;

public interface BoardService {
	
	public void write(String title,String name,String content) throws Exception;

	public List<BoardDto> boardList();
	
	public BoardDto read(int id) throws Exception;
}
