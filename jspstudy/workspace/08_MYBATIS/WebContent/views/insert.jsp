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
	<script>
		$(document).ready(function(){

			$('#f').on('submit', function(event){
				
				if ($('#name').val() == '') {
					alert('이름 필수');
					$('#name').focus();
					event.preventDefault();
					return false;
				} else if ($('#salary').val() == '') {
					alert('연봉 필수');
					$('#salary').focus();
					event.preventDefault();
					return false;
				}
				return true;
				
			});
			
		})
	</script>
</head>
<body>

	<form id="f" action="/MYBATIS/insertEmp.do" method="post">
	
		<label for="name">사원이름</label>
		<input type="text" name="name" id="name">
		
		<label for="salary">사원연봉</label>
		<input type="text" name="salary" id="salary">
		
		<div>
			<button>삽입하기</button>
			<input type="button" value="목록으로 이동" onclick="location.href='/MYBATIS/selectEmpList.do'">
		</div>
	</form>

</body>
</html>
