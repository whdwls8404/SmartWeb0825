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
		<c:if test="${emp == null}">
			<h3>존재하지 않는 사원입니다.</h3>
		</c:if>
		<c:if test="${emp != null}">
			<ul>
				<li>사원번호 : ${emp.num}</li>
				<li>사원이름 : ${emp.name}</li>
				<li>사원연봉 : ${emp.salary}</li>
				<li>고용일자 : ${emp.hire}</li>
			</ul>
			<div>
				<a href="/MYBATIS/deleteEmp.do?num=${emp.num}">삭제</a>
			</div>
			<div>
				<a href="/MYBATIS/updateEmpForm.do?num=${emp.num}">수정</a>
			</div>
		</c:if>
		<a href="/MYBATIS/selectEmpList.do">목록으로 이동</a>
	</div>

</body>
</html>