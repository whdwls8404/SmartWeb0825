<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>회원번호 : ${member.idx}</h1>
	<h1>회원아이디 : ${member.id}</h1>
	<h1>회원이름 : ${member.name}</h1>

	<a href="/ex04">index로 돌아가기</a>  <!-- @GetMapping("/") 매핑과 연결됨. -->
	<br>
	<a href="/ex04/index.do">index로 돌아가기</a>  <!-- @GetMapping("index.do") 매핑과 연결됨. -->

</body>
</html>








