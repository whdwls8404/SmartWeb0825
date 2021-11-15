<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table {
			border-collapse: collapse;
			border-top: 2px solid gray;
			border-bottom: 2px solid gray;
		}
		td {
			padding: 10px 5px;
			border-bottom: 1px solid gray;
			text-align: center;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#f').on('submit', function(event) {
				if ($('#name').val() == '${loginUser.name}' && $('#point').val() == '${loginUser.point}') {
					alert('수정할 내용이 없습니다.');
					e.preventDefault();
					return false;
				}
				return true;
			});
			$('#delete_btn').on('click', function(){
				if (confirm('탈퇴하시겠습니까?')) {
					location.href = '/ServerProgram/delete.do';
				}
			});
		})
	</script>
</head>
<body>
	<header>
		<h3>회원 관리 시스템</h3>
		<div>
			<a href="/ServerProgram/logout.do">로그아웃</a>
		</div>
	</header>
	<hr>
	<section>
		<form id="f" action="/ServerProgram/update.do" method="post">
			<table>
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>등급</td>
						<td>포인트</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${loginUser.id}</td>
						<td><input type="text" id="name" name="name" value="${loginUser.name}"></td>
						<td>${loginUser.grade}</td>
						<td><input type="text" id="point" name="point" value="${loginUser.point}"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<button>수정하기</button>
							<input type="button" value="탈퇴하기" id="delete_btn">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</section>
</body>
</html>