<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

	<h1>연락처 등록 화면</h1>
	
	<form method="post" action="/ex09/contact/addContact">
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="tel" placeholder="전화번호"><br>
		<input type="text" name="address" placeholder="주소"><br>
		<input type="text" name="birthday" placeholder="YYYY-MM-DD"><br>
		<button>등록하기</button>
		<input type="button" value="목록" onclick="location.href='/ex09/contact/findAllContact'">
	</form>

</body>
</html>