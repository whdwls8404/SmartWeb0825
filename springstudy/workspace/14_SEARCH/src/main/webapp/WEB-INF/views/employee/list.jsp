<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<td>NO</td>
				<td>EMPLOYEE_ID</td>
				<td>FIRST_NAME</td>
				<td>LAST_NAME</td>
				<td>HIRE_DATE</td>
				<td>SALARY</td>
				<td>DEPARTMENT_ID</td>
				<td>DEPARTMENT_NAME</td>
				<td>LOCATION_ID</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="employee" items="${list}">
				<tr>
					<td>NO</td>
					<td>${employee.employeeId}</td>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.hireDate}</td>
					<td>${employee.salary}</td>
					<td>${employee.departmentId}</td>
					<td>DEPARTMENT_NAME</td>
					<td>LOCATION_ID</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>