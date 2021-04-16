<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
	prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	  href="<c:url value="/assets/css/home.css" />" />
</head>
<body>
	<div id ="container">
			<jsp:include page="/WEB-INF/views/includes/header.jsp" />
				<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
					<div id - "wapper">
						<div id="content">
						<div id ="site -introduce">
					<h1> OOPS</h1>
					<h2> Error 발생</h2>
					<h3>${name }</h3>
					<p>${ message}</p>
				</div>
			</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
			
	</div>
</body>
</html>