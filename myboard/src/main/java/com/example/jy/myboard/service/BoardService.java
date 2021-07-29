package com.example.jy.myboard.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.jy.myboard.dto.BoardDto;

import com.example.jy.myboard.dto.SearchPageDto;

public interface BoardService {
	
	public void write(BoardDto board,MultipartHttpServletRequest request) throws Exception;

	public List<BoardDto> boardList(SearchPageDto page) throws Exception;
	
	public BoardDto read(int id) throws Exception;
	
	public int update(BoardDto board) throws Exception;
	
	public int delete(int id) throws Exception;
	
	public int count(SearchPageDto page) throws Exception;
	

	
}
