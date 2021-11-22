<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		* {
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		.wrap {
			width: 1500px;
			margin: 0 auto;
			padding: 10px;
			display: flex;
		}
		.input_area {
			width: 300px;
			padding: 10px;
		}
		.list_area {
			width: 1200px;
			padding: 10px;
		}
		.list_area table {
			width: 100%;
			border-collapse: collapse;
		}
		.list_area table td {
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			padding: 3px 5px;
			text-align: center;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			fnSelectBoardList();
			fnInsertBoard();
			fnDeleteBoard();
		});
		function fnSelectBoardList(){
			$.ajax({
				url: 'selectBoardList.jdbc',
				type: 'get',
				dataType: 'json',
				success: function(boards) {
					// 기존 목록 지우기
					$('#board_list').empty();
					// $.each(배열, function(인덱스, 요소){});
					$.each(boards, function(i, board){
						$('<tr>')
						.append($('<td>').text(board.bNo))
						.append($('<td>').text(board.writer))
						.append($('<td>').text(board.content))
						.append($('<td>').text(board.bDate))
						.append($('<td>').html('<input type="hidden" name="bNo" value="' + board.bNo + '"><input type="button" value="삭제" class="delete_btn">'))
						.appendTo('#board_list');
					});
				},
				error: function() {
					alert('실패');
				}
			});
		}  // end fnSelectBoardList()
		function fnInsertBoard(){
			$('#insert_btn').on('click', function(){
				if ($('#bNo').val().length != 5) {
					alert('게시글번호는 5자리입니다.');
					return;
				}
				// jQuery.ajax({});
				$.ajax({
					url: 'insertBoard.jdbc',
					type: 'post',
					data: $('#f').serialize(),  // 폼의 모든 요소를 파라미터로 보냄.
					dataType: 'json',
					success: function(obj) {
						alert(obj.result);
						fnSelectBoardList();
					},
					error: function(xhr){  // 응답 텍스트는 xhr 객체에 responseText 프로퍼티로 전달됨.
						if (xhr.status == 1111) {  // response.setStatus(1111); 코드로 보낸 값을 받음.
							alert(xhr.responseText);							
						}
					}
				});
			});
		}  // end fnInsertBoard()
		function fnDeleteBoard(){
			$('body').on('click', '.delete_btn', function(){
				if (confirm('삭제할까요?')){
					$.ajax({
						url: 'deleteBoard.jdbc',
						type: 'get',
						data: 'bNo=' + $(this).prev().val(),
						dataType: 'json',
						success: function(obj) {
							if (obj.result) {
								alert('삭제 성공');
								fnSelectBoardList();
							} else {
								alert('삭제 실패');
							}
						},
						error: function() {
							alert('실패');
						}
					});
				}
			});
		}
		
	</script>
</head>
<body>

	<div class="wrap">
		<div class="input_area">
			<form id="f">
				<input type="text" name="bNo" id="bNo" placeholder="5자리번호"><br>
				<input type="text" name="writer" id="writer" placeholder="작성자"><br>
				<input type="text" name="content" id="content" placeholder="내용"><br>
				<input type="button" value="등록하기" id="insert_btn">
			</form>
		</div>
		<div class="list_area">
			<table>
				<thead>
					<tr>
						<td>게시글번호</td>
						<td>작성자</td>
						<td>내용</td>
						<td>작성일자</td>
						<td></td>
					</tr>
				</thead>
				<tbody id="board_list"></tbody>
			</table>
		</div>	
	</div>

</body>
</html>