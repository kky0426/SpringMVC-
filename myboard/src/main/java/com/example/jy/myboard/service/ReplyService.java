package com.example.jy.myboard.service;

import java.util.List;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.ReplyDto;

public interface ReplyService {
	public int addReply(ReplyDto reply) throws Exception;
	
	public List<ReplyDto> getReplyList(BoardDto board)throws Exception;
}
