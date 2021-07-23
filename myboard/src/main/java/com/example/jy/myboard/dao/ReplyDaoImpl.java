package com.example.jy.myboard.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.jy.myboard.dto.BoardDto;
import com.example.jy.myboard.dto.ReplyDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertReply(ReplyDto reply) throws Exception{
		return sqlSession.insert("replyMapper.insertReply", reply);
	}

	@Override
	public List<ReplyDto> getBoardReply(BoardDto board) throws Exception{
		return sqlSession.selectList("replyMapper.getBoardReply", board);
	}

	@Override
	public int deleteReply(ReplyDto reply) throws Exception {
		return sqlSession.delete("replyMapper.deleteReply",reply);
	}

	@Override
	public int updateReply(ReplyDto reply) throws Exception {
		return sqlSession.update("replyMapper.updateReply", reply);
	}

	@Override
	public ReplyDto getReplyOne(int replyId) throws Exception {
		return sqlSession.selectOne("replyMapper.getReplyOne",replyId);
	}
	
}
