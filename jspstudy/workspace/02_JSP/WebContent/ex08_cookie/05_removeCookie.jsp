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
</head>
<body>

	<%
		/*
			쿠키 삭제하기 - 1
			1. 모든 쿠키를 읽는다.
			2. 삭제할 쿠키의 유효 기간을 0으로 설정한다.
			3. 동일한 이름의 쿠키로 덮어쓰기한다.
		*/
		
		// agree, address 쿠키를 모두 삭제하기
		
		/*
		Cookie[] cookies = request.getCookies();
	
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("agree") || cookie.getName().equals("address")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		*/
		
		/*
			쿠키 삭제하기 - 2
			1. 동일한 쿠키를 만든다.
			2. 유효 기간을 0으로 설정한다.
			3. 동일한 이름의 쿠키로 덮어쓰기한다.
		*/
		
		Cookie cookie1 = new Cookie("agree", "");
		cookie1.setMaxAge(0);
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("address", "");
		cookie2.setMaxAge(0);
		response.addCookie(cookie2);
		
	%>

</body>
</html>