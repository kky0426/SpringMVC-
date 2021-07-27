<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">	 	
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
		$(document).ready(function(){
			// 취소
			$("#cancel").on("click", function(){
				
				location.href = "main";
						    
			})
		
			$("#submit").on("click", function(){
				if($("#userPass").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#userPass").focus();
					return false;
				}
				$.ajax({
					url : "checkPass",
					type : "POST",
					dataType : "json",
					data : $("#delForm").serializeArray(),
					success: function(data){
						
						if(data!=true){
							alert("패스워드가 틀렸습니다.");
							return;
						}else{
							if(confirm("회원탈퇴하시겠습니까?")){
								$("#delForm").submit();
							}
							
						}
					}
				})
				
			});
			
				
			
		})
	</script>
<body>
	<section id="container">
		<form  action="deleteUser" method="post" id="delForm">
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">아이디</label>
				<input type="text" class="from-control" id="userId" name="userId" value="${user.userId}">
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userPass">비밀번호</label>
				<input type="text" class="from-control" id="userPass" name="userPass">
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="userId">이름</label>
				<input type="text" class="from-control" id="userName" name="userName" value="${user.userName}">
			</div>
		</form>
		<div>
			<button class="btn btn-success" type="button" id="submit">회원탈퇴</button>
			<button class="btn btn-danger" type="button" id="cancel">취소</button>
		</div>
		<div>
			<c:if test="${msg==false}">
				<p>비밀번호가 맞지 않습니다.
			</c:if>
		</div>
	</section>
</body>
</html>



