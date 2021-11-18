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

		게시글 번호 : ${sessionScope.notice.nNo}<br>
		작성자 : ${notice.writer}<br>
		조회수 : ${notice.hit}<br>
		IP : ${notice.ip}<br>
		작성일 : ${notice.nDate}<br>
		최종수정일 : ${notice.nLastModified}<br>
		제목 : ${notice.title}<br>
		내용<br>
		<pre>${notice.content}</pre>
		
		<hr>
		
		<form action="insert.reply" method="post">
			<label for="writer">작성자</label>
			<input name="writer" id="writer"><br>
			<textarea rows="5" cols="30" name="content"></textarea><br>
			<input type="hidden" name="nNo" value="${notice.nNo}">
			<button>댓글달기</button>
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




