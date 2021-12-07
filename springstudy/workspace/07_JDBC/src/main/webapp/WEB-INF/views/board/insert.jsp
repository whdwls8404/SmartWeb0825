<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성 화면</h1>
	<form action="/ex07/board/insertBoard.do" method="post">
		<input type="text" name="writer" placeholder="작성자"><br>
		<input type="text" name="title" placeholder="제목"><br>
		<input type="text" name="content" placeholder="내용"><br>
		<button>작성완료</button>
	</form>
</body>
</html>