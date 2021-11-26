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
	<script>
		$(document).ready(function(){
			// 삭제
			$('#delete_btn').on('click', function(){
				if (confirm('게시글에 달린 모든 댓글도 함께 삭제됨. 삭제할까요?')) {
					$('#f').attr('action', 'delete.board');
					$('#f').submit();
				}
			});
			// 수정하러가기
			$('#update_btn').on('click', function(){
				$('#f').attr('action', 'updateForm.board');
				$('#f').submit();
			});
		});
	</script>
</head>
<body>

	<div>
		<input type="button" value="목록으로이동" onclick="location.href='${referer}'">
		<c:if test="${loginUser.id == board.writer}">  <!-- 작성자만 볼 수 있다. -->
			<form id="f" method="post">
				<input type="hidden" name="bNo" value="${board.bNo}">
				<input type="hidden" name="path" value="storage/${year}/${month}/${day}">
				<input type="hidden" name="saveName" value="${board.saveName}">
				<input type="hidden" name="title" value="${board.title}">
				<input type="hidden" name="content" value="${board.content}">
				<input type="hidden" name="writer" value="${board.writer}">
				<input type="button" value="수정하러가기" id="update_btn">
				<input type="button" value="삭제하기" id="delete_btn">
			</form>
		</c:if> 
	</div>

	<div>

		<table>
			<tbody>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
					<td>작성일자</td>
					<td>${board.created}</td>
					<td>수정일자</td>
					<td>${board.lastModified}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="5">${board.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="5">${board.content}</td>
				</tr>
				<tr>
					<td colspan="6">
						<img width="640px" src="storage/${year}/${month}/${day}/${board.saveName}" alt="${board.fileName}">
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>

</body>
</html>