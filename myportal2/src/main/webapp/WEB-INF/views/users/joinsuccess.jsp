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
</head>
<body>
	<div id ="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id - "wapper">
			<div id="content">
			<div id ="site -introduce">

	<h1>회원 가입 성공</h1>
	<p class="jr-success">
		회원가입을 축하합니다.
	</p>
	<p>
		<a href="<c:url value="/members/login"/>">로그인하기</a>
	</p>

</div>
		</div>
	</div>
					<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	
</body>
</html>