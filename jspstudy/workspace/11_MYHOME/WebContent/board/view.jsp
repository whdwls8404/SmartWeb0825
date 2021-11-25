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

		<table>
			<tbody>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
					<td>작성일자</td>
					<td>${board.created}</td>
					<td>수정일자</td>
					<td>${board.lastModified}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td colspan="5">${board.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td colspan="5">${board.content}</td>
				</tr>
				<tr>
					<td colspan="6">
						<img width="640px" src="storage/${year}/${month}/${day}/${board.saveName}" alt="${board.fileName}">
					</td>
				</tr>
			</tbody>
		</table>
		
	</div>

</body>
</html>