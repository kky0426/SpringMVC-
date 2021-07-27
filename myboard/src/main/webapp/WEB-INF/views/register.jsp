<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$(".cancel").on("click",function(){
			location.href="main";
		})
		
		$("#submit").on("click",function(){
			
			if($("#userId").val()==""){
				alert("아이디를 입력해주세요");
				$("#userId").focus();
				return false;
			}
			if($("#userPass").val()==""){
				alert("비밀번호를 입력해주세요");
				$("#userPass").focus();
				return false;
			}
			if($("#userName").val()==""){
				alert("이름을 입력해주세요");
				$("#userName").focus();
				return false;
			}
			$.ajax({
				url : "checkId",
				type : "POST",
				dataType : "json",
				data : $("#registerForm").serializeArray(),
				success : function(data){
					if (data==0){
						$("#registerForm").submit();
					}else{
						alert("중복된 아이디가 있습니다.");
						return;
					}
				}
			
			})
		})
	});
</script>
<body>
	<section id="container">
		<form name="registerForm" action="register" method="post" id="registerForm">
			<div class = "form-gruop has-feedback">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId"/>
			</div>
			<div class = "form-gruop has-feedback">
				<label class="control-label" for="userPass">패스워드</label>
				<input class="form-control" type="password" id="userPass" name="userPass"/>
			</div>
			<div class = "form-gruop has-feedback">
				<label class="control-label" for="userName">이름</label>
				<input class="form-control" type="text" id="userName" name="userName"/>
			</div>
		</form>
		<div>
			<button class="button button-success" type="button" id="submit">가입</button>
			<button class="cancel button button-danger" type="button">취소</button>
		</div>
	</section>
</body>
</html>