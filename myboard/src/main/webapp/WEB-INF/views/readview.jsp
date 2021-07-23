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
		var formObj = $("form[name='readForm']");
		
		$(".update_btn").on('click',function(){
			formObj.attr("action","updateview");
			formObj.attr("method","get");
			formObj.submit();
		})
		
		$(".delete_btn").on("click",function(){
			var deleteCheck = confirm("삭제하시겠습니까?");
			if(deleteCheck == true){
				formObj.attr("action","delete");
				formObj.attr("mothod","post");
				formObj.submit();
			}
		
		})
		
		$(".list_btn").on("click",function(){
			event.preventDefault();
			location.href="list?page=${searchPage.page}"
						+"&offset=${searchPage.offset}"
						+"&feild=${searchPage.feild}"
						+"&keyword=${searchPage.keyword}";
		})
		
		var replyForm = $("form[name='replyForm']");
		$(".replyWriteButton").on("click",function(){
			replyForm.attr("action","replywrite");
			replyForm.attr("method","post");
			replyForm.submit();
		});
		
		$(".deleteReplyButton").on("click",function(){
			
			location.href="deleteReplyView?BoardId=${read.boardId}"
						+"&page=${searchPage.page}"
						+"&offset=${searchPage.offset}"
						+"&feild=${searchPage.feild}"
						+"&keyword=${searchPage.keyword}"
						+"&replyId="+$(this).attr("data-replyId");
		});
		
		$(".updateReplyButton").on("click",function(){
			
			location.href = "updateReplyView?BoardId=${read.boardId}"
				+"&page=${searchPage.page}"
				+"&offset=${searchPage.offset}"
				+"&feild=${searchPage.feild}"
				+"&keyword=${searchPage.keyword}"
				+"&replyId="+$(this).attr("data-replyId");
		});
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
					<input type="hidden" id="boardId" name="boardId" value="${read.boardId}"/>
					<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
					<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
					<input type="hidden" id="feild"  name="feild" value="${searchPage.feild}"/>
					<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
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
				</form>
				<div>
					<button type="button" class="update_btn">수정</button>
					<button type="button" class="delete_btn">삭제</button>
					<button type="button" class="list_btn">목록</button>
				</div>
					
				<form name="replyForm" method="post">
					<input type="hidden" id="boardId" name="boardId" value="${read.boardId}"/>
					<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
					<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
					<input type="hidden" id="feild"  name="feild" value="${searchPage.feild}"/>
					<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
					
					<div>
						<label for="writer">댓글 작성자</label><input type="text" id="writer" name="writer"/>
						<label for="content">댓글 내용</label><input type="text" id="content" name="content"/>
					</div>
					<div>
						<button type="button" class="replyWriteButton">작성</button>
					</div>
				</form>
				<!-- 댓글 -->
				<div id="reply">
					<ol class="replyList">
						<c:forEach items="${reply}" var="replyList">
							<li>
								<p>
									작성자 : ${replyList.writer}<br/>
									작성 날짜 : <fmt:formatDate value="${read.date}" pattern="yyyy-MM-dd"/><br/>
								</p>
								<p>${replyList.content}</p>
								<div>
									<button type="button" class ="updateReplyButton" data-replyId="${replyList.replyId}">수정</button>
									<button type="button" class = "deleteReplyButton" data-replyId="${replyList.replyId}">삭제</button>
								</div>
							</li>
						</c:forEach>
					</ol>
				</div>

			</section>
			<hr />
		</div>
	</body>
</html>