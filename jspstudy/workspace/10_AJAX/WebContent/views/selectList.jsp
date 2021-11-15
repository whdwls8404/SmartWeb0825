<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<style>
		label {
			display: block;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		
		$(document).ready(function(){
			fnSelectProductList();
			fnInsertProduct();
			fnNameCheck();
			fnPrevInsertName();
			fnDeleteProduct();
		});
		
		function fnDeleteProduct() {
			$('body').on('click', '.delete_btn', function(){
				let delete_pno = $(this).data('pno');
				if (confirm('제품번호 ' + delete_pno + ' 제품을 삭제할까요?')) {
					$.ajax({
						url: '/AJAX/delete.do',
						type: 'get',
						data: 'pno=' + delete_pno,  // 서버로 보내는 데이터, 파라미터 pno로 보냄
						success: function(resData) {
							if (resData.result > 0) {
								alert('삭제 완료.');
								fnSelectProductList();
							} else {
								alert('삭제 실패1');  // 삭제할 회원번호가 없어서
							}
						},
						error: function() {
							alert('삭제 실패2');  // 코드 수정 필요
						}
					});
				}
			});
		}
		
		function fnSelectProductList() {
			$.ajax({
				url: '/AJAX/selectList.do',
				type: 'get',
				// data: 없음  (서버로 보내는 데이터)
				dataType: 'json',  // 받아오는 데이터의 타입
				success: function(resData) {  // resData에 SelectListService의 반환 값 arr 저장
					// 제품 목록 초기화
					$('#product_list').empty();
					// 제품 목록 만들기
					if (resData.length == 0) {
						$('<tr>')
						.append( $('<td colspan="5">').text('등록된 제품이 없습니다.') )
						.appendTo('#product_list');
					} else {
						for (let i = 0; i < resData.length; i++) {
							$('<tr>')
							.append( $('<td>').text(resData[i].pno) )
							.append( $('<td>').text(resData[i].name) )
							.append( $('<td>').text(resData[i].price) )
							.append( $('<td>').text(resData[i].made) )
							.append( $('<td>').html('<input type="button" value="삭제" class="delete_btn" data-pno="' + resData[i].pno + '">') )
							.appendTo('#product_list');
						}
					}
				},
				error: function() {
					alert('제품 목록 가져오기 실패');
				}
			});
		}
		
		function fnInsertProduct() {
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
							fnSelectProductList();
						} else {
							alert('제품 등록 실패1.');
						}
					},
					error: function() {
						alert('제품 등록 실패2.');
					}
				});
			});
		}
		
		function fnNameCheck() {
			$('#name').on('blur', function(){
				$.ajax({
					url: '/AJAX/nameCheck.do',
					type: 'get',
					data: 'name=' + $(this).val(),
					dataType: 'json',
					success: function(resData) {
						if (resData.result == false) {
							alert('동일한 제품이 있습니다.');
						}
					},
					error: function() {
						alert('제품명 중복 체크 실패');
					}
				});
			});
		}
		
		function fnPrevInsertName() {
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
		}
		
		
		
		
		
		
		
		
		
		
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

	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>제품번호</td>
				<td>제품명</td>
				<td>제품가격</td>
				<td>제조일자</td>
				<td>버튼</td>
			</tr>
		</thead>
		<tbody id="product_list"></tbody>
	</table>

</body>
</html>