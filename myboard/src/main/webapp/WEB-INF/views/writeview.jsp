<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form method="post" action ="write">
		제목 : <input type=text name="title"><br>
		이름 : <input type=text name="writer_name"><br>
		내용 : <input type=text name="content"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>