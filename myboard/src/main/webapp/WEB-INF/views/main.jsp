<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutButton").on("click",function(){
			location.href="logout";
		})
		
		$("#regiserButton").on("click",function(){
			location.href="register";
		})
		$("#listButton").on("click",function(){
			location.href="list";
		})
		
		$("#userUpdateButton").on("click",function(){
			location.href="updateUserView";
		})
		
	});
</script>
</head>
<body>
	<form name='loginForm' method='post' action='login'>
		<c:if test="${user==null}">
			<div>
				<label for="userId"></label>
				<input type="text" id="userId" name="userId">
			</div>
				<div>
				<label for="userPass"></label>
				<input type="password" id="userPass" name="userPass">
			</div>
			<div>
				<button type="submit">로그인</button>
				<button type="button" id="regiserButton">회원가입</button>
			</div>
		</c:if>
		<c:if test="${user!=null}">
			<div>
				<p>${user.userId}님 환영합니다.</p>
				<button id="listButton" type="button">글목록</button>
				<button id="logoutButton" type="button">로그아웃</button>
				<button id="userUpdateButton" type="button">회원정보수정</button>
			</div>
		</c:if>
		<c:if test="${msg==false}">
			<p style="color:red;">로그인 실패! 아이디와 비밀번호를 확인해주세요.</p>
		</c:if>
	</form>
</body>
</html>