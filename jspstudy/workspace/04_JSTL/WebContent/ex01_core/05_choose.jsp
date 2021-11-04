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

	<%--
		choose
		1. if - else if - else문으로 해석된다.
		2. if문이 여러 개 필요한 경우 유용하다.
	--%>

	<c:set var="age" value="44" />
	
	<c:choose>
		<c:when test="${age - 0 < 0 or age - 100 > 0}">나이가 아니다.</c:when>
		<c:when test="${7 - age >= 0}">미취학아동</c:when>
		<c:when test="${13 - age >= 0}">초등학생</c:when>
		<c:when test="${16 - age >= 0}">중학생</c:when>
		<c:when test="${19 - age >= 0}">고등학생</c:when>
		<c:otherwise>성인</c:otherwise>
	</c:choose>
	
</body>
</html>