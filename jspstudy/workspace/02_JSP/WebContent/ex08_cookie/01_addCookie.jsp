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
		// 1. 쿠키 만들기
		Cookie cookie = new Cookie("agree", "yes");
	
		// 2. 쿠키 유효시간 정하기
		cookie.setMaxAge(15 * 24 * 60 * 60);  // 단위: 초 (15일 * 24시간 * 60분 * 60초)
		
		// 3. 쿠키 저장하기
		// 사용자에게 쿠키를 되돌려 줌.(response)
		response.addCookie(cookie);
		
		// 4. 저장된 쿠키 정보 확인하기
		// out 내장 객체 : 브라우저 화면 만드는 객체
		out.println("<h1>쿠키이름 : " + cookie.getName() + "</h1>");
		out.println("<h1>유효시간 : " + cookie.getMaxAge() + "</h1>");
		out.println("<h1>쿠키 값 : " + cookie.getValue() + "</h1>");
		
	%>

</body>
</html>