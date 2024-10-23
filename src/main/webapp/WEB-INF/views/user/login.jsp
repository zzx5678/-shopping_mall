<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style.css">
</head>
<body>
	<div id="header">
		<a id="header-a" href="/ex/">Home</a>
	</div>
	<div id="main">
	    
	    <h1>로그인</h1><br>
	    
	    <form action="/ex/user/login_Check" method="get">
	        아이디 : <input type="text" class="input" name="id" value="${ids}" > <br>
	        비밀번호 : <input type="password" class="input" name="pw" value="${pws}"> <br>
	        <input type="checkbox" name="id_save" value="id_save"  ${id_save_Checked} > 아이디 저장 
	        <input type="checkbox" name="auto_login" value="auto_login" ${auto_login_Checked} > 자동 로그인 <br>
	        <input type="submit" class="button" value="로그인">
	        <button type="button" class="button" onclick="location.href='/ex/user/join'">회원가입</button><br>
	    </form>
	    
    </div>
</body>
</html>