<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* redirect : 기존 요청(request)을 전달하지 않는다. */
	
	/* 강제로 전달하시오. */
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	response.sendRedirect("04_sendRedirectC.jsp?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age);
%>