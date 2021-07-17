package com.example.jy.myboard.dto;

import java.util.Date;

public class BoardDto {
	private int boardId;
	private String title;
	private String writerName;
	private String content;
	private Date date;
	
	public BoardDto() {}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriterName() {
		return writerName;
	}
	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", title=" + title + ", writerName=" + writerName + ", content="
				+ content + ", date=" + date + "]";
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
