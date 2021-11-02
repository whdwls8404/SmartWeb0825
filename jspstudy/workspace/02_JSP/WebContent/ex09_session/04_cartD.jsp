<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 장바구니(cart) 삭제
	session.removeAttribute("cart");
	response.sendRedirect("04_cartC.jsp");
%>