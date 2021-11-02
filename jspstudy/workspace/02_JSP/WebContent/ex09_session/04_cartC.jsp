<%@page import="java.util.ArrayList"%>
<%@page import="ex09_session.Product"%>
<%@page import="java.util.List"%>
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

	<%
		// session에 저장된 cart 가져오기
		List<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
		StringBuilder sb = new StringBuilder();
		if (cart == null) {
			sb.append("장바구니가 비었습니다.");
		} else {
			for (Product p : cart) {
				sb.append(p.getProduct() + "....." + p.getQuantity() + "<br>");
			}
		}
	%>
	
	<h1>장바구니</h1>
	<%=sb.toString()%>
	
	<br><br><br>
	<input type="button" value="계속쇼핑하기" onclick="location.href='04_cartA.jsp'">
	<input type="button" value="장바구니비우기" onclick="fnEmptyCart()">
	<script>
		function fnEmptyCart() {
			if (confirm('장바구니를 비울까요?')) {
				location.href='04_cartD.jsp';
			} else {
				alert('취소되었습니다.');
			}			
		}
	</script>
</body>
</html>