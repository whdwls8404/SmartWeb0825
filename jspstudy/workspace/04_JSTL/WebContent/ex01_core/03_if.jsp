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
		if
		1. <c:if test="조건식">실행문</c:if>
		2. else if, else문이 없다.
	--%>

	<c:set var="age" value="8" />
	
	<c:if test="${age - 20 >= 0}">
		성인
	</c:if>
	
	<c:if test="${age - 20 < 0}">
		미성년자
	</c:if>

</body>
</html>