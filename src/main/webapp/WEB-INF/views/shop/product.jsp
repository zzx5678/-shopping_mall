<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 정보</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>상품 정보</h1>
		쇼핑물 입니다.<br>
		<button class="button" type="button" onclick="location.href='/ex/shop/products'">상품 목록 </button><br>
		<form>
			상품 이미지 <br>
			<img src="${ShopDto.img_address }" width="500px" height="500px"><br>
			상품 코드 : <input type="text" class="input" name="code" value="${ShopDto.code }" disabled> <br>
			상품 이름 : <input type="text" class="input" name="name" value="${ShopDto.name }" disabled> <br>
			상품 가격 : <input type="text" class="input" name="price" value="${ShopDto.price }" disabled> <br>
			
			상세 내용 <br>
		    <textarea name="product_Text" class="input" rows="4" cols="50" placeholder="내용을 입력하세요." disabled>${ShopDto.product_Text }</textarea><br>
		       제조사 : <input type="text" class="input" name="manufacturer" value="${ShopDto.manufacturer }" disabled><br>
		       분류 : <input type="text" class="input" name="classify" value="${ShopDto.classify }" disabled><br>
		       재고 수 : <input type="text" class="input" name="stock" value="${ShopDto.stock }" disabled> <br>
		       상태 : <input type="radio" class="input" name="quality" value="신규 제품" ${ShopDto.quality.equals("신규 제품") ? "checked" : ""} disabled> 신규 제품
		        <input type="radio" class="input" name="quality" value="중고 제품" ${ShopDto.quality.equals("중고 제품") ? "checked" : ""} disabled> 중고 제품 <br>
	    </form>
    </div>
</body>
</html>