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

	// 페이지 로드
	$(document).ready(function(){
		fnAreaSetting();
		fnInit();
		fnFindAll();
		fnFind();
		fnAutoComplete();
	});

	// 검색 화면 세팅 함수
	function fnAreaSetting(){
		$('#equal_area, #range_area').css('display', 'none');
		$('#column').change(function(){
			if ($(this).val() == '') {
				$('#equal_area, #range_area').css('display', 'none');
			} else if ($(this).val() == 'HIRE_DATE' || $(this).val() == 'SALARY') {
				$('#range_area').css('display', 'inline');
				$('#equal_area').css('display', 'none');
			} else {
				$('#equal_area').css('display', 'inline');
				$('#range_area').css('display', 'none');
			}
		});
	}  // end fnAreaSetting
	
	// 화면 초기화 함수
	function fnInit(){
		$('#init_btn').click(function(){
			$('#column, #query, #begin, #end').val('');
			$('#equal_area, #range_area').css('display', 'none');
		});
	}  // end fnInit

	// 전체 검색 함수
	function fnFindAll(){
		$('#find_all_btn').click(function(){
			location.href='/ex14/search/findAll';
		});
	}  // end fnFindAll
	
	// 검색 함수
	function fnFind(){
		let regEmployeeId = /^[0-9]{1,3}$/;
		$('#search_btn').click(function(){
			if ($('#column').val() == '') {
				alert('검색 카테고리를 선택하세요.');
				$('#column').focus();
				return;
			}
			else if ($('#column').val() == 'EMPLOYEE_ID' && regEmployeeId.test($('#query').val()) == false) {
				alert('검색할 올바른 사원번호를 입력하세요.');
				$('#query').focus();
				return;
			}
			else if ($('#column').val() == 'FIRST_NAME' && $('#query').val() == '') {
				alert('검색할 사원이름을 입력하세요.');
				$('#query').focus();
				return;
			}
			else if ($('#column').val() == 'HIRE_DATE' && $('#begin').val() == '') {
				alert('검색할 시작날짜를 입력하세요.');
				$('#begin').focus();
				return;
			}
			else if ($('#column').val() == 'HIRE_DATE' && $('#end').val() == '') {
				alert('검색할 종료날짜를 입력하세요.');
				$('#end').focus();
				return;
			}
			else if ($('#column').val() == 'SALARY' && ($('#begin').val() == '' || isNaN($('#begin').val()))) {
				alert('검색할 올바른 최소연봉을 입력하세요.');
				$('#begin').focus();
				return;
			}
			else if ($('#column').val() == 'SALARY' && ($('#end').val() == '' || isNaN($('#end').val()))) {
				alert('검색할 올바른 최대연봉을 입력하세요.');
				$('#end').focus();
				return;
			}
			
			if ($('#column').val() == 'EMPLOYEE_ID' || $('#column').val() == 'FIRST_NAME') {
				location.href='/ex14/search/findEmployee?column=' + $('#column').val() + '&query=' + $('#query').val();				
			}
			else if ($('#column').val() == 'HIRE_DATE' || $('#column').val() == 'SALARY') {
				location.href='/ex14/search/findEmployee?column=' + $('#column').val() + '&begin=' + $('#begin').val() + '&end=' + $('#end').val();
			}
		});
	}  // end fnFind
	
	// 자동 완성 함수
	function fnAutoComplete(){
		$('#query').keyup(function(){
			$('#auto_complete').empty();  // 자동 완성 목록의 초기화
			$.ajax({
				url: '/ex14/search/autoComplete',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({
					column: $('#column').val(),
					query: $('#query').val()
				}),
				dataType: 'text',
				success: function(obj) {
					let result = JSON.parse(obj);
					if (result.status == 200) {
						$.each(result.list, function(i, item){
							$('<option>')
							.val(item[$('#column').find('option[value="'+ $('#column').val() +'"]').data('column-name')])
							.appendTo('#auto_complete');
						});
					}
				},
				error: function(xhr) {
					
				}
			});
		});
	}  // end fnAutoComplete
	
</script>
</head>
<body>

	<h1>사원 검색 화면</h1>
	
	<form id="f" method="get">
		<select name="column" id="column">
			<option value="">:::선택:::</option>
			<option value="EMPLOYEE_ID" data-column-name="employeeId">EMPLOYEE_ID</option>
			<option value="FIRST_NAME" data-column-name="firstName">FIRST_NAME</option>
			<option value="HIRE_DATE" data-column-name="hireDate">HIRE_DATE</option>
			<option value="SALARY" data-column-name="salary">SALARY</option>
		</select>
		<span id="equal_area">
			<input list="auto_complete" type="text" name="query" id="query">
			<datalist id="auto_complete"></datalist>
		</span>
		<span id="range_area">
			<input type="text" name="begin" id="begin" placeholder="begin">
			~
			<input type="text" name="end" id="end" placeholder="end">
		</span>
		<br><br>
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" id="init_btn">
		<input type="button" value="전체사원조회" id="find_all_btn">
	</form>
	
	<br><hr><br>
	<%@ include file="list.jsp" %>
	
</body>
</html>