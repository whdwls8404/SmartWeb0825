<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#f').on('submit', function(event){
				if ($('#content').val() == '') {
					alert('내용 필수');
					$('#content').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
	</script>
</head>
<body>

	<div>
		<form id="f" action="insert.free" method="post">
			<label for="writer">작성자</label>
			<input type="text" name="writer" id="writer" value="${loginUser.id}" readonly><br>
			<textarea rows="5" cols="30" name="content" id="content" placeholder="내용"></textarea><br><br>
			<button>작성완료</button>
			<input type="reset" value="다시작성">
			<input type="button" value="목록이동" onclick="location.href='list.free'">
		</form>
	</div>

</body>
</html>