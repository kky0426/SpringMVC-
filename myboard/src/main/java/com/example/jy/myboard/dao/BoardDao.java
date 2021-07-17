package com.example.jy.myboard.dao;

import java.util.HashMap;
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
	
}
