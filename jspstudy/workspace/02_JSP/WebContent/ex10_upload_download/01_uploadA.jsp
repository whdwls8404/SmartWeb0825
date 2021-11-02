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
	<script>
		
		$(document).ready(function(){
			fnFileCheck();
		});
		
		function fnFileCheck(){
			$('#filename').on('change', function(event){
				/*
					이벤트 대상
					event.target
					this
					#filename
				*/
				
				/* 첨부 파일의 확장자 제한하기 */
				/*
					파일명.확장자
					마지막 . 인덱스 : 3  (lastIndexOf())
					3 + 1 인덱스부터 끝까지 추출  (substring())
				*/
				let fullname = $(this).val();
				let extension = fullname.substring(fullname.lastIndexOf('.') + 1).toUpperCase();
				let extList = ['JPG', 'JPEG', 'PNG', 'GIF'];
				if ($.inArray(extension, extList) == -1) {  // 배열에 찾는 요소가 없으면 -1을 반환
					alert('확장자가 jpg, jpeg, png, gif인 파일만 업로드 할 수 있습니다.');
					$(this).val('');  // 첨부된 파일명을 빈 문자열로 바꿈 => 첨부가 없어짐.
					return false;
				}
				
				/* 첨부 파일의 용량 제한하기 */
				let maxSize = 10 * 1024 * 1024;  // 10메가 * 1024킬로바이트 * 1024바이트
				let fileSize = $(this)[0].files[0].size;
				if (maxSize < fileSize) {
					alert('10MB 이하의 파일만 업로드 할 수 있습니다.');
					$(this).val('');
					return false;
				}
			});
		}
		
	</script>
</head>
<body>

	<form action="01_uploadB.jsp" method="post" enctype="multipart/form-data">
		<div>		
			<label for="uploader">작성자</label>
			<input type="text" name="uploader" id="uploader">
		</div>
		<div>
			<label for="filename">첨부파일</label>
			<input type="file" name="filename" id="filename">
		</div>
		<div>
			<button>파일 첨부하기</button>
		</div>
	</form>

</body>
</html>