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
		// 사원이름과 입사일자가 모두 변화 없는 경우
		// 서브밋을 막자!
		// 1. 새로 입력한 이름 : $('#name').val()
		// 2. 사원의 원래 이름 : ${emp.name}
		$(document).ready(function(){
			$('#f').on('submit', function(event){
				if ( $('#name').val() == '${emp.name}' && $('#hire').val() == '${emp.hire}' ) {
					alert('변경사항이 없습니다.');
					event.preventDefault();
					return false;
				}
				return true;
			});
		})
	</script>
</head>
<body>

	<div>
		<form action="/JDBC/update.emp" id="f">
			<h1>사원 상세 정보 보기</h1>
			사원번호 : ${emp.num}<br>
			사원이름 : <input type="text" name="name" id="name" value="${emp.name}"><br>
			입사일자 : <input type="text" name="hire" id="hire" value="${emp.hire}"><br>
			<input type="hidden" name="num" value="${emp.num}">
			<button>정보수정하기</button>
			<input type="button" value="사원목록보기" onclick="location.href='/JDBC/selectList.emp'">
		</form>
	</div>

</body>
</html>