<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 수정
		$('#update_btn').on('click', function(){
			if ($('#title').val() == '${gallery.title}' &&
				$('#content').val() == '${gallery.content}' &&
				$('#newFile').val() == '') {
				alert('수정할 내용이 없습니다.');
				return;
			}
			$('#f').attr('action', '/ex12/gallery/updateGallery');
			$('#f').submit();
		});
		// 삭제
		$('#delete_btn').on('click', function(){
			if (confirm('삭제할까요?')) {
				$('#f').attr('action', '/ex12/gallery/deleteGallery');
				$('#f').submit();				
			}
		});
	})
</script>
</head>
<body>

	<h1>갤러리 상세 보기 화면</h1>
	
	<form id="f" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="created" value="${gallery.created}">
		<input type="hidden" name="path" value="${gallery.path}">
		<input type="hidden" name="saved" value="${gallery.saved}">
		<input type="hidden" name="origin" value="${gallery.origin}">
		<input type="hidden" name="no" value="${gallery.no}">
		
		<input type="button" value="수정완료" id="update_btn">
		<input type="button" value="삭제" id="delete_btn">
		<input type="button" value="목록" onclick="location.href='/ex12/gallery/selectGalleryList'">
		
		<hr>
		
		작성자<br>
		${gallery.writer}<br><br>
		
		작성일<br>
		${gallery.created}<br><br>
		
		수정일<br>
		${gallery.lastModified}<br><br>
		
		작성자 IP<br>
		${gallery.ip}<br><br>
		
		제목<br>
		<input type="text" name="title" id="title" value="${gallery.title}"><br><br>
		
		내용<br>
		<input type="text" name="content" id="content" value="${gallery.content}"><br><br>
		
		첨부 변경하기<br>
		<input type="file" name="newFile" id="newFile"><br>
		
	</form>
	
	<c:if test="${not empty gallery.origin}">
		기존 첨부 : ${gallery.origin}<br><br>			
		<img alt="${gallery.origin}" src="/ex12/${gallery.path}/${gallery.saved}" width="500px"><br>
		<form action="/ex12/gallery/download" method="post">
			<input type="hidden" name="origin" value="${gallery.origin}">
			<input type="hidden" name="path" value="${gallery.path}">
			<input type="hidden" name="saved" value="${gallery.saved}">
			<button>다운로드</button>
		</form>
	</c:if>
	
</body>
</html>