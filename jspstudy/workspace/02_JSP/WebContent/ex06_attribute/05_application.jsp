<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
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
		// 읽어 들일 파일의 실제 경로
		String realPath = application.getRealPath("ex06_attribute/next_level.txt");
	
		// 문자 기반 입력 스트림(reader) 생성
		BufferedReader br = new BufferedReader(new FileReader(realPath));
		
		// 읽어 들이기
		// 한 줄 읽고 <br> 붙여서 result에 누적
		String result = "";
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			result += line + "<br>";
		}
		
		// 스트림 닫기
		if (br != null) {
			br.close();
		}
		
	%>

	<h1>NEXT-LEVEL</h1>
	<div>
		<%=result%>
	</div>
	
</body>
</html>