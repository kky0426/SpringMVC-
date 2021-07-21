package com.example.jy.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jy.myboard.dto.BoardDto;

import com.example.jy.myboard.dto.SearchPageDto;
import com.example.jy.myboard.dao.BoardDaoImpl;

@Service
public class BoardServiceImpl implements BoardService{
		
	@Autowired
	private BoardDaoImpl dao;
	
	@Override
	public void write(String title,String name,String content) throws Exception{
		BoardDto board = new BoardDto();
		board.setTitle(title);
		board.setWriterName(name);
		board.setContent(content);
		dao.insertBoard(board);
	}
	@Override
	public BoardDto read(int id) throws Exception {
		return dao.getBoardById(id);
	}

	
	@Override
	public int update(BoardDto board) throws Exception {
		return dao.updateBoard(board);
	}
	
	@Override
	public int delete(int id) throws Exception{
		return dao.deleteBoard(id);
	}

	
	
	@Override
	public List<BoardDto> boardList(SearchPageDto page) throws Exception {
		return dao.getBoardPage(page);
	}
	
	@Override
	public int count(SearchPageDto page) throws Exception {
		return dao.boardCount(page);
	}
	
	
	
		
}
