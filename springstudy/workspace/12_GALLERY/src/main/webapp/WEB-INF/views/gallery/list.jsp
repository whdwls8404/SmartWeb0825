<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<h1>갤러리 목록 보기</h1>
	
	<a href="/ex12/gallery/insertPage">새 갤러리 작성</a>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>썸네일</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>첨부다운로드</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="6">작성된 갤러리 없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="gallery" items="${list}">
					<tr>
						<td>${gallery.no}</td>
						<td><img alt="${gallery.origin}" src="/ex12/${gallery.path}/s_${gallery.saved}"></td>
						<td><a href="/ex12/gallery/selectGalleryByNo?no=${gallery.no}">${gallery.title}</a></td>
						<td>${gallery.writer}</td>
						<td>${gallery.created}</td>
						<td><i class="fas fa-paperclip"></i></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>

</body>
</html>