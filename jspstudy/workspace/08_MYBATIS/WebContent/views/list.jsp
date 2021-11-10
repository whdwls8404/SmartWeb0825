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
	<style>
		* {
			margin: 0;
			padding: 0;
		}
		ul {
			margin-top: 10px;
			list-style-type: none;
			display: flex;
		}
		ul li {
			width: 100px;
		}
	</style>
</head>
<body>

	<div>
		<c:if test="${empty empList}">
			<h1>등록된 사원이 없습니다.</h1>
		</c:if>
		<c:if test="${not empty empList}">
			<ul>
				<li>사원번호</li>
				<li>사원이름</li>
				<li>고용일자</li>
			</ul>
			<c:forEach var="emp" items="${empList}">
				<ul>
					<li>${emp.num}</li>
					<li><a href="/MYBATIS/selectEmp.do?num=${emp.num}">${emp.name}</a></li>
					<li>${emp.hire}</li>
				</ul>
			</c:forEach>
		</c:if>
		<div>
			<a href="/MYBATIS/insertEmpForm.do">사원 등록하기</a>
		</div>
	</div>

</body>
</html>