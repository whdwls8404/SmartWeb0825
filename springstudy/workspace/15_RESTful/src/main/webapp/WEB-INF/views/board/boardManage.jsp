<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	
	// 페이지 로드
	$(document).ready(function(){
		fnInit();
		fnFileCheck();
		fnAddBoard();
	});
	
	// 입력 폼 초기화 함수
	function fnInit(){
		$('#writer').val('');
		$('#title').val('');
		$('#content').val('');
		$('#files').val('');
	}
	
	// 첨부파일 점검 함수 (확장자 + 크기)
	function fnFileCheck(){
		$('#files').change(function(){

			let regFile = /(.*)\.(jpg|jpeg|png|gif)$/;
			let maxSize = 1024 * 1024 * 10;  // 최대 크기 10MB
			
			let files = $(this)[0].files;
			for (let i = 0; i < files.length; i++) {
				if (regFile.test(files[i].name) == false){
					alert('이미지만 첨부할 수 있습니다.');
					$(this).val('');
					return;
				}
				if (files[i].size > maxSize) {  // files[i].size : 첨부된 파일 크기
					alert('10MB 이하의 파일만 업로드가 가능합니다.');
					$(this).val('');
					return;
				}
			}
		});
	}  // end fnFileCheck
	
	// 게시판 등록 함수
	function fnAddBoard(){
		$('#insert_btn').click(function(){
			if ($('#files').val() == ''){
				alert('첨부는 필수입니다.');
				return;
			}
			// ajax의 파일업로드는 form 객체 사용
			var formData = new FormData();
			formData.append('writer', $('#writer').val());
			formData.append('title', $('#title').val());
			formData.append('content', $('#content').val());
			let files = $('#files')[0].files;
			for (let i = 0; i < files.length; i++) {
				formData.append('files', files[i]);  // 첨부를 FormData에 넣기				
			}
			$.ajax({
				url: '/ex15/api/boards',
				type: 'post',
				contentType: false,  // ajax 파일 첨부할 때 세팅
				processData: false,  // ajax 파일 첨부할 때 세팅
				data: formData,
				dataType: 'json',
				success: function(map){
					if (map.boardResult > 0) {
						if (map.boardAttachResult > 0) {
							fnShowAttachedFile(map);
						} else {
							alert('첨부 실패');
						}
					} else {
						alert('게시글 등록 실패');
					}
					fnInit();
				}
			});
		});
	}  // end fnAddBoard
	
	// 첨부된 파일 확인 함수
	function fnShowAttachedFile(map){
		$('#upload_result').empty();
		$.each(map.thumbnails, function(i, thumbnail){
			$('#upload_result')
			.append( $('<div>').html( $('<img>').attr('src', '/ex15/' + map.path + '/' + thumbnail) ) );
		});
	}  // end fnShowAttachedFile
	
</script>
<style>
	#upload_result {
		width: 500px;
		display: flex;
	}
	#upload_result > div {
		margin-right: 10px;
		width: 100px;
	}
	#upload_result > div > img {
		width: 100%;
	}
</style>
</head>
<body>
	
	<h1>게시판 관리</h1>
	<div>
		작성자 <input type="text" id="writer"><br>
		제목   <input type="text" id="title"><br>
		내용   <input type="text" id="content"><br>
		첨부   <input type="file" id="files" multiple><br>  <!-- 다중첨부 multiple -->
		<input type="button" value="등록" id="insert_btn">
	</div>
	
	<hr>
	
	<h1>첨부된 파일 썸네일</h1>
	<div id="upload_result"></div>

</body>
</html>