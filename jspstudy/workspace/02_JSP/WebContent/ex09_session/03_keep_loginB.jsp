<%@page import="ex09_session.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	
	request.setCharacterEncoding("UTF-8");

	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String keepLoginCheck = request.getParameter("keepLoginCheck");
	
	Member member = new Member();
	member.setUserId(userId);
	member.setUserPw(userPw);
	
	// admin/1234이면 로그인 성공으로 가정
	Member loginUser = null;
	
	if (member.getUserId().equals("admin") && member.getUserPw().equals("1234")) {
			
		// loginUser : DB에서 가져온 회원 정보로 가정 
		loginUser = new Member();
		loginUser.setUserId("admin");
		loginUser.setUserPw("1234");
		loginUser.setUserName("민경태");
		
		// 브라우저를 닫은 뒤에도 로그인이 유지되려면
		// 관련 정보를 Cookie에 담는다.
		
		// 로그인 유지 체크하면 로그인 정보를 Cookie에 저장
		if (keepLoginCheck != null) {
			Cookie cookie1 = new Cookie("userId", loginUser.getUserId());
			cookie1.setMaxAge(15 * 24 * 60 * 60);
			response.addCookie(cookie1);
			Cookie cookie2 = new Cookie("userName", loginUser.getUserName());
			cookie2.setMaxAge(15 * 24 * 60 * 60);
			response.addCookie(cookie2);
		// 로그인 유지 체크 안하면 로그인 정보를 session에 저장
		} else {
			session.setAttribute("userId", loginUser.getUserId());
			session.setAttribute("userName", loginUser.getUserName());
		}

	}
	
	// 이동
	response.sendRedirect("03_keep_loginC.jsp");
	
%>