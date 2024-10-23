<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>상품 수정</h1>
		쇼핑물 상품 수정입니다.<br>
		<button type="button" class="button" onclick="location.href='/ex/shop/add'">상품 등록 </button>
		<button type="button" class="button" onclick="location.href='/ex/shop/products'">상품 목록 </button><br><br>
		
		<c:forEach var="shopDto" items="${list}">
		<div style="float:left; overflow: auto; border: 1px solid black; width: 295px; height:330px; margin: 5px; text-align: center;">
	    <form>
	        <img src="${shopDto.img_address}" width="200" height="200"><br>
	        ${shopDto.name}<br>
	        ${shopDto.product_Text}<br>
	        ${shopDto.price}원<br>
	    <button type="button" class="button" onclick="location.href='/ex/shop/product_update?code=${shopDto.code}'">수정</button>
	    <button type="button" class="button" onclick="location.href='/ex/shop/product_deleteDB?code=${shopDto.code}'">삭제</button><br>
	    </form>
	    </div>
		</c:forEach>
	</div>
</body>
</html>