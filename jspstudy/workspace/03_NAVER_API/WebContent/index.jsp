<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인으로 이동합니다.</h1>
	<a href="<%=request.getContextPath()%>/LoginServlet">로그인하러 가기</a>
	<br>
	<a href="/naver.api/LoginServlet">로그인하러 가기</a>

</body>
</html>