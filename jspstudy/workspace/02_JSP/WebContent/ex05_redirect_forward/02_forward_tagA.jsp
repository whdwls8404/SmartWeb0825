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
</head>
<body>

	<script>
		$(document).ready(function(){
			$('#title').on('click', function(){
				let name = $(this).data('name');
				location.href = '02_forward_tagB.jsp?name=' + name;
			});
		});
	</script>

	<h1 id="title" data-name="민경태">클릭하면 이름이 전달됩니다</h1>	

</body>
</html>
