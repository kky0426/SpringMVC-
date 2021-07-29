package com.example.jy.myboard.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.SearchPageDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(BoardDto board){
		return sqlSession.insert("boardMapper.insertBoard", board);
	}

	@Override
	public int updateBoard(BoardDto board) {
		return sqlSession.update("boardMapper.updateBoard", board);
	}

	@Override
	public int deleteBoard(int boardId){
		return sqlSession.delete("boardMapper.deleteBoard", boardId);
	}

	@Override
	public int boardCount(SearchPageDto page){
		return sqlSession.selectOne("boardMapper.boardCount", page);
	}

	@Override
	public BoardDto getBoardById(int boardId){
		return sqlSession.selectOne("boardMapper.getBoardById", boardId);
	}

	@Override
	public List<BoardDto> getBoardPage(SearchPageDto page){
		return sqlSession.selectList("boardMapper.getBoardPage", page);
	}

	@Override
	public int insertFile(Map<String, Object> map) throws Exception {
		return sqlSession.insert("boardMapper.insertFile",map);
	}
	

}
