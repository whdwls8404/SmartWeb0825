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
	<script type="text/javascript">
		$(document).ready(function(){
			$('#delete_link').on('click', function(event){
				if ( confirm('삭제할까요?') == false ) {
					event.preventDefault();
					return false;
				}
				return true;
			})
		})
	</script>
</head>
<body>

	<div>
		<h1>사원 전체 목록</h1>
		<div><a href="/JDBC/insertForm.emp">사원 등록 하러 가기</a></div>
		<table border="1">
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원명</td>
					<td>삭제</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="emp" items="${empList}">
					<tr>
						<td>${emp.num}</td>
						<td><a href="/JDBC/selectDto.emp?num=${emp.num}">${emp.name}</a></td>
						<td><a id="delete_link" href="/JDBC/delete.emp?num=${emp.num}">x</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>