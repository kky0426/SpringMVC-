<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[name='writeForm']");
		$(".write_btn").on("click",function(){
			if(fn_valiChk()){
				return false;
			}else{
				formObj.attr("action","write");
				formObj.attr("method","post");
				formObj.submit();
			}					
		});
		
		
	})
	
	function fn_valiChk(){
			var regForm = $("form[name='writeForm'] .chk").length;
			for(var i = 0; i<regForm; i++){
				if($(".chk").eq(i).val() == "" || $(".chk").eq(i).val() == null){
					alert($(".chk").eq(i).attr("title"));
					return true;
				}
			}
		}
</script>

<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<div>
		<%@include file = "nav.jsp" %>
	</div>
	<c:if test="${user.userId !=null}">
		<form name="writeForm">
			제목 : <input type=text name="title" class="chk" title="제목을 입력하세요"><br>
			이름 : <input type=text name="writer_name" class="chk" title="이름을 입력하세요"><br>
			내용 : <input type=text name="content" class="chk" title="내용을 입력하세요"><br>
			<button type="button" class="write_btn">작성</button>
		</form>
	</c:if>
	<c:if test="${user.userId==null}">
		<p>로그인 후에 작성하실 수 있습니다.</p>
	</c:if>
</body>
</html>