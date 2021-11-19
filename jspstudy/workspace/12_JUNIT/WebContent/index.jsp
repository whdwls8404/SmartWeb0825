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
		});
		function fnSelectBoardList(){
			$.ajax({
				url: 'selectBoardList.do',
				type: 'get',
				// data: 보내는 파라미터
				dataType: 'json',
				success: function(arr) {
					
				},
				error: function() {
					alert('실패');
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