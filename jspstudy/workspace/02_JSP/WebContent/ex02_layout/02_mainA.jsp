<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:include page="02_header.jsp">
	<jsp:param value="정치" name="title"/>
</jsp:include>

		<div>구역1</div>
		<div>구역2</div>
		<div>구역3</div>

<%@ include file="01_footer.jsp" %>
