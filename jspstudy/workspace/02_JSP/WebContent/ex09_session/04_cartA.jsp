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
</head>
<body>

	<form action="04_cartB.jsp">
		<h1>상품 선택</h1>
		<select name="product">
			<option value="냉장고" selected>냉장고</option>
			<option value="식기세척기">식기세척기</option>
			<option value="에어프라이어">에어프라이어</option>
			<option value="전자렌지">전자렌지</option>
			<option value="오븐">오븐</option>
		</select>
		<input type="text" name="quantity">개
		<button>장바구니에 담기</button>
	</form>

</body>
</html>