package com.example.jy.myboard.dto;

import java.util.Date;

public class ReplyDto {
	private int boardId;
	private int replyId;
	private String content;
	private String writer;
	private Date date;
	
	
	
	public ReplyDto() {}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	@Override
	public String toString() {
		return "ReplyDto [boardId=" + boardId + ", replyId=" + replyId + ", content=" + content + ", writer=" + writer
				+ ", date=" + date + "]";
	}
	public int getReplyId() {
		return replyId;
	}
	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
