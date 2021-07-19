<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
	 	<title>게시판</title>
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	</head>
	<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[name='readForm']")
		
		$(".update_btn").on('click',function(){
			formObj.attr("action","updateview");
			formObj.attr("method","get");
			formObj.submit();
		})
		
		$(".delete_btn").on("click",function(){
			formObj.attr("action","delete");
			formObj.attr("mothod","post");
			formObj.submit();
		})
		
		$(".list_btn").on("click",function(){
			event.preventDefault();
			location.href="list";
			
		})
	})
</script>
	
	<body>
	
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 상세
			</nav>
			<button></button>
			<hr />
			
			<section id="container">
				<form name="readForm" role="form" method="post">
					<table>
						<tbody>
							<tr>
								<td>
									<label for="boardId">글 번호</label><input type="text" id="boardId" name="boardId" value="${read.boardId}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="title">제목</label><input type="text" id="title" name="title" value="${read.title}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label><textarea id="content" name="content"><c:out value="${read.content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writerName">작성자</label><input type="text" id="writerName" name="writerName" value="${read.writerName}" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="date">작성날짜</label>
									<fmt:formatDate value="${read.date}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">수정</button>
						<button type="submit" class="delete_btn">삭제</button>
						<button type="submit" class="list_btn">목록</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>