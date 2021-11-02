<%@page import="java.sql.Date"%>
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
		MultipartRequest mr = new MultipartRequest(
				/* 기존 request */	request,
				/* 업로드 경로  */  realPath,
				/* 최대 크기    */  10 * 1024 * 1024,
				/* 인코딩       */  "UTF-8",
				/* 파일명 중복  */  new DefaultFileRenamePolicy()
				);
	%>
	
	<%--
		주의사항.
		- request는 사용할 수 없다.
		- MultipartRequest 객체를 대신 사용한다.
	--%>
	<div><%=request.getParameter("uploader")%></div>
	<div><%=mr.getParameter("uploader")%></div>
	
	<%-- 알아두면 유용한 정보 --%>
	<div>올릴 때 파일명 : <%=mr.getOriginalFileName("filename")%></div>
	<div>저장 된 파일명 : <%=mr.getFilesystemName("filename")%></div>
	<%
		// 첨부된 파일을 File 객체로 가져오기
		File file = mr.getFile("filename");
	%>
	<div>저장 된 파일명 : <%=file.getName()%></div>
	<div>파일 크기 : <%=file.length()%>Byte</div>
	<div>파일 크기 : <%=file.length() / 1024%>KB</div>
	<div>파일 크기 : <%=file.length() / 1024 / 1024%>MB</div>
	<div>최종 수정일 : <%=new Date(file.lastModified())%></div>
	<div>
		<img src="../storage/<%=mr.getFilesystemName("filename")%>" alt="첨부파일 미리보기" width="500px">
	</div>
	
	<div>
		<a href="01_download.jsp?filename=<%=mr.getFilesystemName("filename")%>">다운로드</a>
	</div>

</body>
</html>