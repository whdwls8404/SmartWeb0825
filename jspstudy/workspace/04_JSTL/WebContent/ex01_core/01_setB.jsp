<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("UTF-8"); %>
	
	<h1>파라미터</h1>
	<h1>전화 : <%=request.getParameter("tel")%></h1>
	<h1>주소 : <%=request.getParameter("address")%></h1>
	
	<h1>속성</h1>
	<h1>전화 : <%=(String)request.getAttribute("tel")%></h1>
	<h1>주소 : <%=(String)request.getAttribute("address")%></h1>

	<h1>속성</h1>
	<h1>전화 : ${tel}</h1>
	<h1>주소 : ${address}</h1>
	<h1>키 : ${height}cm</h1>
	<h1>몸무게 : ${weight}kg</h1>
	
	<c:set var="bmi" value="${weight div (height * height div 10000)}" />
	<h1>체질량지수 : ${bmi}</h1>
	<h1>건강상태 : ${bmi - 25 >= 0 ? "관리필요" : "정상"}</h1>
	
</body>
</html>




