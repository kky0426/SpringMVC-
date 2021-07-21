package com.example.jy.myboard.dto;

public class SearchPageDto extends PageDto{
	private String feild=null;
	private String keyword = "";
	
	public String getFeild() {
		return feild;
	}
	public void setFeild(String feild) {
		this.feild = feild;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		return "SearchPageDto [feild=" + feild + ", keyword=" + keyword + "]";
	}
	
	
	
}
