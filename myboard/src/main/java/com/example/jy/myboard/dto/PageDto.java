package com.example.jy.myboard.dto;

public class PageDto {
	private int page;
	private int offset;
	private int rowS;
	private int rowE;
	
	
	public PageDto() {
		this.page=1;
		this.offset=10;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		if (page<=0){
			this.page=1;
		}else{
			this.page = page;
		}
	}
	
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		if(offset<=0 || offset>100) {
			this.offset=10;
		}else {
			this.offset = offset;
		}
	}
	public int getRowS() {
		rowS = ((page-1)*offset)+1;
		return rowS;
	}
	public void setRowS(int rowS) {
		this.rowS = rowS;
	}
	public int getRowE() {
		rowE = rowS+offset-1;
		return rowE;
	}
	public void setRowE(int rowE) {
		this.rowE = rowE;
	}
	
	
	
	
}
