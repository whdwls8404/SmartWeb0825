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

	<%-- session에 저장된 속성 꺼내기 --%>
	<%
		String name = (String)session.getAttribute("name");
	%>
	
	<h1>이름 : <%=name%></h1>
	
	
	<%-- session에 저장된 속성은 EL로 사용할 수 있다. --%>
	<div>${name}</div>
	
</body>
</html>