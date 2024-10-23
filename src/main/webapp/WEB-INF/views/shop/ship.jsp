<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>배송 정보</h1>
		
		<form action="/ex/shop/order_insertDB" method="post">
			
			이름 : <input type="text" class="input" name="order_name" value="${UserDto.id }"> <br>
			주문일 : ${formattedDate} <br>
			<input type="hidden" name="order_day" value="${formattedDate}">
			
	       	주소 : <input type="text" class="input" name="order_address" value="${UserDto.address }"> <br>
	       	
	       	<c:if test="${!empty sessionScope.userId}">
	       	이메일 : <input type="text" class="input" name="email" value="${sessionScope.emailArr[0] }">
	       	<label for="select"> @ </label>
			<select class="input" name="select">
	        	<option value="naver.com" ${sessionScope.emailArr[1].equals("naver.com") ? "selected" : "" }>naver.com</option>
	        	<option value="gmail.com" ${sessionScope.emailArr[1].equals("gmail.com") ? "selected" : "" }>gmail.com</option>
	        	<option value="daum.net" ${sessionScope.emailArr[1].equals("daum.net") ? "selected" : "" }>daum.net</option>
			</select><br>
			
			</c:if>
			전화번호 : <input type="text" class="input" name="phoneNumber1" value="${sessionScope.phoneNumberArr[0] }">
	       	 - <input type="text" class="input" name="phoneNumber2" value="${sessionScope.phoneNumberArr[1] }">
	       	 - <input type="text" class="input" name="phoneNumber3" value="${sessionScope.phoneNumberArr[2] }"> <br>
	       	
	       	<c:if test="${empty sessionScope.userId}">
	    	비회원 주문 비밀번호 설정 : <input type="password" class="input" name="order_password" > <br>
	    	</c:if>   
	       	
	       	<button type="button" class="button" onclick="location.href='/ex/shop/cartshop'">이전</button>
	       	<button type="button" class="button" onclick="location.href='/ex/shop/products'">취소 </button>
			<input type="submit" class="button" value="등록">
		</form>
	</div>
</body>
</html>