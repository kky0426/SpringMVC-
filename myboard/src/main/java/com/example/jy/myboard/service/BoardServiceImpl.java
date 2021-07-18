package com.example.jy.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dao.BoardDao;

@Service
public class BoardServiceImpl implements BoardService{
		
	@Autowired
	private BoardDao dao;
	
	@Override
	public void write(String title,String name,String content) throws Exception{
		BoardDto board = new BoardDto();
		board.setTitle(title);
		board.setWriterName(name);
		board.setContent(content);
		dao.insertBoard(board);
	}
	
	public List<BoardDto> boardList(){
		return dao.getAllBoard();
	}
	
}
