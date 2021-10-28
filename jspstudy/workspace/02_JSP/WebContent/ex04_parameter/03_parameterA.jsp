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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#login_form').on('submit', function(event){
				if ($('#id').val() == '') {
					alert('아이디를 입력해 주세요');
					$('#id').focus();
					event.preventDefault();
					return false;
				} else if ($('#pwd').val() == '') {
					alert('비밀번호를 입력해 주세요');
					$('#pwd').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
	</script>
</head>
<body>

	<form action="03_parameterB.jsp" method="post" id="login_form">
		<input type="text" name="id" id="id">
		<br>
		<input type="password" name="pwd" id="pwd">
		<br>
		<button>로그인</button>
	</form>

</body>
</html>