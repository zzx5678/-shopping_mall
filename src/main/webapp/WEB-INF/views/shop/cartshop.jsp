<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>장바구니</h1>
	       장바구니 목록입니다.<br>
	    <table class="table">
	        <tr>
	            <th>상품</th><th>가격</th><th>수량</th><th>총 가격</th><th>비고</th>
	        </tr>
	        <c:set var="totalPriceSum" value="0" />
	        <c:forEach var="Cart_list" items="${Cart_list}">
	            <tr>
	                <td>${Cart_list.name}</td>
	                <td>${Cart_list.price}</td>
	                <td>${Cart_list.quantity}</td>
	                <td>${Cart_list.totalPrice}</td>
	                <td>
                        <button type="button" onclick="location.href='/ex/shop/cartshop_delete?product_code=${Cart_list.product_code}'">삭제</button>
	                </td>
	            </tr>
	            <c:set var="totalPriceSum" value="${totalPriceSum + Cart_list.totalPrice}" />
	        </c:forEach>
	        <tr>
	            <td colspan="3" style="text-align: right;">모든 상품 가격에 대한 총합 &nbsp;&nbsp;</td>
	            <td>${totalPriceSum}</td>
	            <td></td>
	        </tr>
	    </table>
	    <button type="button" class="button" onclick="location.href='/ex/shop/cart_all_delete'">전체 삭제</button>
	    <button type="button" class="button" onclick="location.href='/ex/shop/ship'">주문 하기</button>
    </div>
</body>
</html>