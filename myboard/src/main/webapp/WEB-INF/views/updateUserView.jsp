<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">	 	

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#cancel").on("click",function(){
			location.href="main";
		})
		
		$("#delete").on("click",function(){
			location.href="deleteUserView";
		})
		
		$("#submit").on("click",function(){
			$.ajax({
				url : "checkPass",
				type : "POST",
				dataType : "json",
				data : $("#updateForm").serializeArray(),
				success : function(data){
					if(data==true){
						if(confirm("수정하시겠습니까?")){
							$("#updateForm").submit();
						}
					}else{
						alert("패스워드가 틀렸습니다.");
						return;
					}
				}
			})
		});
		})
		
</script>
	
</head>
<body>
	<section id="container">
		<form name="updateForm" action = "updateUser" method="post" id="updateForm">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId" value="${user.userId}"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userPass">비밀번호</label>
				<input class="form-control" type="text" id="userPass" name="userPass" />
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userName">이름</label>
				<input class="form-control" type="text" id="userName" name="userName" value="${user.userName}"/>
			</div>			
		</form>
		<div>
				<button class="btn btn-success" type="button" id="submit">수정</button>
				<button class="btn btn-warning" type="button" id="cancel">취소</button>
				<button class="btn btn-danger" type="button" id="delete">회원탈퇴</button>
			</div>
	</section>
</body>
</html>