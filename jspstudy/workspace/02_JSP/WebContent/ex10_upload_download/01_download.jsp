<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	request.setCharacterEncoding("UTF-8");

	String filename = request.getParameter("filename");
	String realPath = application.getRealPath("storage");
	
	// 서버에 저장된 파일(업로드 된 파일)
	File file = new File(realPath, filename);
	
	// 응답 헤더
	response.setHeader("Content-Disposition", "attachment; filename=" + filename);
	response.setHeader("Content-Length", file.length() + "");
	response.setHeader("Content-Type", "application/x-msdownload");
	
	// JSP 내장 출력 스트림 : out 처리
	out.clear();
	out = pageContext.pushBody();
	
	// 서버에 저장된 파일 입력 스트림
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
	
	// 응답으로 보낼 파일 출력 스트림
	BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
	
	// 파일 크기만큼 메모리 확보
	
	int fileSize = (int)file.length();
	
	byte[] b = new byte[fileSize];
	
	// 서버에 저장된 파일 전체 읽어서 배열 b에 저장하기
	bis.read(b, 0, fileSize);
	
	// 배열 b 내용을 bos로 보내기
	bos.write(b, 0, fileSize);
	
	if (bos != null) { bos.close(); }
	if (bis != null) { bis.close(); }
	
%>