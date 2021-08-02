package com.example.jy.myboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.jy.myboard.dto.BoardDto;

import com.example.jy.myboard.dto.SearchPageDto;
import com.example.jy.myboard.util.FileUtils;
import com.example.jy.myboard.dao.BoardDaoImpl;

@Service
public class BoardServiceImpl implements BoardService{
		
	@Autowired
	private BoardDaoImpl dao;
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public void write(BoardDto board, MultipartHttpServletRequest request) throws Exception{
		dao.insertBoard(board);
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(board, request);
		int size = list.size();
		for(int i=0; i<size ; i++) {
			dao.insertFile(list.get(i));
		}
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

	@Override
	public List<Map<String, Object>> getFileList(int boardId) throws Exception {
		return dao.getFileList(boardId);
	}

	@Override
	public Map<String, Object> getFileInfo(Map<String,Object> map) throws Exception {
		return dao.getFileInfo(map);
	}
	
	
	
		
}
