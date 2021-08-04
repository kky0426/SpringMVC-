<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	<title>게시판</title>
	 	<style type="text/css">
	 		li {list-style:none; float:left; padding:6px;}
	 	</style>
	</head>

	<body>
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			<div>
				<%@include file = "nav.jsp" %>
			</div>
			<hr />
			
			<section id="container">
				<form role="form" method="get">				
					<table class = "table table-hover">
						<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th><th>조회수</th></tr>
						
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.boardId}" /></td>
								<td>
									<a href="readview?boardId=${list.boardId}&
															page=${searchPage.page}&
															offset=${searchPage.offset}&
															feild=${searchPage.feild}&
															keyword=${searchPage.keyword}">
															<c:out value="${list.title}" /></a>
								</td>
								<td><c:out value="${list.writerName}" /></td>
								<td><fmt:formatDate value="${list.date}" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${list.hit}"></c:out></td>
							</tr>
						</c:forEach>					
					</table>
					
					<div class="search row">
						<div class="col-xs-2 col-sm-2">						
							<select name="feild" class="form_control">
							   				
								<option value="">----</option>
								<option value="title">제목</option>
								<option value="content">내용</option>
								<option value="writerName">작성자</option>
							</select>
							<div class = "input-gruop">		
								<input type="text" name="keyword" id="keywordInput" value="${page.keyword}" class="form-control"/>
								<span class="input-group-btn">							
									<button id="searchButton" type="submit" class="btn btn-default">검색</button>
								</span>
							</div>
						</div>
					</div>
					
					<div class="col-md-offset-3">
						<ul class="pogination">
							<c:if test="${pageMaker.pre}">
								<li><a href="list${pageMaker.makeSearch(pageMaker.startPage-1)}}">이전</a></li>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<li> <a href="list${pageMaker.makeSearch(idx) }">${idx}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next && pageMaker.endPage>0}">
								<li><a href="list${pageMaker.makeSearch(pageMaker.endPage+1)}">다음</a></li>
							</c:if>
						</ul>
					</div>
				</form>
			</section>
			
			<hr />
		</div>
	</body>
</html>