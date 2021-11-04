<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		age는 문자열이기 때문에 숫자와의 크기비교 연산은 부적절하다.
		age를 연산(-)해서 숫자로 변환한 뒤 비교한다.	
	--%>

	${age - 20 >= 0 ? "성인" : "미성년자"}

</body>
</html>