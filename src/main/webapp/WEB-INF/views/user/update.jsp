<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보 수정</title>
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
		    <h1>회원 정보 수정</h1>
		
		    <form action="/ex/user/updateDB" method="post">
				아이디 : <input type="text" class="input" name="id" value="${UserDto.id }" readonly> <br>
				비밀번호 : <input type="password" class="input" name="pw" value="${UserDto.pw }"> <br>
				비밀번호 확인 : <input type="password" class="input" name="pw_check" value="${UserDto.pw }"> <br>
				이름 : <input type="text" class="input" name="name" value="${UserDto.name }"> <br>
				성별 : <input type="radio" name="gender" value="남성" ${UserDto.gender.equals("남성") ? "checked" : ""}> 남자
		        	 <input type="radio" name="gender" value="여성" ${UserDto.gender.equals("여성") ? "checked" : ""}> 여자 <br>
		       	생일 : <input type="text" class="input" name="year" placeholder="출생 년도 숫자만" value="${sessionScope.birthdayArr[0] }">년
		       	<select class="input" name="month">
		        	<option value="01" ${sessionScope.birthdayArr[1].equals("01") ? "selected" : "" }>1월</option>
		        	<option value="02" ${sessionScope.birthdayArr[1].equals("02") ? "selected" : "" }>2월</option>
		        	<option value="03" ${sessionScope.birthdayArr[1].equals("03") ? "selected" : "" }>3월</option>
		        	<option value="04" ${sessionScope.birthdayArr[1].equals("04") ? "selected" : "" }>4월</option>
		        	<option value="05" ${sessionScope.birthdayArr[1].equals("05") ? "selected" : "" }>5월</option>
		        	<option value="06" ${sessionScope.birthdayArr[1].equals("06") ? "selected" : "" }>6월</option>
		        	<option value="07" ${sessionScope.birthdayArr[1].equals("07") ? "selected" : "" }>7월</option>
		        	<option value="08" ${sessionScope.birthdayArr[1].equals("08") ? "selected" : "" }>8월</option>
		        	<option value="09" ${sessionScope.birthdayArr[1].equals("09") ? "selected" : "" }>9월</option>
		        	<option value="10" ${sessionScope.birthdayArr[1].equals("10") ? "selected" : "" }>10월</option>
		        	<option value="11" ${sessionScope.birthdayArr[1].equals("11") ? "selected" : "" }>11월</option>
		        	<option value="12" ${sessionScope.birthdayArr[1].equals("12") ? "selected" : "" }>12월</option>
				</select>
		       	<input type="text" class="input" name="day" placeholder="출생일 숫자만" value="${sessionScope.birthdayArr[2] }">일 <br>
		       	
		       	이메일 : <input type="text" class="input" name="email" value="${sessionScope.emailArr[0] }">
		       	<label for="select"> @ </label>
				<select class="input" name="select">
		        	<option value="naver.com" ${sessionScope.emailArr[1].equals("naver.com") ? "selected" : "" } >naver.com</option>
		        	<option value="gmail.com" ${sessionScope.emailArr[1].equals("gmail.com") ? "selected" : "" }>gmail.com</option>
		        	<option value="daum.net" ${sessionScope.emailArr[1].equals("daum.net") ? "selected" : "" }>daum.net</option>
				</select><br>
		       	전화번호 : <input type="text" class="input" name="phoneNumber1" value="${sessionScope.phoneNumberArr[0] }">
		       	 - <input type="text" class="input" name="phoneNumber2" value="${sessionScope.phoneNumberArr[1] }">
		       	 - <input type="text" class="input" name="phoneNumber3" value="${sessionScope.phoneNumberArr[2] }"> <br>
		       	주소 : <input type="text" class="input" name="address" value="${UserDto.address }"> <br>
		       	
		       	<button type="button" class="button" onclick="confirmDelete()">회원 탈퇴</button>
				<input type="submit" class="button" value="수정">
			</form>
			
		    <button type="button" class="button" onclick="location.href='/ex/user/index'">취소</button><br>
		    <script type="text/javascript">
			function confirmDelete() {
    			// 확인 및 취소 버튼이 있는 메시지 표시
    			var confirmed = confirm("정말로 회원 탈퇴하시겠습니까? 회원탈퇴 취소");

		    	// 사용자가 '확인'을 클릭한 경우
    			if (confirmed) {
        			// 페이지 이동
        			location.href = '/ex/user/deleteDB';
    			}
    			// 사용자가 '취소'를 클릭하면 아무 작업도 하지 않음
			}
</script>
	    </div>
    </div>
</body>
</html>
