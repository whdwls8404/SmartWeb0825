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

		게시글 번호 : ${free.fNo}<br>
		작성자 : ${free.writer}<br>
		조회수 : ${free.hit}<br>
		IP : ${free.ip}<br>
		작성일 : ${free.created}<br>
		최종수정일 : ${free.lastModified}<br>
		내용<br>
		<pre>${free.content}</pre>
		
		<br>

		<!--
			목록 : 누구나 
			수정, 삭제 : 작성자만
		-->
		<input type="button" value="목록" onclick="location.href='${referer}'">
		<c:if test="${free.writer == loginUser.id}">
			<form id="f" method="post">
				<!-- 수정할 게시글 정보를 넘기기 -->
				<input type="hidden" name="fNo" value="${free.fNo}">
				<input type="hidden" name="content" value="${free.content}">
				<input type="button" value="수정하러가기" onclick="fnFreeUpdate()">
			</form>
			<input type="button" value="삭제" onclick="fnFreeDelete()">
		</c:if>
		
		<script>
			function fnFreeUpdate() {
				$('#f').attr('action', 'updateForm.free');
				$('#f').submit();
			}
			function fnFreeDelete() {
				if (confirm('게시글을 삭제할까요?')) {
					location.href='delete.free?fNo=${free.fNo}';
				}
			}
		</script>
		
		<hr>
		
		<div>
		<%--
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
		--%>
		</div>
		
	</div>

</body>
</html>