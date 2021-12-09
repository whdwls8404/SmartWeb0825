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

	<h1>공지사항 작성 화면</h1>
	<form method="post" action="/ex11/notice/insertNotice">
		<input type="text" name="title" placeholder="제목"><br>
		<textarea rows="2" cols="25" name="content" placeholder="내용"></textarea><br><br>
		<button>작성완료</button>
		<input type="button" value="목록" onclick="location.href='/ex11/notice/selectNoticeList'">
	</form>

</body>
</html>