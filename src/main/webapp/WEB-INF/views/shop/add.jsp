<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>상품 등록</h1>
		쇼핑물 입니다.<br>
		<form action="/ex/shop/addDB" method="post">
			상품 이미지 : <input type="text" class="input" name="img_address" placeholder="절대 경로를 입력하세요." > <br>
			상품 코드 : <input type="text" class="input" name="code"> <br>
			상품명 : <input type="text" class="input" name="name"> <br>
			가격 : <input type="text" class="input" name="price" > <br>
			
	       	
	       	상세 내용 <br>
	       	<textarea name="product_Text" class="input" rows="4" cols="50" placeholder="내용을 입력하세요."></textarea>
	       	<br>
	       	제조사 : <input type="text" class="input" name="manufacturer"><br>
	       	분류 : <input type="text" class="input" name="classify"><br>
	       	재고 수 : <input class="input" type="text" name="stock" > <br>
	       	상태 : <input type="radio" name="quality" value="신규 제품"> 신규 제품
	        	<input type="radio" name="quality" value="중고 제품"> 중고 제품 <br>
	        	
	       	<button type="button" class="button" onclick="location.href='/ex/shop/products'">목록</button>
			<input type="submit" class="button" value="등록">
		</form>
	</div>
</body>
</html>