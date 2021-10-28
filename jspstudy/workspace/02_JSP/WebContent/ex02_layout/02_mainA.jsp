<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	2. 액션 태그 사용
		1) 현재 페이지에 다른 페이지를 포함할 수 있다.
		2) 동적 페이지를 포함할 수 있다.
		3) 페이지에 parameter를 전달할 수 있다.
		<jsp:include page="포함할페이지">
			<jsp:param value="값" name="파라미터"/>
		</jsp:include>
--%>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:include page="02_header.jsp">
	<jsp:param value="정치" name="title"/>
</jsp:include>

		<div>구역1</div>
		<div>구역2</div>
		<div>구역3</div>

<%@ include file="01_footer.jsp" %>
