<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portal</title>
<link rel="stylesheet" href="<c:url value="/assets/css/board.css" />" />
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
				
	<form method="post" 
		action="<c:url value="/board/write" />">
		<table border="1" width="640">
			<tr>
				<td colspan="2"><h3>게시판</h3></td>
			</tr>
			<tr>
				<th colspan="2">글쓰기</th>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value=""></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="content" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="<c:url value="/board/" />">취소</a>
					<input type="submit" value="등록">
				</td>	
			</tr>
		</table>
	</form>
			
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>