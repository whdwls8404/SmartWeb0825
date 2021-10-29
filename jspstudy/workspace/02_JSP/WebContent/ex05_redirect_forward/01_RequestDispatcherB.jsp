<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/* forward : 기존 요청(request)을 그대로 전달한다. */
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("01_RequestDispatcherC.jsp");
	dispatcher.forward(request, response);
%>