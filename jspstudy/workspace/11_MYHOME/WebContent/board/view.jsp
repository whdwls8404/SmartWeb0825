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
			// 댓글삽입
			$('#insert_btn').on('click', function(){
				if ( $('#content').val() == '' ) {
					alert('댓글 내용 필수.');
					$('#content').focus();
					return;
				}
				$.ajax({
					url: 'insert.comments',
					type: 'post',
					data: $('#comments_form').serialize(),
					dataType: 'json',
					success: function(obj) {  // obj : {"result": 0} 또는 {"result": 1}
						fnCommentsList();
					},
					error: function(xhr) {
						alert(xhr.responseText);
					}
				});
			});
			// 목록보기
			fnCommentsList();
			// 댓글삭제
			fnDeleteComments();
		});
		function fnCommentsList() {
			 $.ajax({
				url: 'list.comments',
				type: 'get',
				data: 'bNo=${board.bNo}',
				dataType: 'json',
				success: function(comments) {  // comments : [{}, {}, {}, ...]
					$('#comments_list').empty();
					$.each(comments, function(i, comment){
						if (comment.state == 0) {  // 정상 댓글이면
							if ('${loginUser.id}' == comment.writer) {
								$('<ul>')
								.append( $('<li>').text(comment.writer) )
								.append( $('<li>').text(comment.content) )
								.append( $('<li>').text(comment.created) )
								.append( $('<li>').html('<a class="delete_comments_link" data-cno="' + comment.cNo + '">삭제</a>') )
								.appendTo('#comments_list');
							} else {
								$('<ul>')
								.append( $('<li>').text(comment.writer) )
								.append( $('<li>').text(comment.content) )
								.append( $('<li>').text(comment.created) )
								.append( $('<li>').html('') )
								.appendTo('#comments_list');
							}
						} else if (comment.state == -1) {  // 삭제된 댓글이면
							$('<ul>')
							.append( $('<li>').text('') )
							.append( $('<li>').text('삭제된 댓글입니다.') )
							.append( $('<li>').text('') )
							.append( $('<li>').html('') )
							.appendTo('#comments_list');
						}
					});
				},
				error: function(xhr) {
					alert(xhr.responseText);
				}
			 });
		}
		function fnDeleteComments() {
			$('body').on('click', '.delete_comments_link', function(event){
				if (confirm('댓글을 삭제할까요?')) {
					// console.log($(this).data('cno'));
					$.ajax({
						url: 'delete.comments',
						type: 'get',
						data: 'cNo=' + $(this).data('cno'),
						success: function(){
							fnCommentsList();
						},
						error: function(xhr){
							alert(xhr.responseText);
						}
					});
				}
			});
		}
	</script>
	<style>
		#comments_list > ul {
			width: 700px;
			margin-top: 10px;
			padding: 0px;
			list-style-type: none;
			display: flex;
		}
		#comments_list > ul > li:nth-of-type(1) { width: 100px; }
		#comments_list > ul > li:nth-of-type(2) { width: 400px; }
		#comments_list > ul > li:nth-of-type(3) { width: 100px; }
		#comments_list > ul > li:nth-of-type(4) { width: 100px; }
	</style>
</head>
<body>

	<div>
		<input type="button" value="목록으로이동" onclick="location.href='list.board'">
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
	
	<hr>
	
	<!-- 댓글 입력란 -->
	<div>
		<form id="comments_form">
			<table>
				<tbody>
					<tr>
						<td rowspan="2">
							<textarea rows="3" cols="80" name="content" id="content"></textarea>
							<input type="hidden" name="writer" value="${loginUser.id}">
							<input type="hidden" name="bNo" value="${board.bNo}">
						</td>
						<td>
							${loginUser.id}(${loginUser.name})
						</td>
					</tr>
					<tr>
						<td>
							<c:if test="${loginUser != null}">  <!-- 로그인해야 보임. -->
								<input type="button" value="댓글달기" id="insert_btn">
							</c:if>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<!-- 댓글목록 -->
	<div id="comments_list">
		<ul>
			<li>작성자</li>
			<li>내용</li>
			<li>작성일자</li>
			<li>삭제</li>
		</ul>
	</div>

</body>
</html>