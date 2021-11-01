<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		1. session
			1) JSP 내장 객체이다.
			2) HttpSession 타입의 객체이다.
			3) session은 request로부터 구할 수 있다.
			    HttpSession session = request.getSession();
			4) 서버 측 공간이기 때문에 보안이 뛰어나다.
			5) session에 저장된 정보(속성, attribute)는 웹 브라우저가 켜져 있는 동안 유지된다.
		2. session 속성
			1) 속성 저장 : session.setAttribute("속성명", 값);
			2) 속성 확인 : (캐스팅)session.getAttribute("속성명");
			3) 속성 삭제 : session.removeAttribute("속성명");
		3. session 초기화
			session.invalidate();
	*/
	
	// session에 속성 저장하고 이동하기
	session.setAttribute("name", "민경태");
	session.setAttribute("age", 44);
	
	// session은 request와 상관이 없으므로 리다이렉트/포워드 상관 없음.
	
	// 리다이렉트(request 없이 이동)
	// response.sendRedirect("01_sessionB.jsp");
	
	// 포워드(request 가지고 이동)
	request.getRequestDispatcher("01_sessionB.jsp").forward(request, response);
	
%>