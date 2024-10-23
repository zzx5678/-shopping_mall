<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업데이트</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>상품 수정</h1>
		쇼핑물 입니다.<br>
		<form action="/ex/shop/product_updateDB" method="post">
			상품 이미지 <br>
			<img src="${ShopDto.img_address }"><br>
			상품 이미지 : <input type="text" class="input" name="img_address" placeholder="절대 경로를 입력하세요." value="${ShopDto.img_address }"> <br>
			상품 코드 : <input type="text" class="input" name="code" value="${ShopDto.code }" > <br>
			상품 이름 : <input type="text" class="input" name="name" value="${ShopDto.name }" > <br>
			상품 가격 : <input type="text" class="input" name="price" value="${ShopDto.price }" > <br>
			
			상세 내용 <br>
		    <textarea name="product_Text" class="input" rows="4" cols="50" placeholder="내용을 입력하세요" >${ShopDto.product_Text }</textarea><br>
		       제조사 : <input type="text" class="input" name="manufacturer" value="${ShopDto.manufacturer }" ><br>
		       분류 : <input type="text" class="input" name="classify" value="${ShopDto.classify }" ><br>
		       재고 수 : <input type="text" class="input" name="stock" value="${ShopDto.stock }" > <br>
		       상태 : <input type="radio" name="quality" value="신규 제품" ${ShopDto.quality.equals("신규 제품") ? "checked" : ""} > 신규 제품
		        <input type="radio" name="quality" value="중고 제품" ${ShopDto.quality.equals("중고 제품") ? "checked" : ""} > 중고 제품 <br>
		    <button type="button" class="button" onclick="location.href='/ex/shop/editProducts'">수정 목록</button>
		    <input type="submit" class="button" value="수정">
	    </form>
    </div>
</body>
</html>