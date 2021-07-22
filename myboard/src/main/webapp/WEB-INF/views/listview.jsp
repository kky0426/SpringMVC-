<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<head>
	 	<title>게시판</title>
	 	<style type="text/css">
	 		li {list-style:none; float:left; padding:6px;}
	 	</style>
	</head>

	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 목록
			  <button type="button" onclick="location.href='writeview'">글 작성</button>
			</nav>
			<hr />
			
			<section id="container">
				<form role="form" method="get">				
					<table>
						<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
						
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
							</tr>
						</c:forEach>					
					</table>
					
					<div class="search">
						<select name="feild">
						   				
							<option value="">----</option>
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="writerName">작성자</option>
						</select>
						<input type="text" name="keyword" id="keywordInput" value="${page.keyword}"/>
						<button id="searchButton" type="submit">검색</button>
				
					</div>
					
					<div>
						<ul>
							<c:if test="${pageMaker.pre}">
								<li><a href="list${pageMaker.makeSearch(pageMaker.startPage-1)}}">이전</a></li>
							</c:if>
							<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
								<li><a href="list${pageMaker.makeSearch(idx) }">${idx}</a></li>
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