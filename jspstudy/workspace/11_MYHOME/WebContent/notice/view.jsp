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

	<div>

		게시글 번호 : ${notice.nNo}<br>
		작성자 : ${notice.writer}<br>
		조회수 : ${notice.hit}<br>
		IP : ${notice.ip}<br>
		작성일 : ${notice.nDate}<br>
		최종수정일 : ${notice.nLastModified}<br>
		제목 : ${notice.title}<br>
		내용<br>
		<pre>${notice.content}</pre>
		
		<br>

		<!--
			목록 : 누구나 
			수정, 삭제 : 작성자만
		-->
		<input type="button" value="목록" onclick="location.href='list.notice'">
		<c:if test="${notice.writer == loginUser.id}">
			<input type="button" value="수정" onclick="location.href='updateForm.notice'">
			<input type="button" value="삭제" onclick="fnNoticeDelete()">		
		</c:if>
		
		<script>
			function fnNoticeDelete() {
				if (confirm('게시글을 삭제할까요?')) {
					location.href = 'delete.notice?nNo=${notice.nNo}';
				}
			}
		</script>
		
		<hr>
		
		<!--
			작성자 : 로그인 유저 아이디
			댓글달기 : 로그인 유저만 오픈
		-->
		<form action="insert.reply" method="post">
			<label for="writer">작성자</label>
			<input name="writer" id="writer" value="${loginUser.id}" readonly><br>
			<textarea rows="5" cols="30" name="content"></textarea><br>
			<input type="hidden" name="nNo" value="${notice.nNo}">
			<c:if test="${loginUser != null}">
				<button>댓글달기</button>			
			</c:if>
		</form>
		
		<hr>
		
		<div>
			<c:if test="${empty replyList}">
				첫 댓글의 주인공이 되어 보자
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
					${reply.writer}&nbsp;&nbsp;
					${reply.ip}&nbsp;&nbsp;
					${reply.rDate}<br>
					<pre>${reply.content}</pre>
				</c:forEach>
			</c:if>
		</div>
		
	</div>

</body>
</html>