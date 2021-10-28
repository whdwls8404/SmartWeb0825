<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	long timestamp = System.currentTimeMillis();
	Date today = new Date(timestamp);
	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("yyyy-MM-dd a h:mm:ss");
	String fToday = sdf.format(today);
%>

<script>
	let today = '<%=fToday%>';
	alert(today);
</script>
