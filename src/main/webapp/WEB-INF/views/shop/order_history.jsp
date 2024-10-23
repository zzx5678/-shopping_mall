<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 내역</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<div id="left_main">
			<c:if test="${!empty sessionScope.userId}">
				<button type="button" class="button" onclick="location.href='/ex/user/index'">마이 페이지</button><br>
				<button type="button" class="button" onclick="location.href='/ex/user/update_pw'">회원정보 수정 </button><br>
			</c:if>
			<button type="button" class="button" onclick="location.href='/ex/shop/order_history'">주문 내역</button><br>
		</div>
		<div id="right_main">
			<h1>주문 내역</h1>

			<c:if test="${empty sessionScope.userId}">
			비회원 주문을 하신 경우, 전화번호와 주문번호를 입력하세요.
			<form action="/ex/shop/order_select" method="GET"> 
    			전화번호 : <input type="text" class="input" name="phoneNumber1">
    			- <input type="text" class="input" name="phoneNumber2">
    			- <input type="text" class="input" name="phoneNumber3"> <br>
    			주문 비밀번호 입력 : <input type="password" class="input" name="order_password"><br>
    			<input type="submit" class="button" value="조회하기"><br>
			</form>
			</c:if>	
            
            <!-- 주문 정보가 존재할 때 -->
            <c:if test="${not empty OrderDto}">
            	<p>이름 : <input type="text" class="input" name="name" value="${OrderDto.order_name}" disabled></p>
                <p>주문일 : ${OrderDto.order_day}</p>
                <p>주소 : <input type="text" class="input" name="address" value="${OrderDto.order_address}" disabled></p>
                
                <c:if test="${not empty sessionScope.userId}">
                    <p>이메일 : 
                        <input type="text" class="input" name="email" 
                               value="${sessionScope.Order_emailArr[0] != null ? sessionScope.Order_emailArr[0] : ''}" disabled>
                        <label for="select"> @ </label>
                        <select class="input" name="select" disabled>
                            <option value="naver.com" ${sessionScope.Order_emailArr[1] == 'naver.com' ? 'selected' : ''}>naver.com</option>
                            <option value="gmail.com" ${sessionScope.Order_emailArr[1] == 'gmail.com' ? 'selected' : ''}>gmail.com</option>
                            <option value="daum.net" ${sessionScope.Order_emailArr[1] == 'daum.net' ? 'selected' : ''}>daum.net</option>
                        </select>
                    </p>
                </c:if>
                
                <p>전화번호 : 
                    <input type="text" class="input" name="phoneNumber1" value="${sessionScope.Order_phoneNumberArr[0]}" disabled>
                    - <input type="text" class="input" name="phoneNumber2" value="${sessionScope.Order_phoneNumberArr[1]}" disabled>
                    - <input type="text" class="input" name="phoneNumber3" value="${sessionScope.Order_phoneNumberArr[2]}" disabled>
                </p>
            </c:if>

            <!-- 장바구니 목록 및 가격 합계 -->
            <table class="table">
                <tr>
                    <th>상품</th><th>가격</th><th>수량</th><th>총 가격</th><th>비고</th>
                </tr>
                <c:set var="totalPriceSum" value="0" />
                <c:forEach var="item" items="${Cart_list}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.totalPrice}</td>
                        <td></td>
                    </tr>
                    <c:set var="totalPriceSum" value="${totalPriceSum + item.totalPrice}" />
                </c:forEach>
                <tr>
                    <td colspan="3" style="text-align: right;">모든 상품 가격에 대한 총합 &nbsp;&nbsp;</td>
                    <td>${totalPriceSum}</td>
                    <td></td>
                </tr>
            </table>
	    </div>
	</div>
</body>
</html>