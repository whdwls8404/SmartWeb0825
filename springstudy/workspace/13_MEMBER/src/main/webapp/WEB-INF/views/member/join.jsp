<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		fnIdCheck();
	});
	
	// 아이디 중복체크 변수와 함수
	let idPass = false;
	function fnIdCheck() {
		$('#id').keyup(function(){
			// 정규식 체크
			let regId = /^[a-z]{1,10}$/;  // 실제 서비스는 수정해서 사용
			if ( regId.test($(this).val()) == false ) {
				$('#id_result').text('아이디는 어쩌구저쩌구 입니다.').addClass('no');
				idPass = false;
				return;
			}
			// 중복 체크(DB사용)
			$.ajax({
				url: '/ex13/member/idCheck',
				type: 'post',
				data: 'id=' + $(this).val(),
				dataType: 'json',
				success: function(map){
					if (map.result == null) {
						$('#id_result').text('사용 가능한 아이디입니다').addClass('ok');
						idPass = true;
					} else {
						$('#id_result').text('사용 중인 아이디입니다').addClass('no');
						idPass = false;
					}
				},
				error: function(xhr){
					$('#id_result').text(xhr.responseText).addClass('no');
					idPass = false;
				}
			});
		});
	}  // end fnIdCheck
	
	
	
	
	
	
</script>
<style>
	.no {
		color: red;
	}
</style>
</head>
<body>

	<h1>회원가입 화면</h1>
	
	<form id="f" method="post" action="/ex13/member/join">
		
		아이디<br>
		<input type="text" name="id" id="id">
		<span id="id_result"></span><br><br>
		
		비밀번호<br>
		<input type="password" name="pw" id="pw">
		<span id="pw_result"></span><br><br>
		
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2">
		<span id="pw2_result"></span><br><br>
		
		이름<br>
		<input type="text" name="name" id="name"><br><br>
		
		이메일<br>
		<input type="text" name="email" id="email">
		<input type="button" value="인증번호받기" id="authcode_btn"><br>
		<input type="text" name="authcode" id="authcode">
		<input type="button" value="인증하기" id="verify_btn"><br><br>
		
		<button>가입하기</button>
		
	</form>

</body>
</html>