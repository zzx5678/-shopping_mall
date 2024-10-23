<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>구매 페이지</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<style>
    .hidden {
        display: none;
    }
</style>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>상품 목록</h1>
		쇼핑물 상품 목록입니다.<br>
		<button type="button" class="button" onclick="location.href='/ex/shop/editProducts'">상품 편집 </button>
		<button type="button" class="button" onclick="location.href='/ex/shop/cartshop'">장바구니 </button><br><br>
		
		<c:forEach var="shopDto" items="${list}">
		<div style="float:left; overflow: auto; border: 1px solid black; width: 295px; height: 330px; margin: 5px; text-align: center;">
	    <form action="/ex/shop/cart_insertDB" method="post">
	        <img src="${shopDto.img_address}" width="200px" height="200px"><br>
	        ${shopDto.name}<br>
	        ${shopDto.product_Text}<br>
	        ${shopDto.price}원<br>
	        
	        <input type="hidden" name="product_code" value="${shopDto.code}" >
	        <input type="hidden" name="product_price" value="${shopDto.price}" >
	        
	        <button type="submit" class="button">&#128092; 장바구니</button>
	  		<button type="button" class="button" onclick="location.href='/ex/shop/product?code=${shopDto.code}'">상세 정보</button><br>
	    </form>
	    </div>
		</c:forEach>
	</div>
</body>
</html>

