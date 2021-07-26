<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<meta charset="UTF-8">
<title>게시판</title>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var form = $("form[name='deleteForm']");
		
		$(".cancelButton").on("click",function(){
			location.href="readview?boardId=${reply.boardId}"
						+"&page=${searchPage.page}"
						+"&offset=${searchPage.offset}"
						+"&feild=${searchPage.feild}"
						+"&keyword=${searchPage.keyword}";
		});
	});
</script>
<body>
	<header>
			<h1> 게시판</h1>
	</header>
	<hr />
			 
	<nav> 홈 - 글 상세</nav>
	<hr />
	
	<section id="container">
		<form name="deleteForm" role="form" method="post" action="deleteReply">
			<input type="hidden" id="boardId" name="boardId" value="${reply.boardId}"/>
			<input type="hidden" id="replyId" name="replyId" value="${reply.replyId}"/>
			<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
			<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
			<input type="hidden" id="feild" name="feild" value="${searchPage.feild}"/>
			<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
			
			<div>
				<p>삭제 하시겠습니까?</p>
				<button type="submit" class="deleteButton">예</button>
				<button type="button" class="cancelButton">아니오</button>
			</div>
		</form>
	</section>		
			
</body>
</html>