<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		fnFindId();
	});
	function fnFindId(){
		$('#search_btn').click(function(){
			let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
			if ( regEmail.test($('#email').val()) == false ) {
				alert('이메일 형식을 확인하세요.');
				return;
			}
			$.ajax({
				url: '/ex13/member/findId',
				type: 'post',
				data: 'email=' + $('#email').val(),
				dataType: 'json',
				success: function(map) {
					$('#search_result').text("회원님의 아이디는 " + map.id + "입니다.");
				},
				error: function(xhr) {
					$('#search_result').text(xhr.responseText);
				}
			});
		});
	}
</script>
</head>
<body>

	<h1>아이디 찾기 화면</h1>
	
	가입 당시 이메일<br>
	<input type="text" name="email" id="email">
	<input type="button" value="찾기" id="search_btn"><br><br>
	
	<div>
		<a href="/ex13/member/loginPage">로그인하러가기</a>
	</div>
	
	<hr>
	
	<div id="search_result"></div>
	
</body>
</html>