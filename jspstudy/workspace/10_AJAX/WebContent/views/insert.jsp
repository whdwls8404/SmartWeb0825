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
		label {
			display: block;
		}
	</style>
	<script>
		$(document).ready(function(){
			
			// 제품명 중복 체크
			$('#name').on('blur', function(){
				$.ajax({
					
					url: '/AJAX/nameCheck.do',
					type: 'get',
					data: 'name=' + $(this).val(),
					
					dataType: 'json',
					success: function(resData) {
						// console.log(resData);
						if (resData.result == false) {
							alert('동일한 제품이 있습니다.');
						}
					},
					error: function() {
						alert('제품명 중복 체크 실패');
					}
				});
			});
			
			// 제품 등록
			$('#insert_btn').on('click', function(){
				$.ajax({
					url: '/AJAX/insert.do',
					type: 'post',
					// data: 'name=' + $('#name').val() + '&price=' + $('#price').val(),
					data: $('#f').serialize(),  // 폼의 모든 요소를 파라미터로 넘김
					dataType: 'json',
					success: function(resData) {
						if (resData.result > 0) {
							alert('제품 등록 성공.');
							$('#name').val('');
							$('#price').val('');
						} else {
							alert('제품 등록 실패.');
						}
					},
					error: function() {
						alert('제품 등록 실패.');
					}
				});
			});
			
			// 마지막 등록 제품명 확인
			$('#name_btn').on('click', function(){
				$.ajax({
					url: '/AJAX/prevInsertName.do',
					type: 'get',
					dataType: 'json',
					success: function(resData) {
						alert(resData.name);
					},
					error: function() {
						alert('확인 실패');
					}
				});
			});
			
		})
	</script>
</head>
<body>

	<div>
		<h1>제품 등록 화면</h1>
		<form id="f">
			<label for="name">제품명</label>
			<input type="text" name="name" id="name">
			<input type="button" id="name_btn" value="마지막 등록 제품명 확인">
			<label for="price">제품가격</label>
			<input type="text" name="price" id="price">
			<br>
			<input type="button" id="insert_btn" value="제품등록">
		</form>
	</div>

</body>
</html>