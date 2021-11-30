<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Welcome</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		* {
			padding: 0;
			margin: 0;
			box-sizing: border-box;
		}
		.wrap{
			width: 1500px;
			margin: 0 auto;
			padding: 10px;
			display:flex;
		}
		.input_area {
			width: 300px;
			padding: 10px;
		}
		.member_area {
			width: 1200px;
			padding: 10px;
		}
		.member_area table {
			width:1000px;
			border-collapse: collapse;
			
		}
		.member_area table td{
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			padding: 3px 5px;
			text-align: center;
		}
		
	</style>
	<script>
		$(document).ready(function(){
			fnSelectMemberList();
			fnInsertMember();
			fnDeleteMember();
		}); // load
		
		function fnSelectMemberList(){	
			$.ajax({
				url :'/MemberProject/selectMemeberList.do',
				type: 'get',
				dataType: 'json',
				success : function(members){
				
					// 기존 목록 지우기 
				$('#member_list').empty();
					$.each(members, function(i, member){
						$('<tr>')
						.append( $('<td>').text(member.no) )
					    .append( $('<td>').text(member.name) )
					    .append( $('<td>').text(member.age) )
					    .append( $('<td>').text(member.birthday) )
					    .append( $('<td>').text(member.regDate) )
					    .append( $('<td>').html( '<input type="button" value="삭제"  class="delete_btn"  data-no="'+member.no +'" > ' ) )
						.appendTo($('#member_list') )		
					}) // each
				},
				error : function(xhr, thrownError){  
					 console.log(xhr.status);
				        console.log(thrownError);
					
				}
			}) // ajax	
		}
		
		
		
		// 멤버 등록 ajax 함수
		function fnInsertMember(){
			// 4) -2  6자리 숫자 회원번호 jqery
			$('#insert_btn').on('click',function()  {
				if(	$("#no").val().length != 6  ){
					alert('회원번호는 6자리 숫자입니다.');
					return;
			} 
				//4)-1 ajax
				$.ajax({        
					url : "/MemberProject/insertMember.do",
					type: 'post',
					data : $('#f').serialize(),   
					dataType: 'json',
					success : function(obj){
						alert('회원 등록이 성공했습니다.');
						$('#no').val(''); 	$('#name').val('');  	$('#age').val('');  	$('#birth').val(''); 
						fnSelectMemberList();
					},
					error: function(xhr){   // 응답 텍스트는 xhr 객체에 responseText 프로퍼티로 전달됨  
						  if(xhr.status == 1111 || xhr.status==2222 || xhr.status==3333 || xhr.status==5555 ){ 
								alert(xhr.responseText);
						}
					}
				}); // ajax
			}); 
		} //function
		
		
		// 5) 삭제 
		function fnDeleteMember(){
			$('body').on('click', '.delete_btn', function(){
				//alert($(this).data('no'));
			   let delete_no =  $(this).data('no');
				if(confirm('회원번호' +delete_no +' 회원의 정보를 삭제할까요?')){
					$.ajax({
						url: "/MemberProject/deleteMember.do",
						type: 'get',                  
						data: 'no=' + delete_no,
						dataType: 'json',
						success : function(obj){
							if(obj.result){
								alert('회원번호 ' + delete_no+' 회원 정보가 삭제되었습니다.');
								fnSelectMemberList();  
							} else {
								alert('삭제 실패');
							}
						},
						error : function(){
							alert('실패');
						}
					})//ajax
				} // confirm			
				
			}); // click
		}
	
	</script>
</head>

<body>
	<div class="wrap">
		<div class="input_area">
			<form id="f" >
				<input type="text" name="no" id="no" placeholder="6자리번호"><br>
				<input type="text" name="name" id="name" placeholder="회원명"><br>
				<input type="text" name="age" id="age" placeholder="나이"><br>
				<input type="text" name="birthday" id="birthday" placeholder="생일"><br>
				<input type="button" value="등록하기" id="insert_btn">
			</form>
		</div>
		
		<div class="member_area">
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
				<tbody id="member_list"></tbody>
				
			</table>
		</div>
	</div>

</body>
</html>