<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page session="true" %>

<%
	session.setAttribute("id", "admin");
	String id = (String)session.getAttribute("id");
%>

<script>
	let id = '<%=id%>';
	alert(id);
</script>
