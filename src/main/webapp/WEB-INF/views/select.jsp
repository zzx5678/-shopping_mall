<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 조회</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h2>데이터베이스 조회</h2>
		
		<h3>users</h3>
		<table class="table">
		<tr>
			<th>id</th><th>pw</th><th>name</th><th>gender</th><th>birthday</th><th>birthday</th><th>email</th><th>phoneNumber</th><th>address</th>
		</tr>
		<c:forEach var="UserDto" items="${UserDto}">
			<tr>
				<td>${UserDto.id }</td>
				<td>${UserDto.pw }</td>
				<td>${UserDto.name }</td>
				<td>${UserDto.gender }</td>
				<td>${UserDto.birthday }</td>
				<td><fmt:formatDate value="${UserDto.birthday}" pattern="yyyy년 MM월 dd일 "/></td>
				<td>${UserDto.email }</td>
				<td>${UserDto.phoneNumber }</td>
				<td>${UserDto.address }</td>
			</tr>
		</c:forEach>	
		</table>
		
		<h3>shops</h3>
		<table class="table" style="width: 95%">
		<tr>
			<th>img_address</th><th>code</th><th>name</th><th>price</th><th>product_Text</th><th>manufacturer</th><th>classify</th><th>stock</th><th>quality</th>
		</tr>
		<c:forEach var="ShopDto" items="${ShopDto}">
			<tr>
				<td>${ShopDto.img_address }</td>
				<td>${ShopDto.code }</td>
				<td>${ShopDto.name }</td>
				<td>${ShopDto.price }</td>
				<td>${ShopDto.product_Text }</td>
				<td>${ShopDto.manufacturer }</td>
				<td>${ShopDto.classify }</td>
				<td>${ShopDto.stock }</td>
				<td>${ShopDto.quality }</td>
			</tr>
		</c:forEach>	
		</table>
		
		<h3>cart</h3>
		<table class="table" style="width: 60%">
		<tr>
			<th>cart_id</th><th>session_id</th><th>user_id</th><th>product_code</th><th>quantity</th>
		</tr>
		<c:forEach var="CartDto" items="${CartDto}">
    	<tr>
        	<td>${CartDto.cart_id }</td>
        	<td>${CartDto.session_id }</td>
        	<td>${CartDto.user_id }</td>
        	<td>${CartDto.product_code }</td>
        	<td>${CartDto.quantity }</td>
    	</tr>
		</c:forEach>
		</table>
		
		<h3>cartshop</h3>
		<table class="table" style="width: 90%">
		<tr>
			<th>cart_id</th><th>session_id</th><th>user_id</th><th>product_code</th><th>quantity</th><th>name</th><th>price</th><th>totalPrice</th>
		</tr>
		<c:forEach var="CartShopDto" items="${CartShopDto}">
    	<tr>
        	<td>${CartShopDto.cart_id }</td>
        	<td>${CartShopDto.session_id }</td>
        	<td>${CartShopDto.user_id }</td>
        	<td>${CartShopDto.product_code }</td>
        	<td>${CartShopDto.quantity }</td>
        	<td>${CartShopDto.name }</td>
        	<td>${CartShopDto.price }</td>
        	<td>${CartShopDto.totalPrice }</td>
    	</tr>
		</c:forEach>
		</table>
		
		<h3>orders</h3>
		<table class="table" style="width: 80%">
		<tr>
			<th>order_id</th><th>session_id</th><th>user_id</th><th>order_name</th><th>order_day</th><th>order_address</th><th>order_email</th><th>order_phoneNumber</th><th>order_password</th>
		</tr>
		<c:forEach var="OrderDto" items="${OrderDto}">
    	<tr>
        	<td>${OrderDto.order_id }</td>
        	<td>${OrderDto.session_id }</td>
        	<td>${OrderDto.user_id }</td>
        	<td>${OrderDto.order_name }</td>
        	<td>${OrderDto.order_day }</td>
        	<td>${OrderDto.order_address }</td>
        	<td>${OrderDto.order_email }</td>
        	<td>${OrderDto.order_phoneNumber }</td>
        	<td>${OrderDto.order_password }</td>
    	</tr>
		</c:forEach>
		</table>
		
		<a href="/ex/">main페이지</a><br>
	</div>
</body>
</html>