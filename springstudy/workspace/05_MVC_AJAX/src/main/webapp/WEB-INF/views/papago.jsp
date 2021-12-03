<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap {
		display: flex;
		justify-content: center;
	}
	.left, .right {
		padding: 10px;
	}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		// 언어선택
		$('#source').on('change', function(){
			if ($(this).val() == '') {
				$('#target').val('');
			} else if ($(this).val() == 'ko') {
				$('#target').val('en');
			} else if ($(this).val() == 'en') {
				$('#target').val('ko');
			}
		});
		
		// 번역하기
		$('#btn').on('click', function(){
			$.ajax({
				url: 'papago.do',
				type: 'post',
				data: JSON.stringify({
					"source": $('#source').val(),
					"target": $('#target').val(),
					"text": $('#text').val()
				}),
				contentType: 'application/json',
				dataType: 'json',
				success: function(result) {
					$('#translated').val(result.message.result.translatedText);
				},
				error: function(xhr) {
					alert(xhr.responseText);
				}
			});
		});
	});
</script>
</head>
<body>

	<h1 style="text-align: center;">파파고 번역하기</h1>
	
	<div class="wrap">
	
		<div class="left">
			<form>
				<select id="source">
					<option value="">언어선택</option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>				
				</select><br>
				<textarea rows="20" cols="60" id="text" placeholder="번역할 내용 입력"></textarea><br>
				<input type="button" value="번역하기" id="btn">
			</form>
		</div>
		
		<div class="right">
			<form>
				<select id="target">
					<option value=""></option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>				
				</select><br>
				<textarea rows="20" cols="60" id="translated"></textarea><br>
			</form>
		</div>
		
	</div>

</body>
</html>