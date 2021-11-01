<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style type="text/css">
		label { display: block; }
	</style>
</head>
<body>

	<form action="02_BookB.jsp">
		<label><input type="text" name="title" placeholder="제목"></label>
		<label><input type="text" name="author" placeholder="저자"></label>
		<label><input type="text" name="price" placeholder="가격"></label>
		<button>전송하기</button>
	</form>

</body>
</html>