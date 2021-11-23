<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css" integrity="sha512-4wfcoXlib1Aq0mUtsLLM74SZtmB73VHTafZAvxIp/Wk9u1PpIsrfmTvK0+yKetghCL8SHlZbMyEcV8Z21v42UQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<header>
		<h1><a href="index.jsp">WEB PAGE TITLE</a></h1>
	</header>

	<hr>

	<!-- 작성 링크 -->
	<div>
		<c:if test="${loginUser != null}">
			<a href="insertForm.free">새글작성</a>		
		</c:if>
	</div>
	
	<!-- 검색란 -->
	
	
	<!-- 목록 -->
	전체 게시글 : ${totalRecord}개<br>
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>내용</td>
				<td>조회수</td>
				<td>최종수정일</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="6">없다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="free">
					<c:if test="${free.state == 0}">
						<tr>
							<td>${free.fNo}</td>
							<td>${free.writer}</td>
							<td>
								<c:if test="${free.content.length() < 20}">
									<a href="view.free?fNo=${free.fNo}">${free.content}</a>
								</c:if>
								<c:if test="${free.content.length() >= 20}">
									<a href="view.free?fNo=${free.fNo}">${free.content.substring(0, 20)}</a>								
								</c:if>
							</td>
							<td>${free.hit}</td>
							<td>${free.lastModified}</td>
							<td>
								<c:if test="${loginUser.id == free.writer}">								
									<a id="delete_link" href="delete.free?fNo=${free.fNo}"><i class="far fa-times-circle"></i></a>
									<script type="text/javascript">
										$('#delete_link').on('click', function(event){
											if (confirm('삭제할까요?') == false) {
												event.preventDefault();
												return false;
											}
											return true;
										});
									</script>
								</c:if>
							</td>
						</tr>
					</c:if>
					<c:if test="${free.state == -1}">
						<tr>
							<td colspan="6">삭제된 게시글입니다.</td>
						</tr>
					</c:if>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6">
					
					<!-- 1페이지로 이동 : 1페이지는 링크가 필요 없음. -->
					<c:if test="${p.page == 1}">
						◀◀&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page != 1}">
						<a href="list.free?page=1">◀◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 이전 블록으로 이동 : 1블록은 링크가 필요 없음. -->
					<c:if test="${p.page <= p.pagePerBlock}">
						◀&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page > p.pagePerBlock}">
						<a href="list.free?page=${p.beginPage - 1}">◀</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 페이지 번호 : 현재 페이지는 링크가 필요 없음. -->
					<c:forEach var="i" begin="${p.beginPage}" end="${p.endPage}">
						<c:if test="${p.page == i}">
							${i}&nbsp;&nbsp;
						</c:if>
						<c:if test="${p.page != i}">
							<a href="list.free?page=${i}">${i}</a>&nbsp;&nbsp;
						</c:if>
					</c:forEach>
					
					<!-- 다음 블록으로 이동 : 마지막 블록은 링크가 필요 없음. -->
					<c:if test="${p.endPage == p.totalPage}">
						▶&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.endPage != p.totalPage}">
						<a href="list.free?page=${p.endPage + 1}">▶</a>&nbsp;&nbsp;
					</c:if>
					
					<!-- 마지막 페이지로 이동 : 마지막 페이지는 링크가 필요 없음. -->
					<c:if test="${p.page == p.totalPage}">
						▶▶&nbsp;&nbsp;
					</c:if>
					<c:if test="${p.page != p.totalPage}">
						<a href="list.free?page=${p.totalPage}">▶▶</a>&nbsp;&nbsp;
					</c:if>
	
				</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>