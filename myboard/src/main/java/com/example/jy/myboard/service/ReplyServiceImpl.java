package com.example.jy.myboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jy.myboard.dao.ReplyDaoImpl;
import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.ReplyDto;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDaoImpl dao;
	
	@Override
	public int addReply(ReplyDto reply) throws Exception{
		return dao.insertReply(reply);
	}

	@Override
	public List<ReplyDto> getReplyList(BoardDto board) throws Exception {
		return dao.getBoardReply(board);
	}

	@Override
	public int delete(ReplyDto reply) throws Exception {
		return dao.deleteReply(reply);
	}

	@Override
	public int update(ReplyDto reply) throws Exception {
		return dao.updateReply(reply);
		
	}

	@Override
	public ReplyDto getReply(int replyId) throws Exception {
		return dao.getReplyOne(replyId);
	}
	
	
}
