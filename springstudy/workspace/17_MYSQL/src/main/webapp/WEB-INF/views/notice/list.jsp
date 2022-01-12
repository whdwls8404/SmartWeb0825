<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	
	$(document).ready(function(){
		fnInit();
		fnFindAll();
		fnFind();
	});

	// 화면 초기화 함수
	function fnInit(){
		$('#init_btn').click(function(){
			$('#column, #query').val('');
		});
	}  // end fnInit

	//전체 검색 함수
	function fnFindAll(){
		$('#find_all_btn').click(function(){
			location.href='/ex17/notice/findAll';
		});
	}  // end fnFindAll
	
	// 검색 함수
	function fnFind(){
		$('#f').submit(function(event){
			if ($('#column').val() == '') {
				alert('검색 카테고리를 선택하세요.');
				$('#column').focus();
				event.preventDefault();
				return false;
			}
			return true;
		});
	}
	
</script>
</head>
<body>

	<h1>공지사항 목록 화면</h1>
	
	<a href="/ex17/notice/addForm">새 공지사항 작성</a>
	<hr>
	
	<form id="f" method="get" action="/ex17/notice/find">
		<select name="column" id="column">
			<option value="">:::선택:::</option>
			<option value="TITLE">TITLE</option>
			<option value="CONTENT">CONTENT</option>
		</select>
		<input type="text" name="query" id="query">
		<button id="search_btn">검색하기</button>
		<input type="button" value="검색조건초기화" id="init_btn">
		<input type="button" value="전체공지조회" id="find_all_btn">
	</form>
	
	<br>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="3">공지사항 없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="notice" items="${list}" varStatus="vs">
					<tr>
						<td>${startNum - vs.index}</td>				
						<td><a href="/ex17/notice/detail?no=${notice.no}">${notice.title}</a></td>				
						<td><fmt:formatDate value="${notice.lastModified}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="3">${paging}</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>