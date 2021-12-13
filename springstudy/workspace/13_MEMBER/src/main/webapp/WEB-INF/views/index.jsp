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

	<h1>홈페이지 메인화면</h1>
	
	<c:if test="${loginUser == null}">	
		<a href="/ex13/member/loginPage">로그인</a>
		&nbsp;&nbsp;&nbsp;
		<a href="/ex13/member/joinPage">회원가입</a>
	</c:if>
	
	<c:if test="${loginUser != null}">
		${loginUser.name} 님 반갑습니다.&nbsp;&nbsp;
		<a href="/ex13/member/logout">로그아웃</a>&nbsp;&nbsp;
		<a href="/ex13/member/myPage">마이페이지</a>
	</c:if>
	
	<hr>

</body>
</html>