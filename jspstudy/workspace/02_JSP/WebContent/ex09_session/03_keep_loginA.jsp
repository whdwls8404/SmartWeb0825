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
	<style>
		label {
			display: inline-block;
			width: 100px;
		}
	</style>
</head>
<body>

	<%
		boolean keepLogin = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					keepLogin = true;
					break;
				}
			}
		}
	%>

	<% if (keepLogin == false) { %>
		<form action="03_keep_loginB.jsp" method="post">
			<div>
				<label for="userId">아이디</label>
				<input type="text" name="userId" id="userId">
			</div>
			<div>
				<label for="userPw">비밀번호</label>
				<input type="password" name="userPw" id="userPw">
			</div>
			<div>
				<button>로그인</button>
			</div>
			<div>
				<input type="checkbox" name="keepLoginCheck" id="keepLoginCheck">
				<label for="keepLoginCheck">로그인 유지</label>
			</div>
		</form>
	<% } else { %>
		<% response.sendRedirect("03_keep_loginC.jsp"); %>
	<% } %>
	
</body>
</html>