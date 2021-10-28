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

	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// id + pwd : bean 또는 map 생성
		// DB로 보내고 결과 받음
		// 받은 회원 있으면 로그인 처리 : session에 회원 정보 저장
		
		boolean result = false;  // DB 갔다 온 결과라고 가정
	%>
	
	<script>
		let result = <%=result%>;
		if (result == true) {
			// 성공하면 갈 곳
		} else {
			alert('일치하는 회원이 없습니다.');
			history.back();
		}
	</script>

</body>
</html>
