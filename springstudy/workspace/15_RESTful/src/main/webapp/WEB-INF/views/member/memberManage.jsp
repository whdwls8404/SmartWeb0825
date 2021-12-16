<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">

	// 페이지 로드
	$(document).ready(function(){
		fnFindAllMember();
		fnAddMember();
	});
	
	// 전체 회원 목록 함수
	function fnFindAllMember() {
		$.ajax({
			url: '/ex15/api/members',
			type: 'get',
			dataType: 'json',
			success: function(map){
				$('#member_list').empty();
				if (map.length == 0) {
					$('<tr>')
					.append( $('<td colspan="5">').text('등록된 회원이 없습니다.') )
					.appendTo( '#member_list' );
				} else {
					$.each(map.list, function(i, member){
						$('<tr>')
						.append($('<td>').text(member.id))
						.append($('<td>').text(member.name))
						.append($('<td>').text(member.gender))
						.append($('<td>').text(member.address))
						.append($('<td>').html( $('<input type="hidden" name="memberNo" id="memberNo" value="'+member.memberNo+'"><input type="button" value="조회" class="view_btn">')))
						.appendTo('#member_list');
					});
				}
			},
			error: function(){
				
			}
		});
	}  // end fnFindAllMember

	// 회원 등록 함수
	function fnAddMember() {
		$('#insert_btn').click(function(){
			let member = JSON.stringify({
				id: $('#id').val(),
				name: $('#name').val(),
				gender: $('input:radio[name="gender"]:checked').val(),
				address: $('#address').val()
			});
			$.ajax({
				url: '/ex15/api/members',
				type: 'post',
				contentType: 'application/json',
				data: member,
				dataType: 'json',
				success: function(map){
					alert('회원번호 ' + map.memberNo + '인 회원이 등록되었습니다.');
					fnFindAllMember();
				},
				error: function(){
					
				}
			});
		});
	}  // end fnAddMember
	
	
	
</script>
</head>
<body>

	<h1>회원 관리</h1>
	
	<div>
		아이디 <input type="text" name="id" id="id"><br>
		이름   <input type="text" name="name" id="name"><br>
		주소   <input type="text" name="address" id="address"><br>
		성별
		<input type="radio" name="gender" value="남" id="male"><label for="male">남</label>
		<input type="radio" name="gender" value="여" id="female"><label for="female">여</label><br>
		<input type="button" value="초기화" id="init_btn"> 
		<input type="button" value="등록" id="insert_btn"> 
		<input type="button" value="수정" id="update_btn"> 
		<input type="button" value="삭제" id="delete_btn"> 
	</div>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>성별</td>
				<td>주소</td>
				<td></td>
			</tr>
		</thead>
		<tbody id="member_list"></tbody>
		<tfoot>
			<tr>
				<td colspan="5" id="paging"></td>
			</tr>
		</tfoot>
	</table>

</body>
</html>