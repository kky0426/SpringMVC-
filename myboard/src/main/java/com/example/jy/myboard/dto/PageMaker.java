package com.example.jy.myboard.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean pre;
	private boolean next;
	private int displayPageNum = 10;
	private PageDto page;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(page != null) {
			calcPage();
		}
	}
	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPre() {
		return pre;
	}

	public boolean isNext() {
		return next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	public PageDto getPage() {
		return page;
	}
	public void setPage(PageDto page) {
		this.page = page;
	}
	
	private void calcPage() {
		endPage = (int) (Math.ceil(page.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - page.getOffset())+1;
		
		int tempEnd = (int)(Math.ceil(totalCount/(double)page.getOffset()));
		if (endPage>tempEnd){
			endPage = tempEnd;
		}
		pre = startPage==1 ? false : true;
		next = endPage*page.getOffset() >=totalCount ? false :true;
	}
	
	public String makeQuery(int pageNum) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
									.queryParam("page", pageNum)
									.queryParam("offset",page.getOffset())
									.build();
		return uriComponents.toString();
	}
	
	public String makeSearch(int pageNum) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
									.queryParam("page", pageNum)
									.queryParam("offset", page.getOffset())
									.queryParam("feild",((SearchPageDto)page).getFeild())
									.queryParam("keyword", encoding(((SearchPageDto)page).getKeyword()))
									.build();
		return uriComponents.toString();
	}
	
	private String encoding(String keyword) {
		if(keyword==null || keyword.trim().length()==0) {
			return "";
		}
		try {
			return URLEncoder.encode(keyword,"UTF-8");
		}catch(UnsupportedEncodingException e) {
			return "";
		}
	}
}
