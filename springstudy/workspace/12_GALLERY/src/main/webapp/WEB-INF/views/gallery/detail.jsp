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

	<h1>갤러리 상세 보기 화면</h1>
	
	<form id="f" method="post" enctype="multipart/form-data">
		
		작성자<br>
		${gallery.writer}<br><br>
		
		작성일<br>
		${gallery.created}<br><br>
		
		수정일<br>
		${gallery.lastModified}<br><br>
		
		작성자 IP<br>
		${gallery.ip}<br><br>
		
		제목<br>
		<input type="text" name="title" value="${gallery.title}"><br><br>
		
		내용<br>
		<input type="text" name="content" value="${gallery.content}"><br><br>
		
		첨부 변경하기<br>
		<input type="file" name="new_file"><br>
		기존 첨부 : ${gallery.origin}<br><br>
		
		<img alt="${gallery.origin}" src="/ex12/${gallery.path}/${gallery.saved}" width="500px" >
		
	</form>


</body>
</html>