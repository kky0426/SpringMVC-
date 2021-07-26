<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		
		var formObj = $("form[name='updateForm']");
		$(".cancel_btn").on("click",function(){
			event.preventDefault();
			location.href="readview?boardId=${update.boardId}"
					+"&page=${searchPage.page}"
					+"&offset=${searchPage.offset}"
					+"&feild=${searchPage.feild}"
					+"&keyword=${searchPage.keyword}";
		})
		
		$(".update_btn").on("click",function(){
			if(fn_valiChk()){
				return false;
			}
			formObj.attr("action","update");
			formObj.attr("method","post");
			formObj.submit();
		})
		
	})
	
	function fn_valiChk(){
		var updateForm = $("form[name='updateForm'] .chk").length;
		for(var i = 0; i<updateForm; i++){
			if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
				alert($(".chk").eq(i).attr("title"));
				return true;
			}
		}
	}
</script>
<body>
	<div id="root">
		<header>
			<h1>게시판</h1>
		</header>
		<hr/>
		
	
		<div>
			<%@include file = "nav.jsp" %>
		</div>
		
		<hr/>
		
		<section id="contaner">
			<form name="updateForm">
				<input type="hidden" name="boardId" value="${update.boardId}" readonly="readonly"/>
				<table>
					<tbody>
						<tr>
							<td>
								<label for="title">제목</label><input type = "text" id='title' name = "title"  value="${update.title}" class="chk" title="제목을 입력하세요"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="content">내용</label><input type = "text" id='content' name = "content"  value="${update.content}" class="chk" title="내용을 입력하세요"/>
							</td>
						</tr>
						<tr>
							<td>
								<label for="writerName">작성자</label><input type = "text" id='writerName' name = "writerName"  value="${update.writerName}" class="chk" title="이름을 입려하세요"/>
							</td>
						</tr>
					
					</tbody>
				</table>
				<div>
					<button type="button" class="update_btn">저장</button>
					<button type="button" class="cancel_btn">취소</button>
				</div>
			</form>
		</section>
	</div>
</body>
</html>