<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<div id="left_main">
			<button type="button" class="button" onclick="location.href='/ex/user/index'">마이 페이지</button><br>
			<button type="button" class="button" onclick="location.href='/ex/user/update_pw'">회원정보 수정 </button><br>
			<button type="button" class="button" onclick="location.href='/ex/shop/order_history'">주문 내역</button><br>
		</div>
		<div id="right_main">
			<%
			String id= (String) session.getAttribute("userId");
			String pw= (String) session.getAttribute("userpw");
			if (id != null && pw != null) {
				out.println("사용자 아이디: " + id + "<br>");
			    out.println("사용자 비밀번호: " + pw + "<br>");
			} else {
			    out.println("로그인 후, 사용자 아이디 정보 없음<br>");
			}  
			%><br>
			 	
			<h1>마이 페이지</h1>
			shop 쇼핑물입니다.<br>
			<button type="button" class="button" onclick="location.href='/ex/user/update_pw'">회원정보 수정 </button><br>
			<button type="button" class="button" onclick="location.href='/ex/shop/order_history'">주문 내역</button><br>
			<button type="button" class="button" onclick="location.href='/ex/user/logout'">로그아웃</button><br>
			<br><br>
			<button type="button" class="button" onclick="location.href='/ex/'">메인화면으로 </button>
			<button type="button" class="button" onclick="location.href='/ex/shop/products'">상품으로 </button><br>
		</div>
	</div>
</body>
</html>