<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var form =$("from[name='updateForm']");
		
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
	
	<section id="container">
		<form name="updateForm" role="form" method="post" action="updateReply">
			<input type="hidden" id="boardId" name="boardId" value="${reply.boardId}"/>
			<input type="hidden" id="replyId" name="replyId" value="${reply.replyId}"/>
			<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
			<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
			<input type="hidden" id="feild" name="feild" value="${searchPage.feild}"/>
			<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
			
			<table>
				<tr>
					<td>
						<label for="content">댓글 내용<input type="text" id="content" name="content" value="${reply.content}"/></label>
					</td>
				</tr>
			</table>
			
			<div>
				<button type="submit" class="updateButton">저장</button>
				<button type="button" class="cancelButton">취소</button>
			</div>
		</form>
		
	</section>
</body>
</html>