<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 상세 보기</h1>
	<ul>
		<li>게시글번호 : ${board.no}</li>
		<li>작성자 : ${board.writer}</li>
		<li>제목 : ${board.title}</li>
		<li>내용 : ${board.content}</li>
		<li>최초등록일 : ${board.created}</li>
		<li>최종수정일 : ${board.lastModified}</li>
	</ul>
	<form>
		<input type="hidden" name="no" value="${board.no}">
		<input type="hidden" name="title" value="${board.title}">
		<input type="hidden" name="content" value="${board.content}">
		<input type="button" value="수정" onclick="fnUpdateBoardForm(this.form)">
		<input type="button" value="삭제" onclick="fnDeleteBoard(this.form)">
		<input type="button" value="목록" onclick="fnSelectBoardList()">
	</form>
	<script>
		function fnUpdateBoardForm(f) {
			f.action = '/ex07/board/updateBoardForm.do';
			f.submit();
		}
		function fnDeleteBoard(f) {
			f.action = '/ex07/board/deleteBoard.do';
			f.submit();
		}
		function fnSelectBoardList() {
			location.href='/ex07/board/selectBoardList.do';
		}
	</script>
</body>
</html>