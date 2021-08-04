package com.example.jy.myboard.dao;

import java.util.List;
import java.util.Map;

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
	
	int insertFile(Map<String,Object> map) throws Exception;
	
	public List<Map<String,Object>> getFileList(int boardId) throws Exception;

	public Map<String,Object> getFileInfo(Map<String,Object> map) throws Exception;

	public int boardHit(int boardId) throws Exception;
}
