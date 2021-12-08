<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 수정
		$('#update_btn').on('click', function(){
			if ( '${contact.tel}' == $('#tel').val() && 
				 '${contact.address}' == $('#address').val() &&
				 '${contact.birthday}' == $('#birthday').val() ) {
				alert('변경할 내용 없음.');
				return;
			}
			$('#f').attr('action', '/ex09/contact/updateContact');
			$('#f').submit();
		});
		
		// 삭제
		$('#delete_btn').on('click', function(){
			if (confirm('삭제할까요?')) {
				$('#f').attr('action', '/ex09/contact/deleteContact');
				$('#f').submit();
			}
		});
		
	});
</script>
</head>
<body>

	<h1>연락처 상세 보기 및 수정화면</h1>
	
	<form id="f">
		번호<br>
		<input type="text" name="no" id="no" value="${contact.no}" readonly><br><br>
		이름<br>
		<input type="text" name="name" id="name" value="${contact.name}" readonly><br><br>
		전화번호<br>
		<input type="text" name="tel" id="tel" value="${contact.tel}"><br><br>
		주소<br>
		<input type="text" name="address" id="address" value="${contact.address}"><br><br>
		생일<br>
		<input type="text" name="birthday" id="birthday" value="${contact.birthday}"><br><br>
		<input type="button" value="수정하기" id="update_btn">
		<input type="button" value="삭제하기" id="delete_btn">
		<input type="button" value="목록" onclick="location.href='/ex09/contact/findAllContact'">
	</form>

</body>
</html>