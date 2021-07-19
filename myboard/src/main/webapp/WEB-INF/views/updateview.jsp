<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).read(function(){
		$(".cancel_btn").on("click",function(){
			event.preventDefault();
			location.href="list";
		})
	})
</script>
<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr/>
		
		<nav>홈 - 글작성</nav>
		<hr/>
		
		<section id="contaner">
			<form name="updateForm" role="form" method="post" action="update">
				<input type="hidden" name="boardId" value="${update.boardId}" readonly="readonly"/>
				<table>
					<tbody>
						<tr>
							<td>
								<label for="title">제목</label><input type = "text" id='title' name = "title" , value="${update.title}"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="content">내용</label><input type = "text" id='content' name = "content" , value="${update.content}"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="writerName">작성자</label><input type = "text" id='writerName' name = "writerName" , value="${update.writerName}"/>
							</td>
						</tr>
					
					</tbody>
				</table>
				<div>
					<button type="submit" class="update_btn">저장</button>
					<button type="submit" class="cancel_btn">취소</button>
				</div>
			</form>
		</section>
	</div>
</body>
</html>