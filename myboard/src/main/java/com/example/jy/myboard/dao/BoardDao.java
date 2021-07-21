package com.example.jy.myboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.SearchPageDto;

@Repository
public interface BoardDao {
	int insertBoard(BoardDto board);
	
	int updateBoard(BoardDto board);
	
	int deleteBoard(int boardId);
	
	int boardCount(SearchPageDto page);
	
	BoardDto getBoardById(int boardId);
	
	List<BoardDto> getBoardPage(SearchPageDto page);
	
	
}
