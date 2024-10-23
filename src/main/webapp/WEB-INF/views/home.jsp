<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
<title>시작 메뉴</title>
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>메인 화면</h1>
		shop 쇼핑물입니다.
		<br>
		<button type="button" class="button" onclick="location.href='/ex/shop/products'">상품목록 </button>
		<button type="button" class="button" onclick="location.href='/ex/user/login'">로그인 </button><br>
		<br>
		<P>  The time on the server is ${serverTime}. </P>
		<a href="/ex/select">데이터베이스 조회</a>
	</div>
</body>
</html>