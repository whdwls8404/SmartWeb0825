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
			$('#update_btn').on('click', function(){
				if ($('#title').val() == '${board.title}' && $('#content').val() == '${board.content}') {
					alert('변경할 내용이 없습니다.');
					return;
				}
				$('#f').attr('action', '/QUIZ2/updateBoard.do');
				$('#f').submit();
			});
			$('#delete_btn').on('click', function(){
				if (confirm('정말 삭제하시겠습니까?')) {
					$('#f').attr('action', '/QUIZ2/deleteBoard.do');
					$('#f').submit();
				}
			});
		})
	</script>
</head>
<body>

	<div>
		<form method="post" id="f">
			<table border="1">
				<tbody>
					<tr>
						<td><label for="idx">순번</label></td>
						<td><input type="text" name="idx" id="idx" value="${board.idx}" readonly></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${board.writer}</td>
					</tr>
					<tr>
						<td><label for="title">제목</label></td>
						<td><input type="text" name="title" id="title" value="${board.title}"></td>
					</tr>
					<tr>
						<td><label for="content">내용</label></td>
						<td><textarea name="content" id="content" rows="5" cols="40">${board.content}</textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="수정" id="update_btn">
							<input type="button" value="삭제" id="delete_btn">							
							<input type="button" value="목록" onclick="location.href='/QUIZ2/selectBoardList.do'">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>