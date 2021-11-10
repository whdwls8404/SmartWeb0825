<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
				} else if ($('#name').val() == '${emp.name}' && $('#salary').val() == '${emp.salary}') {
					alert('변화가 없음');
					event.preventDefault();
					return false;
				}
				return true;
				
			});
			
		})
	</script>
</head>
<body>

	<c:if test="${emp == null}">
		<script>
			alert('존재하지 않는 사원입니다.');
			history.back();
		</script>
	</c:if>
	
	<c:if test="${emp != null}">
		<form id="f" action="/MYBATIS/updateEmp.do" method="post">
			<label for="num">사원번호</label>
			<input type="text" name="num" id="num" value="${emp.num}" readonly>
			<label for="name">사원이름</label>
			<input type="text" name="name" id="name" value="${emp.name}">
			<label for="salary">사원연봉</label>
			<input type="text" name="salary" id="salary" value="${emp.salary}">
			<label for="hire">입사일자</label>
			<input type="text" name="hire" id="hire" value="${emp.hire}" readonly>
			<div>
				<button>수정하기</button>
				<input type="button" value="목록으로 이동" onclick="location.href='/MYBATIS/selectEmpList.do'">
				<input type="button" value="상세보기로 이동" onclick="location.href='/MYBATIS/selectEmp.do?num=${emp.num}'">
			</div>
		</form>
	</c:if>

</body>
</html>
