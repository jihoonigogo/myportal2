<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portal</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/user.css" />" />
<!-- jQuery -->
<script src="<c:url value="/assets/javascript/jquery/jquery-3.6.0.js"/>"></script>
<!-- 스크립트 삽입 -->
<script src="<c:url value="/assets/javascript/members.js"/>"></script>
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
				
	<h1>회원 가입</h1>
	
	<form
		id="join-form"
		name="registerForm" 
		action="<c:url value="/members/join"/>"
		method="POST"
		>
		<input type="hidden" name="check" value="f">
		<input type="hidden" name="a" value="join">
		
		<label for="name">이름</label>
		<input name="name" type="text" placeholder="이름을 입력하십시오"><br>
	
		<label for="password">비밀번호</label>
		<input name="password" type="password" placeholder="비밀번호를 입력하십시오"><br>
	
		<label for="email">이메일</label>
		<input type="text" name="email" placeholder="이메일을 입력하십시오."><br>
		
		<!-- 이메일 체크 버튼 -->
		<input type="button" 
			value="중복 체크" 
			onclick="checkemail(this.form.email, '<c:url value="/members/emailcheck" />')" /><br>
		
		
		<label for="gender">성별</label>
		<input type="radio" name="gender" value="M" checked>남성</radio>
		<input type="radio" name="gender" value="F">여성</radio><br>
		<input type="submit" value="전송">
		<!--  input type="button" value="폼 검증" onclick="checkForm(this.form)" --> 
	
	</form>
		
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>