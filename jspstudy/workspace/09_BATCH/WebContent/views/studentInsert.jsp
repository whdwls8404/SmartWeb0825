<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		.wrap {
			width: 500px;
			margin: 0 auto;
		}
		.title {
			text-align: center;
			color: yellowgreen;
		}
		table {
			width: 100%;
			border-collapse: collapse;
		}
		td {
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			text-align: center;
			padding: 3px 5px;
		}
		tbody input {
			width: 80px;
		}
		tfoot input {
			width: 100px;
			height: 30px;
			background-color: limegreen;
			border: 0;
			outline: 0;
			text-align: center;
		}
		tfoot input:first-of-type {
			background-color: crimson;
		}
		tfoot input:hover {
			cursor: pointer;
			background-color: orange;
		}
	</style>
	<script type="text/javascript">
	
		$(document).ready(function(){
			$('#f').on('submit', function(event){
				let regSno = /^[0-9]{5}$/;
				if ( regSno.test($('#sno').val()) == false ) {
					alert('학번은 5자리 정수입니다.');
					$('#sno').focus();
					event.preventDefault();
					return false;
				} else if ( $('#name').val() == '' ) {
					alert('이름은 필수입니다.');
					$('#name').focus();
					event.preventDefault();
					return false;
				} else if ( $('#kor').val() == '' || isNaN($('#kor').val()) || $('#kor').val() < 0 || $('#kor').val() > 100 ) {
					alert('국어 점수는 0~100 사이 정수입니다.');
					$('#kor').focus();
					event.preventDefault();
					return false;
				} else if ( $('#eng').val() == '' || isNaN($('#eng').val()) || $('#eng').val() < 0 || $('#eng').val() > 100 ) {
					alert('영어 점수는 0~100 사이 정수입니다.');
					$('#eng').focus();
					event.preventDefault();
					return false;
				} else if ( $('#mat').val() == '' || isNaN($('#mat').val()) || $('#mat').val() < 0 || $('#mat').val() > 100 ) {
					alert('수학 점수는 0~100 사이 정수입니다.');
					$('#mat').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
		
	</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">학생 등록 화면</h1>
		<form id="f" action="/BATCH/insertStudent.do" method="post">
			<table>
				<thead>
					<tr>
						<td>학번</td>
						<td>성명</td>
						<td>국어</td>
						<td>영어</td>
						<td>수학</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="sno" id="sno" autofocus></td>
						<td><input type="text" name="name" id="name"></td>
						<td><input type="text" name="kor" id="kor"></td>
						<td><input type="text" name="eng" id="eng"></td>
						<td><input type="text" name="mat" id="mat"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="5">
							<input type="submit" id="insert_btn" value="학생 등록하기">
							<input type="reset" value="입력 초기화">
							<input type="button" value="학생 목록" onclick="location.href='/BATCH/studentList.do'">						
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>