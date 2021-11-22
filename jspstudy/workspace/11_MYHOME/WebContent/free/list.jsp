<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<header>
		<h1><a href="index.jsp">WEB PAGE TITLE</a></h1>
	</header>

	<hr>

	<!-- 작성 링크 -->
	<div>
		<c:if test="${loginUser != null}">
			<a href="insertForm.free">새글작성</a>		
		</c:if>
	</div>
	
	<!-- 검색란 -->
	
	
	<!-- 목록 -->
	전체 게시글 : ${totalCount}개<br>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>내용</td>
				<td>조회수</td>
				<td>최종수정일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">없다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="free">
					<tr>
						<td>${free.fNo}</td>
						<td>${free.writer}</td>
						<td>
							<c:if test="${free.content.length() < 20}">
								<a href="view.free?fNo=${free.fNo}">${free.content}</a>
							</c:if>
							<c:if test="${free.content.length() >= 20}">
								<a href="view.free?fNo=${free.fNo}">${free.content.substring(0, 20)}</a>								
							</c:if>
						</td>
						<td>${free.hit}</td>
						<td>${free.lastModified}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					페이징 처리할 곳
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>