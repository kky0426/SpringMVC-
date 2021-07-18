<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<nav> 홈 - 글작성</nav>
	<hr/>
	<section id="container">
		<form role="form" method ="post" action="/write">
			<table>
				<tr><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td><c:out value="${list.boardId}"/></td>
						<td><c:out value="${list.title}"/></td>
						<td><c:out value="${list.writerName}"/></td>
						<td><c:out value="${list.date}"/></td>
					</tr>
				</c:forEach>
			
			</table>
		</form>
	</section>
	<hr/>
</body>
</html>