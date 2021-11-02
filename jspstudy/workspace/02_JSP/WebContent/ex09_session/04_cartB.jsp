<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="ex09_session.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String product = request.getParameter("product");
	String quan = request.getParameter("quantity");
	int quantity = 0;
	if (quan.isEmpty() == false) {
		quantity = Integer.parseInt(quan);
	}
	
	// cart에 저장될 한 항목 Product
	Product p = new Product();
	p.setProduct(product);
	p.setQuantity(quantity);
	
	// cart의 타입 :  Product[] 또는 ArrayList<Product>
	// 1. session에 저장된 cart를 꺼낸다.
	// 2. cart가 없으면 새로운 cart를 만들어서 session에 저장한다.
	List<Product> cart = (ArrayList<Product>)session.getAttribute("cart");
	if (cart == null) {
		cart = new ArrayList<>();
		session.setAttribute("cart", cart);
	}
	
	// cart에 Product p 담기
	cart.add(p);
%>
<script>
	alert('<%=p.getProduct()%> 제품을 장바구니에 추가했습니다.');
	if (confirm('장바구니로 가려면 "확인", 계속 쇼핑하려면 "취소"를 누르세요.')) {  // 확인
		location.href = '04_cartC.jsp';
	} else {  // 취소
		location.href = '04_cartA.jsp';
	}
</script>