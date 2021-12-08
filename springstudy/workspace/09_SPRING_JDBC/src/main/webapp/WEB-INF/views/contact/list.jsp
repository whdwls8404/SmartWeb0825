<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	
	<h1>연락처 목록 화면</h1>
	
	<a href="/ex09/contact/contactPage">연락처 작성하기</a>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>연락처</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="contact" items="${list}">
					<tr>
						<td>${contact.no}</td>
						<td><a href="/ex09/contact/findContact?no=${contact.no}">${contact.name}</a></td>
						<td>${contact.tel}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
</body>
</html>