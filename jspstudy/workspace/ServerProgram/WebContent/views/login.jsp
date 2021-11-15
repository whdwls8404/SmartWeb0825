<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		* {
			margin: 0;
			padding: 0;
		}
		a {
			color: black;
		}
		.container {
			width: 500px;
			margin: 100px auto;
			text-align: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#f').on('submit', function(event){
				if ($('#id').val() == '' || $('#name').val() == '') {
					alert('아이디와 이름은 필수입니다.');
					event.preventDefault();
					return false;
				}
				return true;
			});
		})
	</script>
</head>
<body>
	<div class="container">
		<h3>회원 관리 프로그램</h3><br>
		<form id="f" action="/ServerProgram/login.do" method="post">
			<input type="text" name="id" id="id" placeholder="아이디"><br>
			<input type="text" name="name" id="name" placeholder="이름"><br><br>
			<button>로그인</button>&nbsp;&nbsp;
			<a href="/ServerProgram/joinPage.do">회원가입</a>
		</form>
	</div>
</body>
</html>