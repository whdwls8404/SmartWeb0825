<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- 세션 초기화, 쿠키 삭제 --%>
<%
	// 세션 초기화
	session.invalidate();

	// 쿠키 삭제
	Cookie[] cookies = request.getCookies();
	if (cookies != null && cookies.length != 0) {
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userId") || cookie.getName().equals("userName")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	}
%>
	
<%-- 이동 --%>
<script>
	alert('로그아웃 되었습니다.');
	location.href = '03_keep_loginA.jsp';  // 리다이렉트와 같은 개념으로 이동.
</script>