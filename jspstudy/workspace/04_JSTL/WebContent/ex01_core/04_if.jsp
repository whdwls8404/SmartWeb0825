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

	<c:set var="a" value="12" />
	<c:set var="b" value="8"  />
	
	<%-- 1. 큰 수 출력하기 --%>
	<c:if test="${a - b >= 0}">
		<c:set var="max" value="${a}" />
	</c:if>
	<c:if test="${a - b < 0}">
		<c:set var="max" value="${b}" />
	</c:if>
	<div>큰 수는 ${max}이다.</div>
	
	
	<%-- 2. 10에 가까운 수 출력하기 --%>
	<c:if test="${a - 10 >= 0}">
		<c:set var="diff1" value="${a - 10}" />
	</c:if>
	<c:if test="${a - 10 < 0}">
		<c:set var="diff1" value="${10 - a}" />
	</c:if>
	<c:if test="${b - 10 >= 0}">
		<c:set var="diff2" value="${b - 10}" />
	</c:if>
	<c:if test="${b - 10 < 0}">
		<c:set var="diff2" value="${10 - b}" />
	</c:if>
	<c:if test="${diff1 - diff2 > 0}">
		10과 가까운 수는 ${b}이다<br>
	</c:if>
	<c:if test="${diff1 - diff2 < 0}">
		10과 가까운 수는 ${a}이다<br>
	</c:if>
	<c:if test="${diff1 - diff2 == 0}">
		${a}와 ${b}는 10과 같은 차이이다<br>
	</c:if>

</body>
</html>