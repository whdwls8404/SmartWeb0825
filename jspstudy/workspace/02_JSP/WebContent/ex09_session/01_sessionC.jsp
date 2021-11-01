<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// session 삭제
	// session.removeAttribute("name");
	// session.removeAttribute("age");

	// session 초기화 (전체 session 삭제)
	session.invalidate();

	// 이동
	response.sendRedirect("01_sessionB.jsp");
%>