<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="/ex07/board/insertBoardForm.do">새 글 작성</a>

	<hr>

	<h1>게시판 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.no}</td>
						<td><a href="/ex07/board/selectBoardByNo.do?no=${board.no}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td>${board.created}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>