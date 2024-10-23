<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
		<h1>회원가입</h1><br>
		<form action="/ex/user/joinDB" method="post">
			아이디 : <input type="text" class="input" name="id" > <br>
			비밀번호 : <input type="password" class="input" name="pw"> <br>
			비밀번호 확인 : <input type="password" class="input" name="pw_check"> <br>
			이름 : <input type="text" class="input" name="name" > <br>
			성별 : <input type="radio" name="gender" value="남성"> 남자
	        	<input type="radio" name="gender" value="여성"> 여자 <br>
	       	생일 : <input type="text" class="input" name="year" placeholder="출생 년도 숫자만">
	       	<select class="input" name="month">
	        	<option value="01">1월</option>
	        	<option value="02">2월</option>
	        	<option value="03">3월</option>
	        	<option value="04">4월</option>
	        	<option value="05">5월</option>
	        	<option value="06">6월</option>
	        	<option value="07">7월</option>
	        	<option value="08">8월</option>
	        	<option value="09">9월</option>
	        	<option value="10">10월</option>
	        	<option value="11">11월</option>
	        	<option value="12">12월</option>
			</select>
	       	<input type="text" class="input" name="day" placeholder="출생일 숫자만"> <br>
	       	
	       	이메일 : <input type="text" class="input" name="email">
	       	<label for="select"> @ </label>
			<select class="input" name="select">
	        	<option value="naver.com">naver.com</option>
	        	<option value="gmail.com">gmail.com</option>
	        	<option value="daum.net">daum.net</option>
			</select><br>
	       	전화번호 : <input type="text" class="input" name="phoneNumber1"> - <input class="input" type="text" name="phoneNumber2" > - <input class="input" type="text" name="phoneNumber3" > <br>
	       	주소 : <input type="text" class="input" name="address" > <br>
	       	
	       	<button type="button" class="button" onclick="location.href='/ex/user/login'">취소 </button>
			<input type="submit" class="button" value="회원가입">
		</form>
	</div>
</body>
</html>