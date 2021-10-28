<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 현재 페이지는 에러 처리용 페이지이다. --%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<h1>요청을 처리하는 도중 예기치 않는 문제가 발생했습니다</h1>
		<h3><%=exception.getClass().getName()%></h3>
		<h3><%=exception.getMessage()%></h3>
		<em><a href="mailto:admin@web.com">오류 신고하기</a></em>
	</div>

</body>
</html>
