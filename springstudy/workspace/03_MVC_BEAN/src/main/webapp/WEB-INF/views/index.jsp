<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원아이디 : ${member1.id}</h1>
	<h1>비밀번호 : ${member1.pw}</h1>

	<a href="memberView1.do">회원정보보기1</a><br>
	<a href="memberView2.do">회원정보보기2</a><br>
	<br>
	<a href="boardView.do">게시글보기</a>

</body>
</html>