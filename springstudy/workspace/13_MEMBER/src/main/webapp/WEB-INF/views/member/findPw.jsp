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
		fnSendAuthCode();
	});
	// 이메일 인증코드 전송함수
	function fnSendAuthCode(){
		$('#authCode_btn').click(function(){
			let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+([.][a-zA-Z]{2,}){1,2}$/;
			if ( regEmail.test($('#email').val()) == false ) {
				alert('이메일 형식을 확인하세요.');
				return;
			}
			$.ajax({
				url: '/ex13/member/sendAuthCode',
				type: 'post',
				data: 'email=' + $('#email').val(),
				dataType: 'json',
				success: function(map) {
					alert('인증코드가 발송되었습니다.');
					fnVerifyAuthCode(map.authCode);
				},
				error: function() {
					alert('인증코드 전송 실패');
				}
			});
		});
	}  // end fnSendAuthCode
	
	// 인증코드 검증 함수
	function fnVerifyAuthCode(authCode) {
		$('#verify_btn').click(function(){
			if ( $('#authCode').val() == authCode ) {
				alert('인증되었습니다. 비밀번호 변경 페이지로 이동합니다.');
				location.href = '/ex13/member/updatePwPage?email=' + $('#email').val();
			} else {
				alert('인증에 실패했습니다.');
			}
		});
	}  // end fnVerifyAuthCode
</script>
</head>
<body>

	<h1>비밀번호 찾기 화면</h1>
	
	가입 당시 이메일<br>
	<input type="text" name="email" id="email">
	<input type="button" value="인증번호받기" id="authCode_btn"><br>
	<input type="text" name="authCode" id="authCode">
	<input type="button" value="인증하기" id="verify_btn"><br><br>
	
	<div>
		<a href="/ex13/member/loginPage">로그인하러가기</a>
	</div>
	
</body>
</html>