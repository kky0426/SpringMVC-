package com.example.jy.myboard.dao;

import java.util.List;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.ReplyDto;

public interface ReplyDao {
	public int insertReply(ReplyDto reply) throws Exception;
	
	public List<ReplyDto> getBoardReply(BoardDto board) throws Exception;
	
	public int deleteReply(ReplyDto reply) throws Exception;
	
	public int updateReply(ReplyDto reply) throws Exception;
	
	public ReplyDto getReplyOne(int replyId) throws Exception;
}
