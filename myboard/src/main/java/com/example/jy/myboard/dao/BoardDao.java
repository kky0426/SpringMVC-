package com.example.jy.myboard.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jy.myboard.dto.BoardDto;


@Repository
public class BoardDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insertBoard(BoardDto board) throws Exception {
		String query = "INSERT INTO board (title,writer_name,content)"
				+ "VALUES(?,?,?)";
		return jdbcTemplate.update(query,
				board.getTitle(),
				board.getWriterName(),
				board.getContent());
	}
	
	public List<BoardDto> getAllBoard(){
		String query = "SELECT board_id,title,writer_name,content,date FROM board ORDER BY board_id DESC";
		return jdbcTemplate.query(query, (result,rowNum)->{
			BoardDto board = new BoardDto();
			board.setBoardId(result.getInt("board_id"));
			board.setTitle(result.getString("title"));
			board.setContent(result.getString("content"));
			board.setWriterName(result.getString("writer_name"));
			board.setDate(result.getDate("date"));
			return board;
		});
	}
	
	public BoardDto getBoardById(int id) throws Exception{
		String query = "SELECT board_id,title,writer_name,content,date FROM board WHERE board_id=?";
		return jdbcTemplate.queryForObject(query,(result,rowNum)->{
			BoardDto board = new BoardDto();
			board.setBoardId(result.getInt("board_id"));
			board.setTitle(result.getString("title"));
			board.setContent(result.getString("content"));
			board.setWriterName(result.getString("writer_name"));
			board.setDate(result.getDate("date"));
			return board;
		},id);
	}
	
	public int deleteBoard(int id) throws Exception{
		String query = "DELETE FROM board WHERE board_id=?";
		return jdbcTemplate.update(query,id);
	}
	
	public int updateBoard(BoardDto board) throws Exception{
		String query = "UPDATE board SET title=?,content=? WHERE board_id=?";
		return jdbcTemplate.update(query,board.getTitle(),board.getContent(),board.getBoardId());
	}
		
}
