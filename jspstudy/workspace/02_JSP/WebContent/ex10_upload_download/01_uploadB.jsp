<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

	<%
		// 1. 업로드 디렉터리 경로 알아내기
		String realPath = application.getRealPath("storage");
	
		// 2. 업로드 디렉터리 생성하기
		File dir = new File(realPath);
		if (dir.exists() == false) {
			dir.mkdirs();
		}
		
		// 3. 업로드 진행
		//    cos.jar가 제공하는 MultipartRequest 활용
		MultipartRequest multipartRequest = new MultipartRequest(
				/* 기존 request */	request,
				/* 업로드 경로  */  realPath,
				/* 최대 크기    */  10 * 1024 * 1024,
				/* 인코딩       */  "UTF-8",
				/* 파일명 중복  */  new DefaultFileRenamePolicy()
				);
	%>
	
</body>
</html>