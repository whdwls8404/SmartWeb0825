<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- Java 변수를 JavaScript 변수로 사용할 수 있다. --%>

	<%
		String name = "민경태";
		int age = 44;
	%>
	
	<script>
		let name = '<%=name%>';
		let age = <%=age%>;
		alert(name + ', ' + age);
	</script>
	
	
	<%-- JavaScript 변수를 Java 변수로 사용할 수 없다. 없다. 없다. --%>
	
	<%-- 
	<script>
		var money = 1000;
	</script>
	<h1>주머니에 <%=money%>원이 있다.</h1>
	--%>

</body>
</html>