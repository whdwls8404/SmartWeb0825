<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			if ('${notice.title}' == $('#title').val() &&
				'${notice.content}' == $('#content').val()) {
				alert('수정할 내용이 없다.');
				return;
			}
			$('#f').attr('action', '/ex11/notice/updateNotice');
			$('#f').submit();
		});
		// 삭제
		$('#delete_btn').on('click', function(){
			if (confirm('삭제할까요?')) {
				$('#f').attr('action', '/ex11/notice/deleteNotice');
				$('#f').submit();
			}
		});
	});
</script>
</head>
<body>

	<h1>공지사항 상세 보기 화면</h1>
	
	<form id="f">
		번호<br>
		${notice.no}<br><br>
		제목<br>
		<input type="text" name="title" id="title" value="${notice.title}"><br><br>
		내용<br>
		<textarea rows="2" cols="25" name="content" id="content">${notice.content}</textarea><br><br>
		작성일<br>
		${notice.created}<br><br>
		최종수정일<br>
		${notice.lastModified}<br><br>
		<input type="hidden" name="no" value="${notice.no}">
		<input type="button" value="수정" id="update_btn">
		<input type="button" value="삭제" id="delete_btn">
		<input type="button" value="목록" onclick="location.href='/ex11/notice/selectNoticeList'">
	</form>

</body>
</html>