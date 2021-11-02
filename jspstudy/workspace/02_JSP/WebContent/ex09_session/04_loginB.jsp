<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	Member member = new Member();
	member.setUserId(userId);
	member.setUserPw(userPw);
	
	// 자바 연습용 DB -> Map
	// Map<Key, Value>
	Map<String, String> db = new HashMap<>();
	db.put("admin", "1234");
	db.put("superman", "1234");
	
	if (db.containsKey(member.getUserId())) {  // db에 userId 포함 여부 점검
		if (db.get(member.getUserId()).equals(member.getUserPw())) {  // 비밀번호 일치 여부 점검
			session.setAttribute("loginUser", member);
		}
	}
	
	if (session.getAttribute("loginUser") == null) {
		response.sendRedirect("04_loginA.jsp");
	} else {
		response.sendRedirect("04_cartA.jsp");
	}
	
%>