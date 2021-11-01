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

	<%--
		쿠키 : 브라우저를 닫아도 정보가 유지됨.
		세션 : 브라우저를 닫으면 정보가 사라짐.
	--%>
	
	<%--
		로그인 : 로그인 정보가 세션에 저장됨.
		자동로그인 : 브라우저를 닫아도 로그인이 유지됨.
		             브라우저를 닫으면 세션은 유지가 안 되므로,
		             로그인 정보를 쿠키에 저장해 두다가
		             다시 꺼내서 세션에 저장함.
	--%>

	<%-- 쿠키에 저장된 로그인 정보 ===>>> 세션으로 보내기 --%>
	<%
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("userId")) {
					// 쿠키에 있는 값을 session으로 옮기기
					session.setAttribute("userId", cookie.getValue());
				}
				if (cookie.getName().equals("userName")) {
					// 쿠키에 있는 값을 session으로 옮기기
					session.setAttribute("userName", cookie.getValue());
				}
			}
		}
	%>
	
	<%-- 세션 정보 이용해서 로그인 화면 만들기 --%>
	${userName}님 환영합니다.
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="03_keep_loginD.jsp">로그아웃</a>

</body>
</html>