<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		*{
			padding:0;
			margin:0;
			box-sizing:border-box;
		}
		.wrap{
			width:1500px;
			margin:0 auto;
			padding:10px;
			display:flex;
		}
		.input_area{
			width:300px;
			padding:10px;
		}
		.list_area{
			width:1500px;
			padding:10px;
		}
		.list_area table{
			border-collapse:collapse;
			width:100%;
		}
		.list_area table td{
			border-top:1px solid black;
			border-bottom:1px solid black;
			padding:3xp 5px;
			text-align:center;
			height:30px;
		}
	</style>
	
	<script>
		$(document).ready(function(){
			fnSelectList();
			fnNoCount();
			fnInsertMember()
			fnDeleteMember()
		});
		
		function fnSelectList(){
			$.ajax({
				url: 'selectList.do',
				type: 'post',
				dataType: 'json',
				success: function(arr){
					$('#tbody').empty();
					$.each(arr, function(i, member){
						$('<tr>')
						.append($('<td>').text(member.no))
						.append($('<td>').text(member.name))
						.append($('<td>').text(member.age))
						.append($('<td>').text(member.birthday))
						.append($('<td>').text(member.regDate))
						.append($('<td>').html('<input type="button" class="delete" value="삭제" data-no="' +member.no+'">'))
						.appendTo($('#tbody'))
					});
				},
				error:function(xhr){
					alert(xhr.responseText);
				}
			})
		}
		
		function fnNoCount(){
			$('#no').on('blur', function(){
				if($('#no').val().length < 6 || $('#no').val().length > 6){
					alert('회원번호는 6자리 숫자입니다.');
					$('#no').val('');
					return false;
				}
			});
		}
		
		function fnInsertMember(){
			$('#f').on('submit', function(event){
				$.ajax({
					url: 'insert.do',
					type: 'post',
					data: $('#f').serialize(),
					dataType: 'json',
					success: function(obj){
						if(obj.result){
							alert('회원 등록이 성공했습니다.');
							fnSelectList();
						}
					},
					error: function(xhr){
						if(xhr.status == 2001 || xhr.status == 2002 || xhr.status == 2003){
							alert(xhr.responseText);
						}
					}
				})
			});
		};
		
		function fnDeleteMember(){
			$('body').on('click', '.delete', function(){
				if(confirm('회원번호 ' + $(this).data('no') +' 회원의 정보를 삭제하시겠습니까?')){
					$.ajax({
						url:'delete.do',
						type: 'get',
						data: 'no=' + $(this).data('no'),
						dataType: 'json',
						success: function(obj){
							if(obj.result == 1){
								alert('회원번호 ' +  obj.no + ' 회원 정보가 삭제되었습니다');
								fnSelectList();
							} else{
								alert('삭제 실패');
							}
						},
						error: function(xhr){
							alert(xhr.responseText);
						}
					})
				}
			});
		};
		
	</script>
</head>
<body>
	<div class="wrap">
	
		<div class="input_area">
			<form id="f">
				<input type="text" id="no" name="no" placeholder="회원번호(6자리)">
				<input type="text" id="name" name="name" placeholder="회원명">
				<input type="text" id="age" name="age" placeholder="나이">
				<input type="text" id="birthday" name="birthday" placeholder="생일">
				<button>등록하기</button>
			</form>
		</div>
		
		<div class="list_area">
			<table>
				<thead>
					<tr>
						<td>회원번호</td>
						<td>회원명</td>
						<td>나이</td>
						<td>생일</td>
						<td>가입일</td>
						<td>비고</td>
					</tr>
				</thead>
				<tbody id="tbody">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>