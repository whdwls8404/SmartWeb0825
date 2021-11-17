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
</head>
<body>

	<div>
		<form method="post" action="/QUIZ2/insertBoard.do">
			<table border="1">
				<tbody>
					<tr>
						<td><label for="writer">작성자</label></td>
						<td><input type="text" name="writer" id="writer"></td>
					</tr>
					<tr>
						<td><label for="title">제목</label></td>
						<td><input type="text" name="title" id="title"></td>
					</tr>
					<tr>
						<td><label for="content">내용</label></td>
						<td><textarea name="content" id="content" rows="5" cols="40"></textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<button>등록</button>
							<input type="button" value="목록" onclick="location.href='/QUIZ2/selectBoardList.do'">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>