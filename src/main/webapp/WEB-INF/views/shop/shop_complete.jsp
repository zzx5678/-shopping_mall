<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 완료 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>주문 완료</h1>
		
		<h3>주문이 완료되었습니다.</h3>
	    
		<button type="button" class="button" onclick="location.href='/ex/shop/order_history'">주문 내역</button><br>
		<button type="button" class="button" onclick="location.href='/ex/'">메인 화면으로</button>
	</div>
</body>
</html>