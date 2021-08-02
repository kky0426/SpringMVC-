<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
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
	function fn_fileDown(fileId){
			var formObj = $("form[name='readForm']");
			$("#fileId").attr("value", fileId);			
			formObj.attr("action", "fileDown");
			formObj.submit();
	}
</script>
	
	<body>
	
		<div class="container">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			<div>
				<%@include file = "nav.jsp" %>
			</div>
			<button></button>
			<hr />
			
			<section id="container">
				<form name="readForm" role="form" method="post">
					<input type="hidden" id="boardId" name="boardId" value="${read.boardId}"/>
					<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
					<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
					<input type="hidden" id="feild"  name="feild" value="${searchPage.feild}"/>
					<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
					<input type="hidden" id="fileId" name="fileId" value=""/>
				</form>	
			
				<div class="form-group">			
					<label for="boardId">글 번호</label>
					<input type="text" id="boardId" name="boardId" value="${read.boardId}"/>
				</div>
				<div class="form-group">		
					<label for="title" class="col-sm-2 conrtrol-label">제목</label>
					<input type="text" class="form-control" id="title" name="title" value="${read.title}"/>
				</div>
				<div class="form-group">
					<label for="content" class="col-sm-2 conrtrol-label">내용</label>
					<textarea id="content" class="form-control"  name="content"><c:out value="${read.content}" /></textarea>
				</div>
				<div class="form-group">		
					<label for="writerName" class="col-sm-2 conrtrol-label">작성자</label>
					<input type="text" class="form-control"  id="writerName" name="writerName" value="${read.writerName}" />
				</div>
				<div class="form-group">		
					<label for="date" class="col-sm-2 conrtrol-label">작성날짜</label>
					<fmt:formatDate value="${read.date}" pattern="yyyy-MM-dd"/>					
				</div>
				<div>
				<hr>
				<span>파일 목록</span>
				<div class = "form-group" style="border : 1px solid #dbdbdb;">
					<c:forEach var="file" items="${file}">
						<a href="#" onclick="fn_fileDown('${file.fileId}');">${file.orgFileName}</a>(${file.fileSize}kb)<br>
						
					</c:forEach>
				</div>
				</div>
				<div>
					<button type="button" class="update_btn btn btn-warning">수정</button>
					<button type="button" class="delete_btn btn btn-danger">삭제</button>
					<button type="button" class="list_btn btn btn-primary">목록</button>
				</div>
					
				
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
									<button type="button" class ="updateReplyButton btn btn-warning" data-replyId="${replyList.replyId}">수정</button>
									<button type="button" class = "deleteReplyButton btn btn-danger" data-replyId="${replyList.replyId}">삭제</button>
								</div>
							</li>
						</c:forEach>
					</ol>
				</div>
				
				<form name="replyForm" method="post" class="form-horizontal">
					<input type="hidden" id="boardId" name="boardId" value="${read.boardId}"/>
					<input type="hidden" id="page" name="page" value="${searchPage.page}"/>
					<input type="hidden" id="offset" name="offset" value="${searchPage.offset}"/>
					<input type="hidden" id="feild"  name="feild" value="${searchPage.feild}"/>
					<input type="hidden" id="keyword" name="keyword" value="${searchPage.keyword}"/>
					
					<div class="form-group">
						<label for="writer" class="col-sm-2 control-label">댓글 작성자</label>
						<div class="col-sm-10">
							<input type="text"  class="form-control" id="writer" name="writer"/>
						</div>
						<label for="content" class="form-group">댓글 내용</label>
						<div class="col-sm-10">
							<input type="text"  class="form-control" id="content" name="content"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="button" class="replyWriteButton btn btn-success">작성</button>
						</div>
	
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>