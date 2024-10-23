<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
	<h1>주문 정보</h1>
		주문형태 : <c:if test="${!empty sessionScope.userId}">회원 주문,  id : ${OrderDto.user_id}</c:if> 
		<c:if test="${empty sessionScope.userId}">비회원 주문</c:if><br>
		
		이름 : <input type="text" class="input"  name="name" value="${OrderDto.order_name}" disabled> <br>
              주문일 : ${OrderDto.order_day} <br>
        
              주소 : <input type="text" class="input" name="address" value="${OrderDto.order_address}" disabled> <br>
        
        <c:if test="${!empty sessionScope.userId}">
			이메일 : <input type="text" class="input"  name="email" value="${sessionScope.Order_emailArr[0] != null ? sessionScope.Order_emailArr[0] : '' }" disabled>
        	<label for="select"> @ </label>
        	<select class="input" name="select" disabled>
            	<option value="naver.com" ${sessionScope.Order_emailArr[1].equals("naver.com") ? "selected" : "" } >naver.com</option>
            	<option value="gmail.com" ${sessionScope.Order_emailArr[1].equals("gmail.com") ? "selected" : "" } >gmail.com</option>
            	<option value="daum.net" ${sessionScope.Order_emailArr[1].equals("daum.net") ? "selected" : "" } >daum.net</option>
        	</select><br>
	    </c:if>
	    
              전화번호 : <input type="text" class="input" name="phoneNumber1" value="${sessionScope.Order_phoneNumberArr[0]}" disabled>
         - <input type="text" class="input" name="phoneNumber2" value="${sessionScope.Order_phoneNumberArr[1]}" disabled>
         - <input type="text" class="input" name="phoneNumber3" value="${sessionScope.Order_phoneNumberArr[2]}" disabled> <br>
        
       	
       	<c:if test="${empty sessionScope.userId}">
    	비회원 주문 비밀번호 설정 : <input type="password" name="order_password" value="${OrderDto.order_password}" disabled> <br>
    	</c:if>   
       	
       	<h4>구매한 제품들</h4>
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
                <td></td>
            </tr>
            <c:set var="totalPriceSum" value="${totalPriceSum + Cart_list.totalPrice}" />
        </c:forEach>
        <tr>
            <td colspan="3" style="text-align: right;">모든 상품 가격에 대한 총합 &nbsp;&nbsp;</td>
            <td>${totalPriceSum}</td>
            <td></td>
        </tr>
    	</table>
       	<button type="button" class="button" onclick="location.href='/ex/shop/ship'">이전</button>
       	<button type="button" class="button" onclick="location.href='/ex/shop/products'">취소 </button>
       	<button type="button" class="button" onclick="location.href='/ex/shop/shop_complete'">완료 </button>
	</div>
</body>
</html>