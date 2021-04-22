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
	  href="<c:url value="/assets/css/board.css" />" />
</head>
<body>
	<div id ="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id - "wapper">
			<div id="content">
			<div id ="site -introduce">
	<form method="post" action="<c:url value="/board/modify"/>">
		<input type="hidden" name="no" value="${vo.no }">
		<table border="1" width="640">
			<tr>
				<td colspan="2"><h3>게시판</h3></td>
			</tr>
			<tr>
				<th colspan="2">글수정</th>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value="${vo.title }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea id="content" name="content">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="">취소</a>
					<input type="submit" value="수정">
				</td>
			</tr>
		</table>
	</form>
</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	
</body>
</html>