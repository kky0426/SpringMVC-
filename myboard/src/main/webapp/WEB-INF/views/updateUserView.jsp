<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#cancel").on("click",function(){
			location.href="main";
		})
	});
</script>
	
</head>
<body>
	<section id="container">
		<form action = "updateUser" method="post">
			<div class="form-control has-feedback">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId" value="${user.userId}"/>
			</div>
			<div class="form-control has-feedback">
				<label class="control-label" for="userPass">비밀번호</label>
				<input class="form-control" type="text" id="userPass" name="userPass" value="${user.userPass}"/>
			</div>
					<div class="form-control has-feedback">
				<label class="control-label" for="userName">이름</label>
				<input class="form-control" type="text" id="userName" name="userName" value="${user.userName}"/>
			</div>
			<div class="form-control has-feedback">
				<button class="btn btn-success" type="submit" id="submit">수정</button>
				<button class="btn btn-danger" type="button" id="cancel">취소</button>
			</div>
		</form>
	</section>
</body>
</html>