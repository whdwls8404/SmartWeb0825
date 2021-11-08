<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		label {
			display: inline-block;
			width: 100px;
		}
	</style>
	<script>
		$(document).ready(function(){
			$('#f1').on('submit', function(event){
				if ( $('#width').val() == '' || isNaN($('#width').val()) ) {
					alert('너비는 숫자 필수입니다.');
					$('#width').val('');
					$('#width').focus();
					event.preventDefault();
					return false;
				} else if ( $('#height').val() == '' || isNaN($('#height').val()) ) {
					alert('높이는 숫자 필수입니다.');
					$('#height').val('');
					$('#height').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
			$('#f2').on('submit', function(event){
				if ( $('#radius').val() == '' || isNaN($('#radius').val()) ) {
					alert('반지름은 숫자 필수입니다.');
					$('#radius').val('');
					$('#radius').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
	</script>
</head>
<body>

	<div>
		<form id="f1" action="/MVC2/rectangle.do">
			<div>
				<label for="width">너비</label>
				<input type="text" name="width" id="width">
			</div>
			<div>
				<label for="height">높이</label>
				<input type="text" name="height" id="height">
			</div>
			<div>
				<button>사각형 면적 확인</button>
			</div>
		</form>
	</div>
	
	<hr>
	
	<div>
		<form id="f2" action="/MVC2/circle.do">
			<div>
				<label for="radius">반지름</label>
				<input type="text" name="radius" id="radius">
			</div>
			<div>
				<button>원 면적 확인</button>
			</div>
		</form>
	</div>

</body>
</html>